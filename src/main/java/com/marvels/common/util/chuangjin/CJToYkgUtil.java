package com.marvels.common.util.chuangjin;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.chuangjin.util.CJRequestDto;
import com.marvels.common.util.chuangjin.util.Signature;

/**
 * 创金与云科谷对接，数据安全工具类
 * @author Administrator
 *
 */
public class CJToYkgUtil {
	
	public static String aesKey = PropertiesLoadUtil.getPropertiesValue("cjykg.aesKey","forms-openapi.properties");//"4FE8645B8EAF88EA0ADADA6FAEDD3A29";//双方约定的加密秘钥(由云科谷提供)
	
	//以下一对公私钥，上线后由创金生成并提供公钥给云科谷
	public static String ykgpubKey = PropertiesLoadUtil.getPropertiesValue("cjykg.ykgpubKey","forms-openapi.properties");//"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDR3nhllG5VRj1+df5CY1v+qVYtWuIZV17e2u5gRxw+fcJb6BGBkPNibXO5HPMS3ScmkzlpSnp4wBt+zTVy52Haa2CbQgG2wiuhEHnHig/IT6PHtyCX6roRgbh5Mu3I8F1MqZ/zuXBOBggie/4FGNI9yMESjx50NRAVUBHibEltwIDAQAB";//PropertiesLoadUtil.getPropertiesValue("rongshu.yunkedai.pubkey", "application.properties");
	public static String cjPriKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMNHeeGWUblVGPX51/kJjW/6pVi1a4hlXXt7a7mBHHD59wlvoEYGQ82Jtc7kc8xLdJyaTOWlKenjAG37NNXLnYdprYJtCAbbCK6EQeceKD8hPo8e3IJfquhGBuHky7cjwXUypn/O5cE4GCCJ7/gUY0j3IwRKPHnQ1EBVQEeJsSW3AgMBAAECgYBCDCzHBeaCPqwAlg5cJsT1uNqv1DyYl2A04Zuf1HFgLMtHH8AfrwLDw+4AGfiogmTgirezfFdeye5dRHesT//pMyHTvLr3DDp7sLWMznQH8C8/h1gVeGzMNuae1S8DPTgbqsAOGMq++EpnPJigHGZLdYIk3HY6yDWy1/0V6Jh5EQJBAPOUZVys/ichShoe0sRFZVJRuqUulV3pd9ziU00eVuGgA9g1Wp5bKyKKc1mNh45MDL86L3PQxzA+jlJw8hrwAnMCQQDNPJUrWX0spRPbSC5iDaXPrHU7zZuCeumE8ZTyYviXAHiYpjc4PxpzCkB56JBjRte+Ed+AhzGSPC0+qKUgPQqtAkBAf8kfc0eRgQUoSYUyJ9YeqDmuR9mRlqMAwIWiZChJcp/R/r7SM/4GFXdZ/Vop2gV+FaA/IMe+BLKXLgVOEMP1AkAKnb2hlmlxK8DRMPSlQct36JXP2BzZLP5zUAPCXfg5515VlxN4J1t44+jd5XfCiuGSBV6oSVX5GH/Go/aWqlGpAkEA7zYAx6dz7BxAzV8FdrLVBjcKWZsRGwy5a/IED5ross1CJ0AXD4DTXBqN6Jkdm92eYB48VXMKltif8n7Bv1aFwA==";//PropertiesLoadUtil.getPropertiesValue("rongshu.yunkedai.prikey", "application.properties");
	
	/**
	 * 创金调云科谷，先加密，再签名
	 * wanggang
	 * @param obj
	 * @return  
	 */
	public static CJRequestDto encryptAndSign(Object obj) {
		try {
			CJRequestDto requestDto = new CJRequestDto();
			requestDto.setChannelId("chuangjin");
			requestDto.setTimestamp(new Date().getTime());
			
			//1.先对对象进行加密
			String request  = Signature.encryptAES(aesKey, JSON.toJSONString(obj));
			requestDto.setRequest(request);
			
			//2.进行签名
			Map<String,String> param = new HashMap<String,String>();
	        param.put("channelId", requestDto.getChannelId()+"");
	        param.put("timestamp", requestDto.getTimestamp()+"");
	        param.put("request",requestDto.getRequest());
	        String sign = Signature.signSHA1(param, cjPriKey);
			requestDto.setSign(sign);
		return requestDto;
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error("加密或者签名失败,request="+JSON.toJSONString(obj), e);
			return null;
		}
	}
	
	
	/**
	 * 云科谷回调创金，创金,验签解密，并转换为指定类型的对象<br>
	 * wanggang
	 * @param chuangJinRequestDto
	 * @param clazz
	 * @return
	 */
	public static <T> T  decrypt(CJRequestDto chuangJinRequestDto,Class<T> clazz)throws Exception{
		Map<String,String> map = checkAndDecrypt(chuangJinRequestDto);
		if(!"0".equals(map.get("status")))
			throw new RuntimeException("验签解密失败");
		if(StringUtils.isBlank(map.get("status")))
			throw new RuntimeException("请求参数为空");
		
		T returnObj = JSON.parseObject(map.get("request"), clazz);
		if(returnObj != null)
			MarvelsLogUtil.getInstance().info("解密之后的请求参数,returnObj="+JSON.toJSONString(returnObj));
		
		return returnObj;
	}
	
	/**
	 * 云科谷回调创金，创金验签并解密出请求报文
	 * wanggang
	 * @param chuangJinRequestDto
	 * @return map 
	 * 当 String status =   map.get("status") =0，才表示验签成功，才可以取map.get("request")<br>
	 * status=-1，验签或解密异常，=1，验签失败
	 */
	private static Map<String,String> checkAndDecrypt(CJRequestDto chuangJinRequestDto){
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
			
			MarvelsLogUtil.getInstance().info("checkAndDecryptrequest="+JSON.toJSONString(chuangJinRequestDto));
		    flag = Signature.checkSignSHA1(paramMap, chuangJinRequestDto.getSign(), ykgpubKey);
	        
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
	
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("applSeq", "17896448");
		CJRequestDto dto = encryptAndSign(map);
		dto.setRequestNo("8980erqwerqwerwe");
		MarvelsLogUtil.getInstance().info("待发给云科谷的报文"+JSON.toJSONString(dto));
	}
}
