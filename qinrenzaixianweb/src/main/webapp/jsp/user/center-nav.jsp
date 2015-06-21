<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.qinrenzaixian.core.util.Constants" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="b_nav">
        <!-- Contenedor -->
        <ul id="accordion" class="accordion">
            <li subIndex="0">
                <div class="link">个人信息<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="0">
                    <li><a href="${ctx }<%=Constants.URL.USER_CENTER%>.shtml"><span>基本信息</span></a></li>
                    <li><a href="${ctx }<%=Constants.URL.USER_ADDRESSLIST%>.shtml"><span class="nobb">联系地址</span></a></li>
                </ul>
            </li>
            <li subIndex="1">
                <div class="link">父母寻子<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="1">
                    <li><a href="${ctx }/album/add"><span>我的消息</span></a></li>
                    <li><a href="${ctx }/album?status=1"><span class="nobb">我的回复</span></a></li>
                </ul>
            </li>
            <li subIndex="2">
                <div class="link">子寻父母<i class="fa-chevron-down"></i></div>
                 <ul class="submenu" subIndex="2">
                    <li><a href="${ctx }/album/add"><span>我的消息</span></a></li>
                    <li><a href="${ctx }/album?status=1"><span class="nobb">我的回复</span></a></li>
                </ul>
            </li>
            <li subIndex="3"><div class="link">好人线索<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="3">
                    <li><a href="${ctx }/album/add"><span>我的消息</span></a></li>
                    <li><a href="${ctx }/album?status=1"><span class="nobb">我的回复</span></a></li>
                </ul>
            </li>
        </ul>
    </div>
   