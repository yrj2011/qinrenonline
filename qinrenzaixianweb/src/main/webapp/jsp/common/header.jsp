<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<link rel="shortcut icon" href="${ctx}/images/logo/favicon.ico" mce_href="${ctx}/images/logo/favicon.ico" type="image/x-icon">
<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${ctx}/js/plugin/jquery.placeholder.1.3.js"></script>
<script type="text/javascript">
</script>
<style>
  .level-1 .current !important{
  	width:56px;
  }
</style>
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<script type="text/javascript" src="/js/plugin/DD_belatedPNG.js" ></script>
<script type="text/javascript">
DD_belatedPNG.fix('.seered,.laok img,.seegray,.mBanner img,.div_image div,.png_bg,.weibo,.weixin.xlMenuCon,.copyright img,.div_arrow,.rslides_nav,#footer_index img,.pic_hshow_list,.head_notic_icon,.radio,.yincang .show1 img,.yincang .hide1 img,.show,.radio');
</script>
<![endif]-->
<div id="header">
	<div class="w1000 center">
		<div class="logo pt20 pl15">
		<a href="${ctx}" class="a_logo block f_L" title="亲人在线" style="width:160px;"><h1 class="h1_logo">亲人在线</h1></a>
		</div>
		<div class="head_search pt23 pl30">
			<form action="/search/" method="get" id="searchForm">
				<input type="text" id="keyword"  class="txt"  name="keyword" placeholder="姓名、性别、年龄、家乡" maxlength="60" value=""/>
				<a class="btn search_btn"></a>
			</form>
		</div>
		
			<div class="head_info pt23">
				
				<c:if test="${ sessionScope.QINRENZAIXIAN_WEBLOGIN_KEY == null}">
					<div class="input_logout">
						<a href="${ctx}/user/login.shtml" class="fff">登录
						</a>
					</div>
					<div class="input_logout">
						<a href="${ctx}/user/regist.shtml" class="fff">注册
						</a>
					</div>
				</c:if>
				<c:if test="${ sessionScope.QINRENZAIXIAN_WEBLOGIN_KEY != null}">
				    <div class="input_account">
						<div class="current">
							${sessionScope.QINRENZAIXIAN_WEBLOGIN_KEY.name}
						</div>
					</div>
					<div class="input_logout">
						<a href="${ctx}/user/info.shtml" class="fff" style="">个人中心
						</a>
					</div>
					<div class="input_logout">
						<a href="${ctx}/user/logout.shtml" class="fff">注销
						</a>
					</div>
					
				</c:if>
			</div>
	</div>
</div>
<style>
<!--
   .xlMenuList .t_ul10{left:0px;}
   .xlMenuList .ul10{left:0px;}
-->
</style>
