package com.qinrenzaixian.web.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class UserDaoImpl {
	public SqlSessionTemplate sqlSession;    

	public SqlSessionTemplate getSqlSession() {
	    return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
	    this.sqlSession = sqlSession;
	}

	public Map<String ,Object> selectBlog(String title){
	    return sqlSession.selectOne("com.qinrenzaixian.web.domain.UserDo.findBlog",title);
	}

	public int  insertBlog(Map<String,Object> map){
	    return sqlSession.insert("com.qinrenzaixian.web.domain.UserDo.insertBlog",map);
	}

	public int  deleteBlog(String title){
	    return sqlSession.delete("com.qinrenzaixian.web.domain.UserDo.deleteBlog",title);
	}
	public void test(){
	    System.out.println("blogDaoImp test");
	}
}
