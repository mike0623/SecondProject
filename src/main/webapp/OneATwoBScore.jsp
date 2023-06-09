<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="SecondProject.css">
<style>
	table{
		border-collapse: collapse;
		font-size: large;
	}
	th,td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<jsp:include page="/include/Header.jsp"></jsp:include>
	<table>
		<thead>
			<tr>
				<th>次數</th>
				<th>內容</th>
				<th>結果</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" begin="1" end="${forScore.size()}">
				<tr>
					<td>${forScore[i][0]}</td>
					<td>${forScore[i][1]}</td>
					<td>${forScore[i][2]}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<h3>答案為:<c:forEach items="${forScore[0]}" var="s">${s}</c:forEach></h3>
	<h3>您的分數為:${101 - forScore[forScore.size() -1][0] }</h3>
	<a href="${root}/Lobby.jsp"><button>回到大廳</button></a>

	<div class="rank">
		<table>
		<thead>
			<tr>
				<td>名次</td>
				<td>玩家</td>
				<td>分數</td>
				<td>日期</td>
			</tr>
		</thead>
			<tbody>
				<c:forEach var="i" begin="0" end="${list.size()-1 }">
					<tr>
					<td>第${i+1 }名</td>
					<td>${list[i].f_userID.userName }</td>
					<td>${list[i].score }</td>
					<td>${list[i].createdDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



	<jsp:include page="/include/Footer.jsp"></jsp:include>
</body>
</html>