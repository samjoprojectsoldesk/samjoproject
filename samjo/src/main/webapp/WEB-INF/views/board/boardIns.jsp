<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>  
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsIns.jsp -->
<%
	//사용자가 입력 요청한 정보를 가져오기
	int bbs_idx=Integer.parseInt(request.getParameter("bbs_idx"));
	String bbs_title=request.getParameter("bbs_title").trim();
	String bbs_content=request.getParameter("bbs_content").trim();
	String bbs_userip     =request.getRemoteAddr(); //요청PC의 IP

	//dto객체에 담기
	dto.setBbs_idx(bbs_idx);
	dto.setBbs_title(bbs_title);
	dto.setBbs_content(bbs_content);
	dto.setBbs_userip(bbs_userip);
	
	int cnt=dao.create(dto);  
    if(cnt==0){
        out.println("<p>글추가 실패했습니다</p>");
        out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
    }else{
        out.println("<script>");
        out.println("    alert('게시글이 추가되었습니다');");
        out.println("    location.href='boardList.do';");//목록페이지 이동
        out.println("</script>");
    }//if end
%>	
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    