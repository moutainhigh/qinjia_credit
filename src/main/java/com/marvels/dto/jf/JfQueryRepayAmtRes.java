package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfGetRepayPlanRes
 * @Description 还款金额试算接口出参
 * @Author renyz
 * @Date 2019/10/14 14:24
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayAmtRes {
    /** 借据编号 */
    private String iouId;
    /** 期数区间 */
    private String period;
    /** totalAmt */
    private String totalAmt;
    /** 应还本金 */
    private String repayAmt;
    /** 应还利息 */
    private String repayInt;
    /** 应还费用 */
    private String repayFee;
    /** 应还罚息 */
    private String repaPenaInt;
    /** 应还违约金 */
    private String violateAmt;
    /** 明细数据 */
    private List<JfQueryRepayAmtResDetail> detailList;

}
