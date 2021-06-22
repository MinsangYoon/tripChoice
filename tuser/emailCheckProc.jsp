<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emailCheckProc.jsp</title>
</head>
<body>
  <div style="text-align: center">
    <h3>* Email 중복확인 결과 *</h3>
<%
	String tu_email=request.getParameter("tu_email").trim();
	int cnt=dao.duplecateEmail(tu_email); 
	out.println("입력Email : <strong>" + tu_email + "</strong>"); 
	if(cnt==0){
	    out.println("<p>사용 가능한 Email입니다</p>");
	    out.println("<a href='javascript:apply(\"" + tu_email + "\")'>[적용]</a>");
%>
		<script>
			function apply(tu_email) {	alert(tu_email);	
				opener.memfrm.tu_email.value=tu_email;
				window.close();
			}//apply() end
		</script>
<%	    
	}else{
	    out.println("<p style='color:red'>해당 Email는 사용할 수 없습니다!!</p>");
	}//if end
%>    
    <hr>
    <a href="javascript:history.back()">[다시검색]</a>
    &nbsp;&nbsp;
    <a href="javascript:window.close()">[창닫기]</a>

  </div>
</body>
</html>