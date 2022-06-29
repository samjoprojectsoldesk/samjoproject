<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %> 
<%@ include file="../header.jsp" %>    
<!-- 본문시작 InsProc.jsp -->
<%
	
	//사용자가 입력 요청한 정보를 가져오기
	String U_code		=request.getParameter("u_code").trim();
	String U_name		=request.getParameter("u_name").trim();
	String U_phone		=request.getParameter("u_phone").trim();
	String U_office		=request.getParameter("u_office").trim();
	String C_code		=request.getParameter("c_code").trim();
	String C_kind		=request.getParameter("c_kind").trim();
	String C_name		=request.getParameter("c_name").trim();
	int C_sum			=Integer.parseInt(request.getParameter("c_sum").trim());
	int C_charge		=Integer.parseInt(request.getParameter("c_charge").trim());
	int C_reserve		=Integer.parseInt(request.getParameter("c_reserve").trim());
	String C_img		=request.getParameter("c_img").trim();
	String C_cont	=request.getParameter("c_cont").trim();

	//dto객체에 담기
	dto.setU_code(U_code);
	dto.setU_name(U_name);
	dto.setU_phone(U_phone);
	dto.setU_office(U_office);
	dto.setC_code(C_code);
	dto.setC_kind(C_kind);
	dto.setC_name(C_name);
	dto.setC_sum(C_sum);
	dto.setC_charge(C_charge);
	dto.setC_reserve(C_reserve);
	dto.setC_img(C_img);
	dto.setC_cont(C_cont);
	
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