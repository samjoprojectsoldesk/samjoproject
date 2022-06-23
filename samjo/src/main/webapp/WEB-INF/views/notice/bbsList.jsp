<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>    
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsList.jsp -->
<h3>공 지 사 항</h3>
<p><a href="bbsForm.jsp">[글쓰기]</a></p>

<div class="container">
	<table class="table table-hover">
	<thead>
		<tr class="success">
			<th>일련번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
	</thead>
  	<tbody>
<%	
	//한페이지당 출력할 행의 갯수
	int recordPerPage=5;
	
	ArrayList<noticeDTO> list=dao.list3(col, word, nowPage, recordPerPage); 
	if(list==null){
	    out.println("<tr>");
	    out.println("  <td colspan='4'>");
	    out.println("    <strong>관련자료 없음!!</strong>");
	    out.println("  </td>");
	    out.println("</tr>");
	}else{
	    
	    //오늘 날짜를 문자열 "2022-05-04" 만들기
	    String today=Utility.getDate();
	    
	    for(int i=0; i<list.size(); i++){
	        dto=list.get(i);
%>
			<tr>
				<td style="text-align: left">
	
					<a href="bbsRead.jsp?board_no=<%=dto.getBoard_no()%>%col=<%=col%>&word=<%=word%>"><%=dto.getBoard_title()%></a>
<%
					//조회수가 10이상이면 hot이미지 출력
					if(dto.getBoard_readcnt()>=10){
					    out.println("<img src='../images/hot.gif'>");
					}//if end 
					
					//오늘 작성한 글제목 뒤에 new 이미지 출력
					//작성일(board_readcnt)에서 "년월일"만자르기
					String board_readcnt=dto.getBoard_readcnt().subString(0, 10);
					if(board_readcnt.equals(today)){//작성일과 오늘날짜가 같다면
					    out.println("<img src='../images/new.gif'>");
					}//if end
%>					
				</td>
				<td><%=dto.getBoard_readcnt()%></td>
			</tr>
<%	        
	    }//for end
	    
	    //글갯수
	    int totalRecord=dao.count2(col, word);
	    out.println("<tr>");
	    out.println("	<td colspan='4' style='text-align:center;'>");
	    out.println("		글갯수:<strong>" + totalRecord + "</strong>");
	    out.println("	</td>");
	    out.println("</tr>");
%>
		<!-- 페이지 리스트 -->
		<tr>
			<td colspan='4' style='text-align:center; height: 50px;'>
<%		
				String paging=new Paging().paging3(totalRecord, nowPage, recordPerPage, col, word, "bbsList.jsp");
				out.print(paging);
%>			
			</td>
		</tr>

		<!-- 검색시작 -->
		<tr>
			<td colspan='4' style='text-align:center; height: 50px;'>
				<form action="bbsList.jsp">
					<select name="col">
						<option value="title_content">제목+내용
						<option value="title">제목
						<option value="content">내용					
					</select>
					<input type="text" name="word" id="word">
					<input type="submit" value="검색" class="btn btn-primary">
				</form>
			</td>
		</tr>
		<!-- 검색끝 -->
<%  	    
	}//if end
%>  	
  	</tbody>
  	</table>
</div>

<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    