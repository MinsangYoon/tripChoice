<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작-->
<div>
    ${dto.th_content}
</div>

<div style="clear: both; text-align: right;">
<hr>
방 호수 : ${dto.th_room}호 <br>
최대예약가능인원 : ${dto.th_max}명
<form name="hotel_reser" method="post" action="${root}/hotel_reser/insert2.do">
	<!--
		hidden속성으로 th_code를 다음 페이지(숙소예약테이블에 insert)로 넘겨준다. 
		아이디는 세션에 올린 값 사용.
		넘겨줄 상품코드(trip_code) 값은 소스코드 서로 합친 뒤에 추가하겠음
	-->
	<input type="hidden" id="th_code" name="th_code" value="${dto.th_code}"> 

	예약인원 : <input type="number" min="1" max="${dto.th_max}" id="thr_memeber" name="thr_member"> <br>
	<input type="button" value="이전" class="btn btn-danger" onclick="javascript:history.back()">
	<input type="submit" value="예약" class="btn btn-primary">
	
</form>
</div>
<hr>
<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
