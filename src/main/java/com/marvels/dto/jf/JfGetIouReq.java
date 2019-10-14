package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 玖富根据借款编号查询借据接口入参
 *
 */
@Getter
@Setter
public class JfGetIouReq {
    private String iouId;
}
