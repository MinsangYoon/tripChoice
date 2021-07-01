<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- ck에디터 활용 -->
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>

<!-- 본문 시작-->
<h2 align="center"> 여행상품 수정 </h2>
<!-- 관리자만 작성 가능 -->
<c:if test="${sessionScope.s_tu_rank =='admin'}">
<div class="container">
	<form name="tripfrm" id="tripfrm" method="post" action="trip_update.do" enctype="multipart/form-data">
	<span style="color:red; font-weight: bold">로그인된 id : ${sessionScope.s_tu_id }</span>
	<br>
	<table class="table">
	<tr>
	    <th class="info">*상품코드</th>
	    <td style="text-align:left">
	      <input type="text" name="trip_code" id="trip_code" size="15" required value="${dto.trip_code}">
	    </td>
	</tr>
	<tr>
	    <th class="info">*상품명</th>
	    <td style="text-align:left">
	    <input type="text" name="trip_name" id="trip_name" size="15" required value="${dto.trip_name}">
	    </td>
	</tr>
	<tr>
	    <th class="info">*지역</th>
	    <td style="text-align:left">
	    <input type="text" name="trip_area" id="trip_area" size="15" required value="${dto.trip_area}">
	    </td>
	</tr>
	<tr>
	    <th class="info">*상세설명</th>
	    <td style="text-align:left">
	    <textarea rows="10" cols="60" name="trip_content" id="trip_content" required>${dto.trip_content}</textarea>
	    <script type="text/javascript">
		 	CKEDITOR.replace('trip_content', {
		 		filebrowserUploadUrl : "imageUpload.do" <!--TripImageUpload.java로 이동-->	
		 	});
		</script>  
	    </td>
	</tr>
	<tr>
	    <th class="info">*성인가격</th>
	    <td style="text-align:left">
	    <input type="number" name="trip_cost1" id="trip_cost1" required min="0" value="${dto.trip_cost1}">
	    </td>
	</tr>
	<tr>
	    <th class="info">*청소년가격</th>
	    <td style="text-align:left">
	    <input type="number" name="trip_cost2" id="trip_cost2" required min="0" value="${dto.trip_cost2}">
	    </td>
	</tr>
	<tr>
	    <th class="info">*유아가격</th>
	    <td style="text-align:left">
	    <input type="number" name="trip_cost3" id="trip_cost3" required min="0" value="${dto.trip_cost3}">
	    </td>
	</tr>
	<tr>
	    <th class="info">*패키지예약가능인원</th>
	    <td style="text-align:left">
	    <input type="number" name="trip_possible" id="trip_possible" required min="0" value="${dto.trip_possible}">
	    </td>
	</tr>
	<tr>
	    <th class="info">항공권가격</th>
	    <td style="text-align:left">
	    <input type="number" name="trip_airpcost" id="trip_airpcost" required min="0" value="${dto.trip_airpcost}">
	    </td>
	</tr>
	<tr>
	    <th class="info">숙소가격</th>
	    <td style="text-align:left">
	    <input type="number" name="trip_bedcost" id="trip_bedcost" required min="0" value="${dto.trip_bedcost}">
	    </td>
	</tr>
	<tr>
	      <th class="info">*썸네일</th>
	      <td><input type='file' name='thumbnailMF' size='50' value="${dto.trip_thumbnail}"></td>    
	</tr>
	<tr>  
  		<th class="info">예약진행상황</th>
 		 <td style="text-align:left"><select name="trip_situation" id="trip_situation" value="${dto.trip_situation}">
          <option value="Y" selected>예약중</option>
          <option value="N">예약마감</option>
        </select>
  </td>
</tr>
	<tr>
	    <td colspan="2" style="text-align:center">
	        <input type="submit" value="수정"  class="btn btn-info"/>
	        <input type="reset"  value="취소"  class="btn btn-warning"/>
	    </td>
	</tr>
	</table>
	</form>
</div>	
</c:if>

<!-- 관리자가 아닐 때 띄우기 -->
<c:if test="${sessionScope.s_tu_rank !='admin'}">
<div align="center">
    관리자만 접근 가능합니다
    <br>
    <a href="javascript:history.back()">돌아가기</a>
</div> 
</c:if>
<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
