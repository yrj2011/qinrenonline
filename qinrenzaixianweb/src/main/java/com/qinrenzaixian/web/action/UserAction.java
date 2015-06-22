package com.qinrenzaixian.web.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qinrenzaixian.core.util.ActionUtil;
import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.DateEditor;
import com.qinrenzaixian.core.util.secret.MD5Util;
import com.qinrenzaixian.web.domain.AddressDo;
import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.service.AddressService;
import com.qinrenzaixian.web.service.UserService;

/**
 * 用户相关action 用户注册、登录 、找回密码..
 * 
 * @author yrj
 * @version [版本号, 2015年5月30日]
 * @see
 * @since v1.0 用户模块
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserAction {
	private static Logger log = Logger.getLogger(UserAction.class);
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;

	@InitBinder  
	protected void initBinder(HttpServletRequest request,  
	                              ServletRequestDataBinder binder) throws Exception {  
	    //对于需要转换为Date类型的属性，使用DateEditor进行处理  
	    binder.registerCustomEditor(Date.class, new DateEditor());  
	} 
	
	/**
	 * 注册用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ModelAndView registUser(UserDo userinfo, Model model)throws Exception {
		log.info("创建用户");
		ModelAndView mov = new ModelAndView();
		try {

			userinfo.setPassword(MD5Util.MD5Encode(userinfo.getPassword()));
			userinfo.setCreateIp(ActionUtil.getIP());
			userService.insertUser(userinfo);
			mov.setViewName("user/regist");
			model.addAttribute("userinfo", userinfo);
		} catch (Exception e) {
			log.error("创建用户失败：", e);
			throw e;
		}
		return mov;
	}

	/**
	 * 检查用户名是否存在
	 * 
	 * @param name
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public Map<String, String> validateName(@RequestParam String name,
			@RequestParam String param) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(name, param);
		UserDo user = userService.selectUserByName(param);
		if (user != null) {
			map.put("status", "n");
			map.put("info", "用户名已存在");
		} else {
			map.put("status", "y");
			map.put("info", "");
		}
		
		return map;
	}
	
	/**
	 * 用户登录
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(UserDo userinfo, Model model)throws Exception {
		log.info("用户登录");
		ModelAndView mov = new ModelAndView();
		try {
			UserDo userdo = userService.selectUserByName(userinfo.getName());
			if(userdo == null || !userdo.getPassword().equals(MD5Util.MD5Encode(userinfo.getPassword()))){
				model.addAttribute("loginmsg","用户名或密码错误");
				model.addAttribute("userinfo", userinfo);
				mov.setViewName("user/login");
			}else{
				ActionUtil.setCurrentUser(userdo);
				mov.setViewName("index");
			}
			
		} catch (Exception e) {
			log.error("登录用户失败：", e);
			throw e;
		}
		return mov;
	}
	
	/**
	 * 用户注销
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(UserDo userinfo, Model model)throws Exception {
		log.info("用户注销");
		ModelAndView mov = new ModelAndView();
		try {
			ActionUtil.clearCurrentUser();
			mov.setViewName("index");
		} catch (Exception e) {
			log.error("用户注销失败：", e);
			throw e;
		}
		return mov;
	}
	
	/**
	 * 完善用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/info-detail", method = RequestMethod.POST)
	public ModelAndView infoDetail(UserDo userinfo, Model model)throws Exception {
		log.info("完善用户信息");
		try {
			userinfo.setUpdateIp(ActionUtil.getIP());
			userService.updateUser(userinfo);
			return new ModelAndView("redirect:"+Constants.URL.USER_CENTER);
		} catch (Exception e) {
			log.error("完善用户信息失败：", e);
			throw e;
		}
	}
	
	/**
	 * 删除用户地址
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addressdel", method = RequestMethod.GET)
	public ModelAndView addressDel(AddressDo addressinfo, Model model)throws Exception {
		log.info("删除用户地址");
		try {
			if(addressinfo != null && addressinfo.getId() != null){
				addressService.deleteAddress(addressinfo);
			}
			return new ModelAndView("redirect:"+Constants.URL.USER_ADDRESSLIST+Constants.SUFFIX);
		} catch (Exception e) {
			log.error("删除用户地址：", e);
			throw e;
		}
	}
	
	
	/**
	 * 新增用户地址
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addaddress", method = RequestMethod.POST)
	public ModelAndView addressAdd(AddressDo addressinfo, Model model)throws Exception {
		log.info("新增用户地址");
		try {
			if(addressinfo != null ){
				addressinfo.setCreater(ActionUtil.getCurrentUser().getId());
				addressinfo.setUserId(ActionUtil.getCurrentUser().getId());
				addressService.insertAddress(addressinfo);
			}
			return new ModelAndView("redirect:"+Constants.URL.USER_ADDRESSEDIT+Constants.SUFFIX);
		} catch (Exception e) {
			log.error("新增用户地址：", e);
			throw e;
		}
	}
	
	/**
	 * 新增用户地址
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateaddress", method = RequestMethod.POST)
	public ModelAndView addressaEdit(AddressDo addressinfo, Model model)throws Exception {
		log.info("修改用户地址");
		try {
			if(addressinfo != null && addressinfo.getId() != null ){
				addressinfo.setUpdater(ActionUtil.getCurrentUser().getId());
				addressService.updateAddress(addressinfo);
			}
			return new ModelAndView("redirect:"+Constants.URL.USER_ADDRESSLIST+Constants.SUFFIX);
		} catch (Exception e) {
			log.error("修改用户地址：", e);
			throw e;
		}
	}
}
