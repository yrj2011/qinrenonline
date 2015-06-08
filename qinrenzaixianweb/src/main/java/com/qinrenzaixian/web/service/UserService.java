package com.qinrenzaixian.web.service;

import com.qinrenzaixian.web.domain.UserDo;

/**
 * 用户service接口
 * @author yrj
 *
 */
public interface UserService  {
	
	/**
	 * 通过登录名查询用户
	 * @param name 用户名
	 * @return
	 */
	public UserDo selectUserByName(String  name);
	public int insertUser(UserDo user) throws Exception;
}
