package com.marvels.common.util;

import com.alibaba.fastjson.JSON;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.sy.SyRequestDto;

public class ParamUtil {
    /**
     * 获取圣银参数
     * @param interfaceCode
     * @param object
     * @return
     */
    public static String getSyparamString(String interfaceCode, Object object) {
        PropertiesLoadUtil.getPropertiesValue("chuangjin.lp40008.backurl", "forms-openapi.properties");
        String aa = SerialGenerator.get13Random();
        SyRequestDto request = new SyRequestDto();
        SyRequestDto.SysHeader sysheader = new SyRequestDto.SysHeader();
        SyRequestDto.AppHeader appheader = new SyRequestDto.AppHeader();
        Long reqTime = System.currentTimeMillis();
        sysheader.setCustomerType("");
        sysheader.setCustomerId("");
        sysheader.setEMP_SID("");
        sysheader.setCurrentBusinessCode(interfaceCode);
        sysheader.setResponseFormat("JSON");
        sysheader.setChannel("");
        sysheader.setReqTime(reqTime.toString());
        sysheader.setSequenceNo("02"+aa+"12345");
        request.setSysheader(sysheader);
        appheader.setChallengeCode("");
        appheader.setDeviceSN("");
        appheader.setMobileCode("");
        appheader.setOriginData("");
        appheader.setSecurity("");
        request.setAppheader(appheader);
        request.setReqdata(JSON.toJSON(object));
        return JSON.toJSONString(request);
    }

    public String getJfParamString(JfRequestDto.JfHttpInterfaceHander hand,Object body){
        JfRequestDto requestDto = new JfRequestDto();
        requestDto.setHead(hand);
        requestDto.setBody(body);
        return JSON.toJSONString(requestDto);
    }

}
