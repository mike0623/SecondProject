<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>大廳</title>

<link rel="stylesheet" href="SecondProject.css">
</head>
<style>
.container {
	width: 80%;
	border: 1px solid black;
	margin: auto;
}

.context {
	width: 98%;
	display: flex;
	flex-wrap: wrap;
	justify-content:space-between;
}
.card{
	width: 18rem;
	text-align: center;
	border: 1px solid black;
}

</style>
<body>
	<jsp:include page="/include/Header.jsp"></jsp:include>
	<div class="container">
		<div class="context">
			<div class="card">
				<img alt="" src="${root }/img/boardgame/1A2B.jpg">
				<h5>遊戲名稱</h5>
				<button id="start1A2B">開始遊玩</button>
			</div>
			
			
			
			
		</div>
		
		
		





	</div>
	<jsp:include page="/include/Footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$("#start1A2B").click(function(){
			fetch("http://localhost:8080/SecondProject/game/OneATwoB.jsp").then(result => result.text()).then(message => {
				if(message == "Not Login"){
					alert("請先登入!")
					return;
				}
				window.location.href="http://localhost:8080/SecondProject/game/OneATwoB.jsp"
			})
		})
	</script>
</body>
</html>