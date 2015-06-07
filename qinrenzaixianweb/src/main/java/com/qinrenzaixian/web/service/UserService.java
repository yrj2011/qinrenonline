package com.qinrenzaixian.web.service;

import com.qinrenzaixian.web.domain.UserDo;

/**
 * 用户service接口
 * @author yrj
 *
 */
public interface UserService  {
	
	public UserDo selectBlog(String  name);
	public int insertUser(UserDo user) throws Exception;
}
