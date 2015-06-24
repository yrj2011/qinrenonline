package com.qinrenzaixian.core.util.tag.area;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.qinrenzaixian.core.util.ObjectUtil;
import com.qinrenzaixian.web.domain.CityDo;
import com.qinrenzaixian.web.util.CityUtil;

/**
 * 地址标签
 * @author yrj
 */
public class AddressTag extends TagSupport {
	private static Logger log = Logger.getLogger(AddressTag.class);
    private static final long serialVersionUID = -8425219535807249284L;
    private Long province;
    private Long city;
    private Long district;
    private String address;
    

	public Long getProvince() {
		return province;
	}


	public void setProvince(Long province) {
		this.province = province;
	}


	public Long getCity() {
		return city;
	}


	public void setCity(Long city) {
		this.city = city;
	}


	public Long getDistrict() {
		return district;
	}


	public void setDistrict(Long district) {
		this.district = district;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	/** 
     * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
     */
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        String str ="";
        try {
        	CityDo provinceDo = CityUtil.getCityById(province);
        	CityDo cityDo = CityUtil.getCityById(city);
        	CityDo distractDo = CityUtil.getCityById(district);
        	if(ObjectUtil.isNotNull(provinceDo) && ObjectUtil.isNotNull(provinceDo.getName())){
        		if(provinceDo.getName().equals("北京") ||provinceDo.equals("重庆") 
        		||provinceDo.equals("上海")||provinceDo.equals("天津")){
        			str+=provinceDo.getName()+"市";
        		}else{
        			str+=provinceDo.getName()+"省";
        		}
        	}
        	if(ObjectUtil.isNotNull(cityDo)){
        		if(!cityDo.equals("北京") && !cityDo.equals("重庆") 
        		&&!cityDo.equals("上海")&&!cityDo.equals("天津")){
        			str+=provinceDo.getName()+"市";
        		}
        	}
        	if(ObjectUtil.isNotNull(distractDo)){
        		str+=distractDo.getName();
        	}
        	str+=address;
       	    out.print(str);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
		}
        return super.doEndTag();
    }

}
