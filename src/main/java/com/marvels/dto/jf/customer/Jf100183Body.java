package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 风控设备指纹实时反欺诈（特殊表头表体）
 * @author houyl
 * @date 2019/10/14 18:39
 */
@Setter
@Getter
public class Jf100183Body<T> {
    /** 响应状态码 */
    private String status;
    /** 响应信息 */
    private String message;
    /** 业务参数 */
    private T data;

    public Jf100183Body(String status, String message) {
        this.message = message;
        this.status = status;
    }
}
