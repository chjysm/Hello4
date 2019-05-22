<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 성공여부</title>
</head>
<body>
	<c:choose>
		<c:when test="${deleteMember > 0 }">
			<script>
				alert("회원탈퇴가 성공적으로 되었습니다.")
				location.href="goToIndex.member";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("회원탈퇴에 실패했습니다.");
				location.href="goToIndex.member";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>