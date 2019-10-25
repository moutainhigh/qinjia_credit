package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryAllRepayRecordReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/25 11:31
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryAllRepayRecordReq {
    /** 资产端商户编号*/
    private String merchNo;
    /** 客户编号*/
    private String cusNo;
}
