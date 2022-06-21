<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 template.jsp -->
		<aside id="fh5co-hero" class="js-fullheight">
			<div class="flexslider js-fullheight">
				<div class="slides">
				   	<div class="container">
				   		<div style="margin-top: 25%;">상 품 목 록</div>
				   		<%
				   		ProductRepository dao = ProductRepository.getInstance();	
				   							ArrayList<Product> listOfProducts = SooksoDAO.getAllProducts();
				   		%>
						
						<div class="container">
							<div class="row" align="center">
								<%
									for(int i=0; i<listOfProducts.size(); i++){
										Product product = listOfProducts.get(i);
								%>
								
								<div class="col-md-4">
									<img src="./upload/<%=product.getFilename() %>"
									style="width:100%">
									<h3><%=product.getPname() %></h3>				<!-- 상품 이름 -->
									<p><%=product.getUnitPrice() %>원				<!-- 가격 -->
									<p><a href="./Product.jsp?id=<%=product.getProductId() %>" <!-- 상세보기 -->
										class="btn btn-secondary" role="button">
											<!-- &raquo; = 특수문자 -->
											상세 정보 &raquo;
										</a>
								</div>
								
								<%
									}
								%>
							</div>
						</div>
				   	</div>
				 </div>
			 </div>
		</aside>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>