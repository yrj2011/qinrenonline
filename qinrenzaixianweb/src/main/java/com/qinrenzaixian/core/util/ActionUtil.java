package com.qinrenzaixian.core.util;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.qinrenzaixian.web.domain.UserDo;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Properties;

/**
 * 请求相关的工具类
 * 
 * @author gaoyan
 *
 */
public class ActionUtil {
	private static final Properties prop = PropertiesUtil.getProperty("config.properties");
	
    /**
     * Spring MVC获取request的三种方法：
     * <a href="http://yeelor.iteye.com/blog/1554795">http://yeelor.iteye.com/blog/1554795</a> 
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
            .getRequest();
    }
    
    /**获取请求IP*/
    public static String getIP() {
        HttpServletRequest request = getRequest();
        String addr = request.getRemoteAddr();
        //haproxy代理后把真实访问ip放在http header的 “X-Forwarded-For”中
        String headerXForwardedFor = request.getHeader("X-Forwarded-For");
        return headerXForwardedFor == null ? addr : headerXForwardedFor;
    }

    /**获取服务器真实路径*/
    public static String getRealPath(String path) {
        HttpServletRequest request = getRequest();
        return request.getSession().getServletContext().getRealPath(path);
    }
    
	/**
	 * 获取当前登陆的用户
	 */
    public static UserDo getCurrentUser() {
        Object user = getRequest().getSession().getAttribute(Constants.User.SESSION_WEB_LOGIN_USER_KEY);
        if(user != null) {
            return (UserDo) user;
        }
        UserDo user1 = new UserDo();
        user1.setId(0L);
        return user1;
    }
    
    /**
	 *  设置当前登陆的用户
	 */
    public static void setCurrentUser(UserDo user) {
        getRequest().getSession().setAttribute(Constants.User.SESSION_WEB_LOGIN_USER_KEY, user);
    }
    
    /**
     * 获取用户使用语言(国际化使用)
     * @return
     */
    public static String getLanguage(){
    	return "zh-CN";
    }

    /**
     * 用户注销
     */
	public static void clearCurrentUser() {
		getRequest().getSession().removeAttribute(Constants.User.SESSION_WEB_LOGIN_USER_KEY);
	}
    
	
}
