<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="b_nav">
        <!-- Contenedor -->
        <ul id="accordion" class="accordion">
            <li subIndex="0">
                <div class="link">藏品管理<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="0">
                    <li><a href="${ctx }/auction/add"><span>新增藏品</span></a></li>
                    <li><a href="${ctx }/auction?status=4"><span>在售藏品</span></a></li>
                    <li><a href="${ctx }/auction?status=0"><span style="border:0;">待售藏品</span></a></li>
                </ul>
            </li>
            <li subIndex="1">
                <div class="link">专场管理<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="1">
                    <li><a href="${ctx }/album/add"><span>新增专场</span></a></li>
                    <li><a href="${ctx }/album?status=1"><span style="border:0;">我的专场</span></a></li>
                </ul>
            </li>
            <li subIndex="2">
                <div class="link">交易管理<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="2">
                    <li><a href="${ctx }/trade"><span style="border:0;">我的交易</span></a></li>
                </ul>
            </li>
            <li subIndex="3"><div class="link">配送管理<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="3">
                    <li><a href="${ctx }/logistics/company"><span>物流公司</span></a></li>
                    <li><a href="${ctx }/logistics/address"><span>地址管理</span></a></li>
                    <li><a href="${ctx }/logistics/template"><span style="border:0;">运费模板</span></a></li>
                </ul>
            </li>
            <li subIndex="4"><div class="link">财务管理<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="4">
                    <li><a href="${ctx }/balance/account"><span>账户余额</span></a></li>
                    <li><a href="${ctx }/balance/settlementDatail"><span>结算明细</span></a></li>
                    <li><a href="${ctx }/balance/commission"><span>佣金对账</span></a></li>
                    <li><a href="${ctx }/balance/bond"><span style="border:0;">保证金</span></a></li>
                </ul>
            </li>
            <li subIndex="5"><div class="link">商家设置<i class="fa-chevron-down"></i></div>
                <ul class="submenu" subIndex="5">
                    <li><a href="${ctx }/merchant/info"><span>商家信息</span></a></li>
                    <%-- <li><a href="${ctx }/account/list"><span>子账号管理</span></a></li> --%>
                    <li><a href="${ctx }/account/safe?type=0"><span style="border:0;">账户安全</span></a></li>
                </ul>
            </li>
        </ul>
    </div>
   