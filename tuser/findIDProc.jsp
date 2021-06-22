<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 findIDProc.jsp -->
<h3>* 아이디/비번 찾기 결과 *</h3>
<%
  String tu_name    =request.getParameter("tu_name").trim();
  String tu_email	=request.getParameter("tu_email").trim();
  dto.setTu_name(tu_name);
  dto.setTu_email(tu_email);
  boolean flag=dao.findID(dto);  
  if(flag==false){
    out.println("<p>이름/이메일을 다시 한번 확인해주세요!!</p>");
    out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
  }else{
	out.println("<p>아이디/임시 비밀번호가 이메일로 전송되었습니다</p>");
	out.println("<p>임시 비밀번호는 로그인 후 회원정보수정에서 수정하시기 바랍니다</p>");
	out.println("<p><a href='loginForm.do'>[로그인]</a></p>");

  }//if end
%>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>    