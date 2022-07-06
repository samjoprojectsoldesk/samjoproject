<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 Read.jsp -->
<aside id="fh5co-hero-T" class="js-fullheight">
	<div class="flexslider js-fullheight">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">${dto.u_name}</h2>
			</div>
		</div>
	</div>
</aside>

<div class="row-read">
	<div class="col-md-12 text-center project">
			<div class="image-T">
				<img src="../../storage/${dto.u_img}" class="img-responsive"
					style="width: 40%; float: left;">
				<div class="desc-T">
					<ul>
						<strong>렌트카 업체 정보</strong>						
						<hr>
						<li>업체명&emsp;&emsp;&emsp;${dto.u_name}</li>
						<li>연락처&nbsp;&nbsp;&nbsp;&nbsp;${dto.u_phone}</li>
						<li>사무실&emsp;&emsp;&emsp;${dto.u_office}</li>
						<li>정보&emsp;&emsp;&emsp;${dto.u_cont}</li>
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
			<li class="col-md-4 nav-item"><a class="nav-link"
				id="review-tab" data-toggle="tab" href="#review" role="tab"
				aria-controls="review" aria-selected="false">리뷰</a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="info" role="tabpanel"
				aria-labelledby="info-tab">${dto.u_cont}</div>
			<div class="tab-pane fade" id="map" role="tabpanel"
				aria-labelledby="map-tab"></div>
			<div class="tab-pane fade" id="review" role="tabpanel"
				aria-labelledby="review-tab">리뷰 추가하기</div>
		</div>
	</div>
</div>


</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>