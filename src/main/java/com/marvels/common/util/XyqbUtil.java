package com.marvels.common.util;

import com.marvels.common.annatation.Required;

import java.lang.reflect.Field;

public class XyqbUtil {
	
	/**
	 * 检查对象必填项,如检查通过则返回null
	 * @param input
	 * @return
	 *@author wanggang
	 */
	public static String requiredCheck(Object input) {
		if(input == null) {
			return "数据包为空";
		}

		StringBuilder sb = new StringBuilder();
		Field[] fieldList = input.getClass().getDeclaredFields();
		for(Field field : fieldList) {
			field.setAccessible(true);
			Required  required  = field.getAnnotation(Required.class);
			if(required != null) {//说明是必输项,需要校验
				try {
					Object value = field.get(input);
					if(value == null || "".equals(value.toString())) {
						sb.append(required.desc()).append(",");
					}
					else {
						continue;
					}
				} catch (Exception e) {
					return "额度申请异常:0008(检查必填项出错)";
				} 
			}
		}
		
		if("".equals(sb.toString())) {
			return null;
		}
		else {
			sb.deleteCharAt(sb.length()-1);
			return sb.toString();
		}
	}
}
