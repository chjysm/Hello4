<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(function() {
		$("#pw").on("focusout", function() {
			var regex = /.{4,20}$/g;
			var instring = $("#pw").val();
			var result = regex.exec(instring);
			if (result == null) {
				$("#pw").val("");
				$("#pw").focus();
				$("#msg").text("비밀번호 형식 틀림.");
			}
		});
		$("#pwCheck").on("input", function() {
			if ($("#pw").val() == $("#pwCheck").val()) {
				$("#msg").text("비밀번호가 일치합니다.");
			} else {
				$("#msg").text("비밀번호가 일치하지 않습니다.");
			}
		});
		$("#pwCheck").on("focusout", function() {
			if ($("#pw").val() != $("#pwCheck").val()) {
				$("#pwCheck").val("");
				$("#pw").focus();
			}

		})
		$("#id").on("input", function() {
			var regex = /[a-z0-9]{5,20}$/g;
			var instring = $("#id").val();
			var result = regex.exec(instring);
			if (result == null) {
			} else {
				$.ajax({
					url : "IdDuplCheck.me",
					data : {
						id : $("#id").val()
					},
				}).done(function(resp) {
					if (resp == 0) {
						$("#idCheck").text("아이디가 중복 되지 않습니다.");
					} else {
						$("#idCheck").text("아이디 중복 .");
					}
				});
			}
		});
		$("#sub")
				.on(
						"click",
						function() {
							if (($("#id").val() != "")
									&& ($("#name").val() != "")
									&& ($("#pw").val() != "")
									&& ($("#pwCheck").val() != "")) {
								$("#form").submit();
							} else {
								alert("아이디 중복검사를 하지 않았거나 혹은 아이디,비밀번호,비밀번호,이름 중 입력하지 않은 값이 있습니다.");
							}
						});
	});
</script>
</head>
<body>
	<div id=wrapper>
		<form action="sign.me" id="form">
			<table border="1px">
				<tr>
					<td colspan="2">회원 가입 정보</td>
				</tr>
				<tr>
					<td>아이디 :</td>
					<td><input type="text" id="id" name="id"
						placehorder="7자이상 20자이하 영어소문자,숫자" count="false"><span
						id="idCheck"></span></td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="password" id="pw" name="pw"
						placehorder="4자이상 20자이하"></td>
				</tr>
				<tr>
					<td>비밀번호 확인 :</td>
					<td><input type="password" id="pwCheck" name="pwCheck">
						<span id="msg"></span></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<td>전화번호 :</td>
					<td><input type="text" id="phone" name="phone"></td>
				</tr>
				<tr>
					<td>이메일 :</td>
					<td><input type="text" id="email" name="email"></td>
				</tr>
				<tr>
					<td colspan="2" align=center><input type="button" id="sub"
						value="회원가입"> <input type="reset" value="다시 입력"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>