<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<style>
div.gallery {
  margin: 30px;
  border: 1px solid #ccc;
  float: left;
  width: 300px;
  height: 400px;
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
  height: auto;
}

div.desc {
  padding: 15px;
  text-align: center;
}
</style>

<script>
//날짜선택 함수
$(function() {
    $( "#thr_in" ).datepicker({
    	//showOn: "both",
    	//buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
    	showButtonPanel: true, 
    	currentText: '오늘 날짜', 
        closeText: '닫기', 
        dateFormat: "yy-mm-dd",
        nextText: '다음 달',
        prevText: '이전 달',
        dayNamesMin: ['일','월', '화', '수', '목', '금', '토'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        minDate: 1, //내일 날짜부터 선택 가능.
        maxDate: 30
    });
    $( "#thr_out" ).datepicker({
    	//showOn: "both",
    	showButtonPanel: true, 
    	currentText: '오늘 날짜', 
        closeText: '닫기', 
        dateFormat: "yy-mm-dd",
        nextText: '다음 달',
        prevText: '이전 달',
        dayNamesMin: ['일','월', '화', '수', '목', '금', '토'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        minDate: 3, //3일 후 날짜부터 선택가능.
        maxDate: 33
    });
});
</script>
<!-- 본문 시작-->



<div class="container">
<form name='frm' method='POST' action='t_hotel_list.do' onsubmit="return dateCheck2()">
		<div class="search" id="search" style='text-align:center;'>
			<label>지역</label> <input type='text' name='th_reg' placeholder='지역'size='10' required> 
			<label>인원수</label> <input type='number' name='thr_adult' placeholder='성인' required> <input type='number' name='thr_kid' placeholder='청소년' required> 
			<br><label>체크인/체크아웃</label><input type="text" name="thr_in" id="thr_in" value="체크인" required> <input type="text" name="thr_out" id="thr_out" value="체크아웃" required>
			<input type='submit' value='검색하기' class="search">
		</div><br>
	</form>

<c:if test="${list ==null}">
	<div align="center">
		<span style="font-weight: bold; font-size: 25px; text-align: center;">알맞은 숙소를 찾지 못하였습니다. 다시 검색해주세요.</span>
	 </div>
</c:if>

<c:forEach var="dto" items="${list}">
<div class="gallery">
  <c:if test="${not empty thr_adult }"><a href="t_hotel_read.do?th_code=${dto.th_code}&thr_adult=${thr_adult}&thr_kid=${thr_kid}&thr_in=${thr_in}&thr_out=${thr_out}"></c:if>
    <img src="./thumbnail/${dto.th_thumbnail}" style="width: 100%; height: 45%;">
  </a>
  <div class="desc">
  	<c:if test="${not empty thr_adult }"><a href="t_hotel_read.do?th_code=${dto.th_code}&thr_adult=${thr_adult}&thr_kid=${thr_kid}&thr_in=${thr_in}&thr_out=${thr_out}"></c:if>
  	<span style="font-size: 18px; font-weight: bold;">${dto.th_name}</span></a> 
  	<br> 
  	<div style="text-align: left;">
  	<span style="font-size: 15px; font-weight: bold;">${dto.th_reg }</span><br><br>
  	<span style="font-family: sans-serif;">1박 <span style="color: red">${dto.th_cost1}원~</span></span>
    <br>최대예약가능인원 : ${dto.th_max}명
  	</div>
  </div>
</div>
</c:forEach>

</div>

<div style="clear: both;"></div>

<%@ include file="../footer.jsp" %>        
