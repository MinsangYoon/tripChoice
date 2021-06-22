<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheckForm.jsp</title>
</head>
<body>
  <div style="text-align: center">
    <h3>* 아이디 중복확인 *</h3>
    <form action="idCheckProc.do" onsubmit="return blankCheck()">
    	아이디 : <input type="text" name="tu_id" id="tu_id" maxlength="10" autofocus>
               <input type="submit" value="중복확인">
    </form>
  </div>
  
  <script>
  function blankCheck(){
	 var tu_id=document.getElementById("tu_id").value;
	 tu_id=tu_id.trim();
	 if(tu_id.length<5){
	    alert("아이디는 5글자 이상 입력해 주세요");
	    return false;
	 }//if end
	 return true;
  }//blankCheck() end
  </script>
  
</body>
</html>