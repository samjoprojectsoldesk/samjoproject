<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 -->

<aside id="fh5co-hero-T" class="js-fullheight">
	<div class="flexslider js-fullheight">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">게시글 수정</h2>
			</div>
		</div>
	</div>

</aside>

<div class="row">
	<div class="col-md-12">
		<form name="frm" method="post" action="updateForm.do" class="tourcreate" enctype="multipart/form-data">
			<div class="form-group">
				<label for="bbs_title">제목</label> 
				<input type="text" class="form-control" id="bbs_title" name="bbs_title" value="${dto.bbs_title}">
			</div>
			<div class="form-group">
				<label for="bbs_id">작성자</label> 
				<input type="text" class="form-control" id="bbs_id" name="bbs_id" value="${dto.bbs_id}">
			</div>
			<div class="form-group">
				<label for="posterMF">이미지</label> 
				<img src='../storage/${dto.bbs_img}' width='20%'>
<<<<<<< HEAD
				<input type="file" class="form-control-file" id="posterMF1" name="posterMF1">
				<img src='../storage/${dto.bbs_img2}' width='20%'>
				<input type="file" class="form-control-file" id="posterMF2" name="posterMF2">
				<img src='../storage/${dto.bbs_img3}' width='20%'>
				<input type="file" class="form-control-file" id="posterMF3" name="posterMF3">
=======
				<input type="file" class="form-control-file" id="posterMF" name="posterMF">
>>>>>>> c3f8d50ebc8143095c98381e390e1a5eb71b14d7
			</div>
			<div class="form-group">
				<label for="bbs_content">내용</label>
				<textarea class="form-control" id="bbs_content" name="bbs_content" rows="3" >${dto.bbs_content}</textarea>
			</div>
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">수정</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/board/List.do'">목록</button>
			</div>
		</form>
	</div>
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>