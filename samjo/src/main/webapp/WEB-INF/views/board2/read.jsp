<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 list.jsp -->
<aside id="fh5co-hero-T" class="js-fullheight">
	<div class="flexslider js-fullheight">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">${dto.bbs_title}</h2>
			</div>
		</div>
	</div>
</aside>
<div class="row-read">
	<div class="col-md-12 text-center project">
		<div class="grid-project">
			<div class="image-T">

					<ul>					
						<li>아이디 : ${dto.bbs_id}</li>
						<li>제목 : ${dto.bbs_title}</li>
					</ul>

				<img src="../../storage/${dto.bbs_img}" class="img-responsive"
					style="width: 40%; float: left;">
				<img src="../../storage/${dto.bbs_img2}" class="img-responsive"
					style="width: 40%; float: left;">
				<img src="../../storage/${dto.bbs_img3}" class="img-responsive"
					style="width: 40%; float: left;">
					
				<div>${dto.bbs_content}</div>
				
				<div class='bottom'>
				<c:if test="${s_mlevel==1 || s_id.equals(bbs_id)}">
					<input type="button" value="수정" onclick="location.href='/board2/updateForm.do?bbs_idx=${dto.bbs_idx}'">
            		<input type="button" value="삭제" onclick="location.href='/board2/deleteForm.do?bbs_idx=${dto.bbs_idx}'">
                </c:if>		
				<button type="button" class="btn btn-secondary" onclick="location.href='/board2/List.do'">목록</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>