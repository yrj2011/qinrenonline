package com.qinrenzaixian.web.service;

import com.qinrenzaixian.web.domain.UserDo;

/**
 * 
 * @author yrj
 *
 */
public interface QinrenService  {
	public UserDo selectBlog(String  name);  
	public String  selectOwner(String title);   
	public int  deleteBlog(String title);
	public int insertBlog(String title,String content,String owner);
	public int updateBlog(UserDo blog);

}
