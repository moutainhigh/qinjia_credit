package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 风控设备指纹实时反欺诈
 * @author houyl
 * @date 2019/10/14 17:40
 */
@Getter
@Setter
public class Jf100183Req {
    /** 请求流水号 */
    private String frmsOrderId;
    /** 用户号 */
    private String frmsUserId;
    /** 身份证号 */
    private String frmsIdNo;
    /** 手机号 */
    private String frmsPhoneNo;
    /** 事件类型 */
    private String frmsBizCode;
    /** ip 地址 */
    private String frmsIp;
    /** 设备指纹 */
    private String frmsFingerPrint;
    /** 设备指纹厂商 */
    private String frmsFingerprintManufacturer;
    /** 网络类型 */
    private String frmsNetStatus;
    /** 路由 mac地址 */
    private String frmsMac;
    /** 经度 */
    private String frmsLongitude;
    /** 维度 */
    private String frmsDimension;
    /** 设备类型 */
    private String frmsDeviceType;
    /** Ip 省 */
    private String frmsIpProv;
    /** Ip 市 */
    private String frmsIpCity;
    /** gps 省 */
    private String frmsGpsProv;
    /** gps 市 */
    private String frmsGpsCity;
    /** 手机归属省 */
    private String frmsPhoneProv;
    /** 手机归属市 */
    private String frmsPhoneCity;
    /** 渠道 */
    private String frmsRegistChannel;
    /** Imei 号 */
    private String frmsImei;
    /** 手机 SIM卡状态 */
    private String frmsSimCardStatus;
    /** 注册 IP 归属省 */
    private String frmsRegisterIpProv;
    /** 注册 IP 归属市 */
    private String frmsRegisterIpCity;
    /** 注册 IP */
    private String frmsRegisterIp;
    /** 交易金额 */
    private String frmsTransVol;
    /** 通讯地址 */
    private String frmsContactAddress;
    /** 紧急联系人手机号 */
    private String frmsRelativePhone;
    /** 用户姓名 */
    private String frmsUserName;
    /** 彩虹评级 */
    private String frmsRainbowRate;
    /** 客户级别 */
    private String frmsBorrowGrade;
    /** 订单编号 */
    private String frmsOrderNo;
    /** 产品 ID */
    private String frmsProductId;
    /** 产品名称 */
    private String frmsProductName;
    /** 银行卡号(借记卡) */
    private String frmsCardNo;
    /** 最近一次登录设备指纹 */
    private String frmsLatestLoginFingerprint;
    /** 微言标签,如果存在多个以逗号分隔 */
    private String frmsWeiyanTag;
    /** 银行卡号(信用卡) */
    private String frmsCreditCardNo;

}
