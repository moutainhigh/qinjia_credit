package com.marvels.service;

import com.marvels.dto.jf.JfApplyQuotaReq;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;

public interface JfApiService {
	
	/**
	 * 授信申请
	 * @param param 请求参数
	 * @return
	 * @throws Exception
	 */
	public JfResponseDto applyQuota(JfRequestDto<JfApplyQuotaReq> param) throws Exception;
}
