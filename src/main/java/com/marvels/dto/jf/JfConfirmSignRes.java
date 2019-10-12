package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 签约申请接口返回参数
 */
@Getter
@Setter
public class JfConfirmSignRes {
    //绑定状态
    private String tranStatus;
    //交易完成时间
    private String tranCompletTime;
}
