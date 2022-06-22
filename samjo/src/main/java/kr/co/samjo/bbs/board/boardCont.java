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
	
	@RequestMapping("/board/boardList.do")
	public ModelAndView boardList() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/boardList");
		return mav;
	}//home() end
	
	
}//class end
