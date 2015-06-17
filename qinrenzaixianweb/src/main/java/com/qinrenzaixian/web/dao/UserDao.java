package com.qinrenzaixian.web.dao;

import org.springframework.stereotype.Repository;

import com.qinrenzaixian.web.domain.UserDo;

@Repository("userDao")
public class UserDao extends BaseDAO{

	/**
	 * 通过用户名查询用户
	 * @param name
	 * @return
	 */
	public UserDo selectUserByName(String name){
	    return getSqlSession().selectOne("User.findUser",name);
	}

	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	public int  insertUser(UserDo user){
	    return getSqlSession().insert("User.insertUser",user);
	}
	/**
	 * 修改用户
	 * @param user 用户信息
	 * @return
	 * @throws Exception
	 */
	public int updateUser(UserDo user) throws Exception{
		 return getSqlSession().update("User.updateUser",user);
	}
	

}
