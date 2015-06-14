package com.qinrenzaixian.core.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 资源文件工具类
 * @author yrj
 * @date 2015-06-14 
 */
public class PropertiesUtil {
	
	private static Logger log = LoggerFactory.getLogger(ObjectUtil.class);

	private static Map<String,Properties> props = new HashMap<String,Properties>();
	
	/**
	 * 获取资源文件
	 * @param resourceName
	 * @return
	 */
	public static Properties getProperty(String resourceName){
		Properties prop = null; 
		if(props.containsKey(resourceName)){
			return props.get(resourceName);
		}
		try {
			prop = PropertiesLoaderUtils.loadAllProperties(resourceName);
			props.put(resourceName, prop);
		} catch (IOException e) {
			log.error("资源不存在:"+resourceName);
		}
		return prop;
	}
	
}
