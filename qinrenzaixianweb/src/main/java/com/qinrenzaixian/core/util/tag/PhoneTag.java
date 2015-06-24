package com.qinrenzaixian.core.util.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.StringUtil;

/**
 * 性别标签
 * @author yrj
 */
public class PhoneTag extends TagSupport {
	private static Logger log = Logger.getLogger(PhoneTag.class);
    private static final long serialVersionUID = -8425219535807249284L;
    private String zone;
    private String phone;
    private String extral;
    
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExtral() {
		return extral;
	}

	public void setExtral(String extral) {
		this.extral = extral;
	}

	/** 
     * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
     */
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        String str ="";
        try {
           if(StringUtil.isNotBlank(zone) && StringUtil.isNotBlank(phone)&& StringUtil.isNotBlank(extral)){
        	   str+=zone+"-"+phone+"-"+extral;
           }else if(StringUtil.isNotBlank(zone) && StringUtil.isNotBlank(phone)){
        	   str+=zone+"-"+phone;
           }else if(StringUtil.isNotBlank(phone)){
        	   str+=phone;
           }
           out.print(str);
		} catch (Exception e) {
			log.error(e.getMessage() , e);
		}
        return super.doEndTag();
    }

}
