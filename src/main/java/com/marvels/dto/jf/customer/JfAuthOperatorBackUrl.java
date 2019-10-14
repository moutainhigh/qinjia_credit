package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 运营商授权
 * 前置回调 backUrl 时附带的参数
 * @author houyl
 * @date 2019/10/14 11:56
 */
@Setter
@Getter
public class JfAuthOperatorBackUrl {
    /** 授信任务号 */
    private String taskey;
    /** 授信结果 */
    private String taskState;
}
