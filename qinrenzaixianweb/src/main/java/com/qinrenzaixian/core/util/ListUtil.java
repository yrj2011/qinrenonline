package com.qinrenzaixian.core.util;

import java.util.List;

/**
 * 集合工具类
 * @author yrj
 *
 */
public class ListUtil {
	
	/**
	 * 判断List集合是否为空
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List list){
		if(list == null || list.size() <1)
			return true;
		return false;
	}
	
	/**
	 * 判断List集合是否为空
	 * @param list
	 * @return
	 */
	public static boolean isNotEmpty(List list){
		if(list == null || list.size() <1)
			return false;
		return true;
	}
}
