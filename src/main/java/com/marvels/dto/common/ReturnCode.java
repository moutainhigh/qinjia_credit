package com.marvels.dto.common;

public class ReturnCode {
	
	/**
	 * 
	 * 检查必填项是否输入,发生异常
	 */
	public static final String REQUIRED_CHECK_EXCEPTION = "0008";
	
	/**
	 * 有必填项未输入
	 */
	public static final String REQUIRED_CHECK_NOT_PASS = "0001";
	
	/**
	 * 有必填项未输入
	 */
	public static final String SYSTEM_ERROR = "9999";
	
	public static final String SUCCESS = "00000";
}
