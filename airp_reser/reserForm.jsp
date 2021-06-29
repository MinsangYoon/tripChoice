<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script>
	$(document).ready(function() {
		var i = 0; // 변수설정은 함수의 바깥에 설정!
		$("#add").click(function() {
			$("#boxwrap").append("<table class='table"+i+"'><input type='hidden' name='ta_code' value='${ta_code}'><input type='hidden' name='tu_id' value='${sessionScope.s_tu_id}'><tr><th>항공권 예약</th></tr><tr><th>좌석번호</th><td><input type='text' name='tar_seat' size='10' placeholder='좌석번호'></td></tr><tr><th>여권 이름</th><td><input type='text' name='tar_name' size='30'placeholder='여권이름'></td></tr><tr><th>여권 번호</th><td><input type='text' name='tar_passcode' size='30'placeholder='여권번호'></td></tr></table>")
			i++; // 함수 내 하단에 증가문 설정
		});
		
		$("#remove").click(function() {
			i--; // 함수 내 상단에 감소문 설정
			
			$( "table.table"+i+"" ).remove();
			
		});
		
	});
	
</script>

	<!-- 버튼 -->
	<div class="btnWrap">
		<button id="add">테이블 추가</button>
		
		<button id="remove">테이블 감소</button>
	</div>
	
    <form name='frm' method='POST' action='reser.do' onsubmit="return airpreserCheck()">
    
    <div id="boxwrap">
    <!-- 테이블 생성 공간 -->
    </div>
    
	 <input type='submit' value='예약하기'>
	</form> 
	
	<script>
	function airpreserCheck() { //로그인 유효성 검사
		//1)여권번호가 M으로 시작하는 8글자인지 체크
	    var tar_passcode=document.getElementById("tar_passcode").value;
	    tar_passcode=tar_passcode.trim();
	    if(!(tar_passcode.length==8 && tar_passcode.charAt(0)=='M')){
	    	alert("여권번호를 M이 포함된 8글자로 입력하세요");
	    	document.getElementById("tar_passcode").focus();
	    	return false;
	    }//if end
		return true;
		alert("예약 성공");
	}//airpreserCheck() end
	</script>


<%@ include file="../footer.jsp"%>