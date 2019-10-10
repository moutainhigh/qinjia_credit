package com.marvels.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesLoadUtil {
	//缓存不同properties文件内容
	private static Map<String,Properties> cacheProperties = new HashMap<String,Properties>();
	
	//配置文件缓存时效控制
	private static Map<String,Long> preLoadTime = new HashMap<String,Long>();
	//动态加载间隔时长  5分钟
	private static final int DYNAMIC_LOAD_TIME = 300000;
	
	/**
	 * 获取指定propertis 文件的Properties对象
	 * @param fileName
	 * @return
	 */
	public static Properties getProperties(String resourceName){
		return loadProperties(resourceName);
	}
	
	/**
	 * 获取指定文件 的指定属性值
	 * @param key
	 * @param fileName
	 * @return
	 */
	public static String getPropertiesValue(String key,String resourceName){
		return StringUtils.trim(getDynamicProperty(key,resourceName));
	}
	
	//动态获取配置文件，当缓存配置信息超过5分钟后重新缓存
	private static String getDynamicProperty(String key,String resourceName){
		long currentTime = System.currentTimeMillis();
		if(null==preLoadTime.get(StringUtils.upperCase(resourceName)) || 
		   DYNAMIC_LOAD_TIME <= (currentTime-preLoadTime.get(StringUtils.upperCase(resourceName)).longValue()) ){
			    MarvelsLogUtil.getInstance().info("PropertyLoadUtils reload pss.properties begin");
				
				loadPropertiesCache(resourceName);
				
				MarvelsLogUtil.getInstance().info("PropertyLoadUtils reload pss.properties end");
		}
		return StringUtils.trim(cacheProperties.get(StringUtils.upperCase(resourceName)).getProperty(key));
	}
	
	//加载配置文件，并缓存
	private static void loadPropertiesCache(String resourceName){
			Properties prop = loadProperties(resourceName);
			cacheProperties.put(StringUtils.upperCase(resourceName), prop);
			preLoadTime.put(StringUtils.upperCase(resourceName), Long.valueOf(System.currentTimeMillis()));
    }
	
	//加载配置文件
	private static Properties loadProperties(String resourceName){
		String classpath = PropertiesLoadUtil.class.getClassLoader().getResource(".").getPath();
		classpath = classpath.replace("lib", "");
		MarvelsLogUtil.getInstance().info("classpath="+classpath);
		File file = new File(classpath+"/config/"+resourceName);//先适配测试和生产去config下面找
		if(!file.exists())
			file = new File(classpath+"/"+resourceName);
		MarvelsLogUtil.getInstance().info("是否有找到文件:"+file.exists());
		MarvelsLogUtil.getInstance().info("找到文件路径:"+file.getAbsolutePath());
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader bf = new BufferedReader(isr);
			Properties props = new Properties();
			props.load(bf);
			return props;
		} catch (IOException e) {
			MarvelsLogUtil.getInstance().error("读取配置文件"+resourceName+"失败",e);
			return new Properties();
		}finally {
			if(isr != null)
				try {
					isr.close();
				} catch (IOException e) {
					MarvelsLogUtil.getInstance().error("读取配置文件"+resourceName+"失败",e);
				}
		}
	}
	
}
