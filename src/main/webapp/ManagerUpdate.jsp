<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="#">
<link rel="stylesheet" href="${root}/SecondProject.css">
</head>
<body>
<jsp:include page="/include/Header.jsp"></jsp:include>
	<jsp:include page="/include/SideBar.jsp"></jsp:include>
	<form action="${root}/UserManageUpdate.do" method="post" enctype="multipart/form-data" id="myForm">
		<fieldset>
            <legend>會員資料</legend>
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
					</tr>
				</thead>
				<tbody>
						<tr>
							<td>${userForUpdate.userID}</td>
							<td><input type="text" value="${userForUpdate.userAccount}" name="userAccount"></td>
							<td><input type="text" value="${userForUpdate.userPwd}" name="userPwd"></td>
							<td><input type="text" value="${userForUpdate.userName}" name="userName"></td>
							<td><input type="text" value="${userForUpdate.gender}" name="gender"></td>
							<td><input type="text" value="${userForUpdate.birthday}" name="birthday"></td>
							<td><input type="text" value="${userForUpdate.createDate}" name="createDate"></td>
							<td><input type="file" name="userPhoto"></td>
						</tr>
						<tr>
							<td colspan="8"><button>Send</button></td>
						</tr>
				</tbody>
			</table>
        </fieldset>
	</form>
	
	<jsp:include page="/include/Footer.jsp"></jsp:include>
</body>
</html>