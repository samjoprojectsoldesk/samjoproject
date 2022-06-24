<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsIns.jsp -->
<h3>* 공지사항 작성 *</h3>
<p><a href="bbsList.jsp">[글목록]</a></p>
<div class="container">
	<form name="bbsIns" id="bbsIns" method="post" action="bbsIns.do" onsubmit="return bbsCheck()"><!-- ★myscript.js에 함수 작성함 -->
	<table class="table">
	<tr>
		<th class="success">제목</th>
		<td><input type="text" name="board_title" id="board_title" class="form-control" maxlength="100" required></td>
	</tr>
	<tr>
		<th class="success">내용</th>
		<td><textarea rows="5" class="form-control" name="board_content" id="board_content"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="쓰기" class="btn btn-success">
			<input type="reset" value="취소" class="btn btn-danger">
		</td>
	</tr>
	</table>
	</form>
</div>

<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    