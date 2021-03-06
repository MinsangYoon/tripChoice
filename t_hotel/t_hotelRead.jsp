<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<!-- 본문 시작-->
<c:if test="${sessionScope.s_tu_rank =='admin'}">
	<input type="button" value="수정" onclick="location.href='t_hotel_update.do?th_code=${dto.th_code}'">
	<input type="button" value="삭제" onclick="location.href='t_hotel_delete.do?th_code=${dto.th_code}'">
</c:if>

<div>
    ${dto.th_content}
</div>
<!-- ------------------------------------------------  -->
<body onload="init();">
<script>
var th_cost1;
var thr_adult;
var th_cost2;
var thr_kid;


function init () {
	th_cost1 = document.form.th_cost1.value;
	thr_adult = document.form.thr_adult.value;
	th_cost2 = document.form.th_cost2.value;
	thr_kid = document.form.thr_kid.value;
	
	document.form.thr_price.value =0;
	change();
	change2();
	
}

function add () {
	hm = document.form.thr_adult;
	hm2 = document.form.thr_kid;
	
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	
	thr_price = document.form.thr_price;
	hm.value ++ ;

	sum1.value = parseInt(hm.value) * parseInt(th_cost1);
	sum2.value = parseInt(hm2.value) * parseInt(th_cost2);
	
	thr_price.value=parseInt(sum1.value)+parseInt(sum2.value);
}
function add2 () {
	hm = document.form.thr_adult;
	hm2 = document.form.thr_kid;
	
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	
	thr_price = document.form.thr_price;
	hm2.value ++ ;

	sum1.value = parseInt(hm.value) * parseInt(th_cost1);
	sum2.value = parseInt(hm2.value) * parseInt(th_cost2);
	
	thr_price.value=parseInt(sum1.value)+parseInt(sum2.value);
}

function del () {
	hm = document.form.thr_adult;
	hm2 = document.form.thr_kid;
	
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	
	thr_price = document.form.thr_price;
		if (hm.value > 0) {
			hm.value -- ;
			sum1.value = parseInt(hm.value) * parseInt(th_cost1);
			sum2.value = parseInt(hm2.value) * parseInt(th_cost2);
			thr_price.value=parseInt(sum1.value)+parseInt(sum2.value);
		}
}
function del2 () {
	hm = document.form.thr_adult;
	hm2 = document.form.thr_kid;
	
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	
	thr_price = document.form.thr_price;
		if (hm2.value > 0) {
			hm2.value -- ;
			sum1.value = parseInt(hm.value) * parseInt(th_cost1);
			sum2.value = parseInt(hm2.value) * parseInt(th_cost2);
			thr_price.value=parseInt(sum1.value)+parseInt(sum2.value);
		}
}


function change () {
	hm = document.form.thr_adult;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	thr_price = document.form.thr_price;

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum1.value = parseInt(hm.value) * parseInt(th_cost1);
	thr_price.value= parseInt(sum1.value)+parseInt(sum2.value);
	
}  
function change2 () {
	hm2 = document.form.thr_kid;
	sum1 = document.form.sum1;
	sum2 = document.form.sum2;
	thr_price = document.form.thr_price;

		if (hm2.value < 0) {
			hm2.value = 0;
		}
	sum2.value = parseInt(hm2.value) * parseInt(th_cost2);
	thr_price.value= parseInt(sum1.value)+parseInt(sum2.value);
}

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

<div style="clear: both; text-align: right;">
<hr>
방 호수 : ${dto.th_room}호 <br>
최대예약가능인원 : ${dto.th_max}명
<form name="form" method="post" action="${root}/hotel_reser/hotel_reser_insert.do" onsubmit="return dateCheck2()">
	<!--
		hidden속성으로 th_code를 다음(숙소예약테이블에 insert)으로 넘겨준다. 
		아이디는 세션에 올린 값 사용.
	-->
	<input type="hidden" id="th_code" name="th_code" value="${dto.th_code}"> 
	<input type="hidden" id="tu_id" name="tu_id" value="${sessionScope.s_tu_id}">

	<h2>인원선택</h2>
	<table align="right">
	<tr>
		<td width="110px" height="100px" style="text-align: center;">성인<br><span style="font-weight: bold;">${dto.th_cost1}원</span></td> 
		<td width="200px;"><input type=hidden name="th_cost1" value="${dto.th_cost1}">
		<input type="text" name="thr_adult" value="${thr_adult}" size="3" onchange="change();" required readonly>
		<!-- <input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"> --> </td>
	</tr>
	<tr>
		<td width="100px" height="100px" style="text-align: center;">유,소아<br><span style="font-weight: bold;">${dto.th_cost2}원</span></td> 
		<td width="200px;"><input type=hidden name="th_cost2" value="${dto.th_cost2}">
		<input type="text" name="thr_kid" value="${thr_kid}" size="3" onchange="change2();" required readonly>
		<!-- <input type="button" value=" + " onclick="add2();"><input type="button" value=" - " onclick="del2();"> --></td>
	</tr>

	<tr>
		<td style="text-align: center;">총금액</td> 
		
		<td><input type="text" id="thr_price" name="thr_price" size="11" readonly>원</td>
	</tr>
	
	<tr>
	<td><br></td>
	</tr>

	<tr>
	<td colspan="2"><h2>날짜 선택</h2></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="thr_in" id="thr_in" value="${thr_in}" readonly="readonly"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="thr_out" id="thr_out" value="${thr_out}" readonly="readonly"></td>
	</tr>
	</table>
	
	<input type="hidden" name="sum1" size="11" readonly>
	<input type="hidden" name="sum2" size="11" readonly>
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	<c:if test="${not empty sessionScope.s_tu_id }"> <!-- 로그인 해야만 보임. -->
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
