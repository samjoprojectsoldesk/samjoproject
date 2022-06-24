<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsIns.jsp -->
<h3>* 공지사항 작성 *</h3>
<p><a href="bbsList.jsp">[글목록]</a></p>
<div class="container">
	<form name="bbsIns" id="bbsIns" method="post" action="bbsIns.jsp" onsubmit="return bbsCheck()"><!-- ★myscript.js에 함수 작성함 -->
	<table class="table">
	<tr>
		<th class="success">제목</th>
		<td><input type="text" name="subject" id="subject" class="form-control" maxlength="100" required></td>
	</tr>
	<tr>
		<th class="success">내용</th>
		<td><textarea rows="5" class="form-control" name="content" id="content"></textarea></td>
	</tr>
	<tr>
		<!-- 공지사항 등록 -->	
		<td colspan="2" align="center">
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/notice/noticeList.do'">목록</button>
			</div>
			
		</td>
	</tr>
	</table>
</div>

<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    