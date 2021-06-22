<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 loginProc.jsp-->
<h3>* 로 그 인 결과 *</h3>
<%
	String tu_id    =request.getParameter("tu_id").trim();
	String tu_pw	=request.getParameter("tu_pw").trim();
	dto.setTu_id(tu_id);
	dto.setTu_pw(tu_pw);
	String tu_rank=dao.loginProc(dto);
	if(tu_rank==null){
	    out.println("<p>아이디/비번 다시 한번 확인해주세요!!</p>");
	    out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
	    //로그인 성공
	    //out.print("로그인 성공!!");
	    //out.print("회원등급 : " + mlevel);
	    
		//다른 페이지에서 로그인 상태정보를 공유할 수 있도록
	    session.setAttribute("s_tu_id", tu_id);
	    session.setAttribute("s_tu_pw", tu_pw);
	    session.setAttribute("s_tu_rank", tu_rank);
	    
//쿠키 시작--------------------------------------------------	    
        //->서버가 사용자PC에 저장하는 텍스트 파일로 된 정보
        //->각 브라우저의 쿠키삭제의 영향을 받는다
        //->보안에 취약하다
        //->예)아이디저장, 클릭한 상품목록, 오늘창그만보기

		//<input type=checkbox name=c_id>값 가져오기
		String c_tu_id=Utility.checkNull(request.getParameter("c_tu_id"));
		Cookie cookie=null;
		if(c_tu_id.equals("SAVE")){ //아이디저장 체크를 했다면
		    //쿠키변수선언) new Cookie("쿠키변수명", 값)
			cookie=new Cookie("c_tu_id", tu_id);
		    //쿠키의 생존기간 1개월
		    cookie.setMaxAge(60*60*24*30);
		}else{
		    cookie=new Cookie("c_tu_id", "");
		    cookie.setMaxAge(0);
		}//if end
		
		//요청한 사용자PC에 쿠키값을 저장
		response.addCookie(cookie);
//쿠키 끝---------------------------------------------------
	    
	    //첫페이지로 이동
	    String root=Utility.getRoot();    // /myweb반환
	    response.sendRedirect(root+"/index.do"); 
	    
	}//if end
%>

<!-- 본문 끝-->
        
<%@ include file="../footer.jsp" %>        