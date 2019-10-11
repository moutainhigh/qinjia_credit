package com.marvels.service.impl;

import com.marvels.common.enums.PublicEnums;
import com.marvels.common.util.HttpUtil;
import com.marvels.common.util.ParamUtil;
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
        //MarvelsLogUtil.getInstance().info("[获取申请编号(ITF00012)]开始,入参="+ JSON.toJSONString(request));
        String resultDto =  HttpUtil.doPost("", ParamUtil.getString("",request.getReqdata()));
        qjItfLogService.inParamsItfLog(PublicEnums.InterfaceCodeEnum.ITF00002.getCode(),ParamUtil.getString(PublicEnums.InterfaceCodeEnum.ITF00002.getCode(),request.getReqdata()),"resultDto");
        return null;
    }
}
