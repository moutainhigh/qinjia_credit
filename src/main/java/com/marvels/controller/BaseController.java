package com.marvels.controller;

import com.alibaba.fastjson.JSONObject;
import com.marvels.common.enums.PublicEnums;
import com.marvels.common.util.CommonUtil;
import com.marvels.common.util.HttpUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;
import com.marvels.service.QjItfLogService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * controller基础类
 * @author shiwubin
 *
 */
public class BaseController {
    @Autowired
    private QjItfLogService qjItfLogService;

    /**
     *
     * @param request 请求参数
     * @param enumCode 接口枚举code
     * @return
     */
    public JfResponseDto jfRequestInterface(JfRequestDto request, String enumCode) {
        // 处理系统标识
        JfResponseDto jfResponseDto = buildSysCode(request);
        if(!"10000".equals(jfResponseDto.getStatus())) {
            return jfResponseDto;
        }

        // 请求玖富接口
        String response = HttpUtil.doPost("http"+Enum.valueOf(PublicEnums.JfInterfaceCodeEnum.class, enumCode).getUri(), JSONObject.toJSONString(request));

        // 接口出入参入库-异步
        qjItfLogService.inOutParamsItfLog(enumCode,request,response);

        jfResponseDto.setResult(response);
        return jfResponseDto;
    }


    /**
     * 校验接口系统标识
     * @param request 接口请求参数
     * @return
     */
    public JfResponseDto buildSysCode(JfRequestDto<?> request) {
        JfResponseDto result = null;
        if(CommonUtil.validEmpty(request,request.getHead())) {
            result = new JfResponseDto("10001E","参数不能为空");
            return result;
        }

        // 提供给调用者的系统标识
        String sysCode = PropertiesLoadUtil.getPropertiesValue("qj.jiufu.sysCode", "forms-openapi.properties");

        // 校验syscode
        JfRequestDto.JfHttpInterfaceHander head = request.getHead();
        if(!sysCode.equals(head.getSysCode())) {
            result = new JfResponseDto("10002E","参数不能为空");
            return result;
        }

        // 玖富提供的系统标识
        String jfSysCode = PropertiesLoadUtil.getPropertiesValue("jiufu.sysCode", "forms-openapi.properties");
        request.getHead().setSysCode(jfSysCode);
        return result;
    }
}
