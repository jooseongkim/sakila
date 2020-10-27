<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
.center {
	text-align: center;
}

.wRight {
	text-align-last: right;
}

.table {
	background-color: #33ffcc;
}
</style>
<script>
	//유효성 검사를 해주는 코드를 구현
	$(document).ready(function() {
		$("#btn").click(function() {
			if ($("#staffEmail").val().length < 1) {
				alert("아이디를 확인하세요");
				return;
			} else if ($("#staffPw").val().length < 3) {
				alert("비밀번호를 확인하세요");
				return;
			}
			$("#staffLoginForm").submit();
		});
	});
</script>
</head>
<body>
	<form class="container" id="staffLoginForm" method="post">
		<table class="table center">
			<tr>
				<td class="form-group wRight"><input type="text"
					class="form-control" placeholder="ID" id="staffEmail" name="staffEmail"></td>
			</tr>
			<tr>
				<td class="form-group wRight"><input type="password"
					class="form-control" placeholder="PW" id="staffPw" name="staffPw"></td>
			</tr>
			<tr class="center">
				<td>
					<button type="button" class="btn btn-outline-secondary" id="btn">로그인</button>
				</td>
			</tr>
			<tr>
				<td>오늘 접속자 수 : ${todayStats.count} 명</td>
			</tr>
			<tr>
				<td>총 접속자 수 : ${totalCnt}명</td>
			</tr>
		</table>
	</form>
</body>
</html>