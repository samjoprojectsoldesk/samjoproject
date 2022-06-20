<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 template.jsp -->
    <div class="title">장바구니 항목 삭제</div>
    <form name="frm" method="post" action="delete.do">
    	<input type="hidden" name="c_no" value=${requestScope.c_no}>
		<div class="content">
			<p>장바구니 항목을 삭제하시겠습니까?</p>
		</div>
		<div class="bottom">
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick="location.href='list.do'">
		</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>