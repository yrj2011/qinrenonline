package com.qinrenzaixian.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinrenzaixian.web.dao.CityDao;
import com.qinrenzaixian.web.domain.CityDo;
import com.qinrenzaixian.web.exception.db.DBException;
import com.qinrenzaixian.web.service.CityService;

@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	/**
	 * 通过id查询城市
	 * @param Id 
	 * @return
	 */
	@Override
	public CityDo selectCityById(Long id)throws DBException{
		return cityDao.selectCityById(id);
	}
	
	/**
	 * 查询城市列表
	 * @param City城市信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CityDo> queryAllCityList() throws DBException{
		return cityDao.queryAllCityList();
	}
}
