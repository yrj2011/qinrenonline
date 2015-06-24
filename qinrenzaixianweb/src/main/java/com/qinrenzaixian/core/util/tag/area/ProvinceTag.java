package com.qinrenzaixian.core.util.tag.area;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.qinrenzaixian.core.util.ActionUtil;
import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.ObjectUtil;
import com.qinrenzaixian.core.util.StringUtil;
import com.qinrenzaixian.web.domain.CityDo;
import com.qinrenzaixian.web.util.CityUtil;

/**
 * 省级 下拉框
 * @author yrj
 * @date 2015-06-23 
 */
@SuppressWarnings("unchecked")
public class ProvinceTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	/**
	 * 标签唯一标识
	 */
	private String id;
	/**
	 * 标签name属性值
	 */
	private String name;
	/**
	 * 下级选择标签ID
	 */
	private String subId; 
	/**
	 * css 样式类
	 */
	private String className;
	/**
	 * 属性值
	 */
	private String attr;
	/**
	 * 值
	 */
	private Long value;
	private String defaultValue = "";
	private String defaultText = "请选择";
	
	
	@Override
	public int doStartTag() throws JspException {
		//输出的html
		StringBuffer html = new StringBuffer();
		
		List<CityDo> provs = CityUtil.getAllPrivinceList();
		
		try {
			html.append("<select onChange=\"handleTagChange"+this.getId()+"('"+this.getSubId()+"')\" id='"+ this.getId() +"' name='"+this.getName()+"'");
			if(StringUtil.isNotBlank(this.getClassName())){
				html.append(" class='"+this.getClassName()+"'");
			}
			if(StringUtil.isNotBlank(this.getAttr())){
				html.append("  "+ this.getAttr());
			}
			html.append(" >");
			html.append("	<option value='"+this.getDefaultValue()+"'>"+this.getDefaultText()+"</option>");
			for(CityDo prov : provs){
				
				html.append("	<option value='"+prov.getId()+"' ");
				if(ObjectUtil.isNotNull(this.getValue()) && this.getValue().equals(prov.getId())){
					html.append(" selected='selected' ");
				}
				html.append(">").append(prov.getName()).append("</option>");
			}
			html.append("</select>");
			//ajax获取市级列表
			html.append("<script type='text/javascript'>");
			html.append("	var flag"+this.getId()+" = 1;");
			html.append("	function handleTagChange"+this.getId()+"(subId){");
			html.append("		defaultSelect"+this.getSubId()+"();");
			html.append("		var id = $('#"+this.getId()+"').val();");
			html.append("		if(id==null || id==''){");
			html.append("			$('#"+this.getSubId()+"').change();");
			html.append("			return;");
			html.append("		}");
			html.append("		$.ajax({");
			html.append("			url:'"+ActionUtil.getRequest().getContextPath()+Constants.URL.COMMON_GETCITYLIST+Constants.SUFFIX+"?privinceId='+id,");
			html.append("			type:'get',");
			html.append("			success: function (data){");
			html.append("					$.each(data,function(i, item){");
			html.append("						$('#"+this.getSubId()+"').append('<option value='+item.id+'>'+item.name+'</option>');");
			html.append("					});");
			html.append("					if(flag"+this.getId()+" == 1){");
			html.append("						firstSelected"+this.getSubId()+"();");
			html.append("						flag"+this.getId()+"=0;");
			html.append("					}else{");
			html.append("						$('#"+this.getSubId()+"').change();");
			html.append("					}");
			html.append("				}");
			html.append("		});");
			html.append("	}");
			html.append("	$(function(){$('#"+this.getId()+"').change();});");
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
		this.name=id;
		this.id = id.replace(".", "");
	}


	public String getSubId() {
		return subId;
	}


	public void setSubId(String subId) {
		this.subId = subId.replace(".", "");
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getValue() {
		return value;
	}


	public void setValue(Long value) {
		this.value = value;
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

}
