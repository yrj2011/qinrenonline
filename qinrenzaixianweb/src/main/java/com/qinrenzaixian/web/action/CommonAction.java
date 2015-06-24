package com.qinrenzaixian.web.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.FileUtil;
import com.qinrenzaixian.core.util.ListUtil;
import com.qinrenzaixian.core.util.ObjectUtil;
import com.qinrenzaixian.core.util.StringUtil;
import com.qinrenzaixian.core.util.json.JsonUtils;
import com.qinrenzaixian.web.domain.CityDo;
import com.qinrenzaixian.web.exception.CommonException;
import com.qinrenzaixian.web.util.CityUtil;

/**
 * 
 * 公共Action
 * @author yrj
 * @version [版本号, 2015年6月16日]
 * @see
 * @since v1.0 页面模块
 */
@Controller
@Scope("prototype")
@RequestMapping("/")
public class CommonAction {
	private static Logger log = Logger.getLogger(CommonAction.class);
	/**
	 * 文件上传
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=Constants.URL.COMMON_UPLOAD,method=RequestMethod.POST)
	public Object upload(MultipartFile uploadFile){
		try {
			if(uploadFile == null){
				throw new CommonException("未找到上传文件");
			}
			String fileName = uploadFile.getOriginalFilename();
			String url = null;
			try {
				String path = Constants.UPLOAD_PATH;
				File f = new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String name = StringUtil.getUUID()+".jpg";
				//文件真实名称
				url =  path + name ;
				FileUtil.copyFile(uploadFile.getInputStream(), url);
			} catch (Exception e) {
				log.error("file upload fauilure. ["+fileName+"]");
				throw new CommonException(e.getMessage());
			}
			Map<String, String> rs = new HashMap<String, String>();
				
			rs.put("file_name", url);
			return JsonUtils.toJson(rs);
		} catch (Exception e) {
			log.error("上传文件失败："+e.getMessage() ,e);
		}
		return null;
	}
	
	/**
	 * 获取省份信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=Constants.URL.COMMON_GETPRIVCELIST,method=RequestMethod.GET)
	public Object getPrivceList(){
		try {
			
			List<CityDo>  list = CityUtil.getAllPrivinceList();
			if(ListUtil.isNotEmpty(list)){
				return JsonUtils.toJson(list);
			}
		} catch (Exception e) {
			log.error("获取省份信息失败："+e.getMessage() ,e);
		}
		return null;
	}
	
	/**
	 * 获取城市信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=Constants.URL.COMMON_GETCITYLIST,method=RequestMethod.GET)
	public Object getCityList(Long privinceId){
		try {
			if(ObjectUtil.isNull(privinceId))
				return null;
			List<CityDo>  list = CityUtil.getAllCityList(privinceId);
			if(ListUtil.isNotEmpty(list)){
				return JsonUtils.toJson(list);
			}
		} catch (Exception e) {
			log.error("获取城市信息失败："+e.getMessage() ,e);
		}
		return null;
	}
	
	/**
	 * 获取区县信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=Constants.URL.COMMON_GETPRIVCELIST,method=RequestMethod.GET)
	public Object getDistractList(Long cityId){
		try {
			
			List<CityDo>  list = CityUtil.getAllCityList(cityId);
			if(ListUtil.isNotEmpty(list)){
				return JsonUtils.toJson(list);
			}
		} catch (Exception e) {
			log.error("获取区县信息失败："+e.getMessage() ,e);
		}
		return null;
	}
}
