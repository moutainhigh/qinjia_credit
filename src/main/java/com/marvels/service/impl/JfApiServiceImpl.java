package com.marvels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.marvels.common.enums.PublicEnums;
import com.marvels.common.util.HttpUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.dto.jf.JfApplyQuotaReq;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;
import com.marvels.service.JfApiService;
import com.marvels.service.QjItfLogService;

public class JfApiServiceImpl implements JfApiService {
	
	@Autowired
    private QjItfLogService qjItfLogService;

	@Override
	public JfResponseDto applyQuota(JfRequestDto<JfApplyQuotaReq> param) throws Exception {
		return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
	}

	/**
	 * 发送post请求包装方法
	 * @param syinterface
	 * @param param
	 * @return
	 */
	private JfResponseDto<?> sendRequest(PublicEnums.JfInterfaceCodeEnum syinterface, JfRequestDto<?> param) {
		String url = PropertiesLoadUtil.getPropertiesValue("api.jiufu.url", "forms-openapi.properties");
		String questParam = JSON.toJSONString(param);
		String responseStr = HttpUtil.doPost(url + syinterface.getUri(), questParam);
		qjItfLogService.inOutParamsItfLog(syinterface.getCode(),questParam,responseStr);
		return JSON.parseObject(responseStr, JfResponseDto.class);
	}

}
