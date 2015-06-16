package com.qinrenzaixian.core.util.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.qinrenzaixian.core.util.Constans;
import com.qinrenzaixian.core.util.StringUtil;

/**
 * 性别标签
 * @author yrj
 */
public class SexTag extends TagSupport {
	private static Logger log = Logger.getLogger(SexTag.class);
    private static final long serialVersionUID = -8425219535807249284L;
    private String sex;
    
    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/** 
     * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
     */
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
        	if(StringUtil.hasLength(sex) && Constans.MAN.equals(sex)) {
           	 out.print("男");
           }else{
           	 out.print("女");
           }
		} catch (Exception e) {
			log.error(e.getMessage() , e);
		}
        return super.doEndTag();
    }

}
