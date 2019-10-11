package com.marvels.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * 保存每次的请求和响应的工具类<br>
 * 这里后续优化可以保存到mongodb,并且可以用aop做
 * @author wanggang
 *
 */
@Component
public class DBLogUtil {

	/**
	 * 记录请求响应日志
	 * @param req  请求报文
	 * @param res  响应报文
	 *@author wanggang
	 */
	public  void log(String interfaceNo,Object req,Object res) {
		String reqJson = null;
		String resJson = null;
		try {

		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error("记录日志失败,请求报文="+reqJson+",响应报文="+resJson, e);
		}
		
	}
	
	public static Object getFieldValue(Object obj,String fieldName) {
		Field field = null;
		try {
			field = obj.getClass().getDeclaredField(fieldName);
		}catch(NoSuchFieldException e) {//没有获取到,尝试从父类中获取
			//MarvelsLogUtil.getInstance().error("获取属性异常", e);
			try {
				field = obj.getClass().getSuperclass().getDeclaredField(fieldName);
			}catch(Exception e1) {
				//MarvelsLogUtil.getInstance().error("获取属性异常", e1);
				return null;
			}
		}catch(Exception e) {
			//MarvelsLogUtil.getInstance().error("获取属性异常", e);
			return null;
		}
		try {
			field.setAccessible(true);
			return field.get(obj);
		}catch(Exception e) {
			MarvelsLogUtil.getInstance().error("获取属性异常", e);
		}
		return null;
	}
}
