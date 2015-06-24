package com.qinrenzaixian.web.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.ListUtil;
import com.qinrenzaixian.core.util.ObjectUtil;
import com.qinrenzaixian.web.domain.CityDo;
import com.qinrenzaixian.web.service.CityService;

/**
 * 城市工具
 * @author yrj
 *
 */
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
	@Autowired
	private static CityService cityService;
	/**
	 * 获取所有省份列表
	 * @return
	 */
	public static List<CityDo> getAllPrivinceList(){
		if(allAllPrivinceList != null){
			return allAllPrivinceList;
		}
		synchronized (allAllPrivinceList) {
			if(allCityList == null){
				try {
					allCityList = cityService.queryAllCityList();
					if(ListUtil.isNotEmpty(allCityList)){
						for(CityDo cityDo : allCityList){
							if(ObjectUtil.isNotNull(cityDo.getParentId()) && cityDo.getType() == Constants.Area.PRIVINCE){
								if(allAllPrivinceList == null)
									allAllPrivinceList = new ArrayList<CityDo>();
								allAllPrivinceList.add(cityDo);
							}
						}
					}
				} catch (Exception e) {
					log.error("getAllPrivinceList失败：", e);
				}
				
			}
			return allAllPrivinceList;
		}
	}
	
	/**
	 * 获取所有城市列表
	 * @return
	 */
	public static List<CityDo> getAllCityList(Long privinceId){
		    List<CityDo> cityList = new ArrayList<CityDo>();
			if(allCityList == null){
				synchronized (allCityList) {
					try {
						allCityList = cityService.queryAllCityList();
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
				synchronized (allCityList) {
					try {
						allCityList = cityService.queryAllCityList();
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
}
