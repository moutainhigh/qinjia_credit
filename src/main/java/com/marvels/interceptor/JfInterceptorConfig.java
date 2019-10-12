package com.marvels.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 玖富拦截器配置
 * @author houyl
 * @date 2019/10/11 18:11
 */
@Configuration
public class JfInterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private JfInterceptor jfInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(jfInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
