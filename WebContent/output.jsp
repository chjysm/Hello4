<%@page import="kh.ncs.dto.InOutDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:forEach var="list" items="${List}">
        <span>${list.seq}</span>
        <span>${list.name}</span>
        <span>${list.message}</span>
    </c:forEach>
</body>
</html>