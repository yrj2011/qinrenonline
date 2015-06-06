package com.qinrenzaixian.web.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import com.qinrenzaixian.web.domain.UserDo;

/**
 *@author yrj
 *2015-06-06
 */
public interface QinrenMapper {
	/**
	 * 方法中的@Param("") 可用可不用
	 * @param title
	 * @return
	 */
     @Select("SELECT * FROM  mybatisSpring  WHERE title = #{title}")        
     UserDo selectBlog(@Param("title") String title);
     @Select("select owner  from mybatisSpring where title=#{title}")
     String selectOwner(@Param("title")String title);
     @Delete("delete from mybatisSpring where title=#{title}")
     int deleteBlog(@Param("title")String title);
     @Insert ("insert into mybatisSpring (title,content,owner)  values(#{title},#{content},#{owner})")
     int insertBlog(@Param("title")String title,@Param("content")String content,@Param("owner")String owner);
     @Update("update mybatisSpring set content=#{content} ,owner=#{owner}  where title=#{title}")
     int  updateBlog( UserDo blog);
}