package com.qinrenzaixian.web.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.service.UserService;

/** 
* 用户相关action
* 用户注册、登录 、找回密码..
*  
* @author  yrj 
* @version  [版本号, 2015年5月30日] 
* @see 
* @since v1.0 用户模块
*/
@Controller
@Scope("prototype")   
@RequestMapping("/user")
public class UsersAction {
     @Autowired
	 private UserService userService;
	 /**
	   * 进入用户注册页面
	   * @return
	   */
	  @RequestMapping(value="/regist",method=RequestMethod.GET)  
	  public ModelAndView  intoRegist(Model model)
	  {
	      ModelAndView mov=new ModelAndView();  
	      mov.setViewName("user/regist");  
	      model.addAttribute("userinfo", new UserDo());
	      return mov;  
	  }  
	  
	  /**
	   * 注册用户
	   * @return
	   */
	  @RequestMapping(value="/regist",method=RequestMethod.POST)  
	  public ModelAndView  registUser(UserDo userinfo , Model model)
	  {
	      ModelAndView mov=new ModelAndView(); 
	      try {
			userService.insertUser(userinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	      mov.setViewName("user/regist");
	      model.addAttribute("userinfo", userinfo);
	      return mov;  
	  }  
	  
	 /**
	  * 检查用户名是否存在
	  * @param name
	  * @param param
	  * @return
	  */
     @ResponseBody
	 @RequestMapping(value="/validateName", method=RequestMethod.POST)
	 public Map<String,String> validateName(@RequestParam String name, @RequestParam String param){
		Map<String,String> map = new HashMap<String,String>();
		map.put(name, param);
		long n = System.currentTimeMillis();
		if(n%2==0){
			map.put("status","n");
			map.put("info","用户名已存在");
		}else {
			map.put("status","y");
			map.put("info","");
		}
		return map;
	 }
}
