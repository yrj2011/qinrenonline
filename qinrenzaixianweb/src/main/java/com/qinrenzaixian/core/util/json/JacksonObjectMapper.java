package com.qinrenzaixian.core.util.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 用于注入Spring MVC的json转换器
 * 
 * @author yangrenjaing
 * @date 2015-05-31
 */
public class JacksonObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public JacksonObjectMapper() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		this.setDateFormat(format);
	}
}
