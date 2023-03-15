<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>註冊</title>
    <link rel="stylesheet" href="SecondProject.css">
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
<jsp:include page="/include/Header.jsp"></jsp:include>
    <form action="RegisterData.do" method="post" >
		<fieldset class="form" >
            <legend>註冊</legend>
            <table class="table">
				<tr>
                    <td>*帳號:</td>
                    <td><input type="email" name="registerAccount" placeholder="請輸入電子郵件:"></td>
                </tr>
                <tr>
                    <td>*密碼:</td>
                    <td><input id="registerPwd" type="password" maxlength="16" minlength="4" name="registerPwd" placeholder="請輸入密碼:"></td>
                </tr>
                <tr>
                    <td>*請再次輸入密碼:</td>
                    <td><input id="testPwd" type="password" maxlength="16" minlength="4" name="testPwd" placeholder="請再次輸入密碼:"></td>
                </tr>
                <tr>
                    <td>*姓名:</td>
                    <td><input type="text" name="userName" placeholder="請輸入姓名:"></td>
                </tr>
                <tr>
                    <td>*性別:</td>
                    <td>
                        <input id="male" type="radio" name="gender" value="男" ><label for="male">男</label>
                        <input id="female" type="radio" name="gender" value="女"><label for="female">女</label>
                        <input id="notProvide" type="radio" name="gender" value="不提供"><label for="notProvide">不提供</label>
                    </td>
                </tr>
                <tr>
                    <td>*出生日期:</td>
                    <td><input type="date" name="birthday"></td>
                </tr>
                <c:if test="${accountRepeated == true}" ><tr><td colspan="2"><span style="">已存在之帳號!!</span></td></tr></c:if>
                <c:if test="${columnIsNull == true}" ><tr><td colspan="2"><span style="">必填欄位未填!!</span></td></tr></c:if>
                <c:if test="${testPwdError == true}" ><tr><td colspan="2"><span style="">再次輸入密碼與密碼不相符!!</span></td></tr></c:if>
                <tr>
					<td colspan="2">
						<input type="submit" value="送出">
						<input type="reset" value="清除">
					</td>
				</tr>
			</table>
        </fieldset>
	</form>
    <jsp:include page="/include/Footer.jsp"></jsp:include>
    <script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
    <script>


    </script>
</body>
</html>