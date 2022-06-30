package kr.co.samjo.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/member/loginProc.do")
	public ModelAndView loginProc() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/loginProc");
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
	public ModelAndView memberProc(@ModelAttribute MemberDTO dto, HttpServletRequest req) {
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
	
	
	@RequestMapping("/member/logout.do")
	public ModelAndView logout() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/logout");
		return mav;
	}//logout() end
	
	@RequestMapping("/member/idCheckProc.do")
	public ModelAndView idCheckProc() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/idCheckProc");
		return mav;
	}//idCheckProc() end
	
	@RequestMapping("/member/emailCheckForm.do")
	public ModelAndView emailCheckForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/emailCheckForm");
		return mav;
	}//emailCheckForm() end
	
	@RequestMapping("/member/emailCheckProc.do")
	public ModelAndView emailCheckProc() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/emailCheckProc");
		return mav;
	}//emailCheckProc() end
}
