package com.qinrenzaixian.web.service;

import java.util.List;

import com.qinrenzaixian.web.domain.CityDo;
import com.qinrenzaixian.web.exception.db.DBException;

/**
 *城市service接口
 * @author yrj
 *
 */
public interface CityService  {
	
	/**
	 * 通过id查询城市
	 * @param Id 
	 * @return
	 */
	public CityDo selectCityById(Long id)throws DBException;
	
	/**
	 * 查询城市列表
	 * @param City城市信息
	 * @return
	 * @throws Exception
	 */
	public List<CityDo> queryAllCityList() throws DBException;
}
