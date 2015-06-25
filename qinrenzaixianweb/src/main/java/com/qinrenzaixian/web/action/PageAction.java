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
import com.qinrenzaixian.web.domain.AddressDo;
import com.qinrenzaixian.web.domain.AddressPagination;
import com.qinrenzaixian.web.domain.PublicMessageDo;
import com.qinrenzaixian.web.domain.PublicMessagePagination;
import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.service.AddressService;
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
	@Autowired
	private AddressService addressService;
    /**
     * 地址列表
     */
	private AddressPagination<AddressDo> addressPage;
	private AddressDo addressinfo;
	

	public AddressDo getAddressinfo() {
		return addressinfo;
	}

	public void setAddressinfo(AddressDo addressinfo) {
		this.addressinfo = addressinfo;
	}

	/**
	 * 页数
	 */
	private int page;
	/**
	 * 每页条数
	 */
	private int pageSize;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public AddressPagination<AddressDo> getAddressPage() {
		if(addressPage == null){
			addressPage = new AddressPagination<AddressDo>();
		}
		addressPage.setUserId(ActionUtil.getCurrentUser() ==null?0L:ActionUtil.getCurrentUser().getId());
		if(page>0){
			addressPage.setPage(String.valueOf(page));
		}
		if(pageSize > 0){
			addressPage.setPageSize(pageSize);
		}
		return addressPage;
	}

	public void setAddressPage(AddressPagination<AddressDo> addressPage) {
		this.addressPage = addressPage;
	}

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
	@RequestMapping(value = Constants.URL.USER_INFODETAIL, method = RequestMethod.GET)
	public ModelAndView userinfoDetail(Model model) {
		ModelAndView mov = new ModelAndView();
		UserDo userinfo = ActionUtil.getCurrentUser();
		userinfo = userService.selectUserByName(userinfo.getName());
		mov.addObject("userinfo", userinfo);
		mov.setViewName("user/center-user-detail");
		return mov;
	}
	
	/**
	 * 用户地址列表
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = Constants.URL.USER_ADDRESSLIST, method = RequestMethod.GET)
	public ModelAndView addressList(Model model,AddressPagination<AddressDo> addressPage) throws Exception {
		ModelAndView mov = new ModelAndView();
	    addressService.queryAddressList(addressPage);
	    mov.addObject("addressPage", addressPage);
		mov.setViewName("user/addresslist");
		return mov;
	}
	
	/**
	 * 用户地址编辑
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = Constants.URL.USER_ADDRESSEDIT, method = RequestMethod.GET)
	public ModelAndView addressEdit(Model model, AddressDo addressinfo) throws Exception {
		ModelAndView mov = new ModelAndView();
		 mov.addObject(Constants.FLAG, Constants.FLAG_ADD);
		if(addressinfo ==  null){
			addressinfo = new AddressDo();
		}
		if(addressinfo.getId() != null && addressinfo.getId().longValue() >0){
			addressinfo = addressService.selectAddressById(addressinfo.getId());
			 mov.addObject(Constants.FLAG, Constants.FLAG_UPDATE);
		}
	    mov.addObject("addressinfo", addressinfo);
		mov.setViewName("user/address_add");
		return mov;
	}
	
	
	/**
	 * 寻子发布信息列表
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = Constants.URL.PUBLICKMESSAGE_FC_LIST, method = RequestMethod.GET)
	public ModelAndView publicmessageFcList(Model model, PublicMessagePagination<PublicMessageDo> publickmessagePage) throws Exception {
		publickmessagePage.setType(Constants.FIND_CHILD);
		ModelAndView mov = new ModelAndView();
	    addressService.queryAddressList(addressPage);
	    mov.addObject("addressPage", addressPage);
		mov.setViewName("user/addresslist");
		return mov;
	}
}
