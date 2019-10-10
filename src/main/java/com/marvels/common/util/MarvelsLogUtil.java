package com.marvels.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 日志工具类
 * 记录日志。提供info, warn, error方法
 * @author wangliang
 *
 */
public class MarvelsLogUtil {
	private MarvelsLogUtil(){
		
	}
	
	public static MarvelsLogUtil getInstance() {  
		  return MarvelsLogUtilsInstance.logger;
    }
	
	private static class MarvelsLogUtilsInstance{
		private static MarvelsLogUtil logger = new MarvelsLogUtil();
	}
	
	public void info(String msg){
		Logger logger = getLogger();
		if(logger.isInfoEnabled()){
			logger.info(msg);
		}
	}
	
	public void warn(String msg,Throwable throwable){
		Logger logger = getLogger();
		if(logger.isWarnEnabled()){
			logger.warn(msg,throwable);
		}
	}
	
	public void warn(String msg){
		warn(msg, null);
	}
	
	public void warn(Throwable throwable){
		warn(null,throwable);
	}
	
	public void error(String msg,Throwable throwable){
		Logger logger = getLogger();
		if(logger.isErrorEnabled()){
			logger.error(msg,throwable);
		}
	}
	
	public void error(String msg){
		error(msg, null);
	}
	
	public void error(Throwable throwable){
		error(null,throwable);
	}
	
	private Logger getLogger() {  
        // 最原始被调用的堆栈对象  
        StackTraceElement caller = findCaller();  
        if(null == caller){
        	return LogManager.getLogger(MarvelsLogUtil.class);  
        }
        Logger log = LogManager.getLogger(caller.getClassName() + "." + caller.getMethodName() + "() Line: " + caller.getLineNumber());  
        return log;  
    }  
	
	private StackTraceElement findCaller() {  
        // 获取堆栈信息  
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();  
        if(null == callStack){
        	return null;  
        }
        // 最原始被调用的堆栈信息  
        StackTraceElement caller = null;  
        // 日志类名称  
        String logClassName = MarvelsLogUtil.class.getName();  
        // 循环遍历到日志类标识  
        boolean isEachLogClass = false;  
        // 遍历堆栈信息，获取出最原始被调用的方法信息  
        for (StackTraceElement s : callStack) {  
            // 遍历到日志类  
            if(logClassName.equals(s.getClassName())) {  
                isEachLogClass = true;  
            }  
            // 下一个非日志类的堆栈，就是最原始被调用的方法  
            if(isEachLogClass) {  
                if(!logClassName.equals(s.getClassName())) {  
                    isEachLogClass = false;  
                    caller = s;  
                    break;  
                }  
            }  
        }  
        return caller;  
    }
	
}
