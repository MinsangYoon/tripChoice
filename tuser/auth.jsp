<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- auth.jsp 공통코드 --%>
<%-- 로그인 상태 정보 확인 --%>
<%
	String s_tu_id="";
	String s_tu_pw="";
	String s_tu_rank="";
	
	if(session.getAttribute("s_tu_id")==null || session.getAttribute("s_tu_pw")==null || session.getAttribute("s_tu_rank")==null) {
	    //로그인하지 않았다면
	    s_tu_id="guest";
	    s_tu_pw="guest";
	    s_tu_rank="guest";
	    
	}else{
	    //로그인 성공 했다면
	    s_tu_id		=(String)session.getAttribute("s_tu_id");
	  	s_tu_pw		=(String)session.getAttribute("s_tu_pw");
	  	s_tu_rank	=(String)session.getAttribute("s_tu_rank");
	    
	}//if end
%>