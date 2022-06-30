<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 list.jsp -->
<aside id="fh5co-hero-T" class="js-fullheight">
	<div class="flexslider js-fullheight">
		<div class="container">
			<div class="slider-text-inner desc">
				<h2
					style="margin-top: 300px; text-align: center; font-weight: bold;"
					class="heading-section">${dto.s_name}</h2>
			</div>
		</div>
	</div>
</aside>

<div class="row-read">
	<div class="col-md-12 text-center project">
		<div class="grid-project">
		
				<div class="image-T">
					<img src="../../storage/${dto.s_img}" class="img-responsive"
						style="width: 40%; float: left;">
					<div class="desc-T">
						<ul>
					
							<strong>기본정보</strong>						
							<hr>
							<li>주소&emsp;&emsp;&emsp;${dto.s_addr}</li>
							<li>전화번호&nbsp;&nbsp;&nbsp;&nbsp;${dto.s_tel}</li>
							<li>홈페이지&nbsp;&nbsp;&nbsp;&nbsp; <a class="textLink"
								href="${dto.s_link}" target="_blank">${dto.s_link}</a>
							</li>
							</ul>
					</div>
				</div>
			</div>
		</div>
		
	
	<div class="col-md-12" id="tab-menu">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="col-md-4 nav-item"><a class="nav-link active"
				id="info-tab" data-toggle="tab" href="#info" role="tab"
				aria-controls="info" aria-selected="true">객실안내/예약</a>
			</li>
			<li class="col-md-4 nav-item"><a class="nav-link" id="map-tab"
				data-toggle="tab" href="#map" role="tab" aria-controls="map"
				aria-selected="false">숙소 정보</a>	
			</li>
			<li class="col-md-4 nav-item"><a class="nav-link"
				id="review-tab" data-toggle="tab" href="#review" role="tab"
				aria-controls="review" aria-selected="false">리뷰</a>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="info" role="tabpanel"
				aria-labelledby="info-tab">
				<form>
				<div class="container">
				<input id="datepicker1" type="text"> - <input id="datepicker2" type="text">
				<script>
				datePickerSet($("#datepicker1"), $("#datepicker2"), true); //다중은 시작하는 달력 먼저, 끝달력 2번째

				/*
				    * 달력 생성기
				    * @param sDate 파라미터만 넣으면 1개짜리 달력 생성
				    * @example   datePickerSet($("#datepicker"));
				    * 
				    * 
				    * @param sDate, 
				    * @param eDate 2개 넣으면 연결달력 생성되어 서로의 날짜를 넘어가지 않음
				    * @example   datePickerSet($("#datepicker1"), $("#datepicker2"));
				    */
				function datePickerSet(sDate, eDate, flag) {

				    //시작 ~ 종료 2개 짜리 달력 datepicker	
				    if (!isValidStr(sDate) && !isValidStr(eDate) && sDate.length > 0 && eDate.length > 0) {
				        var sDay = sDate.val();
				        var eDay = eDate.val();

				        if (flag && !isValidStr(sDay) && !isValidStr(eDay)) { //처음 입력 날짜 설정, update...			
				            var sdp = sDate.datepicker().data("datepicker");
				            sdp.selectDate(new Date(sDay.replace(/-/g, "/")));  //익스에서는 그냥 new Date하면 -을 인식못함 replace필요

				            var edp = eDate.datepicker().data("datepicker");
				            edp.selectDate(new Date(eDay.replace(/-/g, "/")));  //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
				        }

				        //시작일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
				        if (!isValidStr(eDay)) {
				            sDate.datepicker({
				                maxDate: new Date(eDay.replace(/-/g, "/"))
				            });
				        }
				        sDate.datepicker({
				            language: 'ko',
				            autoClose: true,
				            onSelect: function () {
				                datePickerSet(sDate, eDate);
				            }
				        });

				        //종료일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
				        if (!isValidStr(sDay)) {
				            eDate.datepicker({
				                minDate: new Date(sDay.replace(/-/g, "/"))
				            });
				        }
				        eDate.datepicker({
				            language: 'ko',
				            autoClose: true,
				            onSelect: function () {
				                datePickerSet(sDate, eDate);
				            }
				        });

				        //한개짜리 달력 datepicker
				    } else if (!isValidStr(sDate)) {
				        var sDay = sDate.val();
				        if (flag && !isValidStr(sDay)) { //처음 입력 날짜 설정, update...			
				            var sdp = sDate.datepicker().data("datepicker");
				            sdp.selectDate(new Date(sDay.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
				        }

				        sDate.datepicker({
				            language: 'ko',
				            autoClose: true
				        });
				    }


				    function isValidStr(str) {
				        if (str == null || str == undefined || str == "")
				            return true;
				        else
				            return false;
				    }
				}
</script>
					<c:forEach var="dto" items="${list}">
					<div class="col-md-4 text-center project">
						<img src="../../storage/${dto.room_img}" class="img-responsive"
						style="width: 40%; float: left;">
							<div class="desc">
								<div>${dto.room_name}</div>
								<div>${dto.room_mp}</div>
								<div>${dto.room_dp}</div>
								<div>${dto.room_ep}</div>
							</div>
						</a>
					</div>
				</c:forEach>

			<div class="tab-pane fade" id="map" role="tabpanel"
				aria-labelledby="map-tab">${dto.s_cont}</div>
				
			<div class="tab-pane fade" id="review" role="tabpanel"
				aria-labelledby="review-tab">리뷰 추가하기</div>
		</div>
	</div>
	</div>
	</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>