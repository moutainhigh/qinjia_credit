package com.marvels.dto.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName SendReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/18 17:18
 * @Version 1.0
 **/
@Getter
@Setter
public class SendSmsReq {
    /**  电话号码*/
    private String phoneNumbers;
    /**  模板编号*/
    private String templateCode;
    /**  模板参数*/
    private String templateParam;
}
