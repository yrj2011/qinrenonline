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
				<div class="input_account">
					<div class="current">
						admin
					</div>
				</div>
				<div class="input_center has_sup">
					<a href="/user/userInfoIndex.shtml">用户中心
					</a>
                    <sup>
                        99+
					</sup>
                	<ul class="info_sub png_bg pr5 pb16">
	                    	<li><a href="/user/buyer/watching.shtml?condition.source=jinpai" target="_blank">a1</sup></a></li>
	                    	<li><a href="/user/buyer/bid.shtml" target="_blank">a2 <sup>sub2</sup></a></li>
	                    	<li><a href="/user/message/message.shtml" target="message">a3<sup>sub3</sup></a></li>
	                    	<li><a href="/user/unpaid.shtml" target="unpaid">a4<sup>sub4</sup></a></li>
	                    	<li><a href="/user/my-auction-list.shtml" target="_blank">a5  <sup>sub5</sup></a></li>
	                    	<li><a href="/user/not-yet-deliver.shtml" target="delivery">a6  <sup>sub6</sup></a></li>

                	</ul>
				</div>
				<div class="input_logout">
					<a href="/logout.shtml" class="fff">登出
					</a>
				</div>
				<div class="input_logout">
					<a href="${ctx}/user/regist.shtml" class="fff">注册
					</a>
				</div>
				<div class="help">
					<a href="/help/162.htm">帮助
					</a>
				</div>
			</div>
	</div>
</div>
<style>
<!--
   .xlMenuList .t_ul10{left:0px;}
   .xlMenuList .ul10{left:0px;}
-->
</style>
