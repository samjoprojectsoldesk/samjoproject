package kr.co.samjo.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberCont {
	
	private MemberDAO dao=null;
	
	public MemberCont() {
		System.out.println("-----loginFormCont() 객체 생성됨");
	}//end
	
	//결과확인 http://localhost:9095/loginForm.do
	
	@RequestMapping("/member/loginForm.do")
	public ModelAndView loginForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
	}//hello() end
	
}
