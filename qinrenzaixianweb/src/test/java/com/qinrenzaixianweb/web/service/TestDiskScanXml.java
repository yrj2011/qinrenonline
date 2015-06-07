package com.qinrenzaixianweb.web.service;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qinrenzaixian.web.dao.UserDaoImpl;

public class TestDiskScanXml extends TestCase {

	/**
	 *  测试mybatis spring 通过数据映射来 映射来实现
	 */
    public void  testMybatis(){
    	try {
    		ApplicationContext act = new ClassPathXmlApplicationContext("/spring/applicationContext-xml.xml");
    		UserDaoImpl blogDaoImp= (UserDaoImpl)act.getBean("userDaoImp");
            blogDaoImp.test();
            Map<String,Object>  blog=blogDaoImp.selectBlog("title1");
            String title=(String)blog.get("name");
            String content=(String)blog.get("content");
            System.out.println("获取的值标题"+title+"  内容："+content);
           /* // 保存一条数据 blog
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("title", "title3");
            map.put("content", "content3");
            map.put("owner", "owner3");
            blogDaoImp.insertBlog(map);
            blogDaoImp.deleteBlog("title3");*/
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
