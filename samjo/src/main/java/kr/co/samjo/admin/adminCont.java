package kr.co.samjo.admin;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.samjo.product.sookso.SooksoDTO;
import net.utility.Utility;

@Controller
public class adminCont {

	adminDAO dao = null;

	public adminCont() {
		dao = new adminDAO();// DB연결 객체 생성
		System.out.println("-----adminCont() 객체 생성됨");
	}// end

	// 결과확인 http://localhost:9095/admin/index.do

	// 요청명령어 등록하고, 실행의 주체는 메소드(함수)
	@RequestMapping("admin/index.do")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		// applicaion.properties환경설정 파일 참조
		// /WEB-INF/views/index.jsp
		mav.setViewName("admin/index");
		return mav;
	}// index() end



}
