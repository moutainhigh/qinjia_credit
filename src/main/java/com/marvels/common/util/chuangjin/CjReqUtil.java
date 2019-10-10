package com.marvels.common.util.chuangjin;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.chuangjin.util.CJRequestDto;
import com.marvels.common.util.chuangjin.util.Signature;
import com.marvels.dto.common.RequestBaseDto;

public class CjReqUtil {

	public static String aesKey = PropertiesLoadUtil.getPropertiesValue("cjykg.aesKey","forms-openapi.properties");//"4FE8645B8EAF88EA0ADADA6FAEDD3A29";//双方约定的加密秘钥(由云科谷提供)
	
	public static String cjpubKey = PropertiesLoadUtil.getPropertiesValue("cjykg.cjpubKey","forms-openapi.properties");//"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDR3nhllG5VRj1+df5CY1v+qVYtWuIZV17e2u5gRxw+fcJb6BGBkPNibXO5HPMS3ScmkzlpSnp4wBt+zTVy52Haa2CbQgG2wiuhEHnHig/IT6PHtyCX6roRgbh5Mu3I8F1MqZ/zuXBOBggie/4FGNI9yMESjx50NRAVUBHibEltwIDAQAB";//PropertiesLoadUtil.getPropertiesValue("rongshu.yunkedai.pubkey", "application.properties");
	public static String ykdPriKey = PropertiesLoadUtil.getPropertiesValue("cjykg.ykdPriKey","forms-openapi.properties");//"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMNHeeGWUblVGPX51/kJjW/6pVi1a4hlXXt7a7mBHHD59wlvoEYGQ82Jtc7kc8xLdJyaTOWlKenjAG37NNXLnYdprYJtCAbbCK6EQeceKD8hPo8e3IJfquhGBuHky7cjwXUypn/O5cE4GCCJ7/gUY0j3IwRKPHnQ1EBVQEeJsSW3AgMBAAECgYBCDCzHBeaCPqwAlg5cJsT1uNqv1DyYl2A04Zuf1HFgLMtHH8AfrwLDw+4AGfiogmTgirezfFdeye5dRHesT//pMyHTvLr3DDp7sLWMznQH8C8/h1gVeGzMNuae1S8DPTgbqsAOGMq++EpnPJigHGZLdYIk3HY6yDWy1/0V6Jh5EQJBAPOUZVys/ichShoe0sRFZVJRuqUulV3pd9ziU00eVuGgA9g1Wp5bKyKKc1mNh45MDL86L3PQxzA+jlJw8hrwAnMCQQDNPJUrWX0spRPbSC5iDaXPrHU7zZuCeumE8ZTyYviXAHiYpjc4PxpzCkB56JBjRte+Ed+AhzGSPC0+qKUgPQqtAkBAf8kfc0eRgQUoSYUyJ9YeqDmuR9mRlqMAwIWiZChJcp/R/r7SM/4GFXdZ/Vop2gV+FaA/IMe+BLKXLgVOEMP1AkAKnb2hlmlxK8DRMPSlQct36JXP2BzZLP5zUAPCXfg5515VlxN4J1t44+jd5XfCiuGSBV6oSVX5GH/Go/aWqlGpAkEA7zYAx6dz7BxAzV8FdrLVBjcKWZsRGwy5a/IED5ross1CJ0AXD4DTXBqN6Jkdm92eYB48VXMKltif8n7Bv1aFwA==";//PropertiesLoadUtil.getPropertiesValue("rongshu.yunkedai.prikey", "application.properties");
	
	public static <T> T  decrypt(CJRequestDto chuangJinRequestDto,Class<T> clazz)throws Exception{
		return decryp(chuangJinRequestDto, clazz, true);
	}
	
	public static FileUploadReq  decryptForFileUpload(CJRequestDto chuangJinRequestDto,Class<FileUploadReq> clazz)throws Exception{
		return decryp(chuangJinRequestDto, clazz, false);
	}
	
	/**
	 * 创金调云科谷，云科谷,验签解密，并转换为指定类型的对象<br>
	 * wanggang
	 * @param chuangJinRequestDto
	 * @param clazz
	 * @return
	 */
	public static <T> T  decryp(CJRequestDto chuangJinRequestDto,Class<T> clazz, boolean needLog)throws Exception{
		Map<String,String> map = checkAndDecrypt(chuangJinRequestDto, needLog);
		if(!"0".equals(map.get("status")))
			throw new RuntimeException("验签解密失败");
		if(StringUtils.isBlank(map.get("status")))
			throw new RuntimeException("请求参数为空");
		
		T returnObj = JSON.parseObject(map.get("request"), clazz);
		if(returnObj != null && needLog)
			MarvelsLogUtil.getInstance().info(chuangJinRequestDto.getRequestNo()+"解密之后的请求参数,returnObj="+JSON.toJSONString(returnObj));
		String requestNo = chuangJinRequestDto.getRequestNo();
		if(StringUtils.isNotBlank(requestNo)){
			if(returnObj instanceof RequestBaseDto) {
				try {
					Field  field = clazz.getSuperclass().getDeclaredField("ykgTraceNo");
					field.setAccessible(true);
					field.set(returnObj, requestNo);
				}catch(Exception e) {
					MarvelsLogUtil.getInstance().error("设置requestNo失败",e);;
				}
			}else if(returnObj instanceof Map) {
				try {
					Method  method = clazz.getDeclaredMethod("put", new Class<?>[]{Object.class,Object.class});
					method.invoke(returnObj, "ykgTraceNo",requestNo);
				}catch(Exception e) {
					MarvelsLogUtil.getInstance().error("设置requestNo失败",e);
				}
			}
		}
		
		return returnObj;
	}
	
	/**
	 * 创金调用云科谷，云科谷验签并解密出请求报文
	 * wanggang
	 * @param chuangJinRequestDto
	 * @return map 
	 * 当 String status =   map.get("status") =0，才表示验签成功，才可以取map.get("request")<br>
	 * status=-1，验签或解密异常，=1，验签失败
	 */
	private static Map<String,String> checkAndDecrypt(CJRequestDto chuangJinRequestDto, boolean needLog){
		Map<String,String> returnMap = new HashMap<String,String>();
		boolean flag = false;
				
		//1.用公钥进行验签
		try {
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("channelId", chuangJinRequestDto.getChannelId());
			paramMap.put("timestamp", chuangJinRequestDto.getTimestamp()+"");
			paramMap.put("request", chuangJinRequestDto.getRequest());
			if(StringUtils.isNotBlank(chuangJinRequestDto.getProductId()))
				paramMap.put("productId", chuangJinRequestDto.getProductId());
			if (needLog) {
				MarvelsLogUtil.getInstance().info("checkAndDecryptrequest="+JSON.toJSONString(chuangJinRequestDto));
			}
		    flag = Signature.checkSignSHA1(paramMap, chuangJinRequestDto.getSign(), cjpubKey);
	        
	        if(!flag){//验签没通过
	        	returnMap.put("status", "10004");
	        	returnMap.put("message", "验签失败");
	        	return returnMap;
	        }
	        
	        String request = null;
	        request =Signature.decryptAES(aesKey,chuangJinRequestDto.getRequest());
	        
			returnMap.put("status", "0");
			returnMap.put("request", request);
			return returnMap;
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error("验签或者解密发生异常,chuangJinRequestDto="+JSON.toJSONString(chuangJinRequestDto), e);
			returnMap.put("status", "10005");
			returnMap.put("message", "验签或者解密异常");
			return returnMap;
		}
	}
	
	
	/**
	 * 云科谷调创金，先加密，再签名
	 * wanggang
	 * @param obj
	 * @return  
	 */
	public static CJRequestDto encryptAndSign(Object obj) {
		try {
			CJRequestDto requestDto = new CJRequestDto();
			requestDto.setChannelId("ykg");
			requestDto.setTimestamp(new Date().getTime());
			
			//1.先对对象进行加密
			String request  = Signature.encryptAES(aesKey, JSON.toJSONString(obj));
			requestDto.setRequest(request);
			
			//2.进行签名
			Map<String,String> param = new HashMap<String,String>();
	        param.put("channelId", requestDto.getChannelId()+"");
	        param.put("timestamp", requestDto.getTimestamp()+"");
	        param.put("request",requestDto.getRequest());
	        String sign = Signature.signSHA1(param, ykdPriKey);
			requestDto.setSign(sign);
		return requestDto;
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error("加密或者签名失败,request="+JSON.toJSONString(obj), e);
			return null;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		String requestStr = "{\"channelId\":\"chuangjin\",\"request\":\"F0100200B80DFD11865F1A51B3C1966EF26762C6A08F247AEB8A816CAE2B8C8A\",\"sign\":\"f6yfXpzvpZEIXbkYIICfarbW9id2EtdUAlpg3WfGtV5SPrGXrNK4n/xyWqXVTBJT11WHPaQyzMzyWaYEe0ZURDmG91qw4QmaOEGJnzBak9bSCJLwX1yTu1VUCiiQf/A1qhZ9Y1EC5dHs4IFDvS6kgDmyFabY7Y82gkj3N/Gk17E=\",\"timestamp\":1566266748309}";
		MarvelsLogUtil.getInstance().info(JSON.toJSONString(decrypt(JSON.parseObject(requestStr, CJRequestDto.class),Map.class)));
	}

}
