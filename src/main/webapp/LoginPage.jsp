<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
<style>
.form {
	/* border: solid 1px black; */
	/* border-radius: 15px; */
	width: 20%;
	margin: auto;
    border-radius: 15px;
    text-align: center;
}
.label{
    text-align: right;
}
.table{
    margin: auto;
}
</style>
</head>
<body>
	<form action="SignIn.do" method="post" >
		<fieldset class="form" >
            <legend>登入</legend>
            <table class="table">
				<tr>
					<td class="label">帳號:</td>
					<td><input type="text" name="userAccount" placeholder="請輸入您的帳號:"></td>
				</tr>
				<tr>
					<td class="label">密碼:</td>
					<td><input type="password" name="userPwd" maxlength="16" minlength="4" placeholder="請輸入您的密碼:"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="登入">
						<input type="reset" value="清除">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="Register.jsp">新用戶註冊</a>
					</td>
				</tr>
			</table>
        </fieldset>
	</form>
</body>
</html>