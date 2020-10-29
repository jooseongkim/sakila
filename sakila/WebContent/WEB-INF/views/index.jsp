<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Your other stuff  (you can have problems if you don't add minimum scale in the viewport) -->
<meta name="viewport" content="width=device-width,minimum-scale=1">
<!-- Include a Sidr bundled CSS theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/jquery.sidr/2.2.1/stylesheets/jquery.sidr.dark.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function myFunction(x) {
		x.classList.toggle("change");
	}
	function openNav() {
		document.getElementById("sidemenu").style.width = "250px";
	}

	function closeNav() {
		document.getElementById("sidemenu").style.width = "0";
	}
</script>
<!-- 주성치 커밋 -->
<style type="text/css">
.font {
	font-family: "Malgun Gotic";
}

.center {
	text-align: center;
}

.container {
	display: inline-block;
	cursor: pointer;
}

.bar1, .bar2, .bar3 {
	width: 35px;
	height: 5px;
	background-color: #333;
	margin: 6px 0;
	transition: 0.4s;
}

.change .bar1 {
	-webkit-transform: rotate(-45deg) translate(-9px, 6px);
	transform: rotate(-45deg) translate(-9px, 6px);
}

.change .bar2 {
	opacity: 0;
}

.change .bar3 {
	-webkit-transform: rotate(45deg) translate(-8px, -8px);
	transform: rotate(45deg) translate(-8px, -8px);
}

.sidenav {
	height: 100%; /* 100% Full-height */
	width: 0;
	position: fixed;
	z-index: 1; /* 항상 위에 */
	top: 0; /
	left: 0;
	background-color: #111; /* 검은색*/
	overflow-x: hidden; /* 가로 스크롤 비활성화 사용 */
	padding-top: 60px; /* Place content 60px from the top */
	transition: 0.5s;
	/* 0.5 second transition effect to slide in the sidenav */
}

/*  메뉴 링크*/
.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #ffffff;
	display: block;
	transition: 0.3s;
}

/*내 마우스가 메뉴 링크에 커서를 올렸을 때 색을 체인지 */
.sidenav a:hover { #b4ffd6
	
}

/* 메뉴 닫기 버튼 배치 및 스타일 */
.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

/* 메뉴 페이지를 열때 페이지 콘텐츠를 오른쪽으로 푸시 */
#main {
	transition: margin-left .5s;
	padding: 20px;
}

.white {
	color: white;
	font-size: 60px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="font center">
		<h1>비디오 대여점</h1>
	</div>
	<hr>
	<div class="container" onclick="openNav()">
		<div class="bar1"></div>
		<div class="bar2"></div>
		<div class="bar3"></div>
	</div>
	<div class="sidenav" id="sidemenu">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<i class="fas fa-user-astronaut white">관리자</i> <a href="#">홈으로</a> <a
			href="#">비디오 목록</a> <a href="#">관리자 페이지</a> <a href="#">etc</a>
	</div>
	<span style="font-size: 30px; cursor: pointer"
		onclick="myFunction(this)"></span>
	<div id="main"></div>

</body>
</html>