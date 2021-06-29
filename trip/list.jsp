<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작-->
    <table class="table table-bordered">
    <thead style="background-color: gray;">
    <tr style="color: white">
    	<th>사진</th>
    	<th>상품명</th>
    	<th>지역</th>
    	<th>가격</th>
    	<th>패키지예약가능인원</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach var="dto" items="${list}">
    <tr>
    	<th width="200px"><img src="./thumbnail/${dto.trip_thumbnail}" width="200px" height="200px"></th>
    	<th><a href="trip_read.do?trip_code=${dto.trip_code}">${dto.trip_name}</a></th>
    	<th>${dto.trip_area}</th>
    	<th>${dto.trip_cost1}</th>
    	<th>${dto.trip_possible}</th>
    </tr>
    </c:forEach>
    </tbody>	
    </table>
<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
