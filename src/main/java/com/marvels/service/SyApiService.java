package com.marvels.service;

import com.marvels.dto.sy.SyRequestDto;
import com.marvels.dto.sy.SyResponseDto;

public interface SyApiService {
    /**
     * 获取申请编号
     * @return
     * @throws Exception
     */
     SyResponseDto ITF00012(SyRequestDto request) throws Exception;
}
