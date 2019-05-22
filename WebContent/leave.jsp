<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴시 비밀번호 확인</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
	$(function(){
		$("#btn").on("click",function(){
			$("#leaveForm").submit();
		})
	})
</script>
 <style>
        div{
            border: 0px solid black;
            box-sizing: border-box;
        }
        #wrapper{
            height: 100px;
            width: 300px;
            margin: auto;
            background-color: #ffb7b7;
        }
        #header{
            text-align: center;
            height: 30%;
            padding-top: 9px;
            color: gray;
        }
       
        #footer{
            text-align: center;
        
            height: 70%;
        }
        input[type="password"]{
            margin-top: 20px;
            border: none;
            width: 70%;
            height: 30%;
        }
        input[type="button"]{
            border: none;
            background-color: #ffd8d8;
            color: gray;
        }
        input[type="button"]:hover{
            cursor: pointer;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div id="wrapper">
        <div id="header"><span>비밀번호를 입력해주세요</span></div>
        <form action="leave.member" method="post" id="leaveForm">
        <div id="footer">
            <input type="password" name="password" id="password">
             <input type="button" value="확인" id="btn">
        </div>
        </form>
        
    </div>
</body>
</html>