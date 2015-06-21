package com.qinrenzaixian.web.domain;


/**
 * 用户地址信息
 * @author xiaoyang
 *
 */
public class AddressDo extends BaseDo {
	 /**
	  * 用户id
	  */
	 private Long userId;
	 /**
	  * 国家
	  */
	 private Long countryId;
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
	 private String address;
	 /**
	  * 邮编
	  */
	 private String zipCode;
	 /**
	  * 联系人
	  */
	 private String contact;
	 /**
	  * 手机号
	  */
	 private String mobilePhone;
	 /**
	  * 区号
	  */
	 private String zone;
	 /**
	  * 电话号
	  */
	 private String phoneNumber;
	 /**
	  * 分机号
	  */
	 private String extNumber;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getExtNumber() {
		return extNumber;
	}
	public void setExtNumber(String extNumber) {
		this.extNumber = extNumber;
	}
	
	
}
