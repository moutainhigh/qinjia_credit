package com.marvels.service.impl;

import com.marvels.dto.jf.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.marvels.common.enums.PublicEnums;
import com.marvels.common.util.HttpUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.service.JfApiService;
import com.marvels.service.QjItfLogService;
import org.springframework.stereotype.Service;

@Service("jfApiService")
public class JfApiServiceImpl implements JfApiService {
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
	
	@Autowired
    private QjItfLogService qjItfLogService;

	@Override
	public JfResponseDto applyQuota(JfRequestDto<JfApplyQuotaReq> param) throws Exception {
		return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
	}

    @Override
    public JfResponseDto<JfQueryBankListRes> queryBankList(JfRequestDto<JfQueryBankListReq> param) throws Exception {
        return (JfResponseDto<JfQueryBankListRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    @Override
    public JfResponseDto<JfQueryCardBinRes> queryCardBin(JfRequestDto<JfQueryCardBinReq> param) throws Exception {
        return (JfResponseDto<JfQueryCardBinRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    @Override
    public JfResponseDto<JfQueryAuthCardRes> queryAuthCard(JfRequestDto<JfQueryAuthCardReq> param) throws Exception {
        return (JfResponseDto<JfQueryAuthCardRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    @Override
    public JfResponseDto<JfSignApplyRes> signApply(JfRequestDto<JfSignApplyReq> param) throws Exception {
        return (JfResponseDto<JfSignApplyRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    @Override
    public JfResponseDto<JfConfirmSignRes> confirmSign(JfRequestDto<JfConfirmSignReq> param) throws Exception {
        return (JfResponseDto<JfConfirmSignRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

}
