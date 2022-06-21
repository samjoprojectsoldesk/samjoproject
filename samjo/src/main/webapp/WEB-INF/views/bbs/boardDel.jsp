<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="ssi.jsp" %>    
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsDel.jsp -->
<!-- 글번호(bbsno)와 비밀번호(passwd)가 일치하면 삭제 -->
<%
	int bbs_idx=Integer.parseInt(request.getParameter("bbs_idx"));
%>
<h3>* 글삭제 *</h3>
<p><a href="boardList.jsp">[글목록]</a></p>
<div class="container">
	<form method="post" action="boardDelProc.jsp" onsubmit="return yesCheck()"><!-- myscript.js -->
		<input type="hidden" name="bbs_idx" value="<%=bbs_idx%>">
		<table class="table">
		<tr>
			<th class="success">삭제하시겠습니까?</th>
			<td><input type="password" name="yes" id="yes" required></td>
		</tr>
		<tr>
			<td colspan="2">
			    <input type="submit" value="삭제" class="btn btn-danger">
			</td>
		</tr>
		</table>
	</form>
</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    