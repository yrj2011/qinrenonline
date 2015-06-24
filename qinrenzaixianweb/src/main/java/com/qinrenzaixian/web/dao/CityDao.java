package com.qinrenzaixian.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qinrenzaixian.web.domain.CityDo;
import com.qinrenzaixian.web.exception.db.DBException;

@Repository("cityDao")
public class CityDao extends BaseDAO{

	/**
	 * 通过ID查询城市信息
	 * @param id
	 * @return
	 */
	public CityDo selectCityById(Long id) throws DBException{
	    return getSqlSession().selectOne("city.findCityById",id);
	}
	
	/**
	 * 查询所有城市信息
	 * @param user 用户信息
	 * @return
	 * @throws Exception
	 */
	public List<CityDo> queryAllCityList() throws DBException{
		 return getSqlSession().selectList("city.queryCityList");
	}
}
