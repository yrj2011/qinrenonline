package com.qinrenzaixian.web.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoSupportDaoImpl extends SqlSessionDaoSupport {
	/**
	 * 我们发现这个类中没有把SqlSessionTemplate 作为一个属性，因为我们继承了SqlSessionDaoSupport
	 * SqlSessionDaoSupport 他会提供sqlsession
	 */
	// 查询获取blog
	public Map<String, Object> selectBlog(String title) {
		return getSqlSession().selectOne("com.qinrenzaixian.web.domain.UserDo.findBlog",
				title);
	}
	//
	public Map<String, Object> selectBlogs(String title) {
		return this.getSqlSession().selectOne(
				"com.qinrenzaixian.web.domain.UserDo.findBlog", title);
	}

	public void test() {
		System.out.println("test support");
	}
}
