<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="auth.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 loginForm.jsp-->
<div style="position: relative; left: 40%">
<h3>* 로 그 인 *</h3>
<%if (s_tu_id.equals("guest") || s_tu_pw.equals("guest") || s_tu_rank.equals("guest")) {
	//로그인을 하지 않은 경우    
    
//쿠키-----------------------------------------------------
	//사용자PC에 저장된 모든 쿠키값 가져오기
	Cookie[] cookies=request.getCookies();
	String c_tu_id="";
	if(cookies!=null){ //쿠키가 존재하는지?
		for(int i=0; i<cookies.length; i++){
		    Cookie cookie=cookies[i];
		    if(cookie.getName().equals("c_tu_id")==true){
		        c_tu_id=cookie.getValue(); //쿠키변수값 가져오기
		    }//if end
		}//for end	    
	}//if end
//---------------------------------------------------------
%>
	<form name="memfrm" id="memfrm" method="post" action="loginProc.do" onsubmit="return loginCheck()"><!-- myscript.js 코딩 -->
		<table>
		<tr>
			<td width="200px">
				<input type="text" name="tu_id" id="tu_id" value="<%=c_tu_id%>" placeholder="아이디" maxlength="10" required>
			</td>
			<td rowspan="2">
				<input type="image" src="../images/bt_login.gif">
				<!-- <input type=image> 기본 속성이 submit -->
			</td>
		</tr>
		<tr>
		   <td>
		      <input type="password" name="tu_pw" id="tu_pw" placeholder="비밀번호" maxlength="10" required>
		   </td>
		</tr>
		<tr>
		   <td colspan="2">
			  <input type="checkbox" name="c_tu_id" value="SAVE" <%if (!(c_tu_id.isEmpty())){out.print("checked");} %>>아이디 저장
			  &nbsp;&nbsp;&nbsp;
			  <a href="agreement.do">회원가입</a>
			  &nbsp;&nbsp;&nbsp;
			  <a href="findID.do">아이디/비번찾기</a>
		   </td>
		</tr>		  
		</table>
	</form>

<%
	} else {
	    //로그인 성공했다면
	    out.println("<strong>" + s_tu_id + "</strong>님");
	    out.println("<a href='logout.do'>[로그아웃]</a>");
	    out.println("<br><br>");
	    out.println("<a href='memberModify.do'>[회원정보수정]</a>");
	    out.println("<a href='memberWithdraw.do'>[회원탈퇴]</a>");
%>
<!-- 관리자만 보임 -->
<c:if test="${sessionScope.s_tu_rank =='admin'}">
	<br><br>관리자입니다.
</c:if>
<%     
	}//if end
%>
</div>
<!-- 본문 끝-->
<br>        
<%@ include file="../footer.jsp" %>        
