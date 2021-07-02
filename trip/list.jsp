<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<style>
div.gallery {
  margin: 30px;
  border: 1px solid #ccc;
  float: left;
  width: 300px;
  height: 400px;
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
  height: auto;
}

div.desc {
  padding: 15px;
  text-align: center;
}
</style>

<h2>상품 목록</h2>


<div class="container">

<c:forEach var="dto" items="${list}">
<div class="gallery">
  <a href="trip_read.do?trip_code=${dto.trip_code}">
    <img src="./thumbnail/${dto.trip_thumbnail}" style="width: 100%; height: 45%;">
  </a>
  <div class="desc">
  	<a href="trip_read.do?trip_code=${dto.trip_code}">
  	<span style="font-size: 20px; font-weight: bold;">[${dto.trip_area}] ${dto.trip_name}</span></a> 
  	<br><br> 
  	<div style="text-align: left;"><span style="font-family: sans-serif;">${dto.trip_cost1}원~</span> &nbsp;&nbsp;&nbsp;&nbsp;<span style="color: red">20%할인</span>
  	<br><br>예약가능인원 : ${dto.trip_possible}명
  	</div>
  </div>
</div>
</c:forEach>

</div>

<div style="clear: both;"></div>

<%@ include file="../footer.jsp" %>        
