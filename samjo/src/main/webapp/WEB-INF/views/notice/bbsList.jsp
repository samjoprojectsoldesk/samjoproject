<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp" %>
<head>
<title>공 지 사 항</title>
</head>

<!-- 본문시작 bbsList.jsp -->
<body>
	<aside id="fh5co-hero-T" class="js-fullheight">
		<div class="flexslider js-fullheight">
			<div class="container">
				<div class="slider-text-inner desc">
					<h2
						style="margin-top: 300px; text-align: center; font-weight: bold;"
						class="heading-section">공 지 사 항</h2>
				</div>
			</div>
		</div>
		
<!-- 검색 시작 -->
		<div style='text-align: right; height: 50px; margin-right: 50px;'>
			<form action="bbsList.jsp">
				<input type="text" id="txtSearch" placeholder="검색어를 입력하세요." value=""
					style="border: 2px solid black; border-radius: 5px 5px 5px 5px">
				&nbsp;&nbsp; <input type="submit" value="검색"
					class="btn btn-secondary"
					style="font-weight: bold; font-family: Arial;">
			</form>
		</div>		
<!-- 검색 끝 -->
		
<!-- 페이지 리스트 -->
		<div class="paging">
			<c:if test="${requestScope.count>0 }">
				<c:set var="pageCount" value="${requestScope.totalPage}" />
				<c:set var="startPage" value="${requestScope.startPage}" />
				<c:set var="endPage" value="${requestScope.endPage}" />

				<div class="content">
					<c:if test="${endPage>pageCount}">
						<c:set var="endPage" value="${pageCount+1}" />
					</c:if>

					<c:if test="${startPage>0}">
						<a href="/notice/noticeList.do?pageNum=${startPage}">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${startPage+1}" end="${endPage-1}">
						<a href="/notice/noticeList.do?pageNum=${i}">[${i}]</a>
					</c:forEach>
			</c:if>
		</div>
    <div class="noticeList">
    <table class="table table-hover">
            <thead>
                <tr>
                    <th class="board_no">일련번호</th>
                    <th class="board_title">제목</th>
                    <th class="board_date">작성일</th>
                    <th class="board_readcnt">조회수</th>
                </tr>
            </thead>
            <thead>
            	<c:forEach var="dto" items="${list }">
            	<tr>
            		<th>${dto.board_no }</th>
            		<th><a href="bbsRead.do?board_no=${dto.board_no}">${dto.board_title }</a></th>
            		<th>${dto.board_date }</th>
            		<th>${dto.board_readcnt }</th>
            	</tr>
            	</c:forEach>
            </thead>
    </table>
    </div>
<!-- 공지사항 작성 -->	
<div class="content">
        <input type="button" value="작성" onclick="location.href='bbsIns.do'">
</div>	
</aside>
</body>
</html>