package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 实名认证
 * @author houyl
 * @date 2019/10/12 11:07
 */
@Setter
@Getter
public class JfAuthNameReq {
    /** 用户手机号 */
    private String phoneNo;
    /** 识别机构编码 */
    private String ocrOrgId;
    /** 用户姓名 */
    private String name;
    /** 性别 */
    private String sex;
    /** 民族 */
    private String nation;
    /** 出生日期 */
    private String birthday;
    /** 户籍地址 */
    private String address;
    /** 身份证号 */
    private String certId;
    /** 证件类型 */
    private String certType;
    /** 证件有效期起 */
    private String validDateBegin;
    /** 证件有效期终 */
    private String validDateEnd;
    /** 发证机关 */
    private String authority;
    /** 文件类型 */
    private String fileType;
    /** 人像面照片 */
    private String frontPhoto;
    /** 国徽面照片 */
    private String backPhoto;
    /** 注册渠道 */
    private String registChannel;
}
