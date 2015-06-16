<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.inc"%>
<c:set var="title" value="用户注册" />
<c:set var="formMethod" value="post" />
<c:set var="formAction" value="${ctx }/user/regist.shtml" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" href="${ctx}/css/base.css"/>
<link rel="stylesheet" href="${ctx}/css/header.css"/>
<link rel="stylesheet" href="${ctx}/css/common.css"/>
<link href="${ctx}/js/plugin/bootstrap/plugin/hoverex/css/hoverex-all.css" rel="stylesheet">
<link href="${ctx}/js/plugin/bootstrap/plugin/hoverex/css/templates.css" rel="stylesheet">
<link href="${ctx}/css/user/regist.css" rel="stylesheet">
<link href="${ctx}/css/normalize.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
<jsp:include page="/jsp/common/header-ref.jsp"></jsp:include>

<div id="bg-container " style="min-width:1000px;">
    <div class="w1000 center " >
      <div class="h2 center">${title}</div>
      <div class="w980 center indexCon regist-center" >
            <div class="form-group">
                <form:form id="registForm" class="registeform" commandName="userinfo" method="${formMethod }" action="${formAction }">
	                <div class="form">
	                    <div class="item">
	                        <div class="item_subinfo fl" >
	                            <span class="label">登录名<b class="ftx04">*</b></span>
	                            <div class="fl">
	                                <form:input path="name" placeholder="请输入登录名" ajaxurl="${ctx}/user/validateName.shtml" class="form-control fl" style="width: 265px;" datatype="*1-20" errormsg="登录名最大长度20位" nullmsg="请输入登录名"/>
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl">
	                            <span class="label">密码<b class="ftx04">*</b></span>
	                            <div class="fl">
	                                <form:password  path="password" placeholder="请输密码" class="form-control fl" style="width: 265px;" datatype="*6-20,zuhe" errormsg="6~20位字符，支持字母、数字和符号的组合" nullmsg="请输入密码"/>
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl">
	                            <span class="label"><b class="ftx04">*</b>重复密码</span>
	                            <div class="fl">
	                                <input  type="password" id="repassword" recheck="password" placeholder="请输再次密码" class="form-control fl" style="width: 265px;" datatype="*1-20" errormsg="2次输入密码不一致，请重新输入" nullmsg="请输入重复密码"/>
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl btn_list">
	                            <a href="javascript:void(0);" id="registuser" class="btn btn-primary" >保存</a>
	                        </div>
	                    </div>
	                </div>
	            </form:form>
            </div>
        </div>
    </div>
</div>
<%@include file="/jsp/common/footer.jsp" %>
</body>
<script src="${ctx}/js/user/regist.js"></script>
</html>