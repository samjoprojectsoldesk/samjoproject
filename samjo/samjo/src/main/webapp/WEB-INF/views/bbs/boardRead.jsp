<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>    
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsRead.jsp -->
<aside id="fh5co-hero" class="js-fullheight">
			<div class="flexslider js-fullheight">
				<div class="slides">
				   	<div class="container">
				   		<div style="margin-top: 25%;">자 유 게 시 판</div>
							<p>
							   <a href="boardForm.jsp">[글쓰기]</a>
							   &nbsp;&nbsp;
							   <a href="boardList.jsp">[글목록]</a>
							</p>
							
							<div class="container">
							<%
								int bbs_idx=Integer.parseInt(request.getParameter("bbs_idx"));
								dto=dao.read(bbs_idx);
								if(dto==null){
								    out.println("해당 글 없음!!");   
								}else{
								    
								    dao.incrementCnt(bbs_idx); //조회수 증가 
								    
							%>
									<table class="table">
									<tr>
										<th class="success">제목</th>
										<td><%=dto.getBbs_content()%></td>
									</tr>
									<tr>
										<th class="success">내용</th>
										<td style="text-align: left;">
							<%
											//사용자가 입력한 엔터(\n)를 <br>태그로 바꾸기
											String content=Utility.convertChar(dto.getBbs_content());
											out.print(content);
							%>
										</td>
									</tr>
									<tr>
										<th class="success">조회수</th>
										<td><%=dto.getBbs_count()%></td>
									</tr>
									<tr>
										<th class="success">작성자</th>
										<td><%=dto.getBbs_id()%></td>
									</tr>
									<tr>
										<th class="success">작성일</th>
										<td><%=dto.getBbs_date()%></td>
									</tr>
									<tr>
										<th class="success">IP</th>
										<td><%=dto.getBbs_userip()%></td>
									</tr>		
									</table>
									<br>
									<input type="button" value="수정"    class="btn btn-warning" onclick="location.href='boardUpdate.jsp?bbs_idx=<%=bbs_idx%>'">
									<input type="button" value="삭제"    class="btn btn-danger"  onclick="location.href='boardDel.jsp?bbs_idx=<%=bbs_idx%>'">		
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








