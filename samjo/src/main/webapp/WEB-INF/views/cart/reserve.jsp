<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 template.jsp -->
<aside id="fh5co-hero-T" class="js-fullheight">
	<div class="flexslider js-fullheight">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">예약 하기</h2>
			</div>
		</div>
	</div>
</aside>
    <form name="frm" method="post" action="reserve.do">
    	<input type="hidden" name="user_id" value=${requestScope.user_id}>
		<div class="content">
			<p>정말로 예약 하시겠습니까?</p>
		</div>
		<div class="bottom">
			<input type="submit" value="예약">
			<input type="button" value="목록" onclick="location.href='list.do'">
		</div>
	</form>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>