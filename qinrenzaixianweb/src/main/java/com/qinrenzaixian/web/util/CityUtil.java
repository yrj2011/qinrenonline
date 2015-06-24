package com.qinrenzaixian.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.ListUtil;
import com.qinrenzaixian.core.util.ObjectUtil;
import com.qinrenzaixian.web.domain.CityDo;
import com.qinrenzaixian.web.exception.db.DBException;
import com.qinrenzaixian.web.service.CityService;

/**
 * 城市工具
 * @author yrj
 *
 */
@Component
public class CityUtil {
	private static Logger log = Logger.getLogger(CityUtil.class);
	/**
	 * 所有城市列表
	 */
	private static List<CityDo> allCityList = null;
	/**
	 * 所有省份列表
	 */
	private static List<CityDo> allAllPrivinceList = null;
	
	/**
	 * 所有城市列表
	 */
	private static Map<Long,CityDo> allCityMap = new HashMap<Long,CityDo>();
	private static Object lock = new Object();
	@Autowired
	private  CityService cityService;
	private static CityUtil cityutil;  
	  
    
    @PostConstruct  
    public void init() {  
    	cityutil = this;  
    	cityutil.cityService = this.cityService;  
  
    }  
    
	/**
	 * 获取所有省份列表
	 * @return
	 */
	public static List<CityDo> getAllPrivinceList(){
		if(allAllPrivinceList != null){
			return allAllPrivinceList;
		}
		synchronized (lock) {
			if(allCityList == null){
				try {
					getCityList();
				} catch (Exception e) {
					log.error("getAllPrivinceList失败：", e);
				}
			}
			if(ListUtil.isNotEmpty(allCityList)){
				for(CityDo cityDo : allCityList){
					if(ObjectUtil.isNotNull(cityDo.getParentId()) && cityDo.getType() == Constants.Area.PRIVINCE){
						if(allAllPrivinceList == null)
							allAllPrivinceList = new ArrayList<CityDo>();
						allAllPrivinceList.add(cityDo);
					}
				}
			}
			return allAllPrivinceList;
		}
	}

	/**
	 * 获取城市列表
	 * @throws DBException
	 */
	private static void getCityList() throws DBException {
		allCityList = cityutil.cityService.queryAllCityList();
		if(ListUtil.isNotEmpty(allCityList)){
			for(CityDo cityDo : allCityList){
				allCityMap.put(cityDo.getId(), cityDo);
			}
		}
	}
	
	/**
	 * 获取所有城市列表
	 * @return
	 */
	public static List<CityDo> getAllCityList(Long privinceId){
		    List<CityDo> cityList = new ArrayList<CityDo>();
			if(allCityList == null){
				synchronized (lock) {
					try {
						getCityList();
					} catch (Exception e) {
						log.error("getAllCityList失败：", e);
					}
				}
			}
			synchronized (cityList) {
				if(ListUtil.isNotEmpty(allCityList)){
					for(CityDo cityDo : allCityList){
						if(ObjectUtil.isNotNull(cityDo.getParentId()) 
						  && cityDo.getParentId().intValue() == privinceId.longValue()){
							cityList.add(cityDo);
						}
					}
				}
			}
			return cityList;
	 }
	
	/**
	 * 获取所有区/县列表
	 * @return
	 */
	public static List<CityDo> getAllDistrictList(Long cityId){
		    List<CityDo> distrctList = new ArrayList<CityDo>();
			if(allCityList == null){
				synchronized (lock) {
					try {
						getCityList();
					} catch (Exception e) {
						log.error("getAllDistrictList失败：", e);
					}
				}
			}
			synchronized (distrctList) {
				if(ListUtil.isNotEmpty(allCityList)){
					for(CityDo cityDo : allCityList){
						if(ObjectUtil.isNotNull(cityDo.getParentId()) 
						  && cityDo.getParentId().intValue() == cityId.longValue()){
							distrctList.add(cityDo);
						}
					}
				}
			}
			return distrctList;
	 }
	
	/**
	 * 通过ID获取城市对象
	 * @param id
	 * @return
	 * @throws DBException 
	 */
	public static CityDo getCityById(Long id) throws DBException{
		if(ObjectUtil.isNull(id) || id.longValue() == 0L|| id.longValue() == 1L)
			return null;
		if(allCityMap.size() < 1)
			getCityList();
		return allCityMap.get(id);
	}
}
