package com.marvels.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * IP白名单适配器
 * @author 
 *
 */

@Configuration
public class MarvelsLogConfigurerAdapter extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//添加IP白名单拦截器
		registry.addInterceptor(new IPWhiteListInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}

class MarvelsCorsRegistration extends CorsRegistration {

    public MarvelsCorsRegistration(String pathPattern) {
        super(pathPattern);
    }

    @Override
    public CorsConfiguration getCorsConfiguration() {
        return super.getCorsConfiguration();
    }
}
