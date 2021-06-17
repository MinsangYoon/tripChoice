<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- ck에디터 활용 -->
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>

<!-- 본문 시작-->
<form name="memfrm" id="memfrm" method="post" action="create.do">
<span style="color:red; font-weight: bold">* 필수입력</span>
<br>
<table class="table">
<tr>
    <th>*숙소코드</th>
    <td style="text-align:left">
      <input type="text" name="th_code" id="th_code" size="15">
    </td>
</tr>
<tr>
    <th>*숙소이름</th>
    <td style="text-align:left">
    <input type="text" name="th_name" id="th_name" size="15">
    </td>
</tr>
<tr>
    <th>*방 번호</th>
    <td style="text-align:left">
    <input type="text" name="th_room" id="th_room" size="15">
    </td>
</tr>
<tr>
    <th>*지역</th>
    <td style="text-align:left">
    <input type="text" name="th_reg" id="th_reg" size="15">
    </td>
</tr>
<tr>
    <th>*상세설명</th>
    <td style="text-align:left">
    <textarea rows="10" cols="60" name="th_content" id="th_content"></textarea>
    <script type="text/javascript">
	 	CKEDITOR.replace('th_content', {
	 		filebrowserUploadUrl : "imageUpload.do"
	 	});
	</script>

  
    </td>
</tr>
<tr>
    <th>최대인원</th>
    <td style="text-align:left">
    <input type="number" name="th_max" id="th_max" >
    </td>
</tr>
<tr>
    <td colspan="2" style="text-align:center">
        <input type="submit" value="숙소등록"  class="btn btn-primary"/>
        <input type="reset"  value="취소"  class="btn btn-primary"/>
    </td>
</tr>
</table>
</form>
<!-- 본문 끝-->

<%@ include file="../footer.jsp" %>        
