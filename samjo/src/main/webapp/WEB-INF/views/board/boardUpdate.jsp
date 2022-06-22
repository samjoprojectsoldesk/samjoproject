<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>  
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsUpdate.jsp -->
<!-- 글번호가 일치하는 행을 가져와서, 수정폼에 출력하기 -->
<aside id="fh5co-hero" class="js-fullheight">
			<div class="flexslider js-fullheight">
				<div class="slides">
				   	<div class="container">
				   		<div style="margin-top: 25%;">자 유 게 시 판</div>
							<p>
							   <a href="boardForm.do">[글쓰기]</a>
							   &nbsp;&nbsp;
							   <a href="boardList.do">[글목록]</a>
							</p>
							
							<div class="container">
							<%
								int bbs_idx=Integer.parseInt(request.getParameter("bbs_idx"));//수정 글번호
								dto=dao.read(bbs_idx);
								if(dto==null){
								    out.println("해당 글 없음!!");
								}else{
							%>
									<form name="boardfrm" id="boardfrm" method="post" action="boardUpdateProc.jsp" onsubmit="return bbsCheck()">
									<input type="hidden" name="bbs_idx" value="<%=bbs_idx%>">
									<table class="table">
									<tr>
									   <th class="success">작성자</th>
									   <td><input type="text" name="bbs_id" id="bbs_id" value="<%=dto.getBbs_id()%>" class="form-control" maxlength="20" required></td>
									</tr>
									<tr>
									   <th class="success">제목</th>
									   <td><input type="text" name="bbs_title" id="bbs_title" value="<%=dto.getBbs_title()%>" class="form-control" maxlength="100" required></td>
									</tr>
									<tr>
									   <th class="success">내용</th>
									   <td><textarea rows="5"  class="form-control" name="bbs_content" id="bbs_content"><%=dto.getBbs_content()%></textarea></td>
									</tr>
									<tr>
									    <td colspan="2" align="center">
									       <input type="submit" value="수정" class="btn btn-success">
									       <input type="reset"  value="취소" class="btn btn-danger">
									    </td>
									</table>	
									</form>
							<%	    
								}//if end
							%>
							</div>
						</div>
					</div>
				</div>
			</aside>
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    








