<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<body>
	<div class="title">항공권 테이블</div>
	<form name='frm' method='POST' action='ticket.do'>
		<table class='table'>
			<tr>
				<th>항공권 등록</th>
			</tr>
			<tr>
				<th>항공권 코드</th>
				<td><input type='text' name='ta_code' size='10'
					placeholder='코드'></td>
			</tr>
			<tr>
				<th>출발장소</th>
				<td><input type='text' name='ta_dep' size='10'
					placeholder='출발장소'></td>
			</tr>
			<tr>
				<th>도착장소</th>
				<td><input type='text' name='ta_arr' size='10'
					placeholder='도착장소'></td>
			</tr>
			<tr>
				<th>예약가능 인원</th>
				<td><input type='number' name='ta_pax' size='10'
					placeholder='예약가능인원'></td>
			</tr>
			<tr>
				<th>비행기모델</th>
				<td><input type='text' name='ta_flightnum' size='10'
					placeholder='모델명'></td>
			</tr>
			<tr>
				<th>출발일시</th>
				<td><input type='text' name='ta_sdate' size='20'
					placeholder='출발일시'></td>
			</tr>
			<tr>
				<th>도착일시</th>
				<td><input type='text' name='ta_fdate' size='20'
					placeholder='도착일시'></td>
			</tr>
			<tr>
				<th>상품코드</th>
				<td><input type='text' name='trip_code' size='10'
					placeholder='상품코드'></td>
			</tr>
		</table>
		<div class='row text-center'>
			<input type='submit' value='등록'> <input type='button'
				value='취소' onclick="location.href='../index.do'">
		</div>
	</form>
</body>

<%@ include file="../footer.jsp"%>
