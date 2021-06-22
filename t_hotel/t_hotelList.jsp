<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작-->
    <table class="table table-bordered">
    <thead style="background-color: gray;">
    <tr style="color: white">
    	<th>숙소명</th>
    	<th>지역</th>
    	<th>방 호수</th>
    	<th>최대예약가능인원</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach var="dto" items="${list}">
    <tr>
    	<th><a href="read.do?th_code=${dto.th_code}">${dto.th_name}</a></th>
    	<th>${dto.th_reg}</th>
    	<th>${dto.th_room}</th>
    	<th>${dto.th_max}</th>
    </tr>
    </c:forEach>
    </tbody>	
    </table>
<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
