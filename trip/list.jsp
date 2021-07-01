<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<style>
 	{font-family:gulim; font-size: 24px;}
 </style>

<!-- 본문 시작-->
<div class="content" align="center">
	<!--  admin 사용자만 상품등록 버튼 활성화 -->
	<c:if test="${sessionScope.s_tu_rank =='admin'}">
		<input type="button" value="여행상품등록" onclick="location.href='createForm.do'"  class="btn btn-info" >
	</c:if>	
		<input type="button" value="HOME"   onclick="location.href='${root}/index.do'" class="btn btn-success" >
		
</div>
<hr>
	
    <table class="table table-bordered" style="width: 70%; margin-left: auto; margin-right: auto;">
    <thead style="background-color: gray;" >
    <tr style="color: white;">
    	<th style="text-align: center;">사진</th>
    	<th style="text-align: center;">상품명</th>
    	<th style="text-align: center;">지역</th>
    	<th style="text-align: center;">가격</th>
    	<th style="text-align: center;">패키지예약가능인원</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach var="dto" items="${list}">
    <tr>
    	<th width="200px"><img src="./thumbnail/${dto.trip_thumbnail}" width="200px" height="200px"></th>
    	<th><a href="trip_read.do?trip_code=${dto.trip_code}">${dto.trip_name}</a></th>
    	<th>${dto.trip_area}</th>
    	<th>${dto.trip_cost1}원</th>
    	<th>${dto.trip_possible}명</th>
    </tr>
    </c:forEach>
    </tbody>	
    </table>
    
    <!-- 검색시작 -->
		<table align="center">
		<tr >
      		<td colspan="4" style="text-align: center; height: 50px">
      			<form action="trip_list_admin.do" onsubmit="return searchCheck()">
      				<select name="col">
      					<option value="trip_area">지역</option>
      					<option value="trip_name">상품명</option>
      				</select>
				    <input type="text" name="word" id="word">
		            <input type="submit" value="검색" class="btn btn-info">
      			</form>
      		</td>
		</tr>
		</table>
		<!-- 검색끝 -->
<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
