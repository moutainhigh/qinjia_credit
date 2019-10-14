package com.marvels.dto.jf.customer;

import java.util.List;
import java.util.Map;

/**
 * 额度查询
 * @author houyl
 * @date 2019/10/14 17:45
 */
public class Jf100184Res {
    /** 客户授信信息 */
    private Map summary;
    /** 额度 */
    private double quota;
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
    /** 场景额度信息 */
    private List<Jf100184Scenes> scenes;

}
