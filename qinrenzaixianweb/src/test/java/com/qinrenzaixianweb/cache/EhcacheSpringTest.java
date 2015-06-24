package com.qinrenzaixianweb.cache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7207448133256412042L;
	String  name;
	String name2;
	public User(String n ,String n2){
		this.name = n;
		this.name2 = n2;
	}
}
public class EhcacheSpringTest {  
	 
    private CacheManager cacheManager;  
      
    private Cache cache;  
  
    @Before  
    public void init() {  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/applicationContext-cache.xml");  
        EhCacheCacheManager ehCacheManager = (EhCacheCacheManager) ctx  
                .getBean("cacheManager");  
        cacheManager = ehCacheManager.getCacheManager();  
        cache = cacheManager.getCache("userCache");  
    }  
      
    @After  
    public void destory() {  
        cacheManager.shutdown();  
    }  
  /*
    @Test  
    public void testEhcacheString() {  
        String key = "hello";  
        String value = "world";  
        cache.put(new Element(key, value));  
        Element element = cache.get(key);  
        Object obj = element.getObjectValue();  
        Assert.assertEquals(value, obj);  
        System.out.println(obj);  
    }  
  
    @Test  
    public void testEhcacheObj() {  
        String key = "user";  
        User value = new User("zhangsan", "lisi");  
        cache.put(new Element(key, value));  
        Element element = cache.get(key);  
        Object obj = element.getObjectValue();  
        Assert.assertEquals(value, obj);  
        System.out.println(obj);  
        Object objSer = element.getValue();  
        Assert.assertEquals(value, objSer);  
        System.out.println(objSer);  
    }  
    */
    @Test  
    public void testGetEhcacheObj() {  
        String key = "user";  
        Element element = cache.get(key);  
        Object obj = element.getObjectValue();  
        System.out.println(obj);  
        Object objSer = element.getValue();  
        System.out.println(objSer);  
    }  
}  