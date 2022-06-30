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
				<th>예약 번호</th>
				<th>상품 갯수</th>
				<th>총 금액</th>
				<th>결제 수단</th>
				<th>인원 수</th>
				<th>예약 결과</th>
				<th>취소</th>
			</tr>

			<c:forEach var="dto" items="${map.list}">
				<tr>
					<td><a href="/read.do?res_no=${dto.res_no}">${dto.res_no}</a></td>
					<td>${dto.amount}</td>
					<td>${dto.pay}</td>
					<td>${dto.p_cnt}</td>
					<td>${dto.result}</td>
					<td><input type="button" value="예약취소"
						onclick="location.href='delete.do?c_no=${dto.c_no}'"></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="button" value="예약확정" onclick="location.href='reserve.do'"></td>
			</tr>
		</table>
	</div>
	</c:otherwise>
</c:choose>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>