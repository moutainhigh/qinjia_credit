package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryRepayListReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/25 11:20
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayListReq {
    /** 资产端商户编号*/
    private String merchNo;
    /** 借据编号*/
    private String iouId;
}
