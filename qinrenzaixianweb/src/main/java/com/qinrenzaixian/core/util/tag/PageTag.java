package com.qinrenzaixian.core.util.tag;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.StringUtil;
import com.qinrenzaixian.web.domain.BaseDo;
import com.qinrenzaixian.web.vo.pagination.Pagination;

/**
 * 分页标签
 * @author yrj
 * @date 2015-06-21 
 */
public class PageTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	/**
	 * 分页参数
	 */
	Pagination  page = null;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int doStartTag() throws JspException {
		if(page == null){
			return SKIP_BODY;
		}
		String uuid = StringUtil.getUUID();
		//输出的html
		StringBuffer html = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();  
		String action = (String)request.getAttribute(Constants.JAVAX_SERVLET_FORWARD_REQUEST_URI);
		html.append("<form id='pageForm"+uuid+"' action='"+action+"' method='"+request.getMethod()+"'>");
		html.append("	<input type='hidden' id='page' name='page' value='1' />");

        Enumeration<String> enumeration = request.getParameterNames();
        //请求参数
		while(enumeration.hasMoreElements()){
			String key = enumeration.nextElement();
			if(key.equals("page") || key.equals("perPage")){
				continue;
			}
			String value = request.getParameter(key);
			html.append("	<input type='hidden' id='"+key+"' name='"+key+"' value='"+value+"' />");
		}
		
		//分页标签view
		html.append("<div class='pagefy' style='text-align:center;height:40px;line-height:40px;'>");
		html.append("   <span class='pagerecord'>每页显示 <select id='perPage' name='perPage' onchange=changePageSize"+uuid+"()><option value='25'>25</option><option value='50'>50</option><option value='100'>100</option></select> 条记录</span>");
		html.append("	<span style='width:100px'><a class='no_classa_decoration' href='javascript:submitPage"+uuid+"(\""+1+"\");'>第一页</a></span>");
		html.append("	<span style='width:100px'><a class='no_classa_decoration' href='javascript:submitPage"+uuid+"(\""+this.page.getPrevPage()+"\");'>上一页</a>&nbsp;&nbsp;&nbsp;</span>");
		for(int i = 1; i <= this.page.getTotalPage(); i++){
			if(i == this.page.getPage()){
				html.append("<span class='currentPagefy'>"+i+"</span>");
				continue;
			}
			html.append("	<span class='commonPagefy' ><a href='javascript:submitPage"+uuid+"(\""+i+"\");'>"+i+"</a></span>");
		}
		if(this.page.getTotalPage() < 1){
			html.append("	<span class='commonPagefy' ><a href='javascript:submitPage"+1+"(\""+1+"\");'>"+1+"</a></span>");
		}
		html.append("	<span ><a class='no_classa_decoration' href='javascript:submitPage"+uuid+"(\""+(this.page.getNextPage())+"\");'>下一页</a></span>");
		html.append("	<span ><a class='no_classa_decoration' href='javascript:submitPage"+uuid+"(\""+this.page.getTotalPage()+"\");'>最后一页</a></span>");
		html.append("   <span class='pageTotalRecord' style='width:100px'>共 "+this.page.getTotalCount()+" 条记录</span>");
		html.append("</div>");
		
		html.append("</form>");
		
		html.append("<script type='text/javascript'>");
		html.append("	function submitPage"+uuid+"(p){");
		html.append("		var pf = document.getElementById(\"pageForm"+uuid+"\");");
		html.append("		document.getElementById(\"page\").value=p;");
		html.append("		pf.submit();");
		html.append("	}");
		html.append("	function changePageSize"+uuid+"(p){");
		html.append("		var pf = document.getElementById(\"pageForm"+uuid+"\");");
		html.append("		pf.submit();");
		html.append("	}");
		html.append("</script>");		
		try {
			//输出分页标签
			pageContext.getOut().print(html.toString());
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		
		return SKIP_BODY;
	}

	public Pagination getPage() {
		return page;
	}

	public void setPage(Pagination page) {
		this.page = page;
	}

	
}
