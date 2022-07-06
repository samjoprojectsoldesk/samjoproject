<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsIns.jsp -->
<aside id="fh5co-hero-T" class="js-fullheight">
		<div class="flexslider js-fullheight">
			<div class="container">
				<div class="slider-text-inner desc">
					<h2 style="margin-top: 300px; text-align: center; font-weight: bold;" class="heading-section">공 지 사 항</h2>
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
							<!-- 공지사항 등록 -->	
						</table>
						<div style="float:right">
								<button type="submit" class="btn btn-primary">등록</button>
								<button type="button" class="btn btn-secondary" onclick="location.href='bbsList.do'">목록</button>
						</div>
						</form>
				</div>
			</div>
		</div>
	</aside>

<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    