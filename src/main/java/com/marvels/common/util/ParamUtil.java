package com.marvels.common.util;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.SerialGenerator;
import com.marvels.dto.sy.AppHeader;
import com.marvels.dto.sy.SyRequestDto;
import com.marvels.dto.sy.SysHeader;

public class ParamUtil {
    public static String getString(String interfaceCode, Object object) {
        PropertiesLoadUtil.getPropertiesValue("chuangjin.lp40008.backurl", "forms-openapi.properties");
        String aa = SerialGenerator.get13Random();
        SyRequestDto request = new SyRequestDto();
        SysHeader sysheader = new SysHeader();
        AppHeader appheader = new AppHeader();
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
}
