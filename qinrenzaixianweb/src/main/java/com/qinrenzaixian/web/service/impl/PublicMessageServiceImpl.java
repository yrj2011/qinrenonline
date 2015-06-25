package com.qinrenzaixian.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinrenzaixian.web.dao.PublicMessageDao;
import com.qinrenzaixian.web.domain.AddressPagination;
import com.qinrenzaixian.web.domain.PublicMessageDo;
import com.qinrenzaixian.web.service.AddressService;

@Service("publicMessageService")
public class PublicMessageServiceImpl implements AddressService {

	@Autowired
	private PublicMessageDao publicmessageDao;

	/**
	 * 通过id查询发布消息
	 * @param Id 
	 * @return
	 */
	@Override
	public PublicMessageDo selectAddressById(Long id){
		return publicmessageDao.selectPublicMessageById(id);
	}
	/**
	 * 新增发布消息
	 * @param publicmessage 发布消息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertAddress(PublicMessageDo publicmessage) throws Exception{
		return publicmessageDao.insertAddress(publicmessage);
	}
	
	/**
	 * 修改发布消息
	 * @param publicmessage 发布消息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateAddress(PublicMessageDo publicmessage) throws Exception{
		return publicmessageDao.updateAddress(publicmessage);
	}
	
	/**
	 * 删除发布消息
	 * @param publicmessage 发布消息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteAddress(PublicMessageDo publicmessage) throws Exception{
		return publicmessageDao.deleteAddress(publicmessage);
	}
	/**
	 * 查询发布消息列表
	 * @param publicmessage 发布消息
	 * @return
	 * @throws Exception
	 */
	@Override
	public void queryAddressList(AddressPagination<PublicMessageDo> pagination) throws Exception{
		publicmessageDao.queryUserAddress(pagination);
	}
}
