package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 2.3鉴权查询接口返回参数
 */
@Getter
@Setter
public class JfQueryAuthCardRes {
    //鉴权结果（Y：成功 N：失败）
    private String result;
    //商户号（错误信息）
    private String errorMsg;
}
