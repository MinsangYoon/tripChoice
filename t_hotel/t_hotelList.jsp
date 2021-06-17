<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작-->
    <c:forEach var="dto" items="${list }">
    숙소코드 : ${dto.th_code }<br>
    숙소이름 : ${dto.th_name }<br>
    방 호실 : ${dto.th_room }<br>
    지역 : ${dto.th_reg }<br>
    상세설명 : ${dto.th_content }<br>
    최대인원 : ${dto.th_max }<hr>
    
    </c:forEach>
<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
