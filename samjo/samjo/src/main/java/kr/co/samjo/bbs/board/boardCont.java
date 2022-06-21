package kr.co.samjo.bbs.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class boardCont {
	public boardCont() {
		System.out.println("-----boardCont() 객체 생성됨");
	}//end
	
	//결과확인 http://localhost:9095/list.do
	
	@RequestMapping("/list.do")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("bbs/bbsList.do");//redirect : 등록한 명령어를 호출하 수 있다
		return mav;
	}//home() end
	
}//class end
