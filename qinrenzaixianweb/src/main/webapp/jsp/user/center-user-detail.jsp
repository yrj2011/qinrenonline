<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/common.inc"%>

<c:set var="title" value="完善个人信息" />
<c:set var="formMethod" value="post" />
<c:set var="formAction" value="${ctx }/user/info-detail.shtml" />

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
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../user/center-nav.jsp" />
<div class="b_content">
<div class="b_inner h1800">
<div class="container">
      <div class="form-group" style="border:0;">
			 <form:form id="infodetailForm" class="infodetailForm" commandName="userinfo" method="${formMethod }" action="${formAction }">
	                <div class="form">
	                    <div class="item">
	                        <div class="item_subinfo fl" >
	                            <span class="label"><b class="ftx04">*</b>登录名</span>
	                            <div class="fl">
	                                <form:input path="name"    class="form-control fl" style="width: 265px;" />
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl">
	                            <span class="label"><b class="ftx04">*</b>密码</span>
	                            <div class="fl">
	                                <form:password  path="password"   class="form-control fl" style="width: 265px;" />
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                       
	                        <div class="item_subinfo fl btn_list">
	                            <a href="javascript:void(0);" id="userinfodetail" class="btn btn-primary" >保存</a>
	                        </div>
	                    </div>
	                </div>
	           </form:form>	
      </div>
</div>
</div>
</div>
<script src="${ctx}/js/user/userinfodetail.js"></script>
</body>
</html>
