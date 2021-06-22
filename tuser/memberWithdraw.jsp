<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 memberWithdraw.jsp-->
<!-- 아이디(id)와 비밀번호(passwd)가 일치하면 삭제 -->
<h3>* 회원 탈퇴 *</h3>
<div class="container">
	<form method="post" action="memberWithdrawProc.do" onsubmit="return memberWithdraw()">
		<table class="table">
		<tr>
			<th class="success">비밀번호</th>
			<td><input type="password" name="tu_pw" id="tu_pw" required></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원탈퇴" class="btn btn-danger">
				<a href="<%=request.getContextPath()%>/loginForm.do" class="btn btn-primary">뒤로가기</a>
		    </td>
		</tr>	
		</table>
	</form>
</div>	
<!-- 본문 끝-->
        
<%@ include file="../footer.jsp" %>        