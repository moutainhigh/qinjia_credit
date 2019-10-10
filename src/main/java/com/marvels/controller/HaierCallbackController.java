package com.marvels.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.chuangjin.util.HttpClient;
import com.marvels.common.util.hexj.dto.CallbackRepaymentRequest;
import com.marvels.common.util.hexj.dto.CallbackRequest;
import com.marvels.common.util.hexj.dto.CallbackResponse;
import com.marvels.common.util.hexj.dto.CallbackResponseBody;
import com.marvels.common.util.hexj.dto.CallbackResponseHead;
import com.marvels.dao.XyqbReqInfoMapper;
import com.marvels.dto.common.ReturnCode;
import com.marvels.dto.common.XyqbReqInfo;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import com.marvels.hm.beforeLending.dto.HmLoanInfo;
import com.marvels.hm.beforeLending.dto.HmProductInfo;
import com.marvels.hm.beforeLending.service.HmLoanInfoService;
import com.marvels.hm.beforeLending.service.HmProductInfoService;
import com.marvels.hm.user.dto.HmUserInfo;
import com.marvels.hm.user.service.HmUserManagerService;
import com.marvels.service.XyqbService;

/**
 * 消金回调
 * @author jason
 *
 */
@RestController
@RequestMapping
public class HaierCallbackController {
	
	@Autowired
	private XyqbReqInfoMapper xyqbReqInfoMapper;
	@Autowired
	private XyqbService xyqbService;
	@Autowired
	private HmLoanInfoService loanInfoService;
	@Autowired
	private HmProductInfoService productInfoService;
	@Autowired
	private HmUserManagerService hmUserManagerService;
	/**
	 * 实现接口文档LP40008
	 * @param callbackRequest
	 * @return
	 */
	@RequestMapping("haier/callback")
	public CallbackResponse processCallback(@RequestBody CallbackRequest callbackRequest) {
		String requestJson = JSON.toJSONString(callbackRequest);
		MarvelsLogUtil.getInstance().info("LP40008收到海尔回调消息：" + requestJson);
		try {
			// 记录到数据库
			XyqbReqInfo record = new XyqbReqInfo();
			record.setCreatedDate(new Date());
			record.setUpdatedDate(new Date());
			record.setInterfaceNo("LP40008");
			record.setReqJson(requestJson);
			record.setSerNo(callbackRequest.getHead().getSerno());
			xyqbReqInfoMapper.insertSelective(record);
			//获取结果转对象
			JSONObject obj = JSONObject.parseObject(requestJson);
			HmLoanInfo loan = new HmLoanInfo();
			//调用海尔10011接口查询实时额度入库更新状态
			QuotaReq quotaReq = new QuotaReq();
			quotaReq.setIdNo(obj.getString("idNo"));
			quotaReq.setIdTyp("20");
			quotaReq.setCreditTyp("01");
			quotaReq.setTradeCode("100200");
			ReqToHaierResultDto LP10011Result = xyqbService.queryQuota(quotaReq);
			if ("0000".equals(LP10011Result.getReturnCode())) {
				JSONObject LP10011Object = JSONObject.parseObject(LP10011Result.getBody());
				HmLoanInfo LP10011Loan = new HmLoanInfo();
				LP10011Loan.setCreditType(LP10011Object.getString("creditType"));
				LP10011Loan.setCrdAmt(LP10011Object.getString("crdAmt"));
				LP10011Loan.setApplSeq(LP10011Object.getString("applSeq"));
				LP10011Loan.setCrdSts(LP10011Object.getString("crdSts"));
				LP10011Loan.setContDt(LP10011Object.getString("contDt"));
				loanInfoService.updateByAppSeq(LP10011Loan);
				//查询userid
				HmLoanInfo loanInfo = loanInfoService.queryByAppSeq(obj.getString("applSeq"));
				//更新user表额度信息
				HmUserInfo user = new HmUserInfo();
				user.setUserId(Long.valueOf(loanInfo.getUserId()));
				user.setCreditAmount(LP10011Object.getBigDecimal("crdAmt"));
				hmUserManagerService.updateUserInfo(user);
			}
			loan.setApplSeq(obj.getString("applSeq"));
			loan.setChannelNo(obj.getString("channelNo"));
			loan.setOutSts(obj.getString("outSts"));
			loan.setStatus("额度推送");
			loan.setMessage(obj.getString("message"));
			loan.setIdNo(obj.getString("idNo"));
			loan.setMsgType(obj.getString("msgType"));
			loanInfoService.updateByAppSeq(loan);
			
			if (null != obj.getJSONArray("productInfo")) {
				//插入产品信息
				JSONArray productList = obj.getJSONArray("productInfo");
				if (productList.size()>0) {
					for (int i = 0; i < productList.size(); i++) {
						JSONObject productObject = productList.getJSONObject(i);
						HmProductInfo product = new HmProductInfo();
						product.setApplSeq(obj.getString("applSeq"));
						product.setTypCde(productObject.getString("typCde"));
						product.setTypSeq(productObject.getString("typSeq"));
						product.setMinAmt(productObject.getString("minAmt"));
						product.setMaxAmt(productObject.getString("maxAmt"));
						product.setTnrOpt(productObject.getString("tnrOpt"));
						product.setTnrMaxDays(productObject.getString("tnrMaxDays"));
						product.setMtdCde(productObject.getString("mtdCde"));
						product.setMtdDesc(productObject.getString("mtdDesc"));
						product.setDocChannel(productObject.getString("docChannel"));
						product.setDueDayOpt(productObject.getString("dueDayOpt"));
						product.setDueDay(productObject.getString("dueDay"));
						product.setTypFreq(productObject.getString("typFreq"));
						product.setTypGrp(productObject.getString("typGrp"));
						product.setMtdTypeCde(productObject.getString("mtdTypeCde"));
						productInfoService.insert(product);
						if (null != productObject.getJSONArray("intRatList")) {
							JSONArray intRatList = obj.getJSONArray("productInfo");
							for (int j = 0; j < intRatList.size(); j++) {
								JSONObject intRatObject = productList.getJSONObject(i);
								//存入利息利率表信息（未实现）
								
								
								
								
								if (null !=intRatObject.getJSONArray("resultList") ) {
									JSONArray valueAdd = obj.getJSONArray("resultList");
									for (int k = 0; k < valueAdd.size(); k++) {
										//存储增值业务（未实现）
									}
									
								}
								
							}
						}
						
					}
				}
			}
			
			
		} catch (Exception e) {
			// 出错不能影响回调流程
		}
		boolean success = true;// TODO 业务逻辑
		CallbackResponse callbackResponse = new CallbackResponse();
		CallbackResponseHead head = new CallbackResponseHead();
		CallbackResponseBody body = new CallbackResponseBody();
		callbackResponse.setHead(head);
		callbackResponse.setBody(body);
		// 继续回调下游
		ReqToHaierResultDto dto = new ReqToHaierResultDto();
		dto.setReturnCode(ReturnCode.SUCCESS);
		dto.setSerno(callbackRequest.getHead().getSerno());
		dto.setBody(JSON.toJSONString(callbackRequest.getBody()));
		String backurl = PropertiesLoadUtil.getPropertiesValue("chuangjin.lp40008.backurl", "forms-openapi.properties");
		if (StringUtils.isNotBlank(backurl)) {
			MarvelsLogUtil.getInstance().info("LP40008请求创金回调地址："+backurl);
			MarvelsLogUtil.getInstance().info("LP40008请求创金回调消息："+JSON.toJSONString(callbackRequest));
			String requestData = JSON.toJSONString(dto);
			String result = HttpClient.sendJson(backurl, "", requestData);
			MarvelsLogUtil.getInstance().info("LP40008创金收到回调并回复消息："+result);
			if (StringUtils.isNotBlank(result)) {
				if (result.contains("&&")) {
					result = result.substring(0, result.indexOf("&&"));
				}
				JSONObject json = JSON.parseObject(result);
				if (ReturnCode.SUCCESS.equals(json.getString("returnCode"))) {
					head.setRetFlag(ReturnCode.SUCCESS);
					return callbackResponse;
				} else {
					head.setRetFlag(json.getString("returnCode"));
					head.setRetMsg(json.getString("returnMsg"));
					return callbackResponse;
				}
			}
		}
		head.setRetFlag(ReturnCode.SYSTEM_ERROR);
		head.setRetMsg("系统错误");
		return callbackResponse;
	}
	
	/**
	 * 实现接口文档LP30004
	 * @param callbackRequest
	 * @return
	 */
	@RequestMapping("haier/callback/repayment")
	public CallbackResponseHead processCallbackForRepayment(@RequestBody CallbackRepaymentRequest callbackRequest) {
		String requestJson = JSON.toJSONString(callbackRequest);
		MarvelsLogUtil.getInstance().info("LP30004收到海尔回调消息：" + requestJson);
		try {
			// 记录到数据库
			XyqbReqInfo record = new XyqbReqInfo();
			record.setCreatedDate(new Date());
			record.setUpdatedDate(new Date());
			record.setInterfaceNo("LP30004");
			record.setReqJson(requestJson);
			record.setSerNo(callbackRequest.getHead().getSerno());
			xyqbReqInfoMapper.insertSelective(record);
		} catch (Exception e) {
			// 出错不能影响回调流程
		}
		boolean success = true;// TODO 业务逻辑
		// 继续回调下游
		ReqToHaierResultDto dto = new ReqToHaierResultDto();
		dto.setReturnCode(ReturnCode.SUCCESS);
		dto.setSerno(callbackRequest.getHead().getSerno());
		dto.setBody(JSON.toJSONString(callbackRequest.getBody()));
		String backurl = PropertiesLoadUtil.getPropertiesValue("chuangjin.lp30004.backurl", "forms-openapi.properties");
		if (StringUtils.isNotBlank(backurl)) {
			MarvelsLogUtil.getInstance().info("LP30004请求创金回调消息："+JSON.toJSONString(callbackRequest));
			String result = HttpClient.sendJson(backurl, "", JSON.toJSONString(dto));
			MarvelsLogUtil.getInstance().info("LP30004创金收到回调并回复消息："+result);
			if (StringUtils.isNotBlank(result)) {
				if (result.contains("&&")) {
					result = result.substring(0, result.indexOf("&&"));
				}
				JSONObject json = JSON.parseObject(result);
				if (ReturnCode.SUCCESS.equals(json.getString("returnCode"))) {
					return new CallbackResponseHead(ReturnCode.SUCCESS);
				} else {
					CallbackResponseHead head = new CallbackResponseHead();
					head.setRetFlag(json.getString("returnCode"));
					head.setRetMsg(json.getString("returnMsg"));
					return head;
				}
			}
		}
		CallbackResponseHead head = new CallbackResponseHead();
		head.setRetFlag(ReturnCode.SYSTEM_ERROR);
		head.setRetMsg("系统错误");
		return head;
	}
	
	
}
