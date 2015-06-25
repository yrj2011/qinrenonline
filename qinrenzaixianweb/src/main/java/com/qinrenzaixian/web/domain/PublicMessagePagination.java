package com.qinrenzaixian.web.domain;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qinrenzaixian.web.vo.pagination.Pagination;

/**
 * 发布消息分页对象
 * 
 * @author yrj
 * @date 2015-06-21
 */
@SuppressWarnings("hiding")
public class PublicMessagePagination<PublicMessageDo> extends Pagination<PublicMessageDo> implements Serializable {
	Logger log = LoggerFactory.getLogger(PublicMessagePagination.class);
	private static final long serialVersionUID = 1L;
	public int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
