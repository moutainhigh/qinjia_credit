package com.marvels.service.impl;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryContractRes
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 18:20
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryContractRes {
    /**  合同编号 */
    private String contractId;
    /**  合同名称 */
    private String contractName;
    /** 下载地址 */
    private String contractOutUrl;
}
