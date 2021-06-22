<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- logout.jsp --%>
<%
	//세션변수 제거
	session.removeAttribute("s_tu_id");
	session.removeAttribute("s_tu_pw");
	session.removeAttribute("s_tu_rank");
	
	//페이지 이동
	response.sendRedirect("loginForm.do");
%>