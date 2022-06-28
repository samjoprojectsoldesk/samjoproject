<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%
if (s_id.equals("guest") || s_passwd.equals("guest") || s_mlevel.equals("guest")) {

	//아이디저장 쿠키 확인------------------------
	//사용자PC에 저장된 모든 쿠키값 가져오기
	Cookie[] cookies = request.getCookies();
	String c_id = "";
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) { //모든 쿠키값 가져오기
			Cookie cookie = cookies[i]; //쿠키 하나씩 가져오기
			if (cookie.getName().equals("c_id") == true) {
				c_id = cookie.getValue();//쿠키변수값 가져오기
			} //if end
		} //for end
	} //if end
		//--------------------------------------
%>
		<!-- 본문시작 loginForm.jsp -->
		
		<aside id="fh5co-hero" class="js-fullheight">
			<div class="flexslider js-fullheight">
				<div class="container">
					<div class="slider-text-inner desc">
						<h2 style="margin-top: 300px; text-align: center; font-weight: bold;" class="heading-section">로그인</h2>
						<form name="loginfrm" id="loginfrm" method="post" action="loginProc.do" onsubmit="return loginCheck()"><!-- myscript.js에서 함수 작성 -->
							<table class="table">
								<tr>
									<td><input type="text" name="id" id="id" value="<%=c_id%>" placeholder="아이디" maxlength="10" required></td>
									<td rowspan="2">
										<!-- type=image의 기본속성이 submit --> <input type="image" src="../images/bt_login.gif">
									</td>
								</tr>
								<tr>
									<td><input type="password" name="passwd" id="passwd" placeholder="비밀번호" maxlength="10" required></td>
								</tr>
								<tr>
									<td colspan="2"><label><input type="checkbox" name="c_id" value="SAVE" <%if (!c_id.isEmpty()) {out.print("checked");}%>>아이디 저장</label>
										&nbsp;&nbsp;&nbsp; <a href="agreement.do">회원가입</a>
										&nbsp;&nbsp;&nbsp; <a href="findID.do">아이디/비밀번호찾기</a></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			
		
<%
	} else {
			//로그인 성공했다면
			out.println("<strong>" + s_id + "</strong> 님");
			out.println("<a href='logout.jsp'>[로그아웃]</a>");
			out.println("<br><br>");
			out.println("<a href='memberModify.jsp'>[회원정보수정]</a>");
			out.println("&nbsp;&nbsp;");
			out.println("<a href='memberWithdraw.jsp'>[회원탈퇴]</a>");
	} //if end
%>
</div>
</aside>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>