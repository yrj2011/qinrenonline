package com.qinrenzaixian.web.domain;


/**
 * 图片小
 * @author xiaoyang
 *
 */
public class PictrueDo extends BaseDo {
	/**
	 *路径
	 **/
	 private String path;
	 /**
	  * 排序号
	  */
	 private int sort;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	 
}
