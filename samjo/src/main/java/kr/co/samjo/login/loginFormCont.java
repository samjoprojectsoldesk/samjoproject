package kr.co.samjo.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class loginFormCont {
	public loginFormCont() {
		System.out.println("-----loginFormCont() 객체 생성됨");
	}//end
	
	//결과확인 http://localhost:9095/loginForm.do
	
	//요청명령어 등록하고, 실행의 주체는 메소드(함수)
	@RequestMapping("/member/loginForm.do")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		// applicaion.properties환경설정 파일 참조
		// /WEB-INF/views/index.jsp
		mav.setViewName("/member/loginForm");
		return mav;
	}//hello() end
}
