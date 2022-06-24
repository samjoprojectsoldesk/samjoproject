package kr.co.samjo.cart;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class cartCont {
	
	cartDAO dao = null;

	public cartCont() {
		dao = new cartDAO();
		System.out.println("-----cartCont객체 생성됨");
	}
	
	@RequestMapping(value = "cart/add.do", method = RequestMethod.POST)
	public ModelAndView cartAdd(@ModelAttribute cartDTO dto, HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		dto.setUser_id(user_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart/msgView");

		int cnt = dao.create(dto);
		if (cnt == 0) {
			String msg = "<p>장바구니 등록 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='장바구니목록' onclick='location.href=\"list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>장바구니 등록 성공</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='장바구니목록' onclick='location.href=\"list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		}
		return mav;
	}

	@RequestMapping("/cart/list.do")
	public ModelAndView list(@ModelAttribute cartDTO dto, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		ModelAndView mav = new ModelAndView();
		String userId = (String) session.getAttribute("s_id");
		if(userId==null) {userId="guest";}
		ArrayList<cartDTO> list = new ArrayList<cartDTO>();
		list = dao.list(userId.trim());
		
		if(list==null) {
			map.put("list", list);
			map.put("count", 0);
		}else {
			map.put("list", list);
			map.put("count", list.size());
		}
		
		mav.setViewName("cart/list");
		mav.addObject("map", map);
		
		return mav;
	}// list end

	@RequestMapping(value = "cart/delete.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int c_no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart/delete");
		mav.addObject("c_no", c_no);
		return mav;
	}// deleteForm end

	@RequestMapping(value = "cart/delete.do", method = RequestMethod.POST)
	public ModelAndView deleteProc(int c_no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart/msgView");

		int cnt = dao.delete(c_no);
		if (cnt == 0) {
			String msg="<p>장바구니 항목 삭제 실패</p>";
			String img="<img src='../images/fail.png'>";
			String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2="<input type='button' value='목록으로' onclick='location.href=\"list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg="<p>장바구니 항목 삭제 성공</p>";
			String img="<img src='../images/sound.png'>";
			String link2="<input type='button' value='목록으로' onclick='location.href=\"list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		}

		return mav;
	}// deleteProc end
}
