package com.marvels.service;

import com.marvels.dto.jf.*;

/**
 *
 */
public interface JfApiService {
	
	/**
	 * 授信申请
	 * @param param 请求参数
	 * @return
	 * @throws Exception
	 */
	JfResponseDto applyQuota(JfRequestDto<JfApplyQuotaReq> param) throws Exception;
	
	/**
	 * 查询授信申请
	 * @param param 请求参数
	 * @return
	 * @throws Exception
	 */
	JfResponseDto queryApplyResult(JfRequestDto<JfQueryApplyResultReq> param) throws Exception;
	
    /**
     * 支持的银行卡列表查询
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto queryBankList(JfRequestDto<JfQueryBankListReq> param) throws Exception;
    /**
     * 卡bin查询
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto queryCardBin(JfRequestDto<JfQueryCardBinReq> param) throws Exception;

    /**
     * 签约申请
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto signApply(JfRequestDto<JfSignApplyReq> param) throws Exception;

    /**
     * 签约确认
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto confirmSign(JfRequestDto<JfConfirmSignReq> param) throws Exception;


    /**
     * 实名认证
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto authName(JfRequestDto param) throws Exception;

    /**
     * 人脸识别结果上传
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto faceRecogSave(JfRequestDto param) throws Exception;

    /**
     * KYC信息提交
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto saveCustomerKyc(JfRequestDto param) throws Exception;

    /**
     * 客户基本信息查询
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto getCustomerBaseInfo(JfRequestDto param) throws Exception;

    /**
     * 商户授信结果信息接收
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto saveCreditGranting(JfRequestDto param) throws Exception;

    /**
     * 风控设备指纹实时反欺诈
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto fgpAntiFraud(JfRequestDto param) throws Exception;

    /**
     * 运营商授权
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto authOperator(JfRequestDto param) throws Exception;

    /**
     * 信用卡授权
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto authCreditCard(JfRequestDto param) throws Exception;

    /**
     * 绑卡列表查询
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto queryBankCard(JfRequestDto param) throws Exception;

    /**
     * 授信项状态查询
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto queryCreditStatus(JfRequestDto param) throws Exception;

    /**
     * 商户接收授权结果
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto callBackAuth(JfRequestDto param) throws Exception;

    /**
     * 借据编号查询借据信息
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto getIou(JfRequestDto<JfGetIouReq> param) throws Exception;

    /**
     * 还款计划查询
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto getRepayPlan(JfRequestDto<JfGetIouReq> param) throws Exception;

    /**
     * 还款金额试算
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto queryRepayAmt(JfRequestDto<JfQueryRepayAmtReq> param) throws Exception;

    /**
     * 主动还款
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto repay(JfRequestDto<JfRayReq> param) throws Exception;

    /**
     * 扣款结果查询
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto queryRepayResult(JfRequestDto<JfQueryRepayResultReq> param) throws Exception;

    /**
     * 查询用户还款记录
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto queryRepayRecord(JfRequestDto<JfQueryRepayRecourdReq> param) throws Exception;

    /**
     * 资金路由接口
     * @throws Exception
     * @param request
     */
    JfResponseDto capitalRouting(JfRequestDto<JfCapitalRoutingReq> request) throws Exception;

    /**
     * 借款试算接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    JfResponseDto loanTrial(JfRequestDto<JfLoanTrialReq> request) throws Exception;

    /**
     * 下单接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    JfResponseDto placeOrder(JfRequestDto<JfPlaceOrderReq> request) throws Exception;

    /**
     * 资产端关单申请接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    JfResponseDto closeOrderApply(JfRequestDto<JfCloseOrderApplyReq> request) throws Exception;

    /**
     * 工单信息查询接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    JfResponseDto queryOrderInfo(JfRequestDto<JfQueryOrderInfoReq> request) throws Exception;

    /**
     * 资产端关单结果查询接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    JfResponseDto queryCloseOrderRes(JfRequestDto<JfQueryCloseOrderReq> request) throws Exception;

    /**
     * 工单合同信息查询接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    JfResponseDto queryContract(JfRequestDto<JfQueryOrderInfoReq> request) throws Exception;

    /**
     * 工单信息查询接口（JFB2）
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    JfResponseDto queryContractJFB2(JfRequestDto<JfQueryOrderInfoJfb2Req> request) throws Exception;

    /**
     * 用户工单列表查询接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    JfResponseDto queryOrderList(JfRequestDto<JfQueryOrderListReq> request);
}
