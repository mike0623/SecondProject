<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
<link rel="stylesheet" href="SecondProject.css">
</head>
<body>
<jsp:include page="/include/Header.jsp"></jsp:include>
    <table>
        <tbody>
            <tr>
                <td>帳號:</td>
                <td>${myUser.userAccount }</td>
            </tr>
            <tr>
                <td>密碼:</td>
                <td>${myUser.userPwd }</td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td>${myUser.userName }</td>
            </tr>
            <tr>
                <td>性別:</td>
                <td>${myUser.gender }</td>
            </tr>
            <tr>
                <td>出生日期:</td>
                <td>${myUser.birthday }</td>
            </tr>
            <tr>
                <td>照片:</td>
                <td><img src="${myUser.userPhoto}" width="50px"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="UpdateUserInfo.jsp"><button>修改資料</button></a>
                    <a href="DeleteUser.do"><button>刪除會員</button></a>
                </td>
            </tr>
            
            
        </tbody>

    </table>
            <c:if test="${deleteUser == true}">
            <form action="DeleteUser.do">
            	<label for="confirmDelete">若確認要刪除會員，請輸入"我確定"</label><input type="text" name="confirmDelete" id="confirmDelete">
            	<input type="submit" value="送出">
            </form>
            </c:if>
    <jsp:include page="/include/Footer.jsp"></jsp:include>
</body>
</html>