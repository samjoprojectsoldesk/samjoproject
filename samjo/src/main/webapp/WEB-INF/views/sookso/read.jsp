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
					class="heading-section">${dto.s_name}</h2>
			</div>
		</div>
	</div>
</aside>

<div class="row-read">
	<div class="col-md-12 text-center project">
		<div class="grid-project">
			<form action="">
				<div class="image-T">
					<img src="../../storage/${dto.s_img}" class="img-responsive"
						style="width: 40%; float: left;">
					<div class="desc-T">
						<ul>
							<strong>기본정보</strong>						
							<hr>
							<li>주소&emsp;&emsp;&emsp;${dto.s_addr}</li>
							<li>전화번호&nbsp;&nbsp;&nbsp;&nbsp;${dto.s_tel}</li>
							<li>홈페이지&nbsp;&nbsp;&nbsp;&nbsp; <a class="textLink"
								href="${dto.s_link}" target="_blank">${dto.s_link}</a>
							</li>
							<!-- 방선택, 방에따른 가격 -->
							
							<li><button type="submit" class="btn btn-primary">예약</button></li>
							<li><button type="submit" class="btn btn-primary">장바구니</button></li>
						</ul>
					</div>
				</div>
			</form>
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
				aria-labelledby="info-tab">${dto.s_cont} {dto.room_img} {dto.room_cont}</div>
				
			<div class="tab-pane fade" id="map" role="tabpanel"
				aria-labelledby="map-tab"></div>
				
			<div class="tab-pane fade" id="review" role="tabpanel"
				aria-labelledby="review-tab">리뷰 추가하기</div>
		</div>
	</div>
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>