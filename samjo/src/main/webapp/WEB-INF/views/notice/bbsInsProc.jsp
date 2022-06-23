<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %> 
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsInsProc.jsp -->
<%
	
	//사용자가 입력 요청한 정보를 가져오기
	int board_no		 =Integer.parseInt(request.getParameter("board_no").trim());
	String board_title	 =request.getParameter("board_title").trim();
	String board_content =request.getParameter("board_content").trim();
	String board_date	 =request.getParameter("board_date").trim();

	//dto객체에 담기
	dto.setBoard_no(board_no);
	dto.setBoard_title(board_title);
	dto.setBoard_content(board_content);
	dto.setBoard_date(board_date);
	
	int cnt=dao.create(dto); 
    if(cnt==0){
        out.println("<p>글추가 실패했습니다</p>");
        out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
    }else{
        out.println("<script>");
        out.println("    alert('게시글이 추가되었습니다');");
        out.println("    location.href='bbsList.jsp';");//목록페이지 이동
        out.println("</script>");
    }//if end
%>
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    