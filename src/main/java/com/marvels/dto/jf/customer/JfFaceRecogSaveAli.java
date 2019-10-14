package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 阿里 Ali
 * @author houyl
 * @date 2019/10/14 10:46
 */
@Getter
@Setter
public class JfFaceRecogSaveAli {
    /** 阿里人脸识别状态 */
    private String statusCode;
    /** 阿里人脸结论 */
    private String auditConclusions;
}
