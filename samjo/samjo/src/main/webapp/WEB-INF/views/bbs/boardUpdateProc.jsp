<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>    
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsUpdateProc.jsp -->
<!-- 수정된 내용으로 수정하기 -->
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
								String bbs_id  =request.getParameter("bbs_id").trim();
								String bbs_title=request.getParameter("bbs_title").trim();
								String bbs_content=request.getParameter("bbs_content").trim();
								String bbs_userip     =request.getRemoteAddr(); //요청PC의 IP
							
								dto.setBbs_idx(bbs_idx);
								dto.setBbs_id(bbs_id);
								dto.setBbs_title(bbs_title);
								dto.setBbs_content(bbs_content);
								dto.setBbs_userip(bbs_userip);
								
								int cnt=dao.updateproc(dto);   
							    if(cnt==0){
							        out.println("<p>비밀번호가 일치하지 않습니다</p>");
							        out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
							    }else{
							        out.println("<script>");
							        out.println("    alert('게시글이 수정되었습니다');");
							        out.println("    location.href='boardList.jsp';");//목록페이지 이동
							        out.println("</script>");
							    }//if end
							%>	
							</div>
						</div>
					</div>
				</div>
			</aside>
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    