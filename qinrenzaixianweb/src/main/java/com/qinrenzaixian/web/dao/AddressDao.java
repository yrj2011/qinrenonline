package com.qinrenzaixian.web.dao;

import org.springframework.stereotype.Repository;

import com.qinrenzaixian.web.domain.AddressDo;
import com.qinrenzaixian.web.domain.AddressPagination;

@Repository("addressDao")
public class AddressDao extends BaseDAO{

	/**
	 * 通过ID查询地址
	 * @param id
	 * @return
	 */
	public AddressDo selectAddressById(Long id){
	    return getSqlSession().selectOne("Address.findAddressById",id);
	}

	/**
	 * 新增地址
	 * @param address
	 * @return
	 */
	public int  insertAddress(AddressDo address){
	    return getSqlSession().insert("Address.insertAddress",address);
	}
	/**
	 * 修改地址
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	public int updateAddress(AddressDo address) throws Exception{
		 return getSqlSession().update("Address.updateAddress",address);
	}
	
	/**
	 * 查询用户地址列表
	 * @param address 地址信息
	 * @return
	 * @throws Exception
	 */
	public void queryUserAddress(AddressPagination<AddressDo> info) throws Exception{
		queryForPaginate("Address.queryAddressList", info);
	}

}
