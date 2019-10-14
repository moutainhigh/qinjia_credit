package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 人脸识别结果上传
 * @author houyl
 * @date 2019/10/14 09:26
 */
@Setter
@Getter
public class JfFaceRecogSaveReq {

    /** 客户号 */
    private String customerId;
    /** 业务流水号 */
    private String bizSeqNo;
    /** docId */
    private String docId;
    /** 活体检测分 */
    private String liveRate;
    /** 人脸对比分 */
    private String similarity;
    /** 刷脸时的照片 */
    private String photo;
    /** 文件类型 */
    private String photoType;
    /** 人脸识别厂商编号 */
    private String credCorpOrg;
    /** 厂商下独有字段json 格式 */
    private String jsonData;

}
