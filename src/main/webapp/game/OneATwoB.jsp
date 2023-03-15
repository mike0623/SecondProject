<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1A2B小遊戲</title>
<link rel="stylesheet" href="${root}/SecondProject.css">
<link rel="shortcut icon" href="#">
<style>
    .container{
        position: relative;
    }
    .showHistoryTableBox{
        position: absolute;
        left: 0;
        top: 0;
        width: 49%;
    }
    .showHistoryTable{
        width: 80%;
        margin: auto;
        border: 1px solid black;
    }
    .inputArea{
        width: 70%;
        margin: auto;
        margin-bottom: 10px;
    }
    .inputsize{
        height: 50px;
        font-size: 50px;
        text-align: center;
    }
    .ForUserTryBox{
        position: absolute;
        right: 0;
        top: 0;
        width: 49%;
    }
    .ForUserTry{
        width: 50%;
        /* border: 1px solid black; */
        display: flex;
        justify-content:space-between;
    }
    .showUserTry{
        width: 50px;
        height: 50px;
        border-radius: 50%;
        position: relative;
        border: 1px black solid;
        background-color: bisque;
    }
    .showNumber{
        position: absolute;
        top: 7px;
        left: 17px;
        font-size: 30px;
    }
    .select{
        text-align: center;
    }
    td{
        text-align: center;
    }
    .textArea{
        width: 50%;
        margin: auto;
        border: 1px solid black;
        height: 500px;
        font-size: 30px;
    }
</style>
</head>
<body>
<jsp:include page="/include/Header.jsp"></jsp:include>
	<div class="inputArea">
            <label for="userInput" class="inputsize">請輸入4個不同的數字(0-9):</label><input type="text" maxlength="4" minlength="4" name="userInput" id="userInput" class="inputsize" /><input type="button" value="送出" id="send" style="height: 50px; position: absolute; top: 42px;">

    </div>
	<div class="container">
        <div class="showHistoryTableBox">
            <table class="showHistoryTable">
                <thead>
                    <tr>
                        <th>次數</th>
                        <th>內容</th>
                        <th>結果</th>
                    </tr>
                </thead>
                <tbody class="tbody">

                </tbody>

            </table>
        </div>
        <div class="ForUserTryBox">
            <div class="ForUserTry">
                <div id="ForUserTryFirstNumber" class="ForJqUse">
                    <div class="showUserTry">
                        <span id="firstNumber" class="showNumber">0</span>
                    </div>
                    <div class="select">
                    <select >
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                    </select>
                    </div>
                </div>
                <div id="ForUserTrySencondNumber" class="ForJqUse">
                    <div class="showUserTry">
                        <span id="secondNumber" class="showNumber">0</span>
                    </div>
                    <div class="select">
                    <select>
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                    </select>
                    </div>
                </div>
                <div id="ForUserTryThirdNumber" class="ForJqUse">
                    <div class="showUserTry">
                        <span id="ThirdNumber" class="showNumber">0</span>
                    </div>
                    <div class="select">
                    <select>
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                    </select>
                    </div>
                </div>
                <div id="ForUserTryForthNumber" class="ForJqUse">
                    <div class="showUserTry">
                        <span id="forthNumber" class="showNumber">0</span>
                    </div>
                    <div class="select">
                    <select>
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                    </select>
                    </div>
                </div>
            </div>
            <div>
                <textarea placeholder="這裡可以做筆記喔~" class="textArea"></textarea>
            </div>
        </div>
    </div>
    


	
	
	
<jsp:include page="/include/Footer.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
    <Script>
        $("select").on("change mouseup",function(){
            $(this).parents(".ForJqUse").find(".showNumber").text($(this).val());
        })
        
        $("#send").click(function(){
        	console.log("123")
            fetch("http://localhost:8080/SecondProject/OneATwoB.do?input="+ $('#userInput').val()).then(result => result.text()).then(message => {
                if(message == "Wrong Input Type"){
                    alert("輸入格式有誤!")
                    return;
                }
                if(message == "win"){
                    alert("恭喜您答對了!!")
                    window.location.href="http://localhost:8080/SecondProject/OneATwoBScore.jsp";
                }
                let result= JSON.parse(message);
                $(".tbody").append("<tr><td>"+result[0]+"</td><td>"+result[1]+"</td><td>"+result[2]+"</td></tr>")
                console.log(result);
            })
        })
        
        
    </Script>
</body>
</html>