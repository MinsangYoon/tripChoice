<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 trqDel.jsp-->
<!-- 글번호(trq_no)가 일치하면 삭제 -->
<h3> 문의사항 삭제</h3>
<p><a href="trqList.jsp">문의사항</a></p>
<div class="container">
	<form method="post" action="trqDelProc.jsp" onsubmit="return pwCheck()">
		<input type="text" name="tbrq_no" value="<%=request.getParameter("trq_no")%>">
		<table class="table">
		<tr>
			<td colspan="2">
				<input type="submit" value="삭제" class="btn btn-danger">
		    </td>
		</tr>	
		</table>
	</form>
</div>	
<!-- 본문 끝-->
        
<%@ include file="../footer.jsp" %>  