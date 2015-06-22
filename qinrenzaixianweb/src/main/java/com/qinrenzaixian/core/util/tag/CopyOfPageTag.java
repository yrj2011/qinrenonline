package com.qinrenzaixian.core.util.tag;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.qinrenzaixian.core.util.Constants;
import com.qinrenzaixian.core.util.StringUtil;

/**
 * 分页标签
 * @author yrj
 * @date 2015-06-21 
 */
@SuppressWarnings("unchecked")
public class CopyOfPageTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	/**
	 * 分页参数
	 */
	private int totalPage;

	private int prevPage;

	private int page;

	private int nextPage;

	private int totalCount;

	/** 
     * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
     */
    @Override
    public int doEndTag() throws JspException {
		if(totalCount < 1){
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
		html.append("	<span style='width:100px'><a class='no_classa_decoration' href='javascript:submitPage"+uuid+"(\""+this.prevPage+"\");'>上一页</a>&nbsp;&nbsp;&nbsp;</span>");
		for(int i = 1; i <= this.totalPage; i++){
			if(i == page){
				html.append("<span class='currentPagefy'>"+i+"</span>");
				continue;
			}
			html.append("	<span class='commonPagefy' ><a href='javascript:submitPage"+uuid+"(\""+i+"\");'>"+i+"</a></span>");
		}
		if(this.totalPage < 1){
			html.append("	<span class='commonPagefy' ><a href='javascript:submitPage"+1+"(\""+1+"\");'>"+1+"</a></span>");
		}
		html.append("	<span ><a class='no_classa_decoration' href='javascript:submitPage"+uuid+"(\""+this.nextPage+"\");'>下一页</a></span>");
		html.append("	<span ><a class='no_classa_decoration' href='javascript:submitPage"+uuid+"(\""+this.totalPage+"\");'>最后一页</a></span>");
		html.append("   <span class='pageTotalRecord' style='width:100px'>共 "+this.totalCount+" 条记录</span>");
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
