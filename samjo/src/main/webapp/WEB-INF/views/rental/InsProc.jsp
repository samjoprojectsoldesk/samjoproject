<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %> 
<%@ include file="../header.jsp" %>    
<!-- 본문시작 InsProc.jsp -->
<%
	
	//사용자가 입력 요청한 정보를 가져오기
	String u_code			=request.getParameter("u_code").trim();
	String u_name			=request.getParameter("u_name").trim();
	String u_phone			=request.getParameter("u_phone").trim();
	String u_office			=request.getParameter("u_office").trim();
	String u_img			=request.getParameter("u_img").trim();
	String u_cont			=request.getParameter("u_cont").trim();
	String review_user_id	=request.getParameter("review_user_id").trim();
	String review_content 	=request.getParameter("review_content").trim();
	String review_date		=request.getParameter("review_date").trim();
	
	//dto객체에 담기
	dto.setU_code(u_code);
	dto.setU_name(u_name);
	dto.setU_phone(u_phone);
	dto.setU_office(u_office);
	dto.setU_phone(u_img);
	dto.setU_office(u_cont);
	dto.setReview_user_id(review_user_id);
	dto.setReview_content(review_content);
	dto.setReview_date(review_date);
	
	int cnt=dao.create(dto); 
    if(cnt==0){
        out.println("<p>글추가 실패했습니다</p>");
        out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
    }else{
        out.println("<script>");
        out.println("    alert('게시글이 추가되었습니다');");
        out.println("    location.href='List.jsp';");//목록페이지 이동
        out.println("</script>");
    }//if end
%>
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    