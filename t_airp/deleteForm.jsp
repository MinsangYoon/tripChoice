<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<body>
	<div class=title>티켓 삭제</div>
	<form name='frm' method='POST' action='delete.do'>
	<input type="hidden" name="ta_code" value="${ta_code}">
	<div class="content">
		<p>티켓 진짜 삭제하쉴?</p>
		<p>*선택하신 티켓이 삭제 됩니다.</p>
	</div>
		<div class='bottom'>
			<input type='submit' value='삭제 진행'> 
			<input type='button' value='HOME'  onclick="location.href='${root}/home.do'">
		</div>
	</form>
</body>
<%@ include file="../footer.jsp"%>