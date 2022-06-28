<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<!-- 본문시작 bbsRead.jsp -->
<aside id="fh5co-hero-T" class="js-fullheight">
	<div class="flexslider js-fullheight">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">공지사항 상세보기</h2>
			</div>
		</div>
	</div>

</aside>

<div class="row">
	<div class="col-md-12">
		<table>
			<tr>
				<th>제목 : ${dto.board_title}</th>
			</tr>		
			<tr>
				<th>내용 : ${dto.board_content}</th>
			</tr>
			<tr>
				<th>조회수 : ${dto.board_readcnt}</th>
			</tr>		
			<!-- 삭제, 수정, 목록 버튼 -->
			<tr>
			<td colspan="2" align="center">
				<div class='bottom'>
					<button type="submit" class="btn btn-primary" onclick="location.href='/notice/bbsUpdate.do?board_no=${dto.board_no}'">수정</button>
					<button type="submit" class="btn btn-primary" onclick="location.href='/notice/bbsDelete.do?board_no=${dto.board_no}'">삭제</button>
					<button type="button" class="btn btn-secondary" onclick="location.href='/notice/bbsList.do'">목록</button>
				</div>			
			</td>
		</table>
	</div>
</div>



<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>
