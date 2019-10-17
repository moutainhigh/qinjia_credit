package com.marvels.common.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName FormsOpenapiProperties
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/17 17:34
 * @Version 1.0
 **/
@Getter
@Component
@PropertySource("forms-openapi.properties")
public class FormsOpenapiProperties {
    @Value("${qj.jiufu.httpHand.code}")
    private String code;
}
