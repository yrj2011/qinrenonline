package com.qinrenzaixian.web.domain;


/**
 * 发布信息图片
 * @author xiaoyang
 *
 */
public class PublicMessagePicDo extends BaseDo {
	/**
	 * 发布信息ID
	 */
	private Long publicmessageId;
	/**
	 * 图片ID
	 */
	private Long pictrueId;
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
	public Long getPictrueId() {
		return pictrueId;
	}
	public void setPictrueId(Long pictrueId) {
		this.pictrueId = pictrueId;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}
