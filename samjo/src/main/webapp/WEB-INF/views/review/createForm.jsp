<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 -->

<aside id="fh5co-hero-R">
	<div class="flexslider">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2 style="margin-top: 300px; text-align: center; font-weight: bold;" class="heading-section">리뷰 등록</h2>
			</div>
		</div>
	</div>
</aside>

<div class="row">
	<div class="col-md-12">
		<form name="frm" method="post" action="reviewcreate.do" class="tourcreate" enctype="multipart/form-data">
			<div class="form-group">
				<label for="review_code">예약번호</label> 
				<input type="text" class="form-control" id="review_code" name="review_code" readonly>
			</div>
			<div class="form-group">
				<label for="s_code">예약 상품</label> 
				<input type="text" class="form-control" id="s_code" name="s_code" readonly>
			</div>
			<div class="form-group">
				<label for="review_user_id">아이디</label> 
				<input type="text" class="form-control" id="review_user_id" name="review_user_id" readonly>
			</div>
			<div class="form-group">
				<label for="review_content">리뷰 내용</label>
				<textarea class="form-control" id="review_content" name="review_content" rows="3"></textarea>
			</div>
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='index.do'">홈 화면</button>
			</div>
		</form>
	</div>
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>