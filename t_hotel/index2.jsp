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
    <li><img src="./storage/JSH101_1.jpg"/></li>
    <li><img src="./storage/JSH101_2.jpg"/></li>
    <li><img src="./storage/JSH101_3.jpg"/></li>
  </ul>

</div>
<div id="container-fluid" style="width: 500px; height: 500px; float: right;">
	숙소명<br>
	방번호<br>
</div>

<div style="clear: both;">

</div>


<%@ include file="../footer.jsp" %>        
