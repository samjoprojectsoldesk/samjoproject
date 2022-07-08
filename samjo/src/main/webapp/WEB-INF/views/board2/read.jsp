<%@page import="kr.co.samjo.board2.boardDTO"%>
<%@page import="kr.co.samjo.board2.boardDAO"%>
<%@page import="kr.co.samjo.board2.CmtDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<%
	boardDAO dao = new boardDAO();
	ArrayList<CmtDTO> list = new ArrayList<CmtDTO>();
	list=dao.cmtList(Integer.parseInt(request.getParameter("bbs_idx")));
	
%>
<jsp:useBean id="dto1" class="kr.co.samjo.board2.CmtDTO" scope="page"></jsp:useBean>
<!-- 본문 시작 list.jsp -->
<aside id="fh5co-hero-T">
	<div class="flexslider">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">${dto.bbs_title}</h2>
			</div>
		</div>
	</div>
<div class="row-read">
	<div class="col-md-12 text-center project">
		<div class="grid-project">
					<ul>					
						<li>아이디 : ${dto.bbs_id}</li>
						<li>제목 : ${dto.bbs_title}</li>
					</ul>
				<img src="../../storage/${dto.bbs_img}" class="img-responsive"
					style="width: 40%; float: left;">	
				<div>${dto.bbs_content}</div>
				</div>
				<div class='bottom'>
					<input type="button" value="수정" onclick="location.href='/board/updateForm.do?bbs_idx=${dto.bbs_idx}'">
            		<input type="button" value="삭제" onclick="location.href='/board/deleteForm.do?bbs_idx=${dto.bbs_idx}'">	
					<button type="button" class="btn btn-secondary" onclick="location.href='/board/List.do'">목록</button>
				</div>
		</div>
		<div class="col-md-12" id="tab-menu">

		<div>
			<h4>댓글</h4>
						<hr>
			<form name="frm" method="post" action="/board/cmt.do"  enctype="multipart/form-data">
			<input type="hidden" name="cmt_bbs_idx" id="cmt_bbs_idx" value="${dto.bbs_idx}">
			<div class="form-group">
				<label for="cmt_content">내용</label>
				<textarea class="form-control" id="cmt_content" name="cmt_content" rows="3"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">등록</button>
			</form>
			<table class="table table-hover">
            <thead>
                <tr>
                    <th class="board_no">내용</th>
                    <th class="board_title">작성자</th>
                    <th class="board_date">작성일</th>
                    <th class="board_readcnt">답글</th>
                </tr>
            </thead>
            <thead>
            	<%
            		if(list!=null){
            		for(int i=0;i<list.size();i++){
            			CmtDTO dto = list.get(i);
            	%>
						<tr>
						<td>
						<%for(int j=0;j<dto.getCmt_re_setp();j++){ %>
								<img src='../storage/reply.gif'>
						<%} %>
							<%=dto.getCmt_content() %>
							</td>
							<td><%=dto.getCmt_id() %></td>
							<td><%=dto.getCmt_date() %></td>
							<td>
								<input type="button" value="답글" onclick="location.href='/cmt/replyproc.do?cmt_idx=<%=dto.getCmt_idx()%>&bbs_idx=<%=dto.getCmt_bbs_idx()%>'">
								<input type="button" value="수정" onclick="location.href='/cmt/update.do?cmt_idx=<%=dto.getCmt_idx()%>&bbs_idx=<%=dto.getCmt_bbs_idx()%>'">
					    		<input type="button" value="삭제" onclick="location.href='/cmt/delete.do?cmt_idx=<%=dto.getCmt_idx()%>&bbs_idx=<%=dto.getCmt_bbs_idx()%>'">
					    	</td>
	            		</tr>
	            <%
            		}
            		}
	            %>
            </thead>
    </table>
			</div>	
		</div>
	</div>


</aside>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>