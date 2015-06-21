package com.qinrenzaixian.web.service;

import com.qinrenzaixian.web.domain.AddressDo;
import com.qinrenzaixian.web.domain.AddressPagination;

/**
 * 地址service接口
 * @author yrj
 *
 */
public interface AddressService  {
	
	/**
	 * 通过id查询地址
	 * @param Id 
	 * @return
	 */
	public AddressDo selectAddressById(Long id);
	/**
	 * 新增地址
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	public int insertAddress(AddressDo address) throws Exception;
	
	/**
	 * 修改地址
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	public int updateAddress(AddressDo address) throws Exception;
	
	/**
	 * 查询地址列表
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	public void queryAddressList(AddressPagination<AddressDo> pagination) throws Exception;
}
