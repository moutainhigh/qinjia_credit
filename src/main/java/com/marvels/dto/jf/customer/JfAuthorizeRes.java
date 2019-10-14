package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 信用卡授权
 * @author houyl
 * @date 2019/10/14 12:03
 */
@Setter
@Getter
public class JfAuthorizeRes {
    /** 信用卡授权H5 页面url */
    private String creditCardAuthUrl;
}
