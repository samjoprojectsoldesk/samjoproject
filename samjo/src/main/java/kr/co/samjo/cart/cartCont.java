package kr.co.samjo.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class cartCont {
	cartDAO dao = null;
	
	public cartCont() {
		dao = new cartDAO();
		System.out.println("-----cartCont객체 생성됨");
	}

	@RequestMapping("/cart/list.do")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cart/list");
		mav.addObject("list", dao.list());
		return mav;
	}//list end
	
}
