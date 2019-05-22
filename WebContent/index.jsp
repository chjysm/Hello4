<%@page import="kh.ncs.dto.InOutDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
</head>
<body>

<br><hr><br>
	
	insert : 
	<form action="input.io">
		<input type="text" name="name">
		<input type="text" name="msg">
		<input type="submit">
	</form>
	
	<br><hr><br>
	
	selectAll : 
	<button type='button' id='btn'>출력</button>
	<script>
		document.getElementById("btn").onclick = function(){
			location.href='output.io';
		}
	</script>

</body>
</html>
