package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 旷视 sdk
 * @author houyl
 * @date 2019/10/14 10:27
 */
@Setter
@Getter
public class JfFaceRecogSaveKs {
    /** Face++验证结果 */
    private String result_code;
    /** Face++对比结果 */
    private String result_message;
    /** 人脸相似置信分 */
    private String confidence;
    /** 攻击性阈值 */
    private String threhold;
    /** 接入方案 */
    private String plan;
}
