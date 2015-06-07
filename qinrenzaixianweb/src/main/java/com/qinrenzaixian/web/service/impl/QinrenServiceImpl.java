package com.qinrenzaixian.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.mapper.QinrenMapper;
import com.qinrenzaixian.web.service.QinrenService;

public class QinrenServiceImpl implements QinrenService {
	@Autowired
	private QinrenMapper qinrenMapper;

/*
    public QinrenMapper getQinrenMapper() {
		return qinrenMapper;
	}

	public void setQinrenMapper(QinrenMapper qinrenMapper) {
		this.qinrenMapper = qinrenMapper;
	}
*/
	
    public void testBlog(){
        System.out.println("测试blog");
    }
    public String selectOwner(String title){
        return qinrenMapper.selectOwner(title);
    }

   @Override
    public int deleteBlog(String title) {
         System.out.println("执行删除");
         // TODO Auto-generated method stub
         return qinrenMapper.deleteBlog(title);
    }

    @Override
    public int insertBlog(String title, String content, String owner) throws Exception {
        // TODO Auto-generated method stub
        qinrenMapper.insertBlog(title, content);
        try {
        	 throw new Exception();
		} catch (Exception e) {
			throw e;
		}
    }

    @Override
    public int updateBlog(UserDo blog) {
        System.out.println("update");
        // TODO Auto-generated method stub
        return qinrenMapper.updateBlog(blog);
    }

    @Override
    public UserDo selectBlog(String title) {
        System.out.println("查询博客");
        // TODO Auto-generated method stub
        return qinrenMapper.selectBlog(title);
    }
    
}
