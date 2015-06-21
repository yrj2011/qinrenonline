package com.qinrenzaixian.web.domain;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qinrenzaixian.web.vo.pagination.Pagination;

/**
 * 地址分页对象
 * 
 * @author yrj
 * @date 2015-06-21
 */
@SuppressWarnings("hiding")
public class AddressPagination<AddressDo> extends Pagination<AddressDo> implements Serializable {
	Logger log = LoggerFactory.getLogger(AddressPagination.class);
	private static final long serialVersionUID = 1L;
	/**
	 * 联系人
	 */
	private String contact;
	/**
	 * 座机
	 */
	private String phone;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 用户ID
	 */
	private Long userId;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

}
