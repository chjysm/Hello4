<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
	$(function() {
		$("#write").on("click", function() {
		location.href = "goWrite.board";
		})
	})
</script>
</head>
<body>
	<table border="1" align="center">
		<tr style="height: 30px">
			<td colspan="8">자유게시판
		</tr>
		<tr style="height: 40px">

			<td style="width: 100px">글번호
			<td style="width: 500px">제목
			<td style="width: 150px">글쓴이
			<td style="width: 100px">조회수
			<td style="width: 100px">작성시간
		</tr>

		<tr style="height: 45px">

			<td style="width: 100px">
			<td style="width: 500px">
			<td style="width: 150px">
			<td style="width: 100px">
			<td style="width: 100px">
		</tr>

		<tr style="height: 30px">
			<td colspan="8" align="center">
		</tr>
		<tr style="height: 30px">
			<td colspan="8" align="right"><input type="button" value="글 쓰기"
				id=write>
		</tr>
	</table>
</body>
</html>