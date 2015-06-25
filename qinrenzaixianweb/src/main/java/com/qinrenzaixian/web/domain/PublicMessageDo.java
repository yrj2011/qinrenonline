package com.qinrenzaixian.web.domain;

import java.util.Date;
import java.util.List;

import com.qinrenzaixian.web.domain.BaseDo;

/**
 * 发布信息
 * @author xiaoyang
 *
 */
public class PublicMessageDo extends BaseDo {
	/**
	 * 所属用户ID
	 */
	private Long userId;
	
	/**
	 * 类型 1 父母寻子，2 子寻父母 ，3 好人线索
	 */
	private int type;
	/**
	 * 发表信息父消息
	 */
	private Long parentId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 省
	 */
	private Long provinceId;
	/**
	 * 市
	 */
	private Long cityId;
	/**
	 * 区县
	 */
	private Long districtId;
	/**
	 * 详细地址
	 */
	private Long address;
	/**
	 * 特征描述
	 */
	private String description;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 排序号
	 */
	private int sort;
	/**
	 * 关联图片
	 */
	private List<PictrueDo> pictrues;
	/**
	 * 关联联系地址
	 */
	private List<AddressDo> addresses;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public Long getAddress() {
		return address;
	}
	public void setAddress(Long address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public List<PictrueDo> getPictrues() {
		return pictrues;
	}
	public void setPictrues(List<PictrueDo> pictrues) {
		this.pictrues = pictrues;
	}
	public List<AddressDo> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDo> addresses) {
		this.addresses = addresses;
	}
	
}
