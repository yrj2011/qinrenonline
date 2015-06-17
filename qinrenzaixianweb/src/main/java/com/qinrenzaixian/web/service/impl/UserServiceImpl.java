package com.qinrenzaixian.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinrenzaixian.web.dao.UserDao;
import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 通过登录名查询用户
	 * @param name 用户名
	 * @return
	 */
	@Override
	public UserDo selectUserByName(String name) {
		return userDao.selectUserByName(name);
	}
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertUser(UserDo user) throws Exception{
		int rs = userDao.insertUser(user);
		return rs;
	}
	
	/**
	 * 修改用户
	 * @param user 用户信息
	 * @return
	 * @throws Exception
	 */
	public int updateUser(UserDo user) throws Exception{
		int rs = userDao.updateUser(user);
		return rs;
	}
}
