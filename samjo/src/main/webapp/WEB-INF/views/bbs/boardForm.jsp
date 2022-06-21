<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsForm.jsp -->
<aside id="fh5co-hero" class="js-fullheight">
			<div class="flexslider js-fullheight">
				<div class="slides">
				   	<div class="container">
				   		<div style="margin-top: 25%;">자 유 게 시 판</div>
							<p><a href="bbsList.jsp">[글목록]</a></p>
							<div class="container">
								<form name="bbsfrm" id="bbsfrm" method="post" action="bbsIns.jsp" onsubmit="return bbsCheck()"><!-- myscript.js에 함수 작성함 -->
								<table class="table">
								<tr>
								   <th class="success">작성자</th>
								   <td><input type="text" name="bbs_id" id="bbs_id" class="form-control" maxlength="20" required></td>
								</tr>
								<tr>
								   <th class="success">제목</th>
								   <td><input type="text" name="bbs_title" id="bbs_title" class="form-control" maxlength="100" required></td>
								</tr>
								<tr>
								   <th class="success">내용</th>
								   <td><textarea rows="5"  class="form-control" name="bbs_content" id="bbs_content"></textarea></td>
								</tr>
								<tr>
								    <td colspan="2" align="center">
								       <input type="submit" value="쓰기" class="btn btn-success">
								       <input type="reset"  value="취소" class="btn btn-danger">
								    </td>
								</table>	
								</form>
							</div>
						</div>
					</div>
				</div>
			</aside>
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    