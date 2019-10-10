package com.marvels.common.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.marvels.common.util.HttpHelper;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.PropertiesLoadUtil;

/**
 * IP白名单拦截器
 * @author wanggang
 *
 */
public class IPWhiteListInterceptor implements HandlerInterceptor {


	private static Map<String,String> ipWhiteMap = new HashMap<String,String>();
	
	static {
		String ipWhiteListStr = PropertiesLoadUtil.getPropertiesValue("xyqb.ip.whitelist", "forms-openapi.properties");
		MarvelsLogUtil.getInstance().info("从配置文件中加载ipWhiteList="+ipWhiteListStr);
		
		if(StringUtils.isNotBlank(ipWhiteListStr)) {
			String[] ipWhiteArray = ipWhiteListStr.split(",");
			for(String ip : ipWhiteArray) {
				ipWhiteMap.put(ip, ip);
			}
		}else {//没配就当作不拦截
			ipWhiteMap.put("*", "*");
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception exception)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		String ip = HttpHelper.getIpAddr(request);
		if(ipWhiteMap.get(ip) != null || ipWhiteMap.get("*") != null)
			return true;
		else {
			MarvelsLogUtil.getInstance().info("请求IP"+ip+"不在白名单中,已被拦截");
			return false;
		}
	}

	
}

