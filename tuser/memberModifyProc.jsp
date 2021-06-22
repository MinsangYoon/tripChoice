<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 memberModifyProc.jsp-->
<h3>* 회원수정 결과 *</h3>
<%
	//1)사용자가 요청한 값 가져오기
	String tu_id    	=(String)session.getAttribute("s_tu_id");
	String tu_pw		=request.getParameter("tu_pw").trim();
	String tu_name		=request.getParameter("tu_name").trim();
	String tu_email		=request.getParameter("tu_email").trim();
	String tu_phone		=request.getParameter("tu_phone").trim();
	String tu_zipcode	=request.getParameter("tu_zipcode").trim();
	String tu_address	=request.getParameter("tu_address").trim();
	String tu_address2	=request.getParameter("tu_address2").trim();

	//2)dto객체에 담기
	dto.setTu_id(tu_id);
	dto.setTu_pw(tu_pw);
	dto.setTu_name(tu_name);
	dto.setTu_email(tu_email);
	dto.setTu_phone(tu_phone);
	dto.setTu_zipcode(tu_zipcode);
	dto.setTu_address(tu_address);
	dto.setTu_address2(tu_address2);

	//3)DB에 추가하기
	int cnt=dao.modify(dto); 
	if(cnt==0){
	    out.println("<p>회원정보 수정 실패했습니다!!</p>");
	    out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
	    out.println("<script>");
	    out.println("  alert('회원 정보 수정 되었습니다~~');");
	    out.println("  location.href='memberModify.do'");
	    out.println("</script>");
	}//if end
%>
<!-- 본문 끝-->
        
<%@ include file="../footer.jsp" %>        