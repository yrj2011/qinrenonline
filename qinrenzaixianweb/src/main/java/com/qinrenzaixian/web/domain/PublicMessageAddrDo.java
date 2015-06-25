package com.qinrenzaixian.web.domain;


/**
 * 发布信息联系地址
 * @author xiaoyang
 *
 */
public class PublicMessageAddrDo extends BaseDo {
	/**
	 * 发布信息ID
	 */
	private Long publicmessageId;
	/**
	 * 联系地址ID
	 */
	private Long addressId;
	/**
	 * 排序号
	 */
	private int sort;
	public Long getPublicmessageId() {
		return publicmessageId;
	}
	public void setPublicmessageId(Long publicmessageId) {
		this.publicmessageId = publicmessageId;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
}
