package com.qinrenzaixianweb.web.service;

import java.util.Map;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qinrenzaixian.web.dao.UserDao;
import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.service.UserService;

public class TestDiskScanXml extends TestCase {

	/**
	 *  测试mybatis spring 通过数据映射来 映射来实现
	 */
    public void  testMybatis(){
    	try {
    		ApplicationContext act = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
    		UserService userService= (UserService)act.getBean("userService");
            UserDo user= new UserDo();
            user.setName("yrj2012");
            user.setPassword("abc123");
            userService.insertUser(user);
           /* // 保存一条数据 user
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("title", "title3");
            map.put("content", "content3");
            map.put("owner", "owner3");
            userDao.insertuser(map);
            userDao.deleteuser("title3");*/
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
