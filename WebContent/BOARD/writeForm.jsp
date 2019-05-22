<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
     <style>
            #wrapper{
                width:500px;
            }
            div {
                border: 1px solid black;
                box-sizing: boder-box;
                text-align: center;
            }
            .input {
                width: 98%;
                height: 98%;
                text-align: center;
            }
            #contents {
                height: 250px;
            }

        </style>
    </head>
    <body>
        <form action="send.bd">
            <div id=wrapper>
                <div>작성자 : ${mdto.name }</div>
                <div>
                    <input id=title name=title class=input type=Text placeholder="제목 입력" >
                </div>
                <div>
                    <textarea id=contents name=contents class=input placeholder="내용 입력"></textarea>
                </div>
                <div>
                    <input id=send type=submit value="작성 완료"> 
                    <input id=turn type=button value="목록으로">
                </div>
            </div>
        </form>
        <script>
            $("#turn").click(function(){
                location.href="board.bd"
            })
        </script>

    </body>
</html>