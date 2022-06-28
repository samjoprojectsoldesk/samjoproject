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
					class="heading-section">여행지 등록</h2>
			</div>
		</div>
	</div>

</aside>

<div class="row">
	<div class="col-md-12">
		<form name="frm" method="post" action="create.do" class="create" enctype="multipart/form-data">
			<div class="form-group">
				<label for="s_cn">숙소 코드</label> 
				<input type="text" class="form-control" id="s_cn" name="s_cn" placeholder="S000">
			</div>
			<div class="form-group">
				<label for="t_name">숙소 명</label> 
				<input type="text" class="form-control" id="s_name" name="s_name">
			</div>
			<div class="form-group">
				<label for="s_addr">주소</label> 
				<input type="text" class="form-control" id="s_addr" name="s_addr">
			</div>
			<div class="form-group">
				<label for="s_tel">전화번호</label> 
				<input type="text" class="form-control" id="s_tel" name="s_tel">
			</div>
			<div class="form-group">
				<label for="s_link">홈페이지 주소</label> 
				<input type="text" class="form-control" id="s_link" name="s_link">
			</div>
			<div class="form-group">
				<label for="posterMF">대표 이미지</label> 
				<input type="file" class="form-control-file" id="posterMF" name="posterMF">
			</div>
			<div class="form-group">
				<label for="t_cont">상세 정보 및 내용</label>
				<textarea class="form-control" id="s_cont" name="s_cont" rows="3"></textarea>
			</div>
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/sookso/List.do'">목록</button>
			</div>
		</form>
	</div>
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>