package com.qinrenzaixian.web.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qinrenzaixian.core.util.ActionUtil;
import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.service.UserService;

/**
 * 
 * 模仿viewcontroll
 * @author yrj
 * @version [版本号, 2015年6月10日]
 * @see
 * @since v1.0 页面模块
 */
@Controller
@Scope("prototype")
public class PageAction {
	private static Logger log = Logger.getLogger(PageAction.class);
	@Autowired
	private UserService userService;

	/**
	 * 进入首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView intoIndex2(Model model) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("index");
		return mov;
	}
	
	/**
	 * 进入首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView intoIndex(Model model) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("index");
		return mov;
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/regist", method = RequestMethod.GET)
	public ModelAndView regist(Model model) {
		ModelAndView mov = new ModelAndView();
		UserDo userinfo = new UserDo();
		mov.addObject("userinfo", userinfo);
		mov.setViewName("user/regist");
		return mov;
	}
	
	/**
	 * 用户登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		ModelAndView mov = new ModelAndView();
		UserDo userinfo = new UserDo();
		mov.addObject("userinfo", userinfo);
		mov.setViewName("user/login");
		return mov;
	}
	
	/**
	 * 个人基本信息
	 * 
	 * @return
	 */
	@RequestMapping(value =Constants.URL.USER_CENTER, method = RequestMethod.GET)
	public ModelAndView userinfo(Model model) {
		ModelAndView mov = new ModelAndView();
		UserDo userinfo = ActionUtil.getCurrentUser();
		userinfo = userService.selectUserByName(userinfo.getName());
		mov.addObject("userinfo", userinfo);
		mov.setViewName("user/center");
		return mov;
	}
	
	/**
	 * 个人信息完善
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/info-detail", method = RequestMethod.GET)
	public ModelAndView userinfoDetail(Model model) {
		ModelAndView mov = new ModelAndView();
		UserDo userinfo = ActionUtil.getCurrentUser();
		userinfo = userService.selectUserByName(userinfo.getName());
		mov.addObject("userinfo", userinfo);
		mov.setViewName("user/center-user-detail");
		return mov;
	}
}
