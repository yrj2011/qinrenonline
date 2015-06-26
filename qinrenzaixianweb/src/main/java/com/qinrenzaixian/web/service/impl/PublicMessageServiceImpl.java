package com.qinrenzaixian.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinrenzaixian.web.dao.PublicMessageDao;
import com.qinrenzaixian.web.domain.PublicMessageDo;
import com.qinrenzaixian.web.domain.PublicMessagePagination;
import com.qinrenzaixian.web.service.PublicMessageService;

@Service("publicMessageService")
public class PublicMessageServiceImpl implements PublicMessageService {

	@Autowired
	private PublicMessageDao publicmessageDao;

	/**
	 * 通过id查询发布消息
	 * @param Id 
	 * @return
	 */
	@Override
	public PublicMessageDo selectPublicMessageById(Long id){
		return publicmessageDao.selectPublicMessageById(id);
	}
	/**
	 * 新增发布消息
	 * @param publicmessage 发布消息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertPublicMessage(PublicMessageDo publicmessage) throws Exception{
		return publicmessageDao.insertPublicMessage(publicmessage);
	}
	
	/**
	 * 修改发布消息
	 * @param publicmessage 发布消息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updatePublicMessage(PublicMessageDo publicmessage) throws Exception{
		return publicmessageDao.updatePublicMessage(publicmessage);
	}
	
	/**
	 * 删除发布消息
	 * @param publicmessage 发布消息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deletePublicMessage(PublicMessageDo publicmessage) throws Exception{
		return publicmessageDao.deletePublicMessage(publicmessage);
	}
	/**
	 * 查询发布消息列表
	 * @param publicmessage 发布消息
	 * @return
	 * @throws Exception
	 */
	@Override
	public void queryPublicMessageList(PublicMessagePagination<PublicMessageDo> pagination) throws Exception{
		publicmessageDao.queryUserPublicMessage(pagination);
	}
}
