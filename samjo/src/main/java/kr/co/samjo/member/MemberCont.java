package kr.co.samjo.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberCont {
	
	private MemberDAO dao=null;
	
	//mymelon프로젝트의 MediagroupCont 참조하시면 됩니다~
	public MemberCont() {
		dao=new MemberDAO();
		System.out.println("-----loginFormCont() 객체 생성됨");
	}//end
	
	
	@RequestMapping("/member/loginForm.do")
	public ModelAndView loginForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
	}//loginForm() end
	
	
	///////////////////////////////////////////////////////
	// spring03_web 프로젝트 kr.co.web.test03 팩키지 참조하면 됩니다
	///////////////////////////////////////////////////////
	
	//<form name="loginfrm" id="loginfrm" method="post" action="loginProc.do"> post방식으로 요청했을때
	@RequestMapping(value = "/member/loginProc.do", method = RequestMethod.POST)
	public ModelAndView loginProc(HttpServletRequest req, HttpSession session) {
		//loginForm.jsp에서 입력한 아이디/비번 가져오기		
		String user_id	 =req.getParameter("user_id").trim();
		String user_pw   =req.getParameter("user_pw").trim();
		
		//dto에 담기
		MemberDTO dto=new MemberDTO();
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		
		//DB에 가서 로그인 정보 가져오기
		String user_level=dao.loginProc(dto);
		
		//세션영역에 로그인 정보 올리기
		session.setAttribute("s_id", user_id);
		session.setAttribute("s_passwd", user_pw);
		session.setAttribute("s_mlevel", user_level);		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/loginForm"); //뷰페이지 이동하기
		
		return mav;
	}//loginProc() end
	
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
<<<<<<< HEAD
	
	
	
=======
>>>>>>> c6f51390f5bd146725f3ed71a867dd75b857c685
}
