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
<!-- 본문 시작-->



<div class="container">

<c:forEach var="dto" items="${list}">
<div class="gallery">
  <a href="t_hotel_read.do?th_code=${dto.th_code}">
    <img src="./thumbnail/${dto.th_thumbnail}" style="width: 100%; height: 45%;">
  </a>
  <div class="desc">
  	<a href="t_hotel_read.do?th_code=${dto.th_code}">
  	<span style="font-size: 18px; font-weight: bold;">${dto.th_name}</span></a> 
  	<br> 
  	<div style="text-align: left;">
  	<span style="font-size: 15px; font-weight: bold;">${dto.th_reg }</span><br><br>
  	<span style="font-family: sans-serif;">1박 <span style="color: red">${dto.th_cost1}원~</span></span>
    <br>최대예약가능인원 : ${dto.th_max}명
  	</div>
  </div>
</div>
</c:forEach>

</div>

<div style="clear: both;"></div>

<%@ include file="../footer.jsp" %>        
