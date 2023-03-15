<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/SecondProject.css">
<link rel="shortcut icon" href="#">
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/include/Header.jsp"></jsp:include>
	<jsp:include page="/include/SideBar.jsp"></jsp:include>
	<div class="box">
		<div class="showManagerTable">
			<table>
				<thead class="showManagerThead">
					<tr>
						<th>userID</th>
						<th>userAccount</th>
						<th>userPwd</th>
						<th>userName</th>
						<th>gender</th>
						<th>birthday</th>
						<th>createDate</th>
						<th>userPhoto</th>
						<th>修改</th>
						<th>刪除</th>
					</tr>
				</thead>
				<tbody class="showManagerTbody">
					<c:forEach var="i" begin="0" end="${users.size()-1}">
						<tr class="showManagerTr">
							<td>${users[i].userID}</td>
							<td>${users[i].userAccount}</td>
							<td>${users[i].userPwd}</td>
							<td>${users[i].userName}</td>
							<td>${users[i].gender}</td>
							<td>${users[i].birthday}</td>
							<td>${users[i].createDate}</td>
							<td><img src="${users[i].userPhoto}" width="50px"></td>
							<td><button class="update">修改</button></td>
							<td><button class="delete">刪除</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button id="prePage">上一頁</button>
			<select id="page" name="page">
				<c:forEach var="i" begin="1" end="${totalPage}">
					<option value="${i}">第${i}頁</option>
				</c:forEach>
			</select>
			<button id="nextPage">下一頁</button>
		</div>
	</div>

	<jsp:include page="/include/Footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
	<script>
		$("#page").change(function(){
			$(".showManagerTbody").empty();
			fetch("${root}/UserManagePageN.do?page="+$(this).val()).then(result => result.text()).then(message => {
				let json = JSON.parse(message);
				let totalPage = json.totalPage;
				let arrayWithBean = json.users;
				for(let i = 0;i<arrayWithBean.length;i++){
					let str = "<tr class='showManagerTr'><td>" + arrayWithBean[i].userID + "</td><td>" + arrayWithBean[i].userAccount + "</td><td>" + arrayWithBean[i].userPwd + "</td><td>" + arrayWithBean[i].userName + "</td><td>" + arrayWithBean[i].gender + "</td><td>" + arrayWithBean[i].birthday + "</td><td>" + arrayWithBean[i].createDate + "</td><td><img src='" + arrayWithBean[i].userPhoto + "' width='50px'/></td><td><button class='update'>修改</button></td><td><button class='delete'>刪除</button></td></tr>";
					$(".showManagerTbody").append(str);
				}
			})
		})
		$("#prePage").click(function(){
			let page = $("#page").val();
			if(page != 1){
				page--;
				// console.log(page);
				$("#page").val(page);
				$(".showManagerTbody").empty();
				fetch("${root}/UserManagePageN.do?page="+page).then(result => result.text()).then(message => {
					let json = JSON.parse(message);
					let totalPage = json.totalPage;
					let arrayWithBean = json.users;
				for(let i = 0;i<arrayWithBean.length;i++){
					let str = "<tr class='showManagerTr'><td>" + arrayWithBean[i].userID + "</td><td>" + arrayWithBean[i].userAccount + "</td><td>" + arrayWithBean[i].userPwd + "</td><td>" + arrayWithBean[i].userName + "</td><td>" + arrayWithBean[i].gender + "</td><td>" + arrayWithBean[i].birthday + "</td><td>" + arrayWithBean[i].createDate + "</td><td><img src='" + arrayWithBean[i].userPhoto + "' width='50px'/></td><td><button class='update'>修改</button></td><td><button class='delete'>刪除</button></td></tr>";
					$(".showManagerTbody").append(str);
				}
				})
			}
		})
		
		$("#nextPage").click(function(){
			let page = $("#page").val();
			let lastPage = $("#page>option:last-child").val();
			// console.log(page);
			// console.log(lastPage);
			if(page != lastPage){
				page++;
				$("#page").val(page);
				$("#page").val(page);
				$(".showManagerTbody").empty();
				fetch("${root}/UserManagePageN.do?page="+page).then(result => result.text()).then(message => {
					let json = JSON.parse(message);
					let totalPage = json.totalPage;
					let arrayWithBean = json.users;
				for(let i = 0;i<arrayWithBean.length;i++){
					let str = "<tr class='showManagerTr'><td>" + arrayWithBean[i].userID + "</td><td>" + arrayWithBean[i].userAccount + "</td><td>" + arrayWithBean[i].userPwd + "</td><td>" + arrayWithBean[i].userName + "</td><td>" + arrayWithBean[i].gender + "</td><td>" + arrayWithBean[i].birthday + "</td><td>" + arrayWithBean[i].createDate + "</td><td><img src='" + arrayWithBean[i].userPhoto + "' width='50px'/></td><td><button class='update'>修改</button></td><td><button class='delete'>刪除</button></td></tr>";
					$(".showManagerTbody").append(str);
				}
				})
			}
		})

		$(".showManagerTbody").on("click",".delete",function(){
			console.log(this)
			let nowPage = $("#page").val();
			fetch("${root}/UserManageDelete.do?userAccount="+$(this).parents(".showManagerTr").children().get(1).innerText+"&page="+nowPage).then(result => result.text()).then(message => {
				let json = JSON.parse(message);
				let totalPage = json.totalPage;
				let arrayWithBean = json.users;
				
				$("#page").empty();
				for(let i =1;i <= totalPage;i++){
					let str= "<option value="+i+">第"+i+"頁</option>";
					$("#page").append(str);
				}
				if(totalPage<nowPage){
					nowPage = nowPage-1;
				}
				$("#page").val(nowPage);
				
				$(".showManagerTbody").empty();
				for(let i = 0;i<arrayWithBean.length;i++){
					let str = "<tr class='showManagerTr'><td>" + arrayWithBean[i].userID + "</td><td>" + arrayWithBean[i].userAccount + "</td><td>" + arrayWithBean[i].userPwd + "</td><td>" + arrayWithBean[i].userName + "</td><td>" + arrayWithBean[i].gender + "</td><td>" + arrayWithBean[i].birthday + "</td><td>" + arrayWithBean[i].createDate + "</td><td><img src='" + arrayWithBean[i].userPhoto + "' width='50px'/></td><td><button class='update'>修改</button></td><td><button class='delete'>刪除</button></td></tr>";
					$(".showManagerTbody").append(str);
				}
				

			})
		})

		$(".showManagerTbody").on("click",".update",function(){
			window.location.href="${root}/ManagerUpdate.jsp?userID="+$(this).parents(".showManagerTr").children().get(0).innerText+"&page="+$("#page").val();
		})
	</script>
</body>
</html>