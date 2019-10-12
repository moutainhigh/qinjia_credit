package com.marvels.service;


import com.marvels.dto.jf.*;

/**
 * 玖富接口调用service
 */
public interface JiuFuPayService {
    /**
     * 支持的银行卡列表查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryBankList(JfRequestDto<JfQueryBankListReq> request) throws Exception;
    /**
     * 卡bin查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryCardBin(JfRequestDto<JfQueryCardBinReq> request) throws Exception;
    /**
     * 鉴权查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryAuthCard(JfRequestDto<JfQueryAuthCardReq> request) throws Exception;
    /**
     * 签约申请
     * @return
     * @throws Exception
     */
    JfResponseDto signApply(JfRequestDto<JfSignApplyReq> request) throws Exception;

    /**
     * 签约确认
     * @return
     * @throws Exception
     */
    JfResponseDto confirmSign(JfRequestDto<JfConfirmSignReq> request) throws Exception;
}
