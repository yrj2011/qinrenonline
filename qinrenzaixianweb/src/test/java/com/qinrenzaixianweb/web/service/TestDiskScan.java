package com.qinrenzaixianweb.web.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.service.impl.QinrenServiceImpl;

import junit.framework.TestCase;

public class TestDiskScan extends TestCase {

	/**
	 *  测试mybatis spring 通过数据映射来 映射来实现
	 */
    public void  testMybatis(){
    	try {
    		ApplicationContext act = new ClassPathXmlApplicationContext("/spring/applicationContext-scan.xml");
            QinrenServiceImpl blogserviceImp= (QinrenServiceImpl)act.getBean("qinrenServiceImp");
          /*  blogserviceImp.testBlog();
            UserDo blog=blogserviceImp.selectBlog("title1");
            System.out.println("title:"+blog.getName()+"  content:"+blog.getName());
            String owner=blogserviceImp.selectOwner("title1");
            System.out.println("myowner"+owner);*/
           // blogserviceImp.deleteBlog("title1");
            blogserviceImp.insertBlog("title112", "title1112", "title112");
            UserDo blogs= new UserDo();
            blogs.setName("title1");
            blogserviceImp.updateBlog(blogs);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
