<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 memberWithdrawProc.jsp-->
<h3>* 회원탈퇴 *</h3>
<%
	String tu_id    =(String)session.getAttribute("s_tu_id");
	String tu_pw=request.getParameter("tu_pw").trim();
	
	dto.setTu_id(tu_id);
	dto.setTu_pw(tu_pw);
	
	int cnt=dao.withdraw(dto); 
	if(cnt==0){
	    out.println("<p>비밀번호가 일치하지 않습니다</p>");
	    out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
	    //세션 정보 모두 삭제하기
	    session.removeAttribute("s_tu_id");
	    session.removeAttribute("s_tu_pw");
	    session.removeAttribute("s_tu_rank");
	    
	    out.println("<script>");
	    out.println("  alert('회원 탈퇴 되었습니다~~');");
	    out.println("  location.href='loginForm.do'");
	    out.println("</script>");
	}//if end	
%>
<!-- 본문 끝-->
        
<%@ include file="../footer.jsp" %>        