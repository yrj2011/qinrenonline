package com.qinrenzaixian.web.action;

import java.util.Date;

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
import org.springframework.web.servlet.ModelAndView;

import com.qinrenzaixian.core.util.ActionUtil;
import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.DateEditor;
import com.qinrenzaixian.web.domain.AddressDo;
import com.qinrenzaixian.web.domain.PublicMessageDo;
import com.qinrenzaixian.web.service.AddressService;
import com.qinrenzaixian.web.service.PublicMessageService;
import com.qinrenzaixian.web.service.UserService;

/**
 * 发布消息相关action
 * 
 * @author yrj
 * @version [版本号, 2015年5月30日]
 * @see
 * @since v1.0 用户模块
 */
@Controller
@Scope("prototype")
@RequestMapping("/publicmessage")
public class PublicMessageAction {
	private static Logger log = Logger.getLogger(PublicMessageAction.class);
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private PublicMessageService publicMessageService;
	@InitBinder  
	protected void initBinder(HttpServletRequest request,  
	                              ServletRequestDataBinder binder) throws Exception {  
	    //对于需要转换为Date类型的属性，使用DateEditor进行处理  
	    binder.registerCustomEditor(Date.class, new DateEditor());  
	} 
	
	
	/**
	 * 删除用户发布消息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/pmdel", method = RequestMethod.GET)
	public ModelAndView addressDel(PublicMessageDo pminfo, Model model)throws Exception {
		log.info("删除用户发布消息");
		try {
			if(pminfo != null && pminfo.getId() != null){
				publicMessageService.deletePublicMessage(pminfo);
			}
			return new ModelAndView("redirect:"+Constants.URL.USER_ADDRESSLIST+Constants.SUFFIX);
		} catch (Exception e) {
			log.error("删除用户发布消息：", e);
			throw e;
		}
	}
	
	
	/**
	 * 新增用户发布信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addpm", method = RequestMethod.POST)
	public ModelAndView addressAdd(PublicMessageDo pminfo, Model model)throws Exception {
		log.info("新增用户发布信息");
		try {
			if(pminfo != null ){
				pminfo.setCreater(ActionUtil.getCurrentUser().getId());
				pminfo.setUserId(ActionUtil.getCurrentUser().getId());
				publicMessageService.insertPublicMessage(pminfo);
			}
			return new ModelAndView("redirect:"+Constants.URL.PUBLICKMESSAGE_FC_EDIT+Constants.SUFFIX);
		} catch (Exception e) {
			log.error("新增用户发布信息：", e);
			throw e;
		}
	}
	
	/**
	 * 修改用户地址
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatepm", method = RequestMethod.POST)
	public ModelAndView addressaEdit(PublicMessageDo pminfo, Model model)throws Exception {
		log.info("修改用户地址");
		try {
			if(pminfo != null && pminfo.getId() != null ){
				pminfo.setUpdater(ActionUtil.getCurrentUser().getId());
				publicMessageService.updatePublicMessage(pminfo);
			}
			return new ModelAndView("redirect:"+Constants.URL.PUBLICKMESSAGE_FC_LIST+Constants.SUFFIX);
		} catch (Exception e) {
			log.error("修改用户地址：", e);
			throw e;
		}
	}
}
