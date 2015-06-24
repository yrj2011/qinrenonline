package com.qinrenzaixian.web.domain;

import java.io.Serializable;

/**
 * 省、市、县信息
 * @author xiaoyang
 *
 */
public class CityDo extends BaseDo implements Serializable{
	private static final long serialVersionUID = -7315739201298493599L;
	private Long id;
	private Long   parentId;
	/**
	 * 简体
	 */
	private String   name;
	/**
	 * 繁体
	 */
	private String  nameHk;
	/**
	 * 英文
	 */
	private String  nameEn;
	/**
	 * 拼音首字母
	 */
	private String  namePy;
	/**
	 * 0:国家,1:省,2:市,3区
	 */
	private int  type;
	/**
	 * 经济协作区 1华北2华东3华中4华南5东北6西北7西南8港澳台
	 */
	private int  area;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentid) {
		this.parentId = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameHk() {
		return nameHk;
	}
	public void setNameHk(String nameHk) {
		this.nameHk = nameHk;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNamePy() {
		return namePy;
	}
	public void setNamePy(String namePy) {
		this.namePy = namePy;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
}
