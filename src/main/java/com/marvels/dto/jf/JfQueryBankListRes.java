package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 支持银行卡查询列表返回对象
 */
@Getter
@Setter
public class JfQueryBankListRes {
    //银行名称
    private String bankName;
    //银行编码
    private String bankNo;
}
