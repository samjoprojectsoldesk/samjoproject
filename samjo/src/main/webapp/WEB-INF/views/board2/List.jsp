<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 template.jsp -->
<aside id="fh5co-hero" class="js-fullheight">
			<div class="flexslider js-fullheight">
				   	<div class="container">
				   		<h2 style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">자유게시판</h2>
				   	</div>
			</div>
</aside>

	<div class="content">
        <input type="button" value="글쓰기" onclick="location.href='boardcreate.do'">
    </div>
   
    <table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
    </tr>
    <!-- MediagroupCont의 list()함수에서 mav.addObject("list")를 가리킴 -->
    <c:forEach var="dto" items="${list}">
        <tr>
        <td>${dto.bbs_idx}</td>
        <td><a href="boardread.do?bbs_idx=${dto.bbs_idx}">${dto.bbs_title}</a></td>
        <td>${dto.bbs_id}</td>
        <td>${dto.bbs_date}</td>
        <td>${dto.bbs_count}</td>
        </tr>
    </c:forEach>  
    </table>
    
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
					<a href="/tour/festivalList.do?pageNum=${startPage}">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage+1}" end="${endPage-1}">
					<a href="/tour/festivalList.do?pageNum=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage<pageCount}">
					<a href="/tour/festivalList.do?pageNum=${startPage+11}">[다음]</a>
				</c:if>
			</div>
		</c:if>
	</div>


<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>