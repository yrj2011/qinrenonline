package com.qinrenzaixian.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinrenzaixian.web.dao.AddressDao;
import com.qinrenzaixian.web.dao.UserDao;
import com.qinrenzaixian.web.domain.AddressDo;
import com.qinrenzaixian.web.domain.AddressPagination;
import com.qinrenzaixian.web.domain.UserDo;
import com.qinrenzaixian.web.service.AddressService;
import com.qinrenzaixian.web.service.UserService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	/**
	 * 通过id查询地址
	 * @param Id 
	 * @return
	 */
	@Override
	public AddressDo selectAddressById(Long id){
		return addressDao.selectAddressById(id);
	}
	/**
	 * 新增地址
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertAddress(AddressDo address) throws Exception{
		return addressDao.insertAddress(address);
	}
	
	/**
	 * 修改地址
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateAddress(AddressDo address) throws Exception{
		return addressDao.updateAddress(address);
	}
	
	/**
	 * 删除地址
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteAddress(AddressDo address) throws Exception{
		return addressDao.deleteAddress(address);
	}
	/**
	 * 查询地址列表
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public void queryAddressList(AddressPagination<AddressDo> pagination) throws Exception{
		addressDao.queryUserAddress(pagination);
	}
}
