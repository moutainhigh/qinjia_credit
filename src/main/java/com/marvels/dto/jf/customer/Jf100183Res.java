package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 风控设备指纹实时反欺诈
 * @author houyl
 * @date 2019/10/14 18:05
 */
@Setter
@Getter
public class Jf100183Res {
    /** 决策结果 */
    private String riskResult;
    /** 通知策略 */
    private String frmsOperatorType;
}
