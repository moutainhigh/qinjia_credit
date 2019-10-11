package com.marvels.dto.sy;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.SerialGenerator;

public class SyRequestDto {
	
	private SysHeader sysheader;
	private AppHeader appheader;
	private Object reqdata;

	public SysHeader getSysheader() {
		return sysheader;
	}

	public void setSysheader(SysHeader sysheader) {
		this.sysheader = sysheader;
	}

	public AppHeader getAppheader() {
		return appheader;
	}

	public void setAppheader(AppHeader appheader) {
		this.appheader = appheader;
	}

	public Object getReqdata() {
		return reqdata;
	}

	public void setReqdata(Object reqdata) {
		this.reqdata = reqdata;
	}

    public static String getRequestDto(String interfaceCode, Object object){
        return getString(interfaceCode, object, SerialGenerator.get13Random());
    }

    public static String getString(String interfaceCode, Object object, String random) {
        PropertiesLoadUtil.getPropertiesValue("chuangjin.lp40008.backurl", "forms-openapi.properties");
        SyRequestDto request = new SyRequestDto();
        SysHeader sysheader = new SysHeader();
        AppHeader appheader = new AppHeader();
        Long reqTime = System.currentTimeMillis();
        String aa = random;
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
