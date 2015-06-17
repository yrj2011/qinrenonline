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
   	<link href="${ctx}/css/user/regist.css" rel="stylesheet">
    <style>
    .table_content input{border:0; height:100%;}
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<jsp:include page="/jsp/common/header-ref-form.jsp"/>
<jsp:include page="../user/center-nav.jsp" />
<div class="b_content">
<div class="b_inner h1800">
<div class="container">
      <div class="form-group" style="border:0;">
			 <form:form id="infodetailForm" class="infodetailForm" commandName="userinfo" method="${formMethod }" action="${formAction }">
	                <div class="form">
	                    <div class="item">
	                        <div class="item_subinfo fl" >
	                            <span class="label">登录名</span>
	                            <div class="fl">
	                                ${userinfo.name }
	                                <form:hidden path="name"    class="form-control fl" style="width: 265px;" />
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">姓名</span>
	                            <div class="fl">
	                                <form:input path="realName" class="form-control fl" style="width: 265px;"/>
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">性别</span>
	                            <div class="fl">
	                                <select class="select-main category fl " id="category_1" style="display:block;" >
			                        	<option value="0"  class="select-option">男</option>
			                        	<option value="1"  >女</option>
			                        </select>
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                       
	                         <div class="item_subinfo fl" >
	                            <span class="label">生日</span>
	                            <div class="fl">
	                                <input name="birthday" value="<fmt:formatDate  value="${userinfo.birthday}"  pattern="yyyy-MM-dd" />" class="Wdate Wdate2 form-control" style="float:left; width:265px;" type="text" id="birthday" name="birthday" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd'})"/>
	                                <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">个人图片</span>
	                             <div class="fl">
	                                <a href="javascript:void(0);" id="picture_a" class="btn btn-block btn-lg btn-main" style="width: 120px;">上传图片</a>
	                                <form:hidden path="picture"  class="sctp" nullmsg="请上传图片" />
	                                <div class="Validform_checktip fl"  id="sctptip"></div>
	                            </div>
	                            <div class="fl ">
	                                <a href="javascript:void(0);" class="btn btn-block btn-lg btn-tip-box" style="margin-left:20px;width: 120px;">大小不超过2M</a>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl picturePreview" style="display:none;">
	                            <span class="label"> </span>
	                            <div class="fl">
	                                <img id="picturePicImg"  class="showimg_box fl" style="width:200px; height:200px;" >
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">身份证</span>
	                            <div class="fl">
	                                 <form:input path="identity"    class="form-control fl" style="width: 265px;" datatype="sfz" />
	                                 <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">身份证图片</span>
	                             <div class="fl">
	                                <a href="javascript:void(0);" id="identitypic_a" class="btn btn-block btn-lg btn-main" style="width: 120px;">上传图片</a>
	                                <form:hidden path="identitypic" class="sctp" nullmsg="请上传图片" />
	                                <div class="Validform_checktip fl"  id="sctptip"></div>
	                            </div>
	                            <div class="fl ">
	                                <a href="javascript:void(0);" class="btn btn-block btn-lg btn-tip-box" style="margin-left:20px;width: 120px;">大小不超过2M</a>
	                            </div>
	                        </div>
	                         <div class="item_subinfo fl identitypicPreview" style="display:none;">
	                            <span class="label"> </span>
	                            <div class="fl">
	                                <img id="identitypicPicImg"  class="showimg_box fl" style="width:200px; height:200px;" >
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">电子邮箱</span>
	                            <div class="fl">
	                                 <form:input path="email"    datatype="empty|e" errormsg="邮箱格式不正确！" class="form-control fl" style="width: 265px;" />
	                                 <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">手机</span>
	                            <div class="fl">
	                                 <form:input path="mobile"  datatype="empty|m" errormsg="手机号码格式不正确！"  class="form-control fl" style="width: 265px;" />
	                                 <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">座机</span>
	                            <div class="fl">
	                                 <form:input path="telephone"   datatype="empty|n5-11" errormsg="座机号码格式不正确！" class="form-control fl" style="width: 265px;" />
	                                 <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">QQ</span>
	                            <div class="fl">
	                                 <form:input path="qq"    datatype="empty|n5-12" errormsg="QQ格式不正确！" class="form-control fl" style="width: 265px;" />
	                                 <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">微信</span>
	                            <div class="fl">
	                                 <form:input path="weixin"    class="form-control fl" style="width: 265px;" />
	                                 <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                        <div class="item_subinfo fl" >
	                            <span class="label">微博</span>
	                            <div class="fl">
	                                 <form:input path="weibo"    class="form-control fl" style="width: 265px;" />
	                                 <div class="Validform_checktip"></div>
	                            </div>
	                        </div>
	                         <!-- 图片上传 -->
                            <input type="file" id="uploadFile" name="uploadFile" style="display:none;"/>
                            <form:hidden path="id" />
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
