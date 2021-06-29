<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작-->
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

	sum1.value = parseInt(hm.value) * trip_cost1;
	sum2.value = parseInt(hm2.value) * trip_cost2;
	sum3.value = parseInt(hm3.value) * trip_cost3;
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

	sum1.value = parseInt(hm.value) * trip_cost1;
	sum2.value = parseInt(hm2.value) * trip_cost2;
	sum3.value = parseInt(hm3.value) * trip_cost3;
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

	sum1.value = parseInt(hm.value) * trip_cost1;
	sum2.value = parseInt(hm2.value) * trip_cost2;
	sum3.value = parseInt(hm3.value) * trip_cost3;
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
			sum1.value = parseInt(hm.value) * trip_cost1;
			sum2.value = parseInt(hm2.value) * trip_cost2;
			sum3.value = parseInt(hm3.value) * trip_cost3;
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
			sum1.value = parseInt(hm.value) * trip_cost1;
			sum2.value = parseInt(hm2.value) * trip_cost2;
			sum3.value = parseInt(hm3.value) * trip_cost3;
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
			sum1.value = parseInt(hm.value) * trip_cost1;
			sum2.value = parseInt(hm2.value) * trip_cost2;
			sum3.value = parseInt(hm3.value) * trip_cost3;
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
	sum1.value = parseInt(hm.value) * trip_cost1;
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
	sum2.value = parseInt(hm2.value) * trip_cost2;
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
	sum3.value = parseInt(hm3.value) * trip_cost3;
	tr_price.value= parseInt(sum1.value+sum2.value+sum3.value);
}
</script>

<div style="float:right; text-align: right; width: 30%;">
<br>
<form name="form" method="post" action="${root}/trip_reser/trip_reser_insert.do">
	<h2>인원선택</h2>
	<table align="right">
	<tr>
		<td width="100px" height="100px" style="text-align: center;">성인<br>${dto.trip_cost1}원</td> 
		<td width="200px;"><input type=hidden name="trip_cost1" value="${dto.trip_cost1}">
		<input type="text" name="tr_adult" value="0" size="3" onchange="change();">
		<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"></td>
	</tr>
	<tr>
		<td width="100px" height="100px" style="text-align: center;">청소년<br>${dto.trip_cost2}원</td> 
		<td width="200px;"><input type=hidden name="trip_cost2" value="${dto.trip_cost2}">
		<input type="text" name="tr_kid" value="0" size="3" onchange="change2();">
		<input type="button" value=" + " onclick="add2();"><input type="button" value=" - " onclick="del2();"></td>
	</tr>
	<tr>
		<td width="100px" height="100px" style="text-align: center;">유아<br>${dto.trip_cost3}원</td> 
		<td width="200px;"><input type=hidden name="trip_cost3" value="${dto.trip_cost3}">
		<input type="text" name="tr_baby" value="0" size="3" onchange="change3();">
		<input type="button" value=" + " onclick="add3();"><input type="button" value=" - " onclick="del3();"></td>
	</tr>

	<tr>
		<td style="text-align: center;">총금액</td> 
		
		<td><input type="text" id="tr_price" name="tr_price" size="11" readonly>원</td>
	</tr>
	</table>
	
	<input type="hidden" name="sum1" size="11" readonly>
	<input type="hidden" name="sum2" size="11" readonly>
	<input type="hidden" name="sum3" size="11" readonly>
	
	<input type="hidden" id="th_code" name="trip_code" value="${dto.trip_code}"> 
	<input type="hidden" id="tu_id" name="tu_id" value="${sessionScope.s_tu_id}">

	<br><br><br><br><br><br><br><br><br><br><br>
	<input type="button" value="이전" class="btn btn-danger" onclick="javascript:history.back()">
	<input type="submit" value="예약" class="btn btn-primary">
</form>
</div>
<hr>
<div style="clear: both;">
</div>

<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
