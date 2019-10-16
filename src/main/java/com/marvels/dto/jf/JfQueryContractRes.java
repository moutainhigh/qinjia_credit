package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryContractRes
 * @Description 工单合同信息查询接口响应参数
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
