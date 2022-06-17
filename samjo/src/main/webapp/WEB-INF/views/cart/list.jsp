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
    	<th>제목</th>
    	<th>등록일</th>
    	<th>음원파일명</th>
    	<th>수정/삭제</th>
    </tr>
   
    <c:forEach var="dto" items="${list}">
    	<tr>
    		<td>${dto.mediano}</td>
    		<td><a href="read.do?mediano=${dto.mediano}">${dto.title}</a></td>
    		<td>${dto.rdate}</td>
    		<td>
    		
    		</td>
    		<td>
    			<input type="button" value="수정" onclick="location.href='update.do?mediano=${dto.mediano}'">
    			<input type="button" value="삭제" onclick="location.href='delete.do?mediano=${dto.mediano}'">
    		</td>    		
    	</tr>
    </c:forEach>
    </table>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>