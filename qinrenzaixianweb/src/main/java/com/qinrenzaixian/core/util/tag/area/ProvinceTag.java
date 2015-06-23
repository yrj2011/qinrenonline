package com.qinrenzaixian.core.util.tag.area;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.qinrenzaixian.core.util.ActionUtil;
import com.qinrenzaixian.core.util.StringUtil;
import com.qinrenzaixian.core.util.json.JsonUtils;

/**
 * 省级 下拉框
 * @author yrj
 * @date 2015-06-23 
 */
@SuppressWarnings("unchecked")
public class ProvinceTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	//字段,从userInfo里取字段
	private String id;
	private String name;
	private String subId; 
	private String className;
	private String attr;
	private String value;
	private String defaultValue = "";
	private String defaultText = "请选择";
	
	
	@Override
	public int doStartTag() throws JspException {
		//输出的html
		StringBuffer html = new StringBuffer();
		
		Map<String,String> provs = MetaUtils.getProvincePair("1");
		
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
			for(Object provId : provs.keySet()){
				Map<String,String> pair = JsonUtils.fromJson(provs.get(provId), Map.class);
				html.append("	<option value='"+provId+"' ");
				if(StringUtil.isNoneBlank(this.getValue()) && provId.equals(this.getValue())){
					html.append(" selected='selected' ");
				}
				html.append(">").append(pair.get(ActionUtil.getLanguage())).append("</option>");
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
			html.append("			url:'"+ActionUtil.getRequest().getContextPath()+"/meta/cities/'+ id,");
			html.append("			type:'get',");
			html.append("			success: function (data){");
			html.append("					$.each(data,function(i, item){");
			html.append("						$('#"+this.getSubId()+"').append('<option value='+item.key+'>'+item.value+'</option>');");
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


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
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
