package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfQueryRepayRecourdRes
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 15:19
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayRecourdRes {
    /** 明细数据*/
    private List<JfQueryRepayRecourdResDetail> recordDetailDTOList;
}
