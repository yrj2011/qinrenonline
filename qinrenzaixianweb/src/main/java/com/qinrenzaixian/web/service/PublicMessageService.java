package com.qinrenzaixian.web.service;

import com.qinrenzaixian.web.domain.PublicMessageDo;
import com.qinrenzaixian.web.domain.PublicMessagePagination;

/**
 * 发布消息service接口
 * @author yrj
 *
 */
public interface PublicMessageService  {
	
	/**
	 * 通过id查询发布消息
	 * @param Id 
	 * @return
	 */
	public PublicMessageDo selectPublicMessageById(Long id);
	/**
	 * 新增发布消息
	 * @param publicmessage  发布消息
	 * @return
	 * @throws Exception
	 */
	public int insertPublicMessage(PublicMessageDo publicmessage) throws Exception;
	
	/**
	 * 修改发布消息
	 * @param publicmessage  发布消息
	 * @return
	 * @throws Exception
	 */
	public int updatePublicMessage(PublicMessageDo publicmessage) throws Exception;
	
	/**
	 * 删除发布消息
	 * @param publicmessage  发布消息
	 * @return
	 * @throws Exception
	 */
	public int deletePublicMessage(PublicMessageDo publicmessage) throws Exception;
	/**
	 * 查询发布消息列表
	 * @param publicmessage  发布消息
	 * @return
	 * @throws Exception
	 */
	public void queryPublicMessageList(PublicMessagePagination<PublicMessageDo> pagination) throws Exception;
}
