<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/common.inc"%>
<c:set var="title" value="基本信息" />
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>用户中心- ${title }</title>
    <link rel="stylesheet" href="${ctx}/css/base.css"/>
    <link rel="stylesheet" href="${ctx}/css/header.css"/>
    <link rel="stylesheet" href="${ctx}/css/common.css"/>
    <link href="${ctx}/js/plugin/bootstrap/plugin/hoverex/css/hoverex-all.css" rel="stylesheet">
    <link href="${ctx}/js/plugin/bootstrap/plugin/hoverex/css/templates.css" rel="stylesheet">
   	<link href="${ctx}/css/user/common.css" rel="stylesheet">
   	<link href="${ctx}/css/user/normalize.css" rel="stylesheet">
    <style>
    .table_content input{border:0; height:100%;}
    .label{height:40px;line-height:40px;width:90px}
    .label-txt{width:300px}
    .item{padding-left:100px}
    .item_subinfo a{display:block;margin-left:220px;color:red} 
    .item_subinfo {border-bottom:0px solid gray;margin-bottom:5px;}
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../user/center-nav.jsp" />
<div class="b_content">
<div class="b_inner h1800">
<div class="container">
    <div class="form-group" style="border:0;">
				<div class="form">
	                    <div class="item">
	                        <div class="item_subinfo " >
	                            <span class="label">登录名</span>
	                            <span class="label-txt">${userinfo.name}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">姓名</span>
	                            <span class="label-txt">${userinfo.realName}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">性别</span>
	                            <span class="label-txt"><q:sexTag sex="${userinfo.sex}"/></span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">生日</span>
	                            <span class="label-txt"><fmt:formatDate  value="${userinfo.birthday}"  pattern="yyyy-MM-dd" /></span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">个人图片</span>
	                            <span class="label-txt">
		                            <c:if test="${userinfo.picture ne null }">
		                            	<img id="picturePicImg"  class="showimg_box fl" style="width:200px; height:200px;" src="${userinfo.picture}">
		                            </c:if>
	                            </span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">身份证</span>
	                            <span class="label-txt">${userinfo.identity}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">身份证图片</span>
	                            <span class="label-txt">
	                             <c:if test="${not empty userinfo.identitypic}">
	                              	   <img id="picturePicImg"  class="showimg_box fl" style="width:200px; height:200px;" src="${userinfo.identitypic}">
	                              </c:if>
	                            </span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">电子邮箱</span>
	                            <span class="label-txt">${userinfo.email}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">手机</span>
	                            <span class="label-txt">${userinfo.mobile}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">座机</span>
	                            <span class="label-txt">${userinfo.telephone}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">QQ</span>
	                            <span class="label-txt">${userinfo.qq}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">微信</span>
	                            <span class="label-txt">${userinfo.weixin}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <span class="label">微博</span>
	                            <span class="label-txt">${userinfo.weibo}</span>
	                        </div>
	                        <div class="item_subinfo ">
	                            <a href="${ctx}/user/info-detail.shtml" target='_self'> 个人信息修改>></a>
	                        </div>
	                    </div>
	           </div>
    </div>
</div>
</div>
</div>
<script>
</script>
</body>
</html>
