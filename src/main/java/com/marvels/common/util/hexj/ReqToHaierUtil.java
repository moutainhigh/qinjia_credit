package com.marvels.common.util.hexj;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvels.common.enums.XyqbCodeAndUrlEnum;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.hexj.dto.ReqToHaierDto;
import com.marvels.common.util.hexj.dto.ReqToHaierHeader;
import com.marvels.common.util.hexj.dto.ReqToHaierMsg;
import com.marvels.common.util.hexj.dto.ReqToHaierRspHeader;
import com.marvels.common.util.hexj.utils.HttpClient;
import com.marvels.common.util.hexj.utils.RSAUtils;
import com.marvels.common.util.hexj.utils.ReqNoUtil;
import com.marvels.common.util.hexj.utils.SignUtils;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;

/**
 * 向海尔消金发送请求工具类
 * @author wanggang
 *
 */
public class ReqToHaierUtil {
	
    /**
     * 海尔消金提供给渠道方的验签公钥，与HaierRespToChannel.java中的私钥（hexjSignPrivateKey）配对
     * 以实际提供为准
     */
    //维信
    private final static String hexjSignPublicKey = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.hexjSignPublicKey","forms-openapi.properties");

    /**
     * 渠道方自己生成的的签名私钥，与HaierRespToChannel.java中的私钥（channelSignPublicKey）配对
     * 以实际提供为准 B7
     */
    //维信
    private final static String channelSignPrivateKey = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelSignPrivateKey","forms-openapi.properties");
    
    
    public static ReqToHaierResultDto requestRiskUpload(String requestPath,String tradeCode,RiskInfoUploadReq body){
    	body.setChannelno(PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno","forms-openapi.properties"));
    	String requestString = JSON.toJSONString(body);
    	MarvelsLogUtil.getInstance().info("进入[风险上送向海尔消金发送请求],入参:tradeCode="+tradeCode+",request="+requestString);
    	ReqToHaierResultDto resultDto = new ReqToHaierResultDto();
    	
    	try {
    		
    		ReqToHaierDto reqToHaierDto = new ReqToHaierDto();
    		reqToHaierDto.setApplyNo(ReqNoUtil.generateSerno());
	    	String encryptDate = RSAUtils.encryptRSA(requestString, channelSignPrivateKey);
	    	reqToHaierDto.setData(encryptDate);
	    	reqToHaierDto.setTradeCode(tradeCode);
	    	 
	    	 //3 签名,签名信息存放header的X-Signature中,再网络发送
	         String signStr = SignUtils.sign(new ObjectMapper().writeValueAsString(reqToHaierDto), channelSignPrivateKey);
	         
	         //4 发送请求
	         String requestBodyStr = new ObjectMapper().writeValueAsString(reqToHaierDto);
	         String url = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.host.url","forms-openapi.properties");
	         MarvelsLogUtil.getInstance().info("开始[风险上送向海尔消金发送请求],appno="+reqToHaierDto.getApplyNo()+",原始数据="+requestString+",requestBodyStr="+requestBodyStr+",signStr="+signStr);
	         String resp = HttpClient.sendJson(url+"/"+requestPath, signStr, requestBodyStr);
	         MarvelsLogUtil.getInstance().info("[风险上送向海尔消金发送请求],海尔返回="+JSON.toJSONString(resp));
	         String[] reqSignStr = resp.split("&&");
	         ReqToHaierRspHeader reqToHaierRspHeader = JSON.parseObject(reqSignStr[0], ReqToHaierRspHeader.class);
	         resultDto.setReturnCode(reqToHaierRspHeader.getHead().getRetFlag());
	         resultDto.setReturnMsg(reqToHaierRspHeader.getHead().getRetMsg());
	         
	         //5 验签
	         if (!SignUtils.verify(reqSignStr[0], hexjSignPublicKey, reqSignStr[1])) {
	             throw new RuntimeException("验签失败");
	         } else {
	        	 MarvelsLogUtil.getInstance().info("[风险上送向海尔消金发送请求],验签成功");
	         }
	         
	         //6 解密
	         JSONObject jsonObject = JSON.parseObject(reqSignStr[0]);
	         String decryptData = "";
	         if (jsonObject.containsKey("body")) {
	             String bodyData = jsonObject.getString("body");
	             if (StringUtils.isNotEmpty(bodyData)) {
	                 decryptData = RSAUtils.decryptRSA(bodyData, hexjSignPublicKey);
	             }
	         }
	         resultDto.setBody(decryptData);
	         if(!XyqbCodeAndUrlEnum.LP40003.getCode().equals(tradeCode)) {
	        	 MarvelsLogUtil.getInstance().info("[风险上送向海尔消金发送请求],海尔返回数据,解密后="+JSON.toJSONString(resultDto));
	         }
	         return resultDto;
    	}catch(Exception e) {
    		MarvelsLogUtil.getInstance().error("风险上送向海尔消金发送请求,系统异常",e);
    		resultDto.setReturnCode("9999");
    		resultDto.setReturnMsg("风险上送向海尔发送请求,系统发生异常");
    		return resultDto;
    	}
    }
    
    /**
     * 向海尔消金发送请求,并返回响应
     * @param requestPath  具体接口地址(去掉域名地址,只需要后面的路径)
     * @param tradeCode 每个接口对应的tradeCode 
     * @param body 真正要传的数据
     * @return
     *@author wanggang
     */
    public static ReqToHaierResultDto request(String requestPath,String tradeCode,Object body){
    	MarvelsLogUtil.getInstance().info("进入[向海尔消金发送请求],入参:tradeCode="+tradeCode+",body="+JSON.toJSONString(body));
    	ReqToHaierResultDto resultDto = new ReqToHaierResultDto();
    	
    	try {
    		//1 组装消息
	    	ReqToHaierHeader head = new ReqToHaierHeader(tradeCode);
	    	resultDto.setSerno(head.getSerno());//记录发给海尔的请求号
	    	ReqToHaierMsg reqToHaierMsg = new ReqToHaierMsg();
	    	reqToHaierMsg.setHead(head);
	    	reqToHaierMsg.setBody(body);
	    	
	    	ReqToHaierDto reqToHaierDto = new ReqToHaierDto();
	    	reqToHaierDto.setData(JSON.toJSONString(reqToHaierMsg));
	    	
	    	//2 加密
	    	 String encryptDate = RSAUtils.encryptRSA(reqToHaierDto.getData(), channelSignPrivateKey);
	    	 reqToHaierDto.setData(encryptDate);
	    	 
	    	 //3 签名,签名信息存放header的X-Signature中,再网络发送
	         String signStr = SignUtils.sign(new ObjectMapper().writeValueAsString(reqToHaierDto), channelSignPrivateKey);
	         
	         //4 发送请求
	         String requestBodyStr = new ObjectMapper().writeValueAsString(reqToHaierDto);
	         String url = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.host.url","forms-openapi.properties");
	         MarvelsLogUtil.getInstance().info("开始[向海尔消金发送请求],serno="+head.getSerno()+",原始数据="+JSON.toJSONString(body)+",requestBodyStr="+requestBodyStr+",signStr="+signStr);
	         String resp = HttpClient.sendJson(url+"/"+requestPath, signStr, requestBodyStr);
	         MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],海尔返回="+JSON.toJSONString(resp));
	         String[] reqSignStr = resp.split("&&");
	         ReqToHaierRspHeader reqToHaierRspHeader = JSON.parseObject(reqSignStr[0], ReqToHaierRspHeader.class);
	         resultDto.setReturnCode(reqToHaierRspHeader.getHead().getRetFlag());
	         resultDto.setReturnMsg(reqToHaierRspHeader.getHead().getRetMsg());
	         
	         //5 验签
	         if (!SignUtils.verify(reqSignStr[0], hexjSignPublicKey, reqSignStr[1])) {
	             throw new RuntimeException("验签失败");
	         } else {
	        	 MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],验签成功");
	         }
	         
	         //6 解密
	         JSONObject jsonObject = JSON.parseObject(reqSignStr[0]);
	         String decryptData = "";
	         if (jsonObject.containsKey("body")) {
	             String bodyData = jsonObject.getString("body");
	             if (StringUtils.isNotEmpty(bodyData)) {
	                 decryptData = RSAUtils.decryptRSA(bodyData, hexjSignPublicKey);
	             }
	         }
	         resultDto.setBody(decryptData);
	         if(!XyqbCodeAndUrlEnum.LP40003.getCode().equals(tradeCode)) {
	        	 MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],海尔返回数据,解密后="+JSON.toJSONString(resultDto));
	         }
	         return resultDto;
    	}catch(Exception e) {
    		MarvelsLogUtil.getInstance().error("向海尔消金发送请求,系统异常",e);
    		resultDto.setReturnCode("9999");
    		resultDto.setReturnMsg("向海尔发送请求,系统发生异常");
    		return resultDto;
    	}
    }
    
    /**
     * 向海尔消金发送请求,并返回响应
     * @param requestPath  具体接口地址(去掉域名地址,只需要后面的路径)
     * @param tradeCode 每个接口对应的tradeCode 
     * @param body 真正要传的数据
     * @return
     *@author wanggang
     */
    public static ReqToHaierResultDto request(String requestPath,String tradeCode,Object body,Object head){
    	MarvelsLogUtil.getInstance().info("进入[向海尔消金发送请求],入参:tradeCode="+tradeCode+",body="+JSON.toJSONString(body));
    	ReqToHaierResultDto resultDto = new ReqToHaierResultDto();
    	
    	try {
    		//1 组装消息
	    	ReqToHaierMsg reqToHaierMsg = new ReqToHaierMsg();
	    	reqToHaierMsg.setHead(head);
	    	reqToHaierMsg.setBody(body);
	    	
	    	ReqToHaierDto reqToHaierDto = new ReqToHaierDto();
	    	reqToHaierDto.setData(JSON.toJSONString(reqToHaierMsg));
	    	
	    	//2 加密
	    	 String encryptDate = RSAUtils.encryptRSA(reqToHaierDto.getData(), channelSignPrivateKey);
	    	 reqToHaierDto.setData(encryptDate);
	    	 
	    	 //3 签名,签名信息存放header的X-Signature中,再网络发送
	         String signStr = SignUtils.sign(new ObjectMapper().writeValueAsString(reqToHaierDto), channelSignPrivateKey);
	         
	         //4 发送请求
	         String requestBodyStr = new ObjectMapper().writeValueAsString(reqToHaierDto);
	         String url = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.host.url","forms-openapi.properties");
	         MarvelsLogUtil.getInstance().info("开始[向海尔消金发送请求],requestBodyStr="+requestBodyStr+",signStr="+signStr);
	         String resp = HttpClient.sendJson(url+"/"+requestPath, signStr, requestBodyStr);
	         MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],海尔返回="+JSON.toJSONString(resp));
	         String[] reqSignStr = resp.split("&&");
	         ReqToHaierRspHeader reqToHaierRspHeader = JSON.parseObject(reqSignStr[0], ReqToHaierRspHeader.class);
	         resultDto.setReturnCode(reqToHaierRspHeader.getHead().getRetFlag());
	         resultDto.setReturnMsg(reqToHaierRspHeader.getHead().getRetMsg());
	         
	         //5 验签
	         if (!SignUtils.verify(reqSignStr[0], hexjSignPublicKey, reqSignStr[1])) {
	             throw new RuntimeException("验签失败");
	         } else {
	        	 MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],验签成功");
	         }
	         
	         //6 解密
	         JSONObject jsonObject = JSON.parseObject(reqSignStr[0]);
	         String decryptData = "";
	         if (jsonObject.containsKey("body")) {
	             String bodyData = jsonObject.getString("body");
	             if (StringUtils.isNotEmpty(bodyData)) {
	                 decryptData = RSAUtils.decryptRSA(bodyData, hexjSignPublicKey);
	             }
	         }
	         resultDto.setBody(decryptData);
	         return resultDto;
    	}catch(Exception e) {
    		MarvelsLogUtil.getInstance().error("向海尔消金发送请求,系统异常",e);
    		resultDto.setReturnCode("9999");
    		resultDto.setReturnMsg("向海尔发送请求,系统发生异常");
    		return resultDto;
    	}
    }
    
    public static ReqToHaierResultDto requestFileUpload(String requestPath,String tradeCode,FileUploadReq request){
    	MarvelsLogUtil.getInstance().info("进入[向海尔消金发送请求],入参:tradeCode="+tradeCode);
    	ReqToHaierResultDto resultDto = new ReqToHaierResultDto();
    	String requestBodyStr = null;
    	try {
	    	
	    	ReqToHaierDto reqToHaierDto = new ReqToHaierDto();
	    	String channelNo = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno","forms-openapi.properties");
	    	reqToHaierDto.setChannelNo(channelNo);
	    	reqToHaierDto.setTradeCode(tradeCode);
	    	reqToHaierDto.setApplyNo(request.getAppno());
	    	request.setChannelNo(channelNo);
	    	reqToHaierDto.setData(JSON.toJSONString(request));
	         String signStr = SignUtils.sign(new ObjectMapper().writeValueAsString(reqToHaierDto), channelSignPrivateKey);
	         
	         requestBodyStr = new ObjectMapper().writeValueAsString(reqToHaierDto);
	         String url = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.host.url","forms-openapi.properties");
	         //MarvelsLogUtil.getInstance().info("开始[文件上传向海尔消金发送请求],appno="+request.getAppno()+",原始数据="+reqToHaierDto.getData());
	         MarvelsLogUtil.getInstance().info("开始[文件上传向海尔消金发送请求],appno="+request.getAppno()+",signStr="+signStr);
	         String resp = HttpClient.sendJson(url+"/"+requestPath, signStr, requestBodyStr);
	         MarvelsLogUtil.getInstance().info("[文件上传向海尔消金发送请求],海尔返回="+JSON.toJSONString(resp));
	         String[] reqSignStr = resp.split("&&");
	         ReqToHaierRspHeader reqToHaierRspHeader = JSON.parseObject(reqSignStr[0], ReqToHaierRspHeader.class);
	         resultDto.setReturnCode(reqToHaierRspHeader.getHead().getRetFlag());
	         resultDto.setReturnMsg(reqToHaierRspHeader.getHead().getRetMsg());
	         
	         if (!SignUtils.verify(reqSignStr[0], hexjSignPublicKey, reqSignStr[1])) {
	             throw new RuntimeException("验签失败");
	         } else {
	        	 MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],验签成功");
	         }
	         
	         JSONObject jsonObject = JSON.parseObject(reqSignStr[0]);
	         String decryptData = "";
	         if (jsonObject.containsKey("body")) {
	             String bodyData = jsonObject.getString("body");
	             if (StringUtils.isNotEmpty(bodyData)) {
	                 decryptData = RSAUtils.decryptRSA(bodyData, hexjSignPublicKey);
	             }
	         }
	         resultDto.setBody(decryptData);
	         MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],海尔返回数据,解密后="+JSON.toJSONString(resultDto));
	         return resultDto;
    	} catch(Exception e) {
    		MarvelsLogUtil.getInstance().error("向海尔消金发送请求,系统异常, 上传内容为："+requestBodyStr);
    		MarvelsLogUtil.getInstance().error("向海尔消金发送请求,系统异常",e);
    		resultDto.setReturnCode("9999");
    		resultDto.setReturnMsg("向海尔发送请求,系统发生异常");
    		return resultDto;
    	}
    }
    public static ReqToHaierResultDto requestFiledownload(String requestPath,String tradeCode,FileDownloadReq request){
    	MarvelsLogUtil.getInstance().info("进入[向海尔消金发送请求],入参:tradeCode="+tradeCode);
    	ReqToHaierResultDto resultDto = new ReqToHaierResultDto();
    	try {
	    	
	    	ReqToHaierDto reqToHaierDto = new ReqToHaierDto();
	    	String channelNo = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno","forms-openapi.properties");
	    	reqToHaierDto.setChannelNo(channelNo);
	    	reqToHaierDto.setTradeCode(tradeCode);
	    	request.setChannelNo(channelNo);
	    	reqToHaierDto.setData(JSON.toJSONString(request));
	    	//2 加密
	    	 String encryptDate = RSAUtils.encryptRSA(reqToHaierDto.getData(), channelSignPrivateKey);
	    	 reqToHaierDto.setData(encryptDate);
	         String signStr = SignUtils.sign(new ObjectMapper().writeValueAsString(reqToHaierDto), channelSignPrivateKey);
	         
	         String requestBodyStr = new ObjectMapper().writeValueAsString(reqToHaierDto);
	         String url = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.host.url","forms-openapi.properties");
	         MarvelsLogUtil.getInstance().info("开始[文件下载向海尔消金发送请求],appno="+request.getAppno()+",signStr="+signStr);
	         String resp = HttpClient.sendJson(url+"/"+requestPath, signStr, requestBodyStr);
	         MarvelsLogUtil.getInstance().info("[文件下载向海尔消金发送请求],海尔返回="+JSON.toJSONString(resp));
	         String[] reqSignStr = resp.split("&&");
	         ReqToHaierRspHeader reqToHaierRspHeader = JSON.parseObject(reqSignStr[0], ReqToHaierRspHeader.class);
	         resultDto.setReturnCode(reqToHaierRspHeader.getHead().getRetFlag());
	         resultDto.setReturnMsg(reqToHaierRspHeader.getHead().getRetMsg());
	         
	         if (!SignUtils.verify(reqSignStr[0], hexjSignPublicKey, reqSignStr[1])) {
	             throw new RuntimeException("验签失败");
	         } else {
	        	 MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],验签成功");
	         }
	         
	         JSONObject jsonObject = JSON.parseObject(reqSignStr[0]);
	         String decryptData = "";
	         if (jsonObject.containsKey("body")) {
	             String bodyData = jsonObject.getString("body");
	             if (StringUtils.isNotEmpty(bodyData)) {
	                 decryptData = RSAUtils.decryptRSA(bodyData, hexjSignPublicKey);
	             }
	         }
	         resultDto.setBody(decryptData);
	         MarvelsLogUtil.getInstance().info("[向海尔消金发送请求],海尔返回数据,解密后="+JSON.toJSONString(resultDto));
	         return resultDto;
    	} catch(Exception e) {
    		MarvelsLogUtil.getInstance().error("向海尔消金发送请求,系统异常",e);
    		resultDto.setReturnCode("9999");
    		resultDto.setReturnMsg("向海尔发送请求,系统发生异常");
    		return resultDto;
    	}
    }
    public static void main(String[] args){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("applSeq", "13441903");
    	MarvelsLogUtil.getInstance().info(JSON.toJSONString(request("hrlp/credit/LP10008", "ACQ-4001", map)));
	}
}
