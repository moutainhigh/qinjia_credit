package com.marvels.service;

import com.marvels.dto.jf.*;

public interface JfApiService {
	
	/**
	 * 授信申请
	 * @param param 请求参数
	 * @return
	 * @throws Exception
	 */
	public JfResponseDto applyQuota(JfRequestDto<JfApplyQuotaReq> param) throws Exception;
    /**
     * 支持的银行卡列表查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryBankList(JfRequestDto<JfQueryBankListReq> param) throws Exception;
    /**
     * 卡bin查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryCardBin(JfRequestDto<JfQueryCardBinReq> param) throws Exception;
    /**
     * 鉴权查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryAuthCard(JfRequestDto<JfQueryAuthCardReq> param) throws Exception;
    /**
     * 签约申请
     * @return
     * @throws Exception
     */
    JfResponseDto signApply(JfRequestDto<JfSignApplyReq> param) throws Exception;

    /**
     * 签约确认
     * @return
     * @throws Exception
     */
    JfResponseDto confirmSign(JfRequestDto<JfConfirmSignReq> param) throws Exception;
}
