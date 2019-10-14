package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * KYC信息提交
 * @author houyl
 * @date 2019/10/14 10:50
 */
@Setter
@Getter
public class JfCustomerKycReq {
    /** 客户号 */
    private String customerId;
    /** 居住省 */
    private String liveProvince;
    /** 居住市 */
    private String liveCity;
    /** 居住县 */
    private String liveCounty;
    /** 居住地地址 */
    private String liveAddress;
    /** 学历编码 */
    private String educationCode;
    /** 婚姻情况编码 */
    private String marriageCode;
    /** 月收入编码 */
    private String incomeLevelCode;
    /** 职业编码 */
    private String professionCode;
    /** 行业编码 */
    private String industryCode;
    /** 收入来源编码 */
    private String incomeSourceCode;
    /** 紧 急 联 系 人 1（编码） */
    private String relativeCode;
    /** 紧 急 联 系 人 1（姓名） */
    private String relativeName;
    /** 紧 急 联 系 人 1（手机号） */
    private String relativeMobile;
    /** 紧 急 联 系 人 2（编码） */
    private String secRelativeCode;
    /** 紧 急 联 系 人 2（姓名） */
    private String secRelativeName;
    /** 紧 急 联 系 人 2（手机号） */
    private String secRelativeMobile;
    /** 电子邮箱 */
    private String email;
    /** 有无贷款编码 */
    private String loanCode;
    /** 经度 */
    private String longitude;
    /** 纬度 */
    private String latitude;
    /** 单位名称 */
    private String company;
    /** 单位电话 */
    private String companyPhone;
    /** 单位地址 */
    private String companyAddress;

}
