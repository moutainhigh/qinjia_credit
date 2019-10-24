package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfQueryOrderListReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/24 17:52
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryOrderListRes {
    /** 总条数 */
    private int count;
    /** 工单列表 */
    private List<JfQueryOrderListResList> orderList;

}
