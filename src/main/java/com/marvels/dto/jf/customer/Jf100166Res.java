package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 借记卡授权
 * @author houyl
 * @date 2019/10/14 17:32
 */
@Getter
@Setter
public class Jf100166Res {
    /** 透传的第三方错误码 */
    private String errorCode;
    /** 透传的第三方错误信息 */
    private String errorMsg;
}
