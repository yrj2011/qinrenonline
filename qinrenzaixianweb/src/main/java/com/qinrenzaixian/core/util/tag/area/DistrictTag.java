package com.qinrenzaixian.core.util.tag.area;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.qinrenzaixian.core.util.StringUtil;

/**
 * 区信息
 * @author yrj
 * @date 2015-06-23 
 */
public class DistrictTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	//字段,从userInfo里取字段
	private String id;
	private String name;
	private String className;
	private String attr;
	private String value;
	private String defaultValue = "";
	private String defaultText = "请选择";
	
	
	
	@Override
	public int doStartTag() throws JspException {
		//输出的html
		StringBuffer html = new StringBuffer();
		try {
			html.append("<select id='"+ this.getId() +"' name='"+this.getName()+"'");
			if(StringUtil.isNotBlank(this.getClassName())){
				html.append(" class='"+this.getClassName()+"'");
			}
			if(StringUtil.isNotBlank(this.getAttr())){
				html.append("  "+ this.getAttr());
			}
			html.append(">");
			html.append("<option value='"+this.getDefaultValue()+"'>"+this.getDefaultText()+"</option>");
			html.append("</select>");
			html.append("<script type='text/javascript'>");
			html.append("	function firstSelected"+this.getId()+"(){");
			if(StringUtil.isNotBlank(this.getValue())){
				html.append("		$('#"+this.getId()+"').find('option[value=\""+this.getValue()+"\"]').attr('selected','selected');");
			}
			html.append("	}");
			html.append("	function defaultSelect"+this.getId()+"(){");
			html.append("		$('#"+this.getId()+"').empty();");
			html.append("		$('#"+this.getId()+"').append('<option value=\""+this.getDefaultValue()+"\">"+this.getDefaultText()+"</option>');");
			html.append("	}");
			html.append("</script>");
			
			//输出分页标签
			pageContext.getOut().print(html.toString());
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.name = id;
		this.id = id.replace(".", "");
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getAttr() {
		return attr;
	}


	public void setAttr(String attr) {
		this.attr = attr;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getName() {
		return name;
	}


	public String getDefaultValue() {
		return defaultValue;
	}


	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}


	public String getDefaultText() {
		return defaultText;
	}


	public void setDefaultText(String defaultText) {
		this.defaultText = defaultText;
	}


	public void setName(String name) {
		this.name = name;
	}

}
