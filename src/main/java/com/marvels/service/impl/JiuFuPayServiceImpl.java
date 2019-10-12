package com.marvels.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.marvels.common.util.HttpUtil;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;
import com.marvels.service.JiuFuPayService;
import com.marvels.service.QjItfLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jiuFuPayService")
public class JiuFuPayServiceImpl implements JiuFuPayService {
    @Autowired
    private QjItfLogService qjItfLogService;

    public JfResponseDto getResult(JfRequestDto request,String enums) {
        String result = HttpUtil.doPost("",request.toString());
        JSONObject resultDto = JSON.parseObject(result);
        JfResponseDto responseDto = JSONObject.toJavaObject(resultDto,JfResponseDto.class);
        qjItfLogService.inOutParamsItfLog("",request.toString(),responseDto);
        return responseDto;
    }

    @Override
    public JfResponseDto queryBankList(JfRequestDto request) throws Exception {
        return getResult(request,"");
    }

    @Override
    public JfResponseDto queryCardBin(JfRequestDto request) throws Exception {
        return getResult(request,"");
    }

    @Override
    public JfResponseDto queryAuthCard(JfRequestDto request) throws Exception {
        return getResult(request,"");
    }

    @Override
    public JfResponseDto signApply(JfRequestDto request) throws Exception {
        return getResult(request,"");
    }

    @Override
    public JfResponseDto confirmSign(JfRequestDto request) throws Exception {
        return getResult(request,"");
    }

}
