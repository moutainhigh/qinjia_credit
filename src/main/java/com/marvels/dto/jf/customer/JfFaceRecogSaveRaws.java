package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * H5 raws
 * @author houyl
 * @date 2019/10/14 10:39
 */
@Setter
@Getter
public class JfFaceRecogSaveRaws {
    /** 流程验证结果 */
    private String validation;
    /** Face++假脸攻击判定 */
    private String face_genuineness;
    /** Face++攻击判断 */
    private String id_attacked;
    /** 接入方案 */
    private String plan;

}
