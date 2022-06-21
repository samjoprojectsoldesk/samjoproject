package kr.co.samjo.cart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class cartCont {
	cartDAO dao = null;
	
	public cartCont() {
		dao = new cartDAO();
		System.out.println("-----cartCont객체 생성됨");
	}
	
	@RequestMapping(value="cart/add.do", method=RequestMethod.POST)
	public ModelAndView cartAdd(@ModelAttribute cartDTO dto) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cart/msgView");
		
		int cnt=dao.create(dto);
		if(cnt==0) {
			String msg="<p>장바구니 등록 실패</p>";
			String img="<img src='../images/fail.png'>";
			String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2="<input type='button' value='장바구니목록' onclick='location.href=\"list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		}else {
			String msg="<p>장바구니 등록 성공</p>";
			String img="<img src='../images/sound.png'>";
			String link2="<input type='button' value='장바구니목록' onclick='location.href=\"list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		}
		return mav;
	}

	@RequestMapping("/cart/list.do")
	public ModelAndView list(String user_id) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cart/list");
		mav.addObject("list", dao.list(user_id));
		mav.addObject("user_id", user_id);
		return mav;
	}//list end
	
	@RequestMapping(value = "cart/delete.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int c_no) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cart/deleteForm");
		mav.addObject("c_no", c_no);
		return mav;
	}//deleteForm end

	@RequestMapping(value = "cart/delete.do", method = RequestMethod.POST)
	public ModelAndView deleteProc(int c_no) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cart/msgView");
		
		int cnt = dao.delete(c_no);
		if(cnt == 0) {}else {}
		
		return mav;
	}//deleteProc end
}
