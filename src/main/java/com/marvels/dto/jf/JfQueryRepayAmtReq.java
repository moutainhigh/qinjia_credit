package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfGetRepayPlanReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 14:21
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayAmtReq {
    /** 借据编号*/
    private String iouId;
    /** 期数区间*/
    private String period;
    /** 还款类型*/
    private String repayType;
}
