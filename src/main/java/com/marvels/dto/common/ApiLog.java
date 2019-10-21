package com.marvels.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 接口日志
 * @author houyl
 * @date 2019/10/11 11:23
 */
@Setter
@Getter
public class ApiLog implements Serializable {

    /** 序列号 */
    private static final long serialVersionUID = 1L;

    /**
     *  主键
     */
    private Long id;
    /**
     *  接口编码
     */
    private String itfCode;
    /**
     *  接口名称
     */
    private String itfName;
    /**
     *  接口URI
     */
    private String itfUri;
    /**
     *  入参
     */
    private String inParam;
    /**
     *  出参
     */
    private String outParam;
    /**
     *  记录作成者
     */
    private String recAddUsr;
    /**
     *  记录作成时间
     */
    private String recAddDtt;
    /**
     *  记录更新者
     */
    private String recUpdUsr;
    /**
     *  记录更新时间
     */
    private String recUpdDtt;
}
