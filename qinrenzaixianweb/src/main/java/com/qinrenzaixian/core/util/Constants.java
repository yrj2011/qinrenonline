package com.qinrenzaixian.core.util;

/**
 * 系统所有常量
 * @author xiaoyang
 *
 */
public class Constants {
	/**
	 * UTF8编码
	 */
	public static final String UTF_8 = "UTF-8";
	/**
	 * MD5算法
	 */
	public static final String MD5 = "MD5";
	
	/**
	 * 男人
	 */
	public static final String MAN = "0";
	
	/**
	 * 女人
	 */
	public static final String WOMAN = "1";
	/**
	 * 文件上传路径
	 */
	public static final String UPLOAD_PATH = "E:/picupload/";
	
	/**
	 * servlet 请求路径KEY
	 */
	public static final String JAVAX_SERVLET_FORWARD_REQUEST_URI ="javax.servlet.forward.request_uri";
	
	public static class User{
		/**
		 * session 登录用户key
		 */
		public static final String SESSION_WEB_LOGIN_USER_KEY = "QINRENZAIXIAN_WEBLOGIN_KEY";
	}
	
	/**
	 * 页面地址
	 * @author xiaoyang
	 *
	 */
	public static class URL{
		/**
		 * 基本信息
		 */
		public static final String USER_CENTER = "/user/info";
		/**
		 * 用户信息修改
		 */
		public static final String USER_INFODETAIL = "/user/info-detail";
		/**
		 * 用户地址列表页
		 */
		public static final String USER_ADDRESSLIST = "/user/addresslist";
	}
	
	
}
