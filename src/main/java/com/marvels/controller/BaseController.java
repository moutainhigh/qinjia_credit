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
        if(CommonUtil.validEmpty(request,request.getHead())) {
            return new JfResponseDto("10001E","参数不能为空");
        }

        // 校验syscode
        JfRequestDto.JfHttpInterfaceHander head = request.getHead();
        if(!checkSysCode(head.getSysCode())) {
            return new JfResponseDto("10002E","系统编号错误");
        }

        // 玖富提供的系统标识
        String jfSysCode = config.getHand_sysCode();
        request.getHead().setSysCode(jfSysCode);

        return null;
    }


    /**
     * 校验系统编号
     * @param sysCode
     * @return
     */
    private boolean checkSysCode(String sysCode) {
        // 云集、吉荣、给米
        if(config.getYj_hand_sysCode().equals(sysCode)
                || config.getJr_hand_sysCode().equals(sysCode)
                ||config.getJm_hand_sysCode().equals(sysCode)) {
            return true;
        }

        return false;
    }
}
