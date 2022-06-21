<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 template.jsp -->
<div class="title">장바구니 목록</div>

    <table>
    
    <tr>
    	<th>번호</th>
    	<th>아이디</th>
    	<th>상품코드</th>
    	<th>수량</th>
    	<th>인원</th>
    	<th>이용시작일</th>
    	<th>이용 끝일</th>
    	<th>삭제</th>
    </tr>
   
    <c:forEach var="dto" items="${list}">
    	<tr>
    		<td><a href="read.do?c_no=${dto.c_no}">${dto.c_no}</a></td>
    		<td>${dto.user_id}</td>
    		<td>${dto.s_code}</td>
    		<td>${dto.cnt}</td>
    		<td>${dto.p_cnt}</td>
    		<td>${dto.sdate}</td>
    		<td>${dto.fdate}</td>
    		<td>
    			<input type="button" value="삭제" onclick="location.href='delete.do?c_no=${dto.c_no}'">
    		</td>
    	</tr>
    </c:forEach>
    </table>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>