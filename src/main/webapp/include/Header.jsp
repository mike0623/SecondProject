<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
	
			<a href="${root}/Lobby.jsp" class="Logo">EEIT162-21-陳昱臻</a>
			
			
			<c:if test="${isLogined == true}">
			<ul class="LoginButton">
				<li><a href="${root}/ManageUserInfo.do" >帳號管理</a></li>
				<li><a href="${root}/SignOut.do" >登出</a></li>
			</ul>
			</c:if>
			<c:if test="${isLogined != true}">
			<ul class="LoginButton">
				<li><a href="${root}/Register.jsp" >註冊</a></li>
				<li><a href="${root}/LoginPage.jsp" >登入</a></li>
			</ul>
			</c:if>
			
			
			
		
	</div>