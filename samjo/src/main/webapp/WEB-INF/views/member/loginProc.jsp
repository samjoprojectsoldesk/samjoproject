<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
<!-- 본문시작 loginProc.jsp -->
<aside id="fh5co-hero" class="js-fullheight">
			<div class="flexslider js-fullheight">
				<div class="container">
					<div class="slider-text-inner desc">
						<h2 style="margin-top: 300px; text-align: center; font-weight: bold;" class="heading-section">로그인결과</h2>
						<%
							String user_id	 =request.getParameter("user_id").trim();
							String user_pw    =request.getParameter("user_pw").trim();
							dto.setUser_id(user_id);
							dto.setUser_pw(user_pw);
							
							String user_level=dao.loginProc(dto); 
							if(user_level==null){
								out.println("<p>아이디/비밀번호 다시 한번 확인해주세요!!</p>");
								out.println("<p><a href='javascript:history.back()'>[다시시도]</p>");
							}else{
								//로그인 성공
								//out.print("로그인성공~~");
								//out.print("회원등급:" + mlevel);
								
								//다른페이지에서 로그인 상태정보를 공유할 수 있도록(session)
								session.setAttribute("s_id", user_id);
								session.setAttribute("s_passwd", user_pw);
								session.setAttribute("s_mlevel", user_level);
								
								//쿠키시작----------------------------------------
								//->웹서버가 사용자PC에 저장하는 텍스트 파일로 된 정보
								//->각 브라우저의 쿠키삭제의 영향을 받는다
								//->보안에 취약하다
								//->예)아이디저장, 오늘창그만보기, 클릭한상품목록
								//->예)오늘창그만보기는 자바스크립트 쿠키. 참조)https://www.w3schools.com/js/js_cookies.asp
								
								//<input type=checkbox name=c_id calue="SAVE"> 값 가져오기
								String c_id=Utility.checkNull(request.getParameter("c_id"));
								Cookie cookie=null;
								if(c_id.equals("SAVE")){ //아이디저장에 체크를 했다면
									//쿠기변수선언 new Cookie("변수명", 값)
									cookie=new Cookie("c_id", user_id);
									//쿠키의 생존기간 1개월
									cookie.setMaxAge(60*60*24*30); //각 브라우저의 쿠키삭제의 영향을 받는다
								}else{
									cookie=new Cookie("c_id", "");
									cookie.setMaxAge(0);
								}//if end
								
								response.addCookie(cookie); //요청한 사용자 PC에 쿠키값을 저장
								//쿠키끝-----------------------------------------
								
								//첫페이지로 이동
								//http://localhost:9090/myweb/index.jsp
								response.sendRedirect("./loginForm.do");
								
							}//if end
							
						%>
				</div>
			</div>
		</div>
</aside>

<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>