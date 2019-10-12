package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口相应格式
 */
@Getter
@Setter
public class JfResponseDto {
    //响应状态码(各接口返回的响应状态编码)
    private String status;
    //响应信息(响应信息详细描述)
    private String message;
    //业务参数(各接口返回的业务参数，Json格式，部分可能不会返回此信息，由各接口确定)
    private String result;
}
