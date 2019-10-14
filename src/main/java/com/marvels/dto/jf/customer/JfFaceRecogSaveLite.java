package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * H5 lite
 * @author houyl
 * @date 2019/10/14 10:46
 */
@Setter
@Getter
public class JfFaceRecogSaveLite {
    /** Face++活体检 */
    private String result;
    /** 测结果 */
    /** Face++合成脸置信度 */
    private String synthetic_face_confidence;
    /** Face++合成脸阈值 */
    private String synthetic_face_threshold;
    /** Face++面具置信度 */
    private String mask_confidence;
    /** Face++面具阈值 */
    private String mask_threshold;
    /** Face++翻拍置信度 */
    private String screen_replay_confidence;
    /** Face++翻拍阈值 */
    private String screen_replay_threshold;
    /** Face++攻击判断 */
    private String id_attacked;
    /** 接入方案 */
    private String plan;
}
