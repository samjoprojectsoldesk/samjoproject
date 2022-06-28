<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsIns.jsp -->
<p><a href="bbsList.do">[글목록]</a></p>
<div class="container">
<<<<<<< HEAD
	<form name="bbsIns" id="bbsIns" method="post" action="notice/bbsIns.do" onsubmit="return bbsCheck()"><!-- ★myscript.js에 함수 작성함 -->

=======
	<form name="bbsIns" id="bbsIns" method="post" action="bbsIns.do" onsubmit="return bbsCheck()"><!-- ★myscript.js에 함수 작성함 -->
>>>>>>> c3f8d50ebc8143095c98381e390e1a5eb71b14d7
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
		<!-- 공지사항 등록 -->	
		<td colspan="2" align="center">
			<div class='bottom'>
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='bbsList.do'">목록</button>
			</div>
			
		</td>
	</tr>
	</table>
	</form>
</div>

<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    