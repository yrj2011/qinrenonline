package com.qinrenzaixian.web.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinrenzaixian.web.domain.UserDo;

@Repository("userDao")
public class UserDao extends BaseDAO{

	public UserDo selectBlog(String title){
	    return getSqlSession().selectOne("User.findUser",title);
	}

	public int  insertUser(UserDo user){
	    return getSqlSession().insert("User.insertUser",user);
	}

	public int  deleteBlog(String title){
	    return getSqlSession().delete("User.deleteBlog",title);
	}
	public void test(){
	    System.out.println("blogDaoImp test");
	}
}
