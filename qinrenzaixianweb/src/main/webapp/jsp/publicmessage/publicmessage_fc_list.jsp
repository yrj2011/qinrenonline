<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/common.inc"%>
<c:set var="title" value="寻子信息" />
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
<jsp:include page="../user/center-nav.jsp" />
<div class="b_content">
<div class="b_inner h1000">
<div class="container">
				<div class="form pt10 pb20 hide" >
					<form id="pm_search_form" action="${ctx }/user/pmlist.shtml" method="get">
						<div class="item">
							<div class="item_subinfo fl">
								<span class="label">联系人</span>
								<div class="fl">
									<input type="text" class="form-control" name="contact"
										value="${pmPage.contact }" placeholder="请输入联系人">
								</div>
								<span class="label">手机</span>
								<div class="fl">
									<input type="text" class="form-control" name="mobile"
										value="${pmPage.mobile }" placeholder="请输入手机">
								</div>
								<span class="label">座机</span>
		                        <div class="fl">
									<input type="text" class="form-control" name="phone"
										value="${pmPage.phone }" placeholder="请输入座机">
								</div>
							</div>
						</div>
					</form>
					<div class="item" style="border-bottom: none; padding-bottom: 0px;">
						<div class="item_subinfo fl btn_list">
							<a href="javascript:void(0)" id="pm_search_btn" class="btn btn-block btn-lg btn-main"
								style="margin-left: 305px;">查询</a> 
							<a href="javascript:void(0)" id="pm_search_reset" class="btn btn-block btn-lg btn-invice"
								style="width: 65px;">重置</a>
						</div>
					</div>
				</div>
				<div class="investment_f">
					<div class="investment_con">
						<div class="investment_con_list" style="display: block;">
						   <div style="width:200px;height:29px;">
						     <a href="${ctx }/user/pmedit.shtml" target="_blank" class="btn btn-block btn-lg btn-main"
								style="margin-left: 0px;">新增</a> 
						   </div>
						   
							<div class="item" style="border-bottom: none;">
								<table border=1>
		                            <tr class="table_title">
		                                <th class="tl">编号</th>
		                                <th class="tl">姓名</th>
		                                <th class="tl">性别</th>
		                                <th class="tl">出身日期</th>
		                                <th class="tl">年龄</th>
		                                <th class="tl">丢失地址</th>
		                                <th class="tl">特征描述</th>
		                                <th class="tl">创建时间</th>
		                                <th class="tl" style="text-align:center">操作</th>
		                            </tr>
									<c:if test="${pmPage != null }">
										<c:forEach var="pm" items="${pmPage.list }">
											<tr class="table_content">
												<td style="width:150px;"><span class="c_qiye toolong">${pm.id }</span></td>
												<td style="width:150px;">${pm.contact}</td>
												<td style="width:150px;">${pm.mobilePhone}</td>
												<td style="width:150px;"><q:phone zone="${pm.zone }" extral="${pm.extNumber }" phone="${pm.phoneNumber }"/></td>
												<td style="width:150px;">
												
												<q:pm pm="${pm.pm}" province="${pm.provinceId}" city="${pm.cityId}" district="${pm.districtId}"/>
												</td>
												<td style="width:150px;">${pm.zipCode}</td>
												<td style="width:120px;">
													<a class="blue" href="${ctx }/user/pmedit.shtml?id=${pm.id }" >修改</a>&nbsp;&nbsp; 
													<a  class="blue" href="${ctx }/user/pmdel.shtml?id=${pm.id }" >删除</a>			
                                                </td>
											</tr>
										</c:forEach>
										<tr>
										 
											<td colspan="6"><q:page  page="${pmPage}" /></td>
										</tr>
									</c:if>
								</table>
							</div>
						</div>
					</div>
				</div>
</div>
</div>
</div>
<script src="${ctx}/js/common/common.js"></script>
<script>
 	 $(function(){
 		formReset("#pm_search_reset", "#pm_search_form");
 		fromSubmit("#pm_search_btn", "#pm_search_form");
 	 });
</script>
</body>
</html>
