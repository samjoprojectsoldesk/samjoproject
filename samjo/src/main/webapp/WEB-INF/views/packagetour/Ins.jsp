<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header2.jsp"%>
<!-- 본문 시작 -->

<aside id="fh5co-hero-T" class="js-fullheight">
	<div class="flexslider js-fullheight">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">패키지투어 등록</h2>
			</div>
		</div>
	</div>

</aside>

<div class="row">
	<div class="col-md-12">
		<form name="frm" method="post" action="Ins.do" class="Ins" enctype="multipart/form-data">
			<div class="form-group">
				<label for="package_no">패키지코드</label> 
				<input type="text" class="form-control" id="package_no" name="package_no" placeholder="T000">
			</div>
			<div class="form-group">
				<label for="package_name">패키지이름</label> 
				<input type="text" class="form-control" id="package_name" name="package_name">
			</div>
			<div class="form-group">
				<label for="package_course">여행코스</label> 
				<input type="text" class="form-control" id="package_course" name="package_course">
			</div>
			<div class="form-group">
				<label for="package_schedule">모집일정</label> 
				<input type="number" class="form-control" id="package_schedule" name="package_schedule">
			</div>
			<div class="form-group">
				<label for="package_price">비용</label> 
				<input type="text" class="form-control" id="package_price" name="package_price">
			</div>
			<div class="form-group">
				<label for="package_recruitment">모집 인원</label> 
				<input type="text" class="form-control" id="package_recruitment" name="package_recruitment">
			</div>
			<div class="form-group">
				<label for="package_content">상세 정보 및 내용</label>
				<textarea class="form-control" id="package_content" name="package_content" rows="3"></textarea>
			</div>
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/packagetour/List.do'">목록</button>
			</div>
		</form>
	</div>
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>