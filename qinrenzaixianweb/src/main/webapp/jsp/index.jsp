<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<title>亲人在线</title>
<meta charset="utf-8">
<meta name="keywords" content="亲人在线">
<meta name="description" content="亲人在线">
<meta name="baidu-site-verification" content="UJkW9FERytLjG1vp" />
<meta property="qc:admins" content="1576274347620177641656375" /> 
<link rel="stylesheet" href="${ctx}/css/base.css"/>
<link rel="stylesheet" href="${ctx}/css/header.css"/>
<link rel="stylesheet" href="${ctx}/css/index.css"/>

<style>
    .subject-list {
        width: 330px;
        height: 330px;
        background:url(images/index/index_date_zhaoonline_20130325.jpg) no-repeat;
    }
    .subject-list h2 {
        padding: 8px;
    }
    .subject-list-inner{
        width: 100%;
        height: 290px;
        overflow:hidden;
    }
    .jspTrack,.jspVerticalBar{
        background: transparent;
    }
    .jspDrag{
        width: 10px;
        background: #000;
        filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=50);
        opacity: 0.5;
    }
    .subject-list-inner:focus{
        outline: none;
    }
    .subject-list ul{
        padding-left: 10px;
        width: 300px;
        overflow: hidden;
    }
    .subject-list li{
        white-space: nowrap;
        overflow: hidden;
        -ms-text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
        text-overflow: ellipsis;
    }
    .subject-list a {
        font-size: 14px;
        font-weight: bold;
        height: 30px;
        line-height: 30px;
    }
    .jspVerticalBar ,.jspVerticalBar .jspArrow{
        width: 12px;
    }
    #block{ width:1000px; position:relative; margin:0px auto; display:none; height:520px;}
    #block #block_del{top:0px; right:0px; bottom:-20px; position:absolute; background-color:#000; width:40px; height:40px; cursor:pointer}
</style>
<!-- <script>
$(document).ready(function() {
    $("#banner").css("margin-top","0px");
    $("#banner-a").css("padding-bottom","0px");
    $("#block").slideDown("slow");
    var timeout;
    timeout=setTimeout(function(){
        $("#block").slideUp("slow");
        $("#banner").css("margin-top","20px");
        $("#banner-a").css("padding-bottom","20px")},10000
    );
    $("#block_del").click(function(){
        $("#block").remove();
        $("#banner").css("margin-top","20px");
        $("#banner-a").css("padding-bottom","20px");
    });
});
</script>
 -->
<script>
    $(document).ready(function(){
        $('.subject-list-inner').jScrollPane();
    });
</script>
</head>

<body>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>
<jsp:include page="/jsp/common/nav.jsp"></jsp:include>
<div class="pb30" id="bg-container h820" style="padding-bottom:30px;min-width:1000px;">
    <div class="w1000 center h820" >
    <div class="w980 center indexCon h820" >
        <div class="clear h10"></div>
        <div class="index_title">亲人寻子 </div>
        <div class="advertise">
            <div class="f_L"><a href=""><img src="../images/koala.jpg" width="280"/></a></div>
            <div class="f_L content_view">
                <dl class="dl_box">
                    <dd class="dd_bodys pl10">
                        <ul>
                           <li class="toolong w190"><span class="lable1">姓名:</span>admin</li>
                           <li class="toolong w190"><span class="lable1">生日:</span>1990年01月10日</li>
                            <li class="toolong w190"><span class="lable1">性别:</span>男</li>
                           <li class="xinxin w190 h38"><span class="lable1">丢失地点:</span>上海 徐汇区 虹桥镇 红梅路1000号</li>
                           <li class="xinxin w190 h110"><span class="lable1">特征描述:</span>红头发 升高1米6 阿斯顿发送到发顿发送到发送到发送到发送到发送顿发送到发送到发送到发送到发送送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到xx</li>
                        </ul>
                    </dd>
                </dl>
            </div>
            <div class="f_L shap"></div>
            <div class="f_L"><a href=""><img src="../images/koala.jpg" width="280"/></a></div>
            <div class="f_L content_view">
                <dl class="dl_box">
                    <dd class="dd_bodys pl10">
                       <ul>
                           <li class="toolong w190">姓名:admin</li>
                           <li class="toolong w190">生日:1990年01月10日</li>
                            <li class="toolong w190">性别:男</li>
                           <li class="xinxin w190 h38">丢失地点:上海 徐汇区 虹桥镇 红梅路1000号</li>
                           <li class="xinxin w190 h110">特征描述:红头发 升高1米6 阿斯顿发送到发顿发送到发送到发送到发送到发送顿发送到发送到发送到发送到发送送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到xx</li>
                        </ul>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="index_bottom_title"> 更多&gt;&gt;</div>
        <div class="clear h10"></div>
        <div class="index_title">子寻亲人 </div>
        <div class="advertise">
            <div class="f_L"><a href=""><img src="../images/koala.jpg" width="280"/></a></div>
            <div class="f_L content_view">
                <dl class="dl_box">
                    <dd class="dd_bodys pl10">
                        <ul>
                           <li class="toolong w190">姓名:admin</li>
                           <li class="toolong w190">生日:1990年01月10日</li>
                            <li class="toolong w190">性别:男</li>
                           <li class="xinxin w190 h38">丢失地点:上海 徐汇区 虹桥镇 红梅路1000号</li>
                           <li class="xinxin w190 h110">特征描述:红头发 升高1米6 阿斯顿发送到发顿发送到发送到发送到发送到发送顿发送到发送到发送到发送到发送送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到xx</li>
                        </ul>
                    </dd>
                </dl>
            </div>
            <div class="f_L shap"></div>
            <div class="f_L"><a href=""><img src="../images/koala.jpg" width="280"/></a></div>
            <div class="f_L content_view">
                <dl class="dl_box">
                    <dd class="dd_bodys pl10">
                       <ul>
                           <li class="toolong w190">姓名:admin</li>
                           <li class="toolong w190">生日:1990年01月10日</li>
                            <li class="toolong w190">性别:男</li>
                           <li class="xinxin w190 h38">丢失地点:上海 徐汇区 虹桥镇 红梅路1000号</li>
                           <li class="xinxin w190 h110">特征描述:红头发 升高1米6 阿斯顿发送到发顿发送到发送到发送到发送到发送顿发送到发送到发送到发送到发送送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到xx</li>
                        </ul>
                    </dd>
                </dl>
            </div>
        </div>
       <div class="index_bottom_title"> 更多&gt;&gt;</div>
       <div class="clear h10"></div>
        <div class="index_title">好人线索 </div>
        <div class="advertise">
            <div class="f_L"><a href=""><img src="../images/koala.jpg" width="280"/></a></div>
            <div class="f_L content_view">
                <dl class="dl_box">
                    <dd class="dd_bodys pl10">
                        <ul>
                           <li class="toolong w190">姓名:admin</li>
                           <li class="toolong w190">生日:1990年01月10日</li>
                            <li class="toolong w190">性别:男</li>
                           <li class="xinxin w190 h38">丢失地点:上海 徐汇区 虹桥镇 红梅路1000号</li>
                           <li class="xinxin w190 h110">特征描述:红头发 升高1米6 阿斯顿发送到发顿发送到发送到发送到发送到发送顿发送到发送到发送到发送到发送送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到xx</li>
                        </ul>
                    </dd>
                </dl>
            </div>
            <div class="f_L shap"></div>
            <div class="f_L"><a href=""><img src="../images/koala.jpg" width="280"/></a></div>
            <div class="f_L content_view">
                <dl class="dl_box">
                    <dd class="dd_bodys pl10">
                       <ul>
                           <li class="toolong w190">姓名:admin</li>
                           <li class="toolong w190">生日:1990年01月10日</li>
                            <li class="toolong w190">性别:男</li>
                           <li class="xinxin w190 h38">丢失地点:上海 徐汇区 虹桥镇 红梅路1000号</li>
                           <li class="xinxin w190 h110">特征描述:红头发 升高1米6 阿斯顿发送到发顿发送到发送到发送到发送到发送顿发送到发送到发送到发送到发送送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到阿斯顿发送到发送到发送到发送到发送到xx</li>
                        </ul>
                    </dd>
                </dl>
            </div>
            <div class="index_bottom_title"> 更多&gt;&gt;</div>
        </div>
         
    </div>
</div>
</div>
<script type="text/javascript">
window.name="index";
$(function(){
    $("#pop_forget").ZForm();
    var view = $.cookie('Z_YAAN');
    var random = [];
    if(view == null){
        random = [$("#defaultBanner").val()];
        $.cookie('Z_YAAN','1',{'max-age':60*10})
    } else {
        random = $("#randomBanners").val() == '' ? [$("#defaultBanner").val()] : $("#randomBanners").val().split('#');
    }
    if(random.length > 0) {
        var x = random.length;    
        var rand = parseInt(Math.random() * x + 1);
        var theme= random[rand-1].split(','); 
        //$("#bg-container").css('backgroundImage', 'url('+theme[2]+')');
        $("#bg-container").attr('style',"background:url('"+theme[2]+"') no-repeat scroll center 0 #1F5063;padding-bottom:85px;min-width:1000px")
        $("#banner").attr('src', theme[1]);
        $("#banner-a").attr('href', theme[0]);
    }
})
</script>
<%@include file="/jsp/common/footer.jsp" %>
</body>
</html>