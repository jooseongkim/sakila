<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
.center {
	text-align: center;
}

.wRight {
	text-align-last: right;
}
</style>
</head>
<body>
	<form class="container">
		<div class="form-group wRight">
			<input type="text" class="form-control" placeholder="ID">
		</div>
		<div class="form-group wRight">
			<input type="password" class="form-control" placeholder="PW">
		</div>
		<div class="center">
			<button type="button" class="btn btn-outline-secondary">로그인</button>
		</div>
	</form>
</body>
</html>