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

	@Override
	public UserDo selectBlog(String name) {
		return userDao.selectBlog(name);
	}
	
	@Override
	public int insertUser(UserDo user) throws Exception{
		int rs = userDao.insertUser(user);
		throw new Exception();
	}
}
