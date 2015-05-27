package com.qinrenzaixian.test.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/** 
* <一句话功能简述> 
* <功能详细描述> 
*  
* @author  yrj 
* @version  [版本号, 2014年3月4日] 
* @see  [相关类/方法] 
* @since  [产品/模块版本] 
*/  
@Controller  
@Scope("prototype")   
@RequestMapping("/user")  
public class UserAction  
{  
  @RequestMapping(value="/save",method=RequestMethod.POST)  
  public ModelAndView  save(String name,String password)  
  {  
      System.out.println("接收到的用户信息："+name);  
        
      ModelAndView mov=new ModelAndView();  
      mov.setViewName("saveUserSuccess");  
      mov.addObject("msg", "保存成功了");  
        
      return mov;  
  }  
}  
