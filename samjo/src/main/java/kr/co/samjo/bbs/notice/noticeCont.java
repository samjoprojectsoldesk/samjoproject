package kr.co.samjo.bbs.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class noticeCont {
	noticeDAO dao = null;
	
	public noticeCont() {
		dao = new noticeDAO();
		System.out.println("-----noticeCont객체 생성됨");
	}
	
	@RequestMapping("notice/bbsList.do")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/bbsList");
		return mav;
	}//notice() end

	
	@RequestMapping(value = "notice/bbsIns.do", method = RequestMethod.GET)
	public String bbsIns() {
		return "notice/bbsIns"; 
	}//bbsIns() end
	
	
	@RequestMapping(value = "notice/bbsIns.do", method = RequestMethod.POST)
	public ModelAndView InsProc(@ModelAttribute noticeDTO dto) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/msgView");

		int cnt = dao.bbsInsProc(dto);
		if (cnt == 0) {
			String msg = "<p>공지사항 등록 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='공지사항 목록' onclick='location.href=\"list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>공지사항 등록 성공</p>";
			String img = "<img src='../images/sound.png'>";
			String link1 = "<input type='button' value='계속등록' onclick='location.href=\"create.do\"'>";
			String link2 = "<input type='button' value='공지사항 목록' onclick='location.href=\"list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);

		} // if end

		return mav;

	}// bbsInsProc() end
	
	
}
