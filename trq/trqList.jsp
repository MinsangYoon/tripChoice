<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
 <style>
 	{font-family:gulim; font-size: 24px;}
 </style>
 </head>
<body>	
	<h2 align="center"> 문의사항 </h2>
	<div class="content" align="center">
		<input type="submit" value="문의사항 등록" class="btn btn-danger" onclick="location.href='./trqForm.do'">
		<input type="button" value="HOME"   onclick="location.href='${root}/tripChoice/index.do'" class="btn btn-success" >
	</div>
 <table class="table table-striped">
  <tr>
  	
  	<th>제목</th>
  	<th>내용</th>
  	<th>작성일</th>
  </tr>
  <c:forEach var="dto" items="${list}">
    <tr>
    	
  		<td><a href="trqRead.do?trq_no=${dto.trq_no}">${dto.trq_sub}</a></td>
  		<td>${dto.trq_con}</td>
  		<td>${dto.trq_date}<br></td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>
<%@ include file="../footer.jsp" %>