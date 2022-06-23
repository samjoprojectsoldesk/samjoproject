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
		<form name="frm" method="post" action="tourcreate.do" class="tourcreate" enctype="multipart/form-data">
			<div class="form-group">
				<label for="t_cn">여행지코드</label> 
				<input type="text" class="form-control" id="t_cn" name="t_cn" placeholder="T000">
			</div>
			<div class="form-group">
				<label for="t_name">관광지 / 문화행사 이름</label> 
				<input type="text" class="form-control" id="t_name" name="t_name">
			</div>
			<div class="form-group">
				<label for="t_addr">주소</label> 
				<input type="text" class="form-control" id="t_addr" name="t_addr">
			</div>
			<div class="form-group">
				<label for="t_dividecn">여행지 구분 코드</label> 
				<input type="number" class="form-control" id="t_dividecn" name="t_dividecn">
			</div>
			<div class="form-group">
				<label for="t_tel">전화번호</label> 
				<input type="text" class="form-control" id="t_tel" name="t_tel">
			</div>
			<div class="form-group">
				<label for="t_link">홈페이지 주소</label> 
				<input type="text" class="form-control" id="t_link" name="t_link">
			</div>
			<div class="form-group">
				<label for="t_sche">일정</label> 
				<input type="text" class="form-control" id="t_sche" name="t_sche">
			</div>
			<div class="form-group">
				<label for="t_car">주차 가능 여부</label> 
				<input type="text" class="form-control" id="t_car" name="t_car">
			</div>
			<div class="form-group">
				<label for="posterMF">대표 이미지</label> 
				<input type="file" class="form-control-file" id="posterMF" name="posterMF">
			</div>
			<div class="form-group">
				<label for="t_cont">상세 정보 및 내용</label>
				<textarea class="form-control" id="t_cont" name="t_cont" rows="3"></textarea>
			</div>
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/tour/tourist.do'">목록</button>
			</div>
		</form>
	</div>
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>