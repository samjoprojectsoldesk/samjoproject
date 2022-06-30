<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %> 
<%@ include file="../header.jsp" %>    
<!-- 본문시작 InsProc.jsp -->
<%
	
	//사용자가 입력 요청한 정보를 가져오기
	String pack_no		=request.getParameter("pack_no").trim();
	String pack_name	=request.getParameter("pack_name").trim();
	String pack_cose	=request.getParameter("pack_cose").trim();
	String pack_plan	=request.getParameter("pack_plan").trim();
	int pack_price		=Integer.parseInt(request.getParameter("pack_price").trim());
	int pack_people		=Integer.parseInt(request.getParameter("pack_people").trim());
	String pack_cont	=request.getParameter("pack_cont").trim();
	String pack_img	 	=request.getParameter("pack_img").trim();
	String review_user_id	=request.getParameter("review_user_id").trim();
	String review_content 	=request.getParameter("review_content").trim();
	String review_date		=request.getParameter("review_date").trim();
	
	//dto객체에 담기
	dto.setPack_no(pack_no);
	dto.setPack_name(pack_name);
	dto.setPack_cose(pack_cose);
	dto.setPack_plan(pack_plan);
	dto.setPack_price(pack_price);
	dto.setPack_people(pack_people);
	dto.setPack_cont(pack_cont);
	dto.setPack_img(pack_img);
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