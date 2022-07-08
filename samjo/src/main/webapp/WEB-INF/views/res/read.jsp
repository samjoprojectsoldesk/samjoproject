<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 template.jsp -->
<aside id="fh5co-hero-T" class="js-fullheight">
	<div class="flexslider js-fullheight">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">예약 목록</h2>
			</div>
		</div>
	</div>
</aside>
<script>
	$(document).ready(function() {
		$("#btnList").click(function() {
			location.href = "../res/list.do";
		});
	});
</script>
<c:choose>
	<c:when test="${map.count ==0}">
		예약이 비었습니다.
	</c:when>
	<c:otherwise>
	<div class="row-read">
		<table class="table">
			<tr>
				<th>예약번호</th>
				<th>상품 이름</th>
				<th>이용시작일</th>
				<th>이용종료일</th>
				<th>리뷰쓰기</th>
			</tr>

			<c:forEach var="dto" items="${map.list}">
				<tr>
					<td>${dto.res_no}</td>
					<td>${dto.s_name}</td>
					<td>${dto.sdate}</td>
					<td>${dto.fdate}</td>
					<td><a href="review/reviewcreate?res_no=${dto.detail_no}">리뷰쓰기</a></td>
			</c:forEach>
			<tr>
				<td><input type="button" value="결제하기" onclick="location.href='cost.do'"></td>
			</tr>
		</table>
	</div>
	</c:otherwise>
</c:choose>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>