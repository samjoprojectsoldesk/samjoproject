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
					class="heading-section">공지사항 수정</h2>
			</div>
		</div>
	</div>
</aside>

<div class="row">
	<div class="col-md-12">
		<form name="frm" method="post" action="../notice/bbsUpdate.do" class="bbsform" enctype="multipart/form-data">
		<input type="hidden" name="board_no" value="${dto.board_no}">
			<div class="form-group">
				<label for="t_cont">제 목</label>
				<textarea class="form-control" id="board_title" name="board_title" rows="3">${dto.board_title}</textarea>
			</div>
			<div class="form-group">
				<label for="t_cont">내 용</label>
				<textarea class="form-control" id="board_content" name="board_content" rows="3">${dto.board_content}</textarea>
			</div>
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">예</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/notice/bbsRead.do?board_no=${dto.board_no}'">아니오</button>
			</div>
		</form>
	</div>
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>