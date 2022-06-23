<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>    
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsRead.jsp -->
<h3>* 게시판 상세보기 *</h3>
<p>
   <a href="bbsForm.jsp">[글쓰기]</a>
   &nbsp;&nbsp;
   <a href="bbsList.jsp?col=<%=col%>&word=<%=word%>">[글목록]</a>
</p>

<div class="container">
<%
	int board_no=Integer.parseInt(request.getParameter("board_no"));
	dto=dao.read(board_no);
	if(dto==null){
	    out.println("해당 글 없음!!");   
	}else{
	    
	    dao.incrementCnt(board_no); //조회수 증가 
	    
%>
		<table class="table">
		<tr>
			<th class="success">제목</th>
			<td><%=dto.getBoard_title() %></td>
		</tr>
		<tr>
			<th class="success">내용</th>
			<td style="text-align: left;">
			<%
			
			%>
		
			</td>
		</tr>
		<tr>
			<th class="success">일련번호</th>
			<td><%=dto.getBoard_no()%></td>
		</tr>
		<tr>
			<th class="success">작성일</th>
			<td><%=dto.getBoard_date()%></td>
		</tr>	
		</table>
		
		<br>
		<input type="button" value="수정" class="btn btn-warning" onclick="location.href='bbsUpdate.jsp?bbsno=<%=board_no%>'">
<!-- 관리자 삭제 및 수정 코드 삽입하기 -->
<% if(s_mlevel==1 || s_id.equals(bbs_id)){ %> 
 	<input type="button" value="삭제" onclick="location.href='bbsDel.do?bbs_idx=<%=board_no%>'">
	<input type="button" value="삭제" class="btn btn-danger" onclick="location.href='bbsDel.jsp?bbsno=<%=board_no%>'">		
<%	
		}
	}//if end		
%>
</div>

<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    