<%@page import="kh.ncs.dto.InOutDTO"%>
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
		ArrayList<InOutDTO> lists = (ArrayList<InOutDTO>)request.getAttribute("List");
		for(InOutDTO list : List){
			%>
			<span><%=list.getSeq()%></span>
			<span><%=list.getName()%></span>
			<span><%=list.getMessage()%></span>
			<br>
			<%
		}
	%>
</body>
</html>