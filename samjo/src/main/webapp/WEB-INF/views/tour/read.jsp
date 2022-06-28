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
					class="heading-section">${dto.t_name}</h2>
			</div>
		</div>
	</div>
</aside>

<div class="row-read">
	<div class="col-md-12 text-center project">
		<div class="grid-project">
			<div class="image-T">
				<img src="../../storage/${dto.t_img}" class="img-responsive"
					style="width: 40%; float: left;">
				<div class="desc-T">
					<ul>
						<strong>기본정보</strong>
						<hr>
						<li>주소&emsp;&emsp;&emsp;${dto.t_addr}</li>
						<li>전화번호&nbsp;&nbsp;&nbsp;&nbsp;${dto.t_tel}</li>
						<li>홈페이지&nbsp;&nbsp;&nbsp;&nbsp; <a class="textLink"
							href="${dto.t_link}" target="_blank">${dto.t_link}</a>
						</li>
						<li>주차&emsp;&emsp;&emsp;${dto.t_car}</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-12" id="tab-menu">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="col-md-4 nav-item"><a class="nav-link active"
				id="info-tab" data-toggle="tab" href="#info" role="tab"
				aria-controls="info" aria-selected="true">상세정보</a></li>
			<li class="col-md-4 nav-item"><a class="nav-link" id="map-tab"
				data-toggle="tab" href="#map" role="tab" aria-controls="map"
				aria-selected="false">지도에서 보기</a></li>
			<li class="col-md-4 nav-item"><a class="nav-link"
				id="review-tab" data-toggle="tab" href="#review" role="tab"
				aria-controls="review" aria-selected="false">리뷰</a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="info" role="tabpanel"
				aria-labelledby="info-tab">${dto.t_cont}</div>
			<div class="tab-pane fade" id="map" role="tabpanel"
				aria-labelledby="map-tab"></div>
			<div class="tab-pane fade" id="review" role="tabpanel"
				aria-labelledby="review-tab">
				<c:forEach var="dto" items="${list}">
				<div class="col-md-4 text-center project">
					<a href="../tour/tourist/read.do?t_cn=${dto.t_cn}"
						class="grid-project">
						<div class="desc">
							<h3>${dto.review_content}</h3>
							<span>${dto.review_user_id}</span>
							<br>
							<span>${dto.review_date}</span>
						</div>
					</a>
				</div>
			</c:forEach>
				
				<!-- 페이지 리스트 -->

			</div>

		</div>
	</div>
	<!-- 본문 끝 -->
	<%@ include file="../footer.jsp"%>