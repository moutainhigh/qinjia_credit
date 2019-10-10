package com.marvels.external.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.marvels.common.enums.XyqbCodeAndUrlEnum;
import com.marvels.common.util.DBLogUtil;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.XyqbUtil;
import com.marvels.common.util.chuangjin.util.HttpClient;
import com.marvels.common.util.hexj.ReqToHaierUtil;
import com.marvels.dto.common.ReturnCode;
import com.marvels.dto.hexj.request.BankCardRouterAndQueryReq;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import com.marvels.dto.info.DecisionReqDto;
import com.marvels.external.HexjApi;

@Component("hexjApi")
public class HexjApiImpl implements HexjApi{
	
	private MarvelsLogUtil logger = MarvelsLogUtil.getInstance();

	@Autowired
	private XyqbCreditApplyInfoMapper xyqbCreditApplyInfoMapper;
	@Autowired
	private XyqbBindBankCardMapper xyqbBindBankCardMapper;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private CommonRiskService commonRiskService;
	@Autowired
	private RepaymentService repaymentService;
	@Autowired
	private DBLogUtil dbLogUtil;
	@Autowired
	private XyqbQuotaInfoMapper xyqbQuotaInfoMapper;
	@Autowired
	private XyqbQuotaDetailInfoMapper xyqbQuotaDetailInfoMapper;
	@Autowired
	private XyqbDecisionQueryInfoMapper xyqbDecisionQueryInfoMapper;
	
	/**
	 * 描述:【LP10001】签约路由+签约查询
	 */
	@Override
	public ReqToHaierResultDto bankCardRouterAndQuery(BankCardRouterAndQueryReq reqBean) {
		MarvelsLogUtil.getInstance().info("【LP10001】签约路由+签约查询接口入参:" + reqBean);
		// 入参空判断
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(reqBean));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		// 固定参数填充
		reqBean.setTraceNo("11");
		// 请求海尔接口
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10001.getUrl(), XyqbCodeAndUrlEnum.LP10001.getCode(),
				reqBean);
	}

	@Override
	public ReqToHaierResultDto criditApply(CriditApplyDto criditApplyDto) {
		MarvelsLogUtil.getInstance().info("[额度申请信息保存/修改(LP10008)]开始,入参="+JSON.toJSONString(criditApplyDto));
		
		//1 填充默认值(以下字段创金获取不到,所以就填海尔给的默认值)
		criditApplyDto.setAutoFlag("N");
		criditApplyDto.setCreditTyp("01");
		if(StringUtils.isBlank(criditApplyDto.getIndivEmpTel()))
			criditApplyDto.setIndivEmpTel(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.indivEmpTel","forms-openapi.properties"));
		criditApplyDto.setPptyLiveOpt(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.pptyLiveOpt","forms-openapi.properties"));
		criditApplyDto.setPptyLiveProvince(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.pptyLiveProvince","forms-openapi.properties"));
		criditApplyDto.setPptyLiveCity(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.pptyLiveCity","forms-openapi.properties"));
		criditApplyDto.setPptyLiveArea(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.pptyLiveArea","forms-openapi.properties"));
		criditApplyDto.setPptyRighName(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.pptyRighName","forms-openapi.properties"));
		criditApplyDto.setPptyLoanInd(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.pptyLoanInd","forms-openapi.properties"));
		criditApplyDto.setOperatorCde(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.operatorCde","forms-openapi.properties"));
		criditApplyDto.setOperatorTel(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.operatorTel","forms-openapi.properties"));
		criditApplyDto.setCooprCde(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.cooprCde","forms-openapi.properties"));
		criditApplyDto.setCooprName(PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.cooprName","forms-openapi.properties"));

		//2 检查必填项
//		String checkResult = XyqbUtil.requiredCheck(criditApplyDto);
//		if(StringUtils.isNotBlank(checkResult))
//			return new ReqToHaierResultDto(ReturnCode.REQUIRED_CHECK_NOT_PASS,"有必填项未输入",checkResult);
		
		//3 检查选填项
		StringBuilder sb = new StringBuilder();
		if("2".equals(criditApplyDto.getFlag()) && StringUtils.isBlank(criditApplyDto.getApplSeq()))
			sb.append("flag为2时applSeq必输,");
		if("Y".equals(criditApplyDto.getPptyLoanInd())) {//如果是按揭
			if(StringUtils.isBlank(criditApplyDto.getMortgageRatio()))
				sb.append("pptyLoanInd为Y则按揭比例(mortgageRatio)必输,");
			if(StringUtils.isBlank(criditApplyDto.getPptyLoanYear()))
				sb.append("pptyLoanInd为Y则按揭周期(pptyLoanYear)必输,");
			if(StringUtils.isBlank(criditApplyDto.getMortgagePartner()))
				sb.append("pptyLoanInd为Y则按揭参与人(mortgagePartner)必输,");
			if(StringUtils.isBlank(criditApplyDto.getPptyLoanBank()))
				sb.append("pptyLoanInd为Y则按揭银行(pptyLoanBank)必输,");
		}
		//这里暂只检查联系人列表是否非空,而没有具体去遍历检查
		if(criditApplyDto.getList() == null || CollectionUtils.isEmpty(criditApplyDto.getList().getRel()))
			sb.append("联系人列表不能为空,");
		if(StringUtils.isNotBlank(sb.toString()))
			return new ReqToHaierResultDto(ReturnCode.REQUIRED_CHECK_NOT_PASS,"有必填项未输入",sb.toString());
			
		//4 向海尔发请求
		ReqToHaierResultDto reqToHaierResultDto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10008.getUrl(), XyqbCodeAndUrlEnum.LP10008.getCode(), criditApplyDto);
		MarvelsLogUtil.getInstance().info("[额度申请信息保存/修改(LP10008)]结束,入参="+JSON.toJSONString(criditApplyDto)+",返回="+JSON.toJSONString(reqToHaierResultDto));
		
		//5 保存请求信息(失败不能影响正常的请求交互)
		try {
			if("00000".equals(reqToHaierResultDto.getReturnCode())) {
				JSONObject json = JSON.parseObject(reqToHaierResultDto.getBody());
				criditApplyDto.setApplSeq(json.getString("applSeq"));
			}else {
				criditApplyDto.setStatus(reqToHaierResultDto.getReturnCode());
				criditApplyDto.setRetMsg(reqToHaierResultDto.getReturnMsg());
			}
			criditApplyDto.setUpdatedDate(new Date());
			criditApplyDto.setCreatedDate(new Date());
			criditApplyDto.setSerNo(reqToHaierResultDto.getSerno());
			xyqbCreditApplyInfoMapper.insert(criditApplyDto);
			dbLogUtil.log("LP10008",criditApplyDto, reqToHaierResultDto);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error("保存额度申请信息异常", e);
		}
		return reqToHaierResultDto;
	}

	/**
	  *@title: 预绑卡请求入参
	　 *@Description【LP10002】单笔签约申请
	 */
	@Override
	public ReqToHaierResultDto preBindBankCard(PreBindBankCardReq reqBean) {
		MarvelsLogUtil.getInstance().info("【LP10002】单笔签约申请接口入参:" + reqBean);
		// 入参空判断
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(reqBean));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		// 固定参数填充
		reqBean.setTraceNo("11");
		reqBean.setInstitution(PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno","forms-openapi.properties"));
		// 请求海尔接口
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10002.getUrl(), XyqbCodeAndUrlEnum.LP10002.getCode(),
				reqBean);
	}

	/**
	 * 空判断校验
	 * @param requiredCheck
	 * @return
	 */
	private ReqToHaierResultDto reqFieldCheck(String requiredCheck){
		ReqToHaierResultDto reqToHaierResultDto = new ReqToHaierResultDto();
		if (requiredCheck != null) {
			if ("额度申请异常:0008(检查必填项出错)".equals(requiredCheck)) {
				MarvelsLogUtil.getInstance().info("【LP10001】签约路由+签约查询接口额度申请异常:0008(检查必填项出错)");
				reqToHaierResultDto.setReturnCode(ReturnCode.REQUIRED_CHECK_EXCEPTION);
				reqToHaierResultDto.setReturnMsg(requiredCheck);
				return reqToHaierResultDto;
			}
			MarvelsLogUtil.getInstance().info("【LP10001】签约路由+签约查询接口有必填项未输入");
			reqToHaierResultDto.setReturnCode(ReturnCode.REQUIRED_CHECK_NOT_PASS);
			reqToHaierResultDto.setReturnMsg(requiredCheck);
			return reqToHaierResultDto;
		}
		return null;
	}
	
	/**
	  *@title:绑卡响应 
	　 *@description【LP10003】单笔签约确认  
	 */
	@Override
	public ReqToHaierResultDto bindBankCard(BindBankCardReq reqBean) {
		MarvelsLogUtil.getInstance().info("【LP10003】单笔签约确认接口入参:" + reqBean);
		// 入参空判断
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(reqBean));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		// 固定参数填充
		reqBean.setDataFrom(PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno","forms-openapi.properties"));
		reqBean.setTraceNo("11");
		reqBean.setInstitution(PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno","forms-openapi.properties"));
		// 请求海尔接口
	    ReqToHaierResultDto reqToHaierResultDto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10003.getUrl(), XyqbCodeAndUrlEnum.LP10003.getCode(),
	        reqBean);
	    bindBankCardSave(reqToHaierResultDto);
	    
	    return reqToHaierResultDto;
	}
	
	/**
	   * 绑卡信息落库
	   * @param reqToHaierResultDto
	   */
	  private void bindBankCardSave(ReqToHaierResultDto reqToHaierResultDto){
	    try {
	      MarvelsLogUtil.getInstance().info("绑卡信息落库入参:" + JSON.toJSONString(reqToHaierResultDto));
	      String returnCode = reqToHaierResultDto.getReturnCode();
	      if("00000".equals(returnCode)){
	        String body = reqToHaierResultDto.getBody();
	        XyqbBindBankCard xyqbBindBankCard = JSONObject.parseObject(body, XyqbBindBankCard.class);
	        xyqbBindBankCardMapper.insertSelective(xyqbBindBankCard);
	      }
	    } catch (Exception e) {
	      MarvelsLogUtil.getInstance().error("绑卡信息落库异常",e);
	    }
	  }

	@Override
	public ReqToHaierResultDto criditApplySubmit(Map<String, String> map) {
		MarvelsLogUtil.getInstance().info("【LP10009】额度申请提交接口入参:" + JSON.toJSONString(map));

		ReqToHaierResultDto resultDto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10009.getUrl(), XyqbCodeAndUrlEnum.LP10009.getCode(),map);
		if("00000".equals(resultDto.getReturnCode())) {
			try {
				CriditApplyDto criditApplyDto = new CriditApplyDto();
				criditApplyDto.setApplSeq(map.get("applSeq"));
				criditApplyDto.setStatus("00");
				xyqbCreditApplyInfoMapper.updateByApplSeq(criditApplyDto);
				dbLogUtil.log("LP10009",criditApplyDto, resultDto);
			}catch(Exception e) {
				MarvelsLogUtil.getInstance().error("修改额度申请信息异常", e);
			}
		}
		return resultDto;
	}

	@Override
	public ReqToHaierResultDto criditApplyCancel(Map<String, String> map) {
		MarvelsLogUtil.getInstance().info("【LP10012】额度申请取消接口入参:" + JSON.toJSONString(map));
		
		ReqToHaierResultDto resultDto =  ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10012.getUrl(), XyqbCodeAndUrlEnum.LP10012.getCode(),map);
		if("00000".equals(resultDto.getReturnCode())) {
			try {
				CriditApplyDto criditApplyDto = new CriditApplyDto();
				criditApplyDto.setApplSeq(map.get("applSeq"));
				criditApplyDto.setStatus("26");
				xyqbCreditApplyInfoMapper.updateByApplSeq(criditApplyDto);
				dbLogUtil.log("LP10012",criditApplyDto, resultDto);
			}catch(Exception e) {
				MarvelsLogUtil.getInstance().error("修改额度申请信息异常", e);
			}
		}
		
		return resultDto; 
	}

	@Override
	public ReqToHaierResultDto queryCriditApplyStatus(Map<String, String> map) {
		MarvelsLogUtil.getInstance().info("【LP10010】额度申请进度查询接口入参:" + JSON.toJSONString(map));
		
		ReqToHaierResultDto resultDto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10010.getUrl(), XyqbCodeAndUrlEnum.LP10010.getCode(),map);
		
		if("00000".equals(resultDto.getReturnCode())) {
			try {
				JSONObject jsonObject = JSON.parseObject(resultDto.getBody());
				CriditApplyDto criditApplyDto = new CriditApplyDto();
				criditApplyDto.setApplSeq(map.get("applSeq"));
				criditApplyDto.setRetMsg(resultDto.getReturnMsg());
				criditApplyDto.setStatus(jsonObject.get("outSts").toString());
				try {
					if(StringUtils.isNotBlank(resultDto.getBody())) {
						JSONObject  json = JSON.parseObject(resultDto.getBody()); 
						JSONArray resultList = json.getJSONArray("resultList");
						if(resultList != null && !resultList.isEmpty()) {
							JSONObject firstApprove = (JSONObject)resultList.get(0);
							if(firstApprove != null) {
								criditApplyDto.setRetMsg(firstApprove.getString("appOutAdviceWfijoin"));
							}
						}
					}
				}catch(Exception e) {
					MarvelsLogUtil.getInstance().error("修改额度申请信息异常", e);
				}
				xyqbCreditApplyInfoMapper.updateByApplSeq(criditApplyDto);
				dbLogUtil.log("LP10010",criditApplyDto, resultDto);
			}catch(Exception e) {
				MarvelsLogUtil.getInstance().error("修改额度申请信息异常", e);
			}
		}
		return resultDto;
	}

	@Override
	public ReqToHaierResultDto queryQuota(QuotaReq quotaReq) {
		MarvelsLogUtil.getInstance().info("【LP10011】实时额度查询接口入参:" + JSON.toJSONString(quotaReq));
		
		ReqToHaierResultDto resultDto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10011.getUrl(), XyqbCodeAndUrlEnum.LP10011.getCode(),quotaReq);
		try {
			if("00000".equals(resultDto.getReturnCode())) {
				if(StringUtils.isNotBlank(resultDto.getBody())){
					JSONObject json = JSON.parseObject(resultDto.getBody());
					if(json != null) {
						XyqbQuotaInfo xyqbQuotaInfo = xyqbQuotaInfoMapper.selectByIdNo(quotaReq.getIdNo());
						if(xyqbQuotaInfo != null) {
							xyqbQuotaInfo.setSerNo(resultDto.getSerno());
							xyqbQuotaInfo.setCreatedDate(new Date());
							xyqbQuotaInfo.setUpdatedDate(new Date());
							xyqbQuotaInfoMapper.updateByIdNo(xyqbQuotaInfo);
						}else {
							xyqbQuotaInfo = new XyqbQuotaInfo();
							xyqbQuotaInfo.setSerNo(resultDto.getSerno());
							xyqbQuotaInfo.setCreatedDate(new Date());
							xyqbQuotaInfo.setUpdatedDate(new Date());
							xyqbQuotaInfo.setCreatedBy("sys");
							xyqbQuotaInfo.setUpdatedBy("sys");
							xyqbQuotaInfo.setIdNo(quotaReq.getIdNo());
							xyqbQuotaInfo.setIdType(quotaReq.getIdTyp());
							xyqbQuotaInfo.setCreditType(quotaReq.getCreditTyp());
							xyqbQuotaInfoMapper.insert(xyqbQuotaInfo);
						}
						
						JSONArray speCrdList = json.getJSONArray("speCrdList");
						xyqbQuotaDetailInfoMapper.deleteByIdNo(quotaReq.getIdNo());
						for(Object speCrd : speCrdList) {
							XyqbQuotaDetailInfo xyqbQuotaDetailInfo = JSON.parseObject(JSON.toJSONString(speCrd), XyqbQuotaDetailInfo.class);
							xyqbQuotaDetailInfo.setCreatedBy("sys");
							xyqbQuotaDetailInfo.setUpdatedBy("sys");
							xyqbQuotaDetailInfo.setCreatedDate(new Date());
							xyqbQuotaDetailInfo.setUpdatedDate(new Date());
							xyqbQuotaDetailInfo.setSerNo(resultDto.getSerno());
							xyqbQuotaDetailInfoMapper.insert(xyqbQuotaDetailInfo);
						}
					}
				}
			}
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error("保存实时额度查询异常", e);
		}
		return resultDto;
	}

	//============jason's code from start from here==================================//
	@Override
	public ReqToHaierResultDto repayPlanQuery(RepayPlanQueryReqBody request) {
		MarvelsLogUtil.getInstance().info("【LP30006】还款计划查询接口入参:" + JSON.toJSONString(request));
		ReqToHaierResultDto dto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP30006.getUrl(), XyqbCodeAndUrlEnum.LP30006.getCode(),request);
		String body = dto.getBody();
		try {
			repaymentService.saveData(body);
		} catch (Exception e) {
			logger.error("error when repay plan query:{}", e);
			ReqToHaierResultDto result = new ReqToHaierResultDto();
			result.setReturnCode(ReturnCode.SYSTEM_ERROR);
			result.setReturnMsg(e.getMessage());
			return result;
		}
		return dto;
	}
	
	@Override
	public ReqToHaierResultDto batchChangeAcct(BatchChangeAcctReqBody request) {
		MarvelsLogUtil.getInstance().info("【LP30015】批量变更还款卡（借据号）接口入参:" + JSON.toJSONString(request));
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP30015.getUrl(), XyqbCodeAndUrlEnum.LP30015.getCode(),request);
	}
	
	@Override
	public ReqToHaierResultDto riskInfoUpload(RiskInfoUploadReq request) {
		MarvelsLogUtil.getInstance().info("【LP40001】上送风险信息接口入参:" + JSON.toJSONString(request));
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(request));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		
		//这里请求云科谷的决策,将芝麻分和百融分传给海尔
		String idNo = null;
		try {
			String url = PropertiesLoadUtil.getPropertiesValue("ykg.decision.score.url","forms-openapi.properties");
			RiskInfoUploadReqExData  extData = request.getExData();
			if(extData != null) {
				String custName = extData.getAcctName();
				idNo = extData.getAppt_id_no();
				String mobile = extData.getMobile();
				if(!StringUtils.isAnyBlank(custName,idNo,mobile)) {
					DecisionReqDto decisionReqDto = new DecisionReqDto();
					decisionReqDto.setCustName(custName);
					decisionReqDto.setIdNo(idNo);
					decisionReqDto.setMobile(mobile);
					MarvelsLogUtil.getInstance().info(idNo+"准备获取决策评分,入参="+JSON.toJSONString(decisionReqDto));
					String result = HttpClient.sendJson(url, JSON.toJSONString(decisionReqDto));
					MarvelsLogUtil.getInstance().info(idNo+"获取决策评分,响应result="+result);
					if(StringUtils.isNotBlank(result)) {
						JSONObject decisionResult = JSON.parseObject(result);
						JSONObject json = decisionResult.getJSONObject("data");
						extData.setScoreDataSaas(json.get("ykg_score")+"");
						extData.setSeCredit(json.get("zmf_score_min")+"");
						
						XyqbDecisionQueryInfo  xyqbDecisionQueryInfo = xyqbDecisionQueryInfoMapper.selectByIdNo(idNo);
						if(xyqbDecisionQueryInfo != null) {
							xyqbDecisionQueryInfo.setYkgScore(json.get("ykg_score")+"");
							xyqbDecisionQueryInfo.setZmfScoreMax(json.get("zmf_score_max")+"");
							xyqbDecisionQueryInfo.setZmfScoreMin(json.get("zmf_score_min")+"");
							xyqbDecisionQueryInfo.setUpdatedDate(new Date());
							xyqbDecisionQueryInfoMapper.updateByPrimaryKeySelective(xyqbDecisionQueryInfo);
						}
					}
				}
			}
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(idNo+"获取云科谷决策评分出错",e);
		}
		
		try {
			commonRiskService.saveData(request);
		} catch (Exception e) {
			logger.error("error when risk info upload:{}", e);
			reqFieldCheck = new ReqToHaierResultDto();
			reqFieldCheck.setReturnCode(ReturnCode.SYSTEM_ERROR);
			reqFieldCheck.setReturnMsg(e.getMessage());
			return reqFieldCheck;
		}
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP40001.getUrl(), XyqbCodeAndUrlEnum.LP40001.getCode(),request);
	}

	@Override
	public ReqToHaierResultDto fileUpload(FileUploadReq request) {
		//MarvelsLogUtil.getInstance().info("【LP40002】文件上传接口入参:" + JSON.toJSONString(request));
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(request));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		
		List<FileUploadReqFile> filelist = request.getFilelist();
		if (filelist != null && filelist.size() > 0) {
			for (FileUploadReqFile file : filelist) {
				reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(file));
				if(reqFieldCheck != null){
					return reqFieldCheck;
				}
			}
		}
		
		try {
			fileUploadService.saveData(request);
		} catch (Exception e) {
			logger.error("error when file upload:{}", e);
			reqFieldCheck = new ReqToHaierResultDto();
			reqFieldCheck.setReturnCode(ReturnCode.SYSTEM_ERROR);
			reqFieldCheck.setReturnMsg(e.getMessage());
			return reqFieldCheck;
		}
		
		return ReqToHaierUtil.requestFileUpload(XyqbCodeAndUrlEnum.LP40002.getUrl(), XyqbCodeAndUrlEnum.LP40002.getCode(),request);
	}
	//============jason's code from end from here==================================//
	
	/**
	 * 
	  *@title:白名单校验 
	　 *@description【LP40007】企业白名单接口 
	 */
	@Override
	public ReqToHaierResultDto whiteList(WhiteListCjReq reqBean) {
		MarvelsLogUtil.getInstance().info("【LP40007】企业白名单接口 入参:" + reqBean);
		// 入参空判断
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(reqBean));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		//字段转换
		WhiteListHead whiteListHead = new WhiteListHead(reqBean);
		WhiteListBody whiteListBody = new WhiteListBody(reqBean);
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP40007.getUrl(), 
				XyqbCodeAndUrlEnum.LP40007.getCode(),whiteListBody,whiteListHead);
	}

	/**
	  *@title:贷前还款试算 
	　 *@Description【LP20001】贷前还款试算
	 */
	@Override
	public ReqToHaierResultDto paymentTrial(PaymentTrialReq reqBean) {
		MarvelsLogUtil.getInstance().info("【LP20001】贷前还款试算接口 入参:" + reqBean);
		// 入参空判断
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(reqBean));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		//TODO due_day字段需要再处理
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP20001.getUrl(), XyqbCodeAndUrlEnum.LP20001.getCode(),reqBean);
	}

	/**
	 * 【LP20003】现金贷支用提交/取消
	 */
	@Override
	public ReqToHaierResultDto beCashSubmit(BeCashSubmitReq reqBean) {
		MarvelsLogUtil.getInstance().info("【LP20003】现金贷支用提交/取消接口 入参:" + reqBean);
		// 入参空判断
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(reqBean));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP20003.getUrl(), XyqbCodeAndUrlEnum.LP20003.getCode(),reqBean);
	}
	
	/**
	 * 【LP20005】贷款信息/审批状态查询
	 */
	@Override
	public ReqToHaierResultDto loanInfoQuery(LoanInfoQuery reqBean) {
		MarvelsLogUtil.getInstance().info("【LP20005】贷款信息/审批状态查询接口 入参:" + reqBean);
		// 入参空判断
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(reqBean));
		if(reqFieldCheck != null){
			return reqFieldCheck;
		}
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP20005.getUrl(), XyqbCodeAndUrlEnum.LP20005.getCode(),reqBean);
	}

	public static void main(String[] args) {
		String propertiesValue = PropertiesLoadUtil.getPropertiesValue("xyqb.LP10008.cooprName", "forms-openapi.properties");
		System.out.println(propertiesValue);
	}
	/**
	 * 【LP40003】文件下载
	 * @param quotaReq
	 * @return
	 */
	@Override
	public ReqToHaierResultDto filedownload(FileDownloadReq reqBean) {
		MarvelsLogUtil.getInstance().info("【LP40003】文件下载接口 入参:" + reqBean);
		// 入参空判断
		ReqToHaierResultDto reqFieldCheck = reqFieldCheck(XyqbUtil.requiredCheck(reqBean));
		if (reqFieldCheck != null) {
			return reqFieldCheck;
		}
		ReqToHaierResultDto request = null;
		try {
			request = ReqToHaierUtil.requestFiledownload(XyqbCodeAndUrlEnum.LP40003.getUrl(), XyqbCodeAndUrlEnum.LP40003.getCode(),reqBean);
			fileUploadService.saveData(request, reqBean);
		} catch (Exception e) {
			logger.error("【LP40003】文件下载接口异常",e);
		}
		return request;
	}

	@Override
	public ReqToHaierResultDto unbind(BnakCardUnbindReqDto bnakCardUnbindReqDto) {
		return ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP40011.getUrl(), XyqbCodeAndUrlEnum.LP40011.getCode(),bnakCardUnbindReqDto);
	}
	
}
