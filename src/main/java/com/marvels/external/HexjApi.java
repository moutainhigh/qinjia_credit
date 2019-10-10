package com.marvels.external;

import java.util.Map;

import com.marvels.dto.hexj.request.BankCardRouterAndQueryReq;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;

public interface HexjApi {

	/**
	 * 额度申请信息保存/修改(LP10008)
	 * @param criditApplyDto
	 * @return
	 *@author wanggang
	 */
	public ReqToHaierResultDto criditApply(CriditApplyDto criditApplyDto);
	
	/**
	 * 额度申请提交
	 * @param map
	 * @return
	 *@author wanggang
	 */
	public ReqToHaierResultDto criditApplySubmit(Map<String,String> map);
	
	/**
	 * 额度申请取消
	 * @param map
	 * @return
	 *@author wanggang
	 */
	public ReqToHaierResultDto criditApplyCancel(Map<String,String> map);
	
	/**
	 * 额度申请进度查询
	 * @param map
	 * @return
	 *@author wanggang
	 */
	public ReqToHaierResultDto queryCriditApplyStatus(Map<String,String> map);
	
	/**
	 * LP10011-实时额度查询
	 * @param quotaReq
	 * @return
	 *@author wanggang
	 */
	public ReqToHaierResultDto queryQuota(QuotaReq quotaReq);
	
	/**
	 * 描述:【LP10001】签约路由+签约查询
	 * @author lvgb
	 */
	ReqToHaierResultDto bankCardRouterAndQuery(BankCardRouterAndQueryReq reqBean);
	
	/**
	  *@title: 预绑卡请求入参
	　 *@Description【LP10002】单笔签约申请
	  @author lvgb
	 */
	ReqToHaierResultDto preBindBankCard(PreBindBankCardReq reqBean);
	
	/**
	  *@title:绑卡响应 
	　 *@description【LP10003】单笔签约确认  
	@author lvgb
	 */
	ReqToHaierResultDto bindBankCard(BindBankCardReq reqBean);
	
	
	//============jason's code from start from here==================================//
	/**
	 * 此处返回的body字符串可以进一步由 {@link com.marvels.dto.hexj.response.RepayPlanQueryRespBody} 进行解析
	 * @author jason
	 * @Description 【LP30006】还款计划查询
	 */
	ReqToHaierResultDto repayPlanQuery(RepayPlanQueryReqBody request);
	
	/**
	 * 此处返回的body字符串可以进一步由 {@link com.marvels.dto.hexj.response.BatchChangeAcctRespBody} 进行解析
	 * @author jason
	 * @Description 【LP30015】批量变更还款卡（借据号）
	 */
	ReqToHaierResultDto batchChangeAcct(BatchChangeAcctReqBody request);
	
	/**
	 * @author jason
	 * @Description 【LP40001】通用风险接口
	 */
	ReqToHaierResultDto riskInfoUpload(RiskInfoUploadReq request);
	
	/**
	 * @author jason
	 * @Description 【LP40002】文件上传接口
	 */
	ReqToHaierResultDto fileUpload(FileUploadReq request);
	//============jason's code from end from here==================================//
	
	/**
	  *@title:白名单校验 
	　 *@description【LP40007】企业白名单接口 
	@author lvgb
	 */
	ReqToHaierResultDto whiteList(WhiteListCjReq reqBean);
	
	/**
	  *@title:贷前还款试算 
	　 *@Description【LP20001】贷前还款试算
	@author lvgb
	 */
	ReqToHaierResultDto paymentTrial(PaymentTrialReq reqBean);
	
	/**
	 * 【LP20003】现金贷支用提交/取消
	 * @author lvgb
	 */
	ReqToHaierResultDto beCashSubmit(BeCashSubmitReq reqBean);
	
	/**
	 * 【LP20005】贷款信息/审批状态查询
	 * @author lvgb
	 */
	ReqToHaierResultDto loanInfoQuery(LoanInfoQuery reqBean);
	/**
	 * 【LP40003】文件下载
	 * @param quotaReq
	 * @return
	 */
	ReqToHaierResultDto filedownload(FileDownloadReq reqBean);
	
	/**
	 * 鉴权
	 * @param bnakCardUnbindReqDto
	 * @return
	 *@author wanggang
	 */
	public ReqToHaierResultDto unbind(BnakCardUnbindReqDto bnakCardUnbindReqDto);
}
