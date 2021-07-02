<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>index.jsp</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- 사용자 정의 스타일과 자바스크립트 -->
<!-- 주의사항 : CSS와 JS는 각 웹브라우저에서 쿠키삭제하고 확인할것 -->
<link rel="stylesheet" href="./css/layout.css">
<script src="./js/myscript.js"></script>


</head>
<body>

	<!-- 메인 카테고리 시작 -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand " href="<%=request.getContextPath()%>/index.do">TripChoice</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
				
				<!-- 관리자 전용 메뉴 -->
				<c:if test="${sessionScope.s_tu_rank =='admin'}">
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">관리자메뉴 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/trip/createForm.do">상품등록</a></li>
							<li><a href="<%=request.getContextPath()%>/trip/trip_list_admin.do">상품목록</a></li>
							<li><a href="<%=request.getContextPath()%>/t_hotel/t_hotelForm.do">숙소등록</a></li>
							<li><a href="<%=request.getContextPath()%>/t_hotel/t_hotel_list_admin.do">숙소목록</a></li>
							<li><a href="<%=request.getContextPath()%>/t_airp/ticket.do">항공권등록</a></li>
							<li><a href="<%=request.getContextPath()%>/t_airp/list.do">항공권목록</a></li>
						</ul></li>
				</c:if>	
				
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">마이메뉴 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/tuser/loginForm.do">로그인</a></li>
							<li><a href="#">회원가입</a></li>
						</ul></li>
					<li><a href="">예약내역</a></li>
					<li><a href="">장바구니</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<!-- 메인 카테고리 끝-->


	<!-- First Container(해외 국내) 시작 -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<ul class="topright">
				<li class=:dropdown><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" style="color: white">국내<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<%=request.getContextPath()%>/trip/trip_list_korea.do">국내전체</a></li>
						<li><a href="<%=request.getContextPath()%>/trip/trip_list_jeju.do">제주</a></li>
					</ul></li>

			</ul>
			<ul class="topright2">
				<li class=:dropdown><a href="<%=request.getContextPath()%>/trip/trip_list_abroad.do" style="color: white">해외</a>

			</ul>

			<div class="item active">
				<img src="./images/jeju.jpg" alt="jeju">
				<div class="carousel-caption">
					<h3>천국의 땅 제주로</h3>
					<p>Heaven of korea</p>
				</div>
			</div>

			<div class="item">
				<img src="./images/iceland.jpg" alt="iceland">
				<div class="carousel-caption">
					<h3>웅장한 대자연의 끝으로</h3>
					<p>Be nature</p>
				</div>
			</div>
		</div>
	</div>

	<!-- First Container 끝-->

	<!-- second container (md 추천 국내 top3) -->
	<div id="second" class="container-fluid text-center">
		<h2>국내 TOP3</h2>
		<div class="main" style="text-align: center">

			<input id="tab1" type="radio" name="tabs" checked> <label
				for="tab1">서울(수도권)</label> <input id="tab2" type="radio" name="tabs">
			<label for="tab2">강원도</label> <input id="tab3" type="radio"
				name="tabs"> <label for="tab3">충청도</label> <input id="tab4"
				type="radio" name="tabs"> <label for="tab4">전라도</label> <input
				id="tab5" type="radio" name="tabs"> <label for="tab5">경상도</label>
			<input id="tab6" type="radio" name="tabs"> <label for="tab6">제주도</label>



			<section id="content1" style="margin-bottom: 20px;">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/hongdae.jpg" alt="hongdae">
						<div class="carousel-caption">
							<h3>홍대입구 9번출구로 모여라!</h3>
							<p>#홍대입구 #감성 #파티룸 #맛집 #도보3분</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/itaewon.jpg" alt="itaewon">
						<div class="carousel-caption">
							<h3>이태원클라쓰</h3>
							<p>#이태원 #이국적풍경 #파티룸</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/gyeongbok.jpg" alt="gyeongbok">
						<div class="carousel-caption">
							<h3>경복궁 투어</h3>
							<p>#경복궁 #궁투어 #한복투어</p>
						</div>
					</div>
				</div>
			</section>

			<section id="content2" style="margin-bottom: 20px;">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/gangneung.jpg" alt="gangneung">
						<div class="carousel-caption">
							<h3>강릉 도깨비 여행</h3>
							<p>#강릉 #도깨비 #인생샷</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/yangyang.png" alt="yangyang">
						<div class="carousel-caption">
							<h3>양양 서핑 여행</h3>
							<p>#양양 #서핑 #감성</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/sokcho.jpg" alt="sokcho">
						<div class="carousel-caption">
							<h3>속초 럭셔리 호캉스</h3>
							<p>#속초 #롯데리조트 #호캉스</p>
						</div>
					</div>
				</div>
			</section>

			<section id="content3" style="margin-bottom: 20px;">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/boryeong.jpg" alt="boryeong">
						<div class="carousel-caption">
							<h3>보령 머드 축제</h3>
							<p>#보령 #머드축제 #세계의축제</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/choongju.jpg" alt="choongju">
						<div class="carousel-caption">
							<h3>충주호 일몰 여행</h3>
							<p>#충주 #일몰여행 #감성샷</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/soklisan.jpg" alt="soklisan">
						<div class="carousel-caption">
							<h3>속리산 국립공원 트래킹</h3>
							<p>#속리산 #등산 #트래킹</p>
						</div>
					</div>
				</div>
			</section>

			<section id="content4" style="margin-bottom: 20px;">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/soonchun.jpg" alt="soonchun">
						<div class="carousel-caption">
							<h3>순천만 여행</h3>
							<p>#순천 #바다 #인생샷</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/yeosu.jpg" alt="yeosu">
						<div class="carousel-caption">
							<h3>여수 밤바다 여행</h3>
							<p>#여수 #밤바다 #맛집탐방</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/namhae.jpg" alt="namehae">
						<div class="carousel-caption">
							<h3>남해 히노끼 여행</h3>
							<p>#남해 #히노끼탕 #힐링</p>
						</div>
					</div>
				</div>
			</section>

			<section id="content5" style="margin-bottom: 20px;">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/busan.jpg" alt="busan">
						<div class="carousel-caption">
							<h3>부산 강안리 등낀도나쓰 여행</h3>
							<p>#부산 #강안리 #등낀도나쓰</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/daegu.jpg" alt="daegu">
						<div class="carousel-caption">
							<h3>대구 맛집 탐방</h3>
							<p>#대구 #맛집탐방 #막창말고많다</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/tongyeong.jpg" alt="tongyeong">
						<div class="carousel-caption">
							<h3>통영 다찌 탐방</h3>
							<p>#통영 #다찌 #맛집탐방</p>
						</div>
					</div>
				</div>
			</section>

			<section id="content6" style="margin-bottom: 20px;">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/seoguipo.jpg" alt="seoguipo">
						<div class="carousel-caption">
							<h3>한라산 여행</h3>
							<p>#한라산 #트래킹 #분화구</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/joongmoon.jpg" alt="joongmoon">
						<div class="carousel-caption">
							<h3>제주 중문 여행</h3>
							<p>#중문 #산책 #인생샷</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="./images/woodo.jpg" alt="woodo">
						<div class="carousel-caption">
							<h3>제주의 숨은 보석 우도</h3>
							<p>#우도 #하루1회 #놓치지마세요</p>
						</div>
					</div>
				</div>
			</section>

		</div>
	</div>


	<!-- second container 끝 -->

	<!-- third container (국내 베스트셀러) -->
	<div id="third" class="container-fluid text-center">
		<div id="myCarousel2" class="carousel slide" data-ride="carousel">
			<div>
				<h2>해외 top2</h2>
			</div>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<div class="col-sm-6">
						<div class="thumbnail3">
							<img src="./images/thai.jpg" alt="thai"
								style="width: 530px; height: 350px">
							<div class="carousel-caption">
								<h3>방콕 힐링 여행</h3>
								<p>#방콕 #힐링 #마사지</p>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="thumbnail3">
							<img src="./images/vietnam.jpg" alt="vietnam"
								style="width: 530px; height: 350px">
							<div class="carousel-caption">
								<h3>다낭 유적지 여행</h3>
								<p>#다낭 #유적지 #인생샷</p>
							</div>
						</div>
					</div>
				</div>





				<div class="item">
					<div class="col-sm-6">
						<div class="thumbnail3">
							<img src="./images/paris.jpg" alt="paris"
								style="width: 530px; height: 350px">
							<div class="carousel-caption">
								<h3>파리 에펠탑 일몰 여행</h3>
								<p>#파리 #에펠탑 #일몰</p>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="thumbnail3">
							<img src="./images/london.jpg" alt="london"
								style="width: 530px; height: 350px">
							<div class="carousel-caption">
								<h3>런던 영화 여행</h3>
								<p>#런던 #영화 #촬영지</p>
							</div>
						</div>
					</div>
				</div>




				<div class="item">
					<div class="col-sm-6">
						<div class="thumbnail3">
							<img src="./images/usa.jpg" alt="usa"
								style="width: 530px; height: 350px">
							<div class="carousel-caption">
								<h3>뉴요커 여행</h3>
								<p>#뉴욕 #자유의여신상 #타임스퀘어</p>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="thumbnail3">
							<img src="./images/guam.jpg" alt="guam"
								style="width: 530px; height: 350px">
							<div class="carousel-caption">
								<h3>환상의 여행지 괌</h3>
								<p>#괌 #flex #돌고래쇼</p>
							</div>
						</div>
					</div>
				</div>
				<br>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel2" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel2" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>

			</div>
		</div>
	</div>
	<!-- third container 끝 -->
	
	
	<!-- Footer -->
	<hr>
	<div class="row text-center">
		<div class="col-sm-3">
			<div class="thumbnail2">
				<img src="./images/qna.png" alt="자주 찾는 질문" width="100px"
					height="100px">
				<p>
					<strong>자주 찾는 질문</strong>
				</p>
				<p>궁금하신 정보. 쉽게 찾아보세요</p>
				<a href="index.do" class="btn btn-warning">자주 찾는 질문 바로가기</a>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="thumbnail2">
				<img src="./images/review.png" alt="리뷰" width="100px" height="100px">
				<p>
					<strong>여행 리뷰</strong>
				</p>
				<p>솔직한 리뷰를 써주세요!</p>
				<a href="index.do" class="btn btn-info">리뷰 바로가기</a>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="thumbnail2">
				<img src="./images/question.png" alt="문의사항" width="100px"
					height="100px">
				<p>
					<strong>문의사항</strong>
				</p>
				<p>언제든지 문의하세요~</p>
				<a href="<%=request.getContextPath()%>/trq/trqList.do" class="btn btn-success">문의사항 바로가기</a>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="thumbnail2">
				<img src="./images/mail.png" alt="메일보내기" width="100px"
					height="100px">
				<p>
					<strong>메일보내기</strong>
				</p>
				<p>하고 싶은 말을 보내주세요</p>
				<a href="index.do" class="btn btn-danger">메일보내기</a>
			</div>
		</div>
	</div>

	<footer class="row text-center">
		(주)TripChoice대표 : 김준욱 | 주소 : 서울특별시 종로구 종로12길 15, 5층(관철동 13-13)<br>

		TripChoice사업자번호: 101-11-12345 | 통신판매업신고번호: 제2021-서울종로-9999호<br>

		대표전화: 1544-0714 | 개인정보 보호책임자 : 유영승<br>
		<h5>Copyright © TripChoice ALL RIGHTS RESERVED</h5>
		
		<a class="up-arrow" href="#myNavbar" data-toggle="tooltip"
			title="TO TOP"> <span class="glyphicon glyphicon-chevron-up"></span>
		</a><br> <br>
	</footer>
	<!--footer 끝------------------------------------------------------------------------------------------------------->
</body>

</html>
