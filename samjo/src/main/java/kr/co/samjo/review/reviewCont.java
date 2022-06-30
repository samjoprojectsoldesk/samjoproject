package kr.co.samjo.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class reviewCont {

	reviewDAO dao = null;
	
	public reviewCont() {
		dao = new reviewDAO(); //DB연결 객체 생성
		System.out.println("-----reviewCont() 객체 생성됨");
	}//end
	
	@RequestMapping(value = "reviewcreate.do", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/createForm");
		return mav; 
	}//create() end
	
	
	@RequestMapping(value = "reviewcreate.do", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute reviewDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/msgView");

		int cnt = dao.create(dto);
		if (cnt == 0) {
			String msg = "<p>리뷰 등록 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='홈 화면으로 돌아가기' onclick='location.href=\"index.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>공지사항 등록 성공</p>";
			String img = "<img src='../images/sound.png'>";
			String link1 = "<input type='button' value='계속등록' onclick='location.href=\"reviewcreate.do\"'>";
			String link2 = "<input type='button' value='홈 화면으로 돌아가기' onclick='location.href=\"index.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} // if end
		return mav;
	}// create() end
	
	
	@RequestMapping(value = "reviewread.do", method = RequestMethod.GET)
	public ModelAndView read() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/read");
		return mav; 
	}//read() end
	
	@RequestMapping(value = "reviewupdate.do", method = RequestMethod.GET)
	public ModelAndView update() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/updateForm");
		return mav; 
	}//update() end
	
	@RequestMapping(value = "reviewdelete.do", method = RequestMethod.GET)
	public ModelAndView delete() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/deleteForm");
		return mav; 
	}//delete() end

	
}
