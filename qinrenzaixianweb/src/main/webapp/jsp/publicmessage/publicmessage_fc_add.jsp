<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/common.inc"%>
<c:if test="${FLAG=='ADD'}">
	<c:set var="title" value="新增寻子信息" />
	<c:set var="formMethod" value="post" />
	<c:set var="formAction" value="${ctx }/user/addaddress.shtml" />
</c:if>
<c:if test="${FLAG=='UPDATE'}">
	<c:set var="title" value="编辑寻子信息" />
	<c:set var="formMethod" value="post" />
	<c:set var="formAction" value="${ctx }/user/updateaddress.shtml" />
</c:if>
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
   	<link href="${ctx}/css/grid-page.css" rel="stylesheet">
    <style>
    .table_content input{border:0; height:100%;}
    .label{height:40px;line-height:40px;width:90px}
    .label-txt{width:300px}
    .item_subinfo a{display:block;margin-left:220px;color:black} 
    .item_subinfo {border-bottom:0px solid gray;margin-bottom:5px;}
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<jsp:include page="/jsp/common/header-ref-form.jsp"/>
<jsp:include page="../user/center-nav.jsp" />
<div class="b_content">
<div class="b_inner h1000">
<div class="container">
				<div class="form pt10 pl160 pb20" >
					 <form:form id="address_form" class="address_form" commandName="pminfo" action="${formAction }" method="${formMethod }">
						<div class="item">
							<div class="item_subinfo fl">
								<span class="label">详细地址</span>
								<div class="fl">
								    <q:province subId="selcity" id="selprovince" name="provinceId" attr="datatype='*'" value="${pminfo.provinceId}" className="select-main category fl w90 "/>
									<q:city subId="seldistrict" id="selcity" name="cityId" attr="datatype='*'" value="${pminfo.cityId}" className="select-main category fl w90 "/>
								    <q:district  id="seldistrict" name="districtId" attr="datatype='*'" value="${pminfo.districtId}" className="select-main category fl w90"/>
								</div>
							</div>
							<div class="item_subinfo fl" >
	                            <span class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                            <div class="fl">
	                               <form:input path="address"   placeholder="请输入详细地址" datatype='*' nullmsg="请输入详细地址" class="form-control fl " style="width: 265px;"/>
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">邮编</span>
	                            <div class="fl">
	                                <form:input path="zipCode" placeholder="请输入邮编" class="form-control fl" datatype="empty|n6-6" style="width: 265px;" errormsg="6位数字" />
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">联系人</span>
	                            <div class="fl">
	                                <form:input path="contact" placeholder="请输入联系人" class="form-control fl" datatype="empty|*1-6" style="width: 265px;" errormsg="1至6位" />
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">手机号</span>
	                            <div class="fl">
	                                <form:input path="mobilePhone" placeholder="请输入手机号" class="form-control fl"  datatype="empty|m"  style="width: 265px;" errormsg="手机号码不正确" />
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">座机</span>
	                            <div class="fl">
	                                 <form:input path="zone" placeholder="区号" class="form-control fl"  datatype="empty|n3-5"  style="width: 60px;" errormsg="3至5位数字" />
	                                 <form:input path="phoneNumber" placeholder="请输入电话号" class="form-control fl"  datatype="empty|n6-8"  style="width: 130px;" errormsg="6至8位数字" />
	                                 <form:input path="extNumber" placeholder="分机号" class="form-control fl"  datatype="empty|n1-5"  style="width: 75px;" errormsg="1至5位数字" />
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <form:hidden path="id"/>
	                         <form:hidden path="userId"/>
						</div>
					</form:form>
					<div class="item" style="border-bottom: none; padding-bottom: 0px;">
						<div class="item_subinfo fl btn_list">
							<a href="javascript:void(0)" id="address_btn" class="btn btn-block  btn-main"
								style="margin-left: 305px;width: 65px;">保存</a> 
							<a href="javascript:void(0)" id="address_reset" class="btn btn-block  btn-main"
								style="width: 65px;">重置</a>
						</div>
					</div>
				</div>
</div>
</div>
</div>
<script src="${ctx}/js/common/common.js"></script>
<script src="${ctx}/js/user/address.js"></script>
<script>
 	 $(function(){
 		formReset("#address_reset", "#address_form");
 		// fromSubmit("#address_btn", "#address_form");
 	 });
</script>
</body>
</html>
