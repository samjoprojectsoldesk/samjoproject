<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 list.jsp -->
<aside id="fh5co-hero-T">
	<div class="flexslider">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">${dto.bbs_title}</h2>
			</div>
		</div>
	</div>
<div class="row-read">
	<div class="col-md-12 text-center project">
		<div class="grid-project">
					<ul>					
						<li>아이디 : ${dto.bbs_id}</li>
						<li>제목 : ${dto.bbs_title}</li>
					</ul>
				<img src="../../storage/${dto.bbs_img}" class="img-responsive"
					style="width: 40%; float: left;">	
				<div>${dto.bbs_content}</div>
				</div>
				<div class='bottom'>
					<input type="button" value="수정" onclick="location.href='/board/updateForm.do?bbs_idx=${dto.bbs_idx}'">
            		<input type="button" value="삭제" onclick="location.href='/board/deleteForm.do?bbs_idx=${dto.bbs_idx}'">	
					<button type="button" class="btn btn-secondary" onclick="location.href='/board/List.do'">목록</button>
				</div>
		</div>
		<div class="col-md-12" id="tab-menu">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="col-md-4 nav-item"><a class="nav-link active"
				id="info-tab" data-toggle="tab" href="#info" role="tab"
				aria-controls="info" aria-selected="true">댓글</a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="info" role="tabpanel"
				aria-labelledby="info-tab">

			<c:forEach var="dto" items="${list}">
				<div class="col-md-4 text-center project">
					<a href="../tour/tourist/read.do?t_cn=${dto.t_cn}"
						class="grid-project">
						<div class="desc">
							<h3>${dto.t_name}</h3>
							<span>${dto.t_addr}</span>
						</div>
					</a>
				</div>
			</c:forEach>
			</div>	
		</div>
		</div>
	</div>
</div>
		
	</div>
</div>
</aside>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>