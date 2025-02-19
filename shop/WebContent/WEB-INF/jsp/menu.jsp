<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.existUser == null">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_loginPage.action">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_registPage.action">注册</a>|
					</li>
				</s:if>
				
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<s:property value="#session.existUser.name"/>|
					</li>
					
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="#">我的订单</a>|
					</li>
					
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_quit.action">退出</a>|
					</li>
				<s:else>
					
				</s:else>
				<li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogout" class="headerLogout">
					<a>[退出]</a>|
				</li>
						<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="./购物车.htm">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>0000/0123456789</strong>
			</div>
	</div>
	

		
		<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${pageContext.request.contextPath}/index.action">首页</a>
						|
					</li>
					<%-- <s:iterator value="#session.clist" var="c"> --%>
					<c:forEach items="${clist }" var="c">
					<li>
						<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=${c.cid }&pageCode=1">${c.cname }</a>
						|
					</li>
					</c:forEach>
				<%-- 	</s:iterator> --%>
		</ul>
	</div>
		