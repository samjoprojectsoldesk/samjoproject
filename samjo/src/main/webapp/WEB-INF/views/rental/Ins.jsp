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
					class="heading-section">렌트카 업체 등록</h2>
			</div>
		</div>
	</div>

</aside>

<div class="row">
	<div class="col-md-12">
		<form name="frm" method="post" action="Ins.do" class="Ins" enctype="multipart/form-data">
			<div class="form-group">
				<label for="u_code">업체코드</label> 
				<input type="text" class="form-control" id="u_code" name="u_code" placeholder="C000">
			</div>
			<div class="form-group">
				<label for="u_name">업체명</label> 
				<input type="text" class="form-control" id="u_name" name="u_name">
			</div>
			<div class="form-group">
				<label for="u_phone">연락처</label> 
				<input type="text" class="form-control" id="u_phone" name="u_phone">
			</div>
			<div class="form-group">
				<label for="u_office">사무실</label> 
				<input type="text" class="form-control" id="u_office" name="u_office">
			</div>
			<div class="form-group">
				<label for="u_cont">정보</label> 
				<input type="text" class="form-control" id="u_cont" name="u_cont">
			</div>
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/rentalcar/List.do'">목록</button>
			</div>
		</form>
	</div>
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>