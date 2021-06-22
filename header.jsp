<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>TripChoice</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- 사용자 정의 스타일과 자바스크립트 -->
<!-- 주의사항 : CSS와 JS는 각 웹브라우저에서 쿠키삭제하고 확인할것 -->
<link rel="stylesheet" href="../css/layout2.css">
<script src="../js/myscript.js"></script>

</head>
<body>

	<!-- 메인 카테고리 시작 -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand " href="../index.do">TripChoice</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
				
				<!-- 관리자 전용 메뉴 -->
				<c:if test="${sessionScope.s_tu_rank =='admin'}">
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">관리자메뉴 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">상품등록</a></li>
							<li><a href="../t_hotel/t_hotelForm.do">숙소등록</a></li>
							<li><a href="../t_airp/ticket.do">항공권등록</a></li>
						</ul></li>
				</c:if>		
						
						
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">마이메뉴 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="../tuser/loginForm.do">로그인</a></li>
							<li><a href="#">회원가입</a></li>
						</ul></li>
					<li><a href="">예약내역</a></li>
					<li><a href="">장바구니</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<!-- 메인 카테고리 끝-->