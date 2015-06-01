<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!-- 强制 360 浏览器 使用webkit 急速内核  -->
<meta name="renderer" content="webkit">
<!-- 强制 IE chrome safari 等浏览器 使用最新的文档模式  -->
<meta http-equiv="X-UA-Compatible" content="IE=edge|chrome=1">
<!--<meta name="viewport" content="width=device-width, initial-scale=1">-->
<meta name="viewport" content="width=1000,user-scalable=1" />
<!-- Loading Bootstrap -->
<link href="${ctx}/js/plugin/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Loading 表单美化 CSS -->
<link href="${ctx}/js/plugin/bootstrap/plugin/validform/jqtransform.css" rel="stylesheet">
<link href="${ctx}/js/plugin/bootstrap/plugin/validform/style.css" rel="stylesheet">
<!-- Loading normalize -->
<link href="${ctx}/css/normalize.css" rel="stylesheet">
<!-- Loading checkbox  radiobutton css -->
<link href="${ctx}/js/plugin/bootstrap/plugin/icheck/skins/flat/_all.css" rel="stylesheet">
<!-- Loading tap选项卡CSS -->
<link href="${ctx}/js/plugin/bootstrap/plugin/tap/css/tap1.css" rel="stylesheet">
<!-- Loading 弹出层 dialog CSS -->
<link href="${ctx}/js/plugin/bootstrap/plugin/dialog/css/dialog.css" rel="stylesheet">
<!-- script -->
<script src="${ctx}/js/plugin/bootstrap/plugin/icheck/icheck.js"></script>
<script src="${ctx}/js/plugin/bootstrap/plugin/switch/jquery-jtumbler-1.0.1.min.js"></script>
<script src="${ctx}/js/plugin/bootstrap/plugin/validform/Validform_v5.3.2.js"></script>
<script src="${ctx}/js/plugin/bootstrap/plugin/dialog/moaModal.minified.js"></script>
<script src="${ctx}/js/plugin/bootstrap/plugin/dialog/Sweefty.js"></script>
<script src="${ctx}/js/plugin/bootstrap/plugin/hoverex/jquery.hoverex.js"></script>
<script src="${ctx}/js/common/common.js"></script>
<script src="${ctx}/js/common/ajaxfileupload.js"></script>
