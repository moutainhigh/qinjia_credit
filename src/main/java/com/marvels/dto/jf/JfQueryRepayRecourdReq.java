package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryRepayRecourdReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 15:17
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayRecourdReq {
    /** 资产端商户编号*/
    private String merchNo;
    /** 商户流水号*/
    private String custNo;
}
