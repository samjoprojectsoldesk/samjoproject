<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>여기놀자</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />

  <!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FREEHTML5.CO
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700,900' rel='stylesheet' type='text/css'>
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="css/superfish.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="css/flexslider.css">

	<link rel="stylesheet" href="css/style.css">


	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">
		<div id="fh5co-header">
		
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<a href="/index.do" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
						<h1 id="fh5co-logo"><a href="index.do"><i class="icon-home2"></i>여기놀자</a></h1>
						<!-- START #fh5co-menu-wrap -->
						<nav id="fh5co-menu-wrap" role="navigation">
							<ul class="sf-menu" id="fh5co-primary-menu">
								<li>
									<a class="bold" href="index.html">여행지소개</a>
									<ul class="fh5co-sub-menu">
									 	<li><a href="/tour/tourist.do">관광지</a></li>
									 	<li><a href="/tour/festivalList.do">문화행사</a></li>
									</ul>
								</li>
								<li>
									<a class="bold" href="work.html">예약</a>
									<ul class="fh5co-sub-menu">
									 	<li><a href="left-sidebar.html">숙박</a></li>
									 	<li><a href="right-sidebar.html">교통</a></li>
										<li><a href="#" class="fh5co-sub-ddown">맛집</a></li>
										<li><a href="#">패키지</a></li>
									</ul>
								</li>
								<li>
									<a class="bold" href="services.html" class="fh5co-sub-ddown">커뮤니티</a>
									 <ul class="fh5co-sub-menu">
									 	<li><a href="/cart/list.do">공지사항</a></li>
									 	<li><a href="/board/boardList.do">자유게시판</a></li>
									</ul>
								</li>
								<li>
									<a class="bold" href="about.html">마이페이지</a>
									<ul class="fh5co-sub-menu">
									 	<li><a href="left-sidebar.html">개인정보수정</a></li>
									 	<li><a href="right-sidebar.html">예약관리</a></li>
									</ul>
								</li>
								<li>
									<a class="bold" href="/member/loginForm.do">로그인</a>
								</li>
								<li>
									<a class="bold" href="/cart/list.do">장바구니</a>
								</li>
							</ul>
						</nav>
					</div>
					<div class="bottomMenu">
                     <div class="searchWrap">
                       <div class="search">
                        <form method="post" name="RsaSearchForm" action="https://search.gyeongju.go.kr/tour/front/Search.jsp" target="_blank" onsubmit="return ">
                           <input type="hidden" name="menu" id="menu2" value="통합검색" />
                           <label class="hidden" for="qt2">검색어 입력</label>
                           <input type="text" name="qt" id="qt2" value="필요한 정보를 검색해보세요." onfocus="value=''"/>
                           <a href="#self" title="새창" class="btn" onclick="checkSerData2(document.RsaSearchForm)">검색</a>
                        </form>
                     </div>
                     </div>
                     <ul class="weather">
                       <li class="todayWeather" >오늘<span class="wTemp">20℃</span></li>
                       <li class="tomorrowWeather" >내일<span class="wState hidden">21℃</span></li>
                       <li class="afterTomorrowWeather">모레<span class="wState2 hidden">22℃</span></li>
                     </ul>
                  </div>
				</div>

			</header>		
		</div>
		<!-- end:fh5co-header -->
		<aside id="fh5co-hero" class="js-fullheight">
			<div class="flexslider js-fullheight">
				<ul class="slides">
			   	<li style="background-image: url(images/dachae.jpg);">
			   		<div class="overlay-gradient"></div>
			   		<div class="container">
			   			<div class="col-md-5 col-sm-6 col-xs-12 js-fullheight slider-text">
			   				<div class="slider-text-inner">
			   					<div class="desc">
			   						<h2>6월 경주, 다채로움</h2>
			   						<p><a href="#" class="btn btn-primary btn-outline">View Details</a></p>
			   					</div>
			   				</div>
			   			</div>
			   		</div>
			   	</li>
			   	<li style="background-image: url(images/top.jpg);">
			   		<div class="overlay-gradient"></div>
			   		<div class="container">
			   			<div class="col-md-5 col-sm-6 col-xs-12 js-fullheight slider-text">
			   				<div class="slider-text-inner">
			   					<div class="desc">
			   						<h2>경주로 오시는 길</h2>
			   						<p><a href="#" class="btn btn-primary btn-outline">View Details</a></p>
			   					</div>
			   				</div>
			   			</div>
			   		</div>
			   	</li>
			   	<li style="background-image: url(images/donghak2.jpg);">
			   		<div class="overlay-gradient"></div>
			   		<div class="container">
			   			<div class="col-md-5 col-sm-6 col-xs-12 js-fullheight slider-text">
			   				<div class="slider-text-inner">
			   					<div class="desc">
			   						<h2>동학의 발상지 따라<br>현곡여행</h2>
			   						<p><a href="#" class="btn btn-primary btn-outline">View Details</a></p>
			   					</div>
			   				</div>
			   			</div>
			   		</div>
			   	</li>
			  	</ul>
		  	</div>
		</aside>
		
		<footer>
			<div id="footer">
				<div class="container">
					
					<div class="row copy-right">
						<div class="col-md-6 col-md-offset-3 text-center">
							<p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p>
							<p>&copy; 2022 <a href="#">Samjo</a>. All Rights Reserved. <br>Made with <i class="icon-heart3"></i> by <a href="http://freehtml5.co/" target="_blank">Freehtml5.co</a> / Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash </a>,<a href="https://pexels.com/" target="_blank"> Pexels</a> <br> Colored Icons: <a href="http://flaticon.com" target="_blank">Flaticon</a></p>
						</div>
					</div>
				</div>
			</div>
		</footer>
	

	</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->


	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="js/main.js"></script>

	</body>
</html>