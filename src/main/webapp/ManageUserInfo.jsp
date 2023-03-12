<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
</head>
<body>
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
                <td colspan="2">
                    <a href="UpdateUserInfo.jsp"><button>修改資料</button></a>
                </td>
            </tr>
        </tbody>

    </table>
</body>
</html>