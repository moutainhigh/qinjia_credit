package com.marvels.service.impl;

import com.marvels.dto.sy.SyRequestDto;
import com.marvels.dto.sy.SyResponseDto;
import com.marvels.service.QjItfLogService;
import com.marvels.service.SyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("SyApiService")
public class SyApiServiceImpl implements SyApiService{
    @Autowired
    private QjItfLogService qjItfLogService;

    @Override
    public SyResponseDto ITF00012(SyRequestDto request) throws Exception {
        return null;
    }
}
