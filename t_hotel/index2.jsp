<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp" %>
<style>
  *{margin:0;padding:0;}
  ul,li{list-style:none;}
  #slide{height:300px;position:relative;overflow:hidden;}
  #slide ul{width:400%;height:100%;transition:1s;}
  #slide ul:after{content:"";display:block;clear:both;}
  #slide li{float:left;width:25%;height:100%;}
  #slide li:nth-child(1)
  #slide li:nth-child(2)
  #slide li:nth-child(3)
  #slide li:nth-child(4)
  #slide input{display:none;}
  #slide label{display:inline-block;vertical-align:middle;width:10px;height:10px;border:2px solid #666;background:#fff;transition:0.3s;border-radius:50%;cursor:pointer;}
  #slide .pos{text-align:center;position:absolute;bottom:10px;left:0;width:100%;text-align:center;}
  #pos1:checked~ul{margin-left:0%;}
  #pos2:checked~ul{margin-left:-100%;}
  #pos3:checked~ul{margin-left:-200%;}
  #pos4:checked~ul{margin-left:-300%;}
  #pos1:checked~.pos>label:nth-child(1){background:#666;}
  #pos2:checked~.pos>label:nth-child(2){background:#666;}
  #pos3:checked~.pos>label:nth-child(3){background:#666;}
  #pos4:checked~.pos>label:nth-child(4){background:#666;}
</style>
<div id="slide" style="width: 50%; height: 500px; float: left; align: center;">
  <input type="radio" name="pos" id="pos1" checked>
  <input type="radio" name="pos" id="pos2">
  <input type="radio" name="pos" id="pos3">
  <ul>
    <li><img src="./storage/JSH101_1.jpg" width="100%" height="100%"/></li>
    <li><img src="./storage/JSH101_2.jpg" width="100%" height="100%"/></li>
    <li><img src="./storage/JSH101_3.jpg" width="100%" height="100%"/></li>
  </ul>
</div>
<div style="width: 600px; height: 500px; float: right; text-align: left;">
	<br>
	<h1>제주신라호텔</h1>
	Jeju Shilla Hotel<br>
	<hr>
	<table>
	<tr>
		<th width="300px">- 무료 Wi-Fi</th>
		<th>- 레스토랑</th>
	</tr>
	<tr>
		<th>- 24시간 프런트 데스크</th>
		<th>- 룸서비스</th>
	</tr>
	<tr>
		<th>- 도서관</th>
		<th>- 렌터카</th>
	</tr>
	</table>
	
	<hr>
	
	<span style="font-size: 15px">제주특별자치도 서귀포시 중문관광로 72번길 75<br>
	전화 064-735-5114<br>
	팩스 82-64-7359105<br>
	체크인 3:00 PM, 체크아웃 11:00 AM 
	</span>
</div>

<div style="clear: both; text-align: right;">
<hr>
방 호수 : 101호 <br>
최대예약가능인원 : 4명<br>
<form name="hotel_reser" method="post" action="${root}/hotel_reser/insert2.do">
	예약인원 : <input type="number" min="1" max="${dto.th_max}" id="thr_memeber" name="thr_member"> 
	<input type="submit" value="예약" class="btn btn-primary">
</form>
</div>

<%@ include file="../footer.jsp" %>        
