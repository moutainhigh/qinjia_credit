package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfQueryAllRepayRecordRes
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/25 11:36
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryAllRepayRecordRes {
    /** 借据列表*/
    private List<JfQueryAllRepayRecordResList> loanIouDetaillList;
}
