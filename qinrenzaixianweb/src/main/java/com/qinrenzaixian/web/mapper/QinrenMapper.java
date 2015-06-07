package com.qinrenzaixian.web.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qinrenzaixian.web.domain.UserDo;

/**
 *@author yrj
 *2015-06-06
 */
public interface QinrenMapper {
	/**
	 * 方法中的@Param("") 可用可不用
	 * @param name
	 * @return
	 */
     @Select("SELECT name,password FROM  user  WHERE name = #{name}")        
     UserDo selectBlog(@Param("name") String name);
     @Select("select name  from user where name=#{name}")
     String selectOwner(@Param("name")String name);
     @Delete("delete from user where name=#{name}")
     int deleteBlog(@Param("name")String name);
     @Insert ("insert into user (name,password)  values(#{name},#{password})")
     int insertBlog(@Param("name")String name,@Param("password")String password);
     @Update("update user set password=#{name}  where name=#{name}")
     int  updateBlog( UserDo user);
}