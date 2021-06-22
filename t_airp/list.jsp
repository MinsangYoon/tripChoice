<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<body>
	<div class="title">티켓 예약하기</div>

	<div class="content "></div>
	<table class="text-center">
		<tr id="table_title">
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

		<c:forEach var="i" begin="0" end="3">

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


</body>

<%@ include file="../footer.jsp"%>
