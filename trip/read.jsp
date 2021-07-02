<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<!-- 본문 시작-->
<!-- 관리자만 작성 가능 -->
<c:if test="${sessionScope.s_tu_rank =='admin'}">
	<input type="button" value="수정" onclick="location.href='trip_update.do?trip_code=${dto.trip_code}'">
	<input type="button" value="삭제" onclick="location.href='trip_delete.do?trip_code=${dto.trip_code}'">
</c:if>

<div>

    ${dto.trip_content}
</div>

<!-- ------------------------------------------------  -->
<body onload="init();">
<script>
var trip_cost1;
var tr_adult;
var trip_cost2;
var tr_kid;
var trip_cost3;
var tr_baby

function init () {
	trip_cost1 = document.form.trip_cost1.value;
	tr_adult = document.form.tr_adult.value;
	trip_cost2 = document.form.trip_cost2.value;
	tr_kid = document.form.tr_kid.value;
	trip_cost3 = document.form.trip_cost3.value;
	tr_baby = document.form.tr_baby.value;
	document.form.tr_price.value =0;
	change();
	change2();
	change3();
}

function add () {
	hm = document.form.tr_adult;
	hm2 = document.form.tr_kid;
	hm3 = document.form.tr_baby;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;
	hm.value ++ ;

	sum1.value = parseInt(hm.value) * parseInt(trip_cost1);
	sum2.value = parseInt(hm2.value) * parseInt(trip_cost2);
	sum3.value = parseInt(hm3.value) * parseInt(trip_cost3);
	tr_price.value=parseInt(sum1.value)+parseInt(sum2.value)+parseInt(sum3.value);
}
function add2 () {
	hm = document.form.tr_adult;
	hm2 = document.form.tr_kid;
	hm3 = document.form.tr_baby;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;
	hm2.value ++ ;

	sum1.value = parseInt(hm.value) * parseInt(trip_cost1);
	sum2.value = parseInt(hm2.value) * parseInt(trip_cost2);
	sum3.value = parseInt(hm3.value) * parseInt(trip_cost3);
	tr_price.value=parseInt(sum1.value)+parseInt(sum2.value)+parseInt(sum3.value);
}
function add3 () {
	hm = document.form.tr_adult;
	hm2 = document.form.tr_kid;
	hm3 = document.form.tr_baby;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;
	hm3.value ++ ;

	sum1.value = parseInt(hm.value) * parseInt(trip_cost1);
	sum2.value = parseInt(hm2.value) * parseInt(trip_cost2);
	sum3.value = parseInt(hm3.value) * parseInt(trip_cost3);
	tr_price.value=parseInt(sum1.value)+parseInt(sum2.value)+parseInt(sum3.value);
}

function del () {
	hm = document.form.tr_adult;
	hm2 = document.form.tr_kid;
	hm3 = document.form.tr_baby;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;
		if (hm.value > 0) {
			hm.value -- ;
			sum1.value = parseInt(hm.value) * parseInt(trip_cost1);
			sum2.value = parseInt(hm2.value) * parseInt(trip_cost2);
			sum3.value = parseInt(hm3.value) * parseInt(trip_cost3);
			tr_price.value=parseInt(sum1.value)+parseInt(sum2.value)+parseInt(sum3.value);
		}
}
function del2 () {
	hm = document.form.tr_adult;
	hm2 = document.form.tr_kid;
	hm3 = document.form.tr_baby;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;
		if (hm2.value > 0) {
			hm2.value -- ;
			sum1.value = parseInt(hm.value) * parseInt(trip_cost1);
			sum2.value = parseInt(hm2.value) * parseInt(trip_cost2);
			sum3.value = parseInt(hm3.value) * parseInt(trip_cost3);
			tr_price.value=parseInt(sum1.value)+parseInt(sum2.value)+parseInt(sum3.value);
		}
}
function del3 () {
	hm = document.form.tr_adult;
	hm2 = document.form.tr_kid;
	hm3 = document.form.tr_baby;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;
		if (hm3.value > 0) {
			hm3.value -- ;
			sum1.value = parseInt(hm.value) * parseInt(trip_cost1);
			sum2.value = parseInt(hm2.value) * parseInt(trip_cost2);
			sum3.value = parseInt(hm3.value) * parseInt(trip_cost3);
			tr_price.value=parseInt(sum1.value)+parseInt(sum2.value)+parseInt(sum3.value);
		}
}

function change () {
	hm = document.form.tr_adult;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum1.value = parseInt(hm.value) * parseInt(trip_cost1);
	tr_price.value= parseInt(sum1.value+sum2.value+sum3.value);
	
}  
function change2 () {
	hm2 = document.form.tr_kid;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;

		if (hm2.value < 0) {
			hm2.value = 0;
		}
	sum2.value = parseInt(hm2.value) * parseInt(trip_cost2);
	tr_price.value= parseInt(sum1.value)+parseInt(sum2.value)+parseInt(sum3.value);
}
function change3 () {
	hm3 = document.form.tr_baby;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	sum3 = document.form.sum3;
	tr_price = document.form.tr_price;

		if (hm3.value < 0) {
			hm3.value = 0;
		}
	sum3.value = parseInt(hm3.value) * parseInt(trip_cost3);
	tr_price.value= parseInt(sum1.value+sum2.value+sum3.value);
}

//날짜선택 함수
$(function() {
    $( "#tr_departure" ).datepicker({
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
    $( "#tr_arrival" ).datepicker({
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

<div style="float:right; text-align: right; width: 30%;">
<br>
<form name="form" method="post" action="${root}/trip_reser/trip_reser_insert.do" onsubmit="return dateCheck()">
	<h2>인원선택</h2>
	<table align="right">
	<tr>
		<td width="110px" height="100px" style="text-align: center;">성인<br><span style="font-weight: bold;">${dto.trip_cost1}원</span></td> 
		<td width="200px;"><input type=hidden name="trip_cost1" value="${dto.trip_cost1}">
		<input type="text" name="tr_adult" value="0" size="3" onchange="change();">
		<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"></td>
	</tr>
	<tr>
		<td width="100px" height="100px" style="text-align: center;">청소년<br><span style="font-weight: bold;">${dto.trip_cost2}원</span></td> 
		<td width="200px;"><input type=hidden name="trip_cost2" value="${dto.trip_cost2}">
		<input type="text" name="tr_kid" value="0" size="3" onchange="change2();">
		<input type="button" value=" + " onclick="add2();"><input type="button" value=" - " onclick="del2();"></td>
	</tr>
	<tr>
		<td width="100px" height="100px" style="text-align: center;">유아<br><span style="font-weight: bold;">${dto.trip_cost3}원</span></td> 
		<td width="200px;"><input type=hidden name="trip_cost3" value="${dto.trip_cost3}">
		<input type="text" name="tr_baby" value="0" size="3" onchange="change3();">
		<input type="button" value=" + " onclick="add3();"><input type="button" value=" - " onclick="del3();"></td>
	</tr>

	<tr>
		<td style="text-align: center;">총금액</td> 
		
		<td><input type="text" id="tr_price" name="tr_price" size="11" readonly>원</td>
	</tr>
	
	<tr>
	<td><br></td>
	</tr>

	<tr>
	<td colspan="2"><h2>날짜 선택</h2></td>
	</tr>
	<tr>
		<td>출발 날짜</td>
		<td><input type="text" name="tr_departure" id="tr_departure" value="출발 날짜"></td>
	</tr>
	<tr>
		<td>도착 날짜</td>
		<td><input type="text" name="tr_arrival" id="tr_arrival" value="도착 날짜"></td>
	</tr>
	</table>
	
	<input type="hidden" name="sum1" size="11" readonly>
	<input type="hidden" name="sum2" size="11" readonly>
	<input type="hidden" name="sum3" size="11" readonly>
	
	<!-- 현재 로그인된 id와 여행상품코드 -->
	<input type="hidden" id="trip_code" name="trip_code" value="${dto.trip_code}"> 
	<input type="hidden" id="tu_id" name="tu_id" value="${sessionScope.s_tu_id}">
	
	
	<c:if test="${not empty sessionScope.s_tu_id }"><!-- 로그인 해야만 보임. -->
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<input type="button" value="이전" class="btn btn-danger" onclick="javascript:history.back()">
		<input type="submit" value="예약" class="btn btn-primary">
	</c:if>
	
</form>
</div>
<hr>
<div style="clear: both;">
</div>

<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
