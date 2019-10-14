package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 场景额度信息
 * @author houyl
 * @date 2019/10/14 17:50
 */
@Getter
@Setter
public class Jf100184Scenes {
    /** 产品类型 */
    private String productType;
    /** 额度 */
    private Double quota;
    /** 额度状态 */
    private String quotaStatus;
    /** 可用额度 */
    private double availableQuota;
    /** 圈存额度 */
    private double qcQuota;
    /** 已用额度 */
    private double usedQuota;
    /** 冻结额度 */
    private double frozenQuota;
}
