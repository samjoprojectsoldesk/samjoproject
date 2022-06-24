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
	
	
	@RequestMapping("/member/loginForm.do")
	public ModelAndView loginForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
	}//loginForm() end
	
	@RequestMapping("/member/agreement.do")
	public ModelAndView agreement() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/agreement");
		return mav;
	}//agreement() end
	
	@RequestMapping("/member/findID.do")
	public ModelAndView findID() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/findID");
		return mav;
	}//findID() end
	
	@RequestMapping("/member/idCheckForm.do")
	public ModelAndView idCheckForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/idCheckForm");
		return mav;
	}//idCheckForm() end
	
	@RequestMapping("/member/memberForm.do")
	public ModelAndView memberForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/memberForm");
		return mav;
	}//memberForm() end
	
	@RequestMapping("/member/memberProc.do")
	public ModelAndView memberProc() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/memberProc");
		return mav;
	}//memberProc() end
	
	@RequestMapping("/member/memberModify.do")
	public ModelAndView memberModify() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/memberModify");
		return mav;
	}//memberModify() end
	
	@RequestMapping("/member/findIDProc.do")
	public ModelAndView findIDProc() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/findIDProc");
		return mav;
	}//findIDProc() end
	
	
	
}
