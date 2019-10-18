package com.marvels.controller;

import com.marvels.dto.common.SendSmsReq;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;
import com.marvels.service.CommonService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendSmsController
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/18 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("qjcs/api/jf/")
public class SendSmsController extends BaseController{
    @Autowired
    private CommonService commonService;
    /**
     * 支持的银行卡列表查询
     * @return
     * @throws Exception
     */
    @RequestMapping("sms10001")
    public JfResponseDto queryBankList(@RequestBody JfRequestDto<SendSmsReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return commonService.sendSms(request);
    }
}
