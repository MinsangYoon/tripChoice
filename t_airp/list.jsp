<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

	<div class="title" style = "text-align:center">티켓 예약하기</div><br>

	<table class="table table-bordered" style="width:70%; height: 100px; margin: auto; text-align: center;">
		<tr id="table_title" style="background-color: gray; color: white;">
			<th>티켓번호</th>
			<th>출발지</th>
			<th>도착지</th>
			<th>출발일시</th>
			<th>도착일시</th>
			<th>여분좌석</th>
			<th>예약</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr class="airp">
				<td>${dto.ta_code}</td>
				<td>${dto.ta_dep}</a></td>
				<td>${dto.ta_arr}</a></td>
				<td>${dto.ta_sdate}</a></td>
				<td>${dto.ta_fdate}</a></td>
				<td>${dto.ta_pax}</a></td>
				<td><input type="button" value="예약"
					onclick="location.href='../airp_reser/reser.do?ta_code=${dto.ta_code}'">
				</td>
				<td><input type="button" value="삭제"
					onclick="location.href='delete.do?ta_code=${dto.ta_code}'">
				</td>

			</tr>
		</c:forEach>
	</table>


<br>

<%@ include file="../footer.jsp"%>