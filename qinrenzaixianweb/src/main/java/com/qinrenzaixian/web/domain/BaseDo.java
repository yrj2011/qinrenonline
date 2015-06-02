package com.qinrenzaixian.web.domain;

import java.util.Date;

/**
 * DO 父对象
 * 
 * @author xiaoyang
 *
 */
public class BaseDo {
	/**
	 * 唯一标识
	 */
	private Long id;

	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 创建人ID
	 */
	private long creater;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 修改人
	 */
	private Long updater;
	
	/**
	 * 删除标志0 可用，1 删除
	 */
	private Integer delflag;
	
	/**
	 * 状态'
	 */
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCreater() {
		return creater;
	}

	public void setCreater(long creater) {
		this.creater = creater;
	}

	public Long getUpdater() {
		return updater;
	}

	public void setUpdater(Long updater) {
		this.updater = updater;
	}

	public Integer getDelflag() {
		return delflag;
	}

	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
