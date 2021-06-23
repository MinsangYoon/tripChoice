<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작-->

<!-- 관리자만 작성 가능 -->
<c:if test="${sessionScope.s_tu_rank =='admin'}">
	<br>
    <form action="t_hotel_delete.do" method="post">
    	<input type="hidden" id="tu_id" name="tu_id" value="${sessionScope.s_tu_id}">
    	<input type="hidden" id="th_code" name="th_code" value="${th_code}">
    	<input type="password" id="tu_pw" name="tu_pw" placeholder="비밀번호를 입력해주세요">
    	<input type="submit" value="삭제" class="btn btn-danger" min="5"> 
    </form>
	<br>
</c:if>    


<!-- 관리자가 아닐 때 띄우기 -->
<c:if test="${sessionScope.s_tu_rank !='admin'}">
<div align="center">
    관리자만 접근 가능합니다
    <br>
    <a href="javascript:history.back()">돌아가기</a>
</div> 
</c:if>

<!-- 본문 끝-->
<%@ include file="../footer.jsp" %>        
