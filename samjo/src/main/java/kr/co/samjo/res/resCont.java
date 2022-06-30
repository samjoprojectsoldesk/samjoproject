package kr.co.samjo.res;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.samjo.cart.cartDAO;
import kr.co.samjo.cart.cartDTO;


@Controller
public class resCont {

	resDAO dao = null;
	resDetailDAO dt_dao = null;
	
	public resCont() {
		dao = new resDAO();
		dt_dao = new resDetailDAO();
		System.out.println("-----resCont객체 생성됨");
	}
	
	@RequestMapping(value = "/res/reseve.do", method = RequestMethod.GET)
	public ModelAndView reserve() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/res/reserve");
		return mav;
	}
	
	@RequestMapping(value = "/res/reseve.do", method = RequestMethod.POST)
	public ModelAndView reserveProc(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("s_id");
		if(user_id == null) {user_id="guest";}
		
		cartDAO cdao = new cartDAO();
		ArrayList<cartDTO> list = cdao.list(user_id);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/res/reserve");
		return mav;
	}

	@RequestMapping("/res/list.do")
	public ModelAndView list(@ModelAttribute resDTO dto, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		ModelAndView mav = new ModelAndView();
		String userId = (String) session.getAttribute("s_id");
		if(userId==null) {userId="guest";}
		ArrayList<resDTO> list = new ArrayList<resDTO>();
		list = dao.list(userId.trim());
		
		if(list==null) {
			map.put("list", list);
			map.put("count", 0);
		}else {
			map.put("list", list);
			map.put("count", list.size());
		}
		
		mav.setViewName("res/list");
		mav.addObject("map", map);
		
		return mav;
	}// list end
	
	@RequestMapping("res/read.do")
	public ModelAndView read(String res_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/res/read");
		ArrayList<resDetailDTO> list = new ArrayList<resDetailDTO>();
		list = dt_dao.list(res_no);

		if(list==null) {
			map.put("list", list);
			map.put("count", 0);
		}else {
			map.put("list", list);
			map.put("count", list.size());
		}
		
		return mav;
	}
	
}
