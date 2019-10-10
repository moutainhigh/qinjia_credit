package com.marvels.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.chuangjin.CjReqUtil;
import com.marvels.common.util.chuangjin.util.CJRequestDto;
import com.marvels.dto.common.ReturnCode;
import com.marvels.dto.hexj.request.BankCardRouterAndQueryReq;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import com.marvels.dto.info.DecisionReqDto;
import com.marvels.service.XyqbService;

@RestController
@RequestMapping
public class XyqbController {
	
	@Autowired
	private XyqbService xyqbService;
	@Autowired
	private RepaymentService repaymentService;
	
	/**
	 * 额度申请信息保存/修改(LP10008)
	 * @param criditApplyDto
	 * @return
	 *@author wanggang
	 */
	@RequestMapping("credit/LP10008")
	public ReqToHaierResultDto criditApply(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("额度申请信息保存/修改(LP10008),接收报文="+JSON.toJSONString(requestDto));
		try {
			CriditApplyDto criditApplyDto = CjReqUtil.decrypt(requestDto, CriditApplyDto.class);
			return xyqbService.criditApply(criditApplyDto);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"额度申请信息保存失败", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	 * 额度申请提交
	 * @param map
	 * @return
	 *@author wanggang
	 */
	@RequestMapping("credit/LP10009")
	@SuppressWarnings("unchecked")
	public ReqToHaierResultDto criditApplySubmit(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("额度申请提交,接收报文="+JSON.toJSONString(requestDto));
		try {
			Map<String,String> map = CjReqUtil.decrypt(requestDto, Map.class);
			return xyqbService.criditApplySubmit(map);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"额度申请提交异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	 * 额度申请取消
	 * @param map
	 * @return
	 *@author wanggang002
	 */
	@RequestMapping("credit/LP10012")
	@SuppressWarnings("unchecked")
	public ReqToHaierResultDto criditApplyCancel(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("额度申请取消,接收报文="+JSON.toJSONString(requestDto));
		try {
			Map<String,String> map = CjReqUtil.decrypt(requestDto, Map.class);
			return xyqbService.criditApplyCancel(map);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"额度申请取消异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	 * 额度申请进度查询
	 * @param map
	 * @return
	 *@author wanggang
	 */
	@RequestMapping("credit/LP10010")
	@SuppressWarnings("unchecked")
	public ReqToHaierResultDto queryCriditApplyStatus(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("额度申请进度查询,接收报文="+JSON.toJSONString(requestDto));
		try {
			Map<String,String> map = CjReqUtil.decrypt(requestDto, Map.class);
			return xyqbService.queryCriditApplyStatus(map);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"额度申请进度查询异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	 * LP10011-实时额度查询
	 * @param quotaReq
	 * @return
	 *@author wanggang
	 */
	@RequestMapping("credit/LP10011")
	public ReqToHaierResultDto queryQuota(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("LP10011-实时额度查询,接收报文="+JSON.toJSONString(requestDto));
		try {
			QuotaReq quotaReq = CjReqUtil.decrypt(requestDto, QuotaReq.class);
			return xyqbService.queryQuota(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"LP10011-实时额度查询异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	 * 描述:【LP10001】签约路由+签约查询
	 * @author lvgb
	 */
	@RequestMapping("credit/LP10001")
	public ReqToHaierResultDto bankCardRouterAndQuery(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP10001】签约路由+签约查询,接收报文="+JSON.toJSONString(requestDto));
		try {
			BankCardRouterAndQueryReq quotaReq = CjReqUtil.decrypt(requestDto, BankCardRouterAndQueryReq.class);
			return xyqbService.bankCardRouterAndQuery(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP10001】签约路由+签约查询异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	  *@title: 预绑卡请求入参
	　 *@Description【LP10002】单笔签约申请
	  @author lvgb
	 */
	@RequestMapping("credit/LP10002")
	public ReqToHaierResultDto  preBindBankCard(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP10002】单笔签约申请,接收报文="+JSON.toJSONString(requestDto));
		try {
			PreBindBankCardReq quotaReq = CjReqUtil.decrypt(requestDto, PreBindBankCardReq.class);
			return xyqbService.preBindBankCard(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP10002】单笔签约申请异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	  *@title:绑卡响应 
	　 *@description【LP10003】单笔签约确认  
	@author lvgb
	 */
	@RequestMapping("credit/LP10003")
	public ReqToHaierResultDto  bindBankCard(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP10003】单笔签约确认 ,接收报文="+JSON.toJSONString(requestDto));
		try {
			BindBankCardReq quotaReq = CjReqUtil.decrypt(requestDto, BindBankCardReq.class);
			return xyqbService.bindBankCard(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP10003】单笔签约确认 异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	
	/**
	  *@title:白名单校验 
	　 *@description【LP40007】企业白名单接口 
	@author lvgb
	 */
	@RequestMapping("credit/LP40007")
	public ReqToHaierResultDto  whiteList(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP40007】企业白名单接口  ,接收报文="+JSON.toJSONString(requestDto));
		try {
			WhiteListCjReq quotaReq = CjReqUtil.decrypt(requestDto, WhiteListCjReq.class);
			return xyqbService.whiteList(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP40007】企业白名单接口 异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	  *@title:贷前还款试算 
	　 *@Description【LP20001】贷前还款试算
	@author lvgb
	 */
	@RequestMapping("credit/LP20001")
	public ReqToHaierResultDto  paymentTrial(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP20001】贷前还款试算 ,接收报文="+JSON.toJSONString(requestDto));
		try {
			PaymentTrialReq quotaReq = CjReqUtil.decrypt(requestDto, PaymentTrialReq.class);
			return xyqbService.paymentTrial(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP20001】贷前还款试算异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	 * 【LP20003】现金贷支用提交/取消
	 * @author lvgb
	 */
	@RequestMapping("credit/LP20003")
	public ReqToHaierResultDto  beCashSubmit(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP20003】现金贷支用提交/取消,接收报文="+JSON.toJSONString(requestDto));
		try {
			BeCashSubmitReq quotaReq = CjReqUtil.decrypt(requestDto, BeCashSubmitReq.class);
			return xyqbService.beCashSubmit(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP20003】现金贷支用提交/取消异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	 * 【LP20005】贷款信息/审批状态查询
	 * @author lvgb
	 */
	@RequestMapping("credit/LP20005")
	public ReqToHaierResultDto  loanInfoQuery(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP20005】贷款信息/审批状态查询,接收报文="+JSON.toJSONString(requestDto));
		try {
			LoanInfoQuery quotaReq = CjReqUtil.decrypt(requestDto, LoanInfoQuery.class);
			return xyqbService.loanInfoQuery(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP20005】贷款信息/审批状态查询异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	@RequestMapping("repay/LP30006")
	public ReqToHaierResultDto repayPlanQuery(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP30006】还款计划查询,接收报文="+JSON.toJSONString(requestDto));
		try {
			RepayPlanQueryReqBody quotaReq = CjReqUtil.decrypt(requestDto, RepayPlanQueryReqBody.class);
			return xyqbService.repayPlanQuery(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP30006】还款计划查询异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	@RequestMapping("repay/LP30015")
	public ReqToHaierResultDto batchChangeAcct(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP30015】批量变更还款卡,接收报文="+JSON.toJSONString(requestDto));
		try {
			BatchChangeAcctReqBody quotaReq = CjReqUtil.decrypt(requestDto, BatchChangeAcctReqBody.class);
			return xyqbService.batchChangeAcct(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP30015】批量变更还款卡异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	@RequestMapping("common/LP40001")
	public ReqToHaierResultDto riskInfoUpload(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP40001】风险信息上送,接收报文="+JSON.toJSONString(requestDto));
		try {
			RiskInfoUploadReq quotaReq = CjReqUtil.decrypt(requestDto, RiskInfoUploadReq.class);
			return xyqbService.riskInfoUpload(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP40001】风险信息上送异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	@RequestMapping("common/LP40002")
	public ReqToHaierResultDto fileUpload(@RequestBody CJRequestDto requestDto) {
		//MarvelsLogUtil.getInstance().info("【LP40002】文件上传,接收报文="+JSON.toJSONString(requestDto));
		try {
			FileUploadReq quotaReq = CjReqUtil.decryptForFileUpload(requestDto, FileUploadReq.class);
			return xyqbService.fileUpload(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP40002】文件上传异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	/**
	 * 【LP40003】文件下载
	 * @param requestDto
	 * @return
	 */
	@RequestMapping("common/LP40003")
	public ReqToHaierResultDto filedownload(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("【LP40003】文件下载,接收报文="+JSON.toJSONString(requestDto));
		try {
			FileDownloadReq quotaReq = CjReqUtil.decrypt(requestDto, FileDownloadReq.class);
			return xyqbService.filedownload(quotaReq);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP40003】文件下载异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"异常"); 
		}
	}
	
	/**
	 * 决策
	 * @param requestDto
	 * @return
	 */
	@RequestMapping("common/decision")
	public ReqToHaierResultDto decision(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("调用云科谷决策,接收报文="+JSON.toJSONString(requestDto));
		try {
			DecisionReqDto decisionReqDto = CjReqUtil.decrypt(requestDto, DecisionReqDto.class);
			return xyqbService.decision(decisionReqDto);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"调用云科谷决策异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"决策异常"); 
		}
	}
	
	/**
	 * 决策
	 * @param requestDto
	 * @return
	 */
	@RequestMapping("common/unbind")
	public ReqToHaierResultDto unbind(@RequestBody CJRequestDto requestDto) {
		MarvelsLogUtil.getInstance().info("解绑,接收报文="+JSON.toJSONString(requestDto));
		try {
			BnakCardUnbindReqDto decisionReqDto = CjReqUtil.decrypt(requestDto, BnakCardUnbindReqDto.class);
			return xyqbService.unbind(decisionReqDto);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"解绑异常", e);
			return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR,"解绑异常"); 
		}
	}
}
