<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>emailCheckProc.jsp</title>
</head>
<body>

	<div style="text-align: center">
		<h3>* 이메일 중복확인 결과 *</h3>
<%
		String email=request.getParameter("email").trim();
		int cnt=dao.duplecateID(email);
		out.println("입력email : <strong>" + email + "</strong>");
		if(cnt==0){
		    if(!(email.length()>8)){
%>
		        <script>alert("이메일 8글자이상 입력해 주세요");
		        history.back();</script>
<%
		    }//if end
		    else{
			out.println("<p>사용 가능한 이메일 입니다</p>");
			//사용 가능한 id를 부모창에 전달하기
			out.println("<a href='javascript:apply(\"" + email + "\")'>[적용]</a>");
		    }
%>
			<script>
				function apply(email) {
					//alert(email);
					//중복 확인된 id를 부모창(opener)
					opener.document.memfrm.email.value=email;
					window.close();
				}//apply() end
			</script>
<%
		}else{
			out.println("<p style='color:red'>해당 이메일은 사용할 수 없습니다</p>");
		}//if end
%>
		<hr>
		<a href="javascript:history.back()">[다시검색]</a>
		&nbsp;&nbsp;
		<a href="javascript:window.close()">[창닫기]</a>
	</div>
	
	
</body>
</html>

