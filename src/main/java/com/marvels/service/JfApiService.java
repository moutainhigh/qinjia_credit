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
     * 鉴权查询
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    JfResponseDto queryAuthCard(JfRequestDto<JfQueryAuthCardReq> param) throws Exception;
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
     * 用于个人信息查询-基于身份证号码
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto getCustomerBaseInfoByIdNo(JfRequestDto param) throws Exception;

    /**
     * 银行卡鉴权
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto authBankCard(JfRequestDto param) throws Exception;

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
     * 交易绑卡落库
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public JfResponseDto changeCard(JfRequestDto param) throws Exception;
}
