<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- ssi.jsp 공통코드 --%>

<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="net.utility.*"%>
<%@page import="kr.co.tripChoice.trq.*"%> 

<jsp:useBean id="dao" class="kr.co.tripChoice.trq.TrqDAO" scope="page"></jsp:useBean>
<jsp:useBean id="dto" class="kr.co.tripChoice.trq.TrqDTO" scope="page"></jsp:useBean>

<% request.setCharacterEncoding("UTF-8"); %>


<%
	//검색
	String col=request.getParameter("col");   //칼럼
	String word=request.getParameter("word"); // 검색어
	col = Utility.checkNull(col);    		  // 문자열값이 null이면 빈문자열로 치환
	word = Utility.checkNull(word);
	
	//현재 페이지
	int nowPage=1;
	if (request.getParameter("nowPage")!=null) {
		nowPage=Integer.parseInt(request.getParameter("nowPage"));
	}//if end
%>