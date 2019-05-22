<%@page import="ncs.kh.dto.MessageDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<MessageDTO> lists = (ArrayList<MessageDTO>)request.getAttribute("lists");
		for(MessageDTO list : lists){
			%>
			<span><%=list.getSeq()%></span>
			<span><%=list.getName()%></span>
			<span><%=list.getMsg()%></span>
			<br>
			<%
		}
	%>
</body>
</html>