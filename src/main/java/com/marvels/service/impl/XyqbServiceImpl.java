package com.marvels.service.impl;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.chuangjin.util.HttpClient;
import com.marvels.dto.hexj.request.BankCardRouterAndQueryReq;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import com.marvels.dto.info.DecisionReqDto;
import com.marvels.external.HexjApi;
import com.marvels.service.XyqbService;

@Service("xyqbService")
public class XyqbServiceImpl implements XyqbService{

	@Autowired
	private HexjApi hexjApi;
	@Autowired
	private XyqbDecisionQueryInfoMapper xyqbDecisionQueryInfoMapper;
	
	@Override
	public ReqToHaierResultDto criditApply(CriditApplyDto criditApplyDto) {
		return hexjApi.criditApply(criditApplyDto);
	}

	@Override
	public ReqToHaierResultDto criditApplySubmit(Map<String, String> map) {
		return hexjApi.criditApplySubmit(map);
	}

	@Override
	public ReqToHaierResultDto criditApplyCancel(Map<String, String> map) {
		return hexjApi.criditApplyCancel(map);
	}

	@Override
	public ReqToHaierResultDto queryCriditApplyStatus(Map<String, String> map) {
		return hexjApi.queryCriditApplyStatus(map);
	}

	@Override
	public ReqToHaierResultDto queryQuota(QuotaReq quotaReq) {
		return hexjApi.queryQuota(quotaReq);
	}

	@Override
	public ReqToHaierResultDto bankCardRouterAndQuery(BankCardRouterAndQueryReq reqBean) {
		return hexjApi.bankCardRouterAndQuery(reqBean);
	}

	@Override
	public ReqToHaierResultDto preBindBankCard(PreBindBankCardReq reqBean) {
		return hexjApi.preBindBankCard(reqBean);
	}

	@Override
	public ReqToHaierResultDto bindBankCard(BindBankCardReq reqBean) {
		return hexjApi.bindBankCard(reqBean);
	}

	@Override
	public ReqToHaierResultDto whiteList(WhiteListCjReq reqBean) {
		return hexjApi.whiteList(reqBean);
	}

	@Override
	public ReqToHaierResultDto paymentTrial(PaymentTrialReq reqBean) {
		return hexjApi.paymentTrial(reqBean);
	}

	@Override
	public ReqToHaierResultDto beCashSubmit(BeCashSubmitReq reqBean) {
		return hexjApi.beCashSubmit(reqBean);
	}

	@Override
	public ReqToHaierResultDto loanInfoQuery(LoanInfoQuery reqBean) {
		return hexjApi.loanInfoQuery(reqBean);
	}
	
	@Override
	public ReqToHaierResultDto repayPlanQuery(RepayPlanQueryReqBody reqBean) {
		return hexjApi.repayPlanQuery(reqBean);
	}
	
	@Override
	public ReqToHaierResultDto batchChangeAcct(BatchChangeAcctReqBody reqBean) {
		return hexjApi.batchChangeAcct(reqBean);
	}

	@Override
	public ReqToHaierResultDto riskInfoUpload(RiskInfoUploadReq reqBean) {
		return hexjApi.riskInfoUpload(reqBean);
	}

	@Override
	public ReqToHaierResultDto fileUpload(FileUploadReq reqBean) {
		return hexjApi.fileUpload(reqBean);
	}
	/**
	 * 【LP40003】文件下载
	 * @param quotaReq
	 * @return
	 */
	@Override
	public ReqToHaierResultDto filedownload(FileDownloadReq reqBean) {
		return hexjApi.filedownload(reqBean);
	}

	@Override
	public ReqToHaierResultDto decision(DecisionReqDto decisionReqDto) {
		String result= HttpClient.sendJson(PropertiesLoadUtil.getPropertiesValue("ykg.decision.url","forms-openapi.properties"),JSON.toJSONString(decisionReqDto));
		if(StringUtils.isNotBlank(result)) {
			try {
				JSONObject json = JSON.parseObject(result);
				XyqbDecisionQueryInfo xyqbDecisionQueryInfo = new XyqbDecisionQueryInfo();
				xyqbDecisionQueryInfo.setIdNumber(decisionReqDto.getIdNo());
				xyqbDecisionQueryInfo.setPhone(decisionReqDto.getMobile());
				xyqbDecisionQueryInfo.setName(decisionReqDto.getCustName());
				xyqbDecisionQueryInfo.setUpdatedDate(new Date());
				xyqbDecisionQueryInfo.setCreatedDate(new Date());
				xyqbDecisionQueryInfo.setCreatedBy("sys");
				xyqbDecisionQueryInfo.setUpdatedBy("sys");
				xyqbDecisionQueryInfo.setStatus(json.getString("returnCode"));
				if("0000".equals(json.getString("returnCode"))) {
					JSONObject data = json.getJSONObject("data");
					if(data != null) {
						xyqbDecisionQueryInfo.setStatus(data.getString("decision_result"));
					}
				}
				xyqbDecisionQueryInfoMapper.insert(xyqbDecisionQueryInfo);
			}catch(Exception e) {
				MarvelsLogUtil.getInstance().error(decisionReqDto.getIdNo()+"调用云科谷决策异常", e);
			}
			return JSON.parseObject(result, ReqToHaierResultDto.class);
		}
		return new ReqToHaierResultDto("0091","决策响应为空");
	}

	@Override
	public ReqToHaierResultDto unbind(BnakCardUnbindReqDto bnakCardUnbindReqDto) {
		return hexjApi.unbind(bnakCardUnbindReqDto);
	}

	@Override
	public ReqToHaierResultDto getDecisionScore(DecisionReqDto decisionReqDto1) {
		String url = PropertiesLoadUtil.getPropertiesValue("ykg.decision.score.url","forms-openapi.properties");
			String custName = decisionReqDto1.getCustName();
			String idNo = decisionReqDto1.getIdNo();
			String mobile = decisionReqDto1.getMobile();
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
		return null;
	}
	
	
}
