package com.marvels.controller;

import com.marvels.common.config.FormsOpenapiConfig;
import com.marvels.common.util.CommonUtil;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * controller基础类
 * @author shiwubin
 *
 */
public class BaseController {

    @Autowired
    private FormsOpenapiConfig config;

    /**
     * 校验接口系统标识
     * @param request 接口请求参数
     * @return
     */
    public JfResponseDto checkBuildSysCode(JfRequestDto<?> request) {
        JfResponseDto result = null;
        if(CommonUtil.validEmpty(request,request.getHead())) {
            result = new JfResponseDto("10001E","参数不能为空");
            return result;
        }

        // 提供给调用者的系统标识
        String sysCode = config.getQj_hand_sysCode();

        // 校验syscode
        JfRequestDto.JfHttpInterfaceHander head = request.getHead();
        if(!sysCode.equals(head.getSysCode())) {
            result = new JfResponseDto("10002E","系统编号错误");
            return result;
        }

        // 玖富提供的系统标识
        String jfSysCode = config.getHand_sysCode();
        request.getHead().setSysCode(jfSysCode);
        return result;
    }
}
