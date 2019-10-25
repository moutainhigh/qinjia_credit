package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询用户已绑定的银行卡列表
 * @author houyl
 * @date 2019/10/25 09:33
 */
@Getter
@Setter
public class Jf100185Req {
    /** 客户号 */
    private String customerId;
}
