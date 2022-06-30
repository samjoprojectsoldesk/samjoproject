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
	cartDAO cdao = null;
	resDetailDAO dt_dao = null;
	
	public resCont() {
		cdao = new cartDAO();
		dao = new resDAO();
		dt_dao = new resDetailDAO();
		System.out.println("-----resCont객체 생성됨");
	}
	
	@RequestMapping(value = "/res/reseve.do", method = RequestMethod.GET)
	public ModelAndView reserve(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = (String) session.getAttribute("s_id");
		if(userId==null) {userId="guest";}
		ArrayList<cartDTO> list = new ArrayList<cartDTO>();
		list = cdao.list(userId.trim());
		long amount = cdao.amount(list);
		
		if(list==null) {
			map.put("list", list);
			map.put("amount", amount);
			map.put("count", 0);
		}else {
			map.put("list", list);
			map.put("amount", amount);
			map.put("count", list.size());
		}
		
		mav.setViewName("../res/reserve");
		mav.addObject("map", map);		
		return mav;
	}
	
	@RequestMapping(value = "/res/reseve.do", method = RequestMethod.POST)
	public ModelAndView reserveProc(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/res/msgView");
		
		resDTO rdto = new resDTO();
		String user_id = (String) session.getAttribute("s_id");
		if(user_id == null) {user_id="guest";}
		
		cartDAO cdao = new cartDAO();
		ArrayList<cartDTO> list = cdao.list(user_id);
		rdto.setUser_id(user_id);
		rdto.setAmount(Integer.parseInt(request.getParameter("amount")));
		rdto.setPay(request.getParameter("pay"));
		rdto.setResult("Y");
		
		int cnt = dao.add(rdto);
		
		if (cnt == 0) {
			String msg = "<p>장바구니 등록 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='장바구니목록' onclick='location.href=\"../cart/list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>장바구니 등록 성공</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='장바구니목록' onclick='location.href=\"/res/list.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
			cdao.delete(user_id);
		}
		
		ArrayList<resDTO> reslist = dao.list(user_id);
		
		for(int i=0;i<list.size();i++) {
			dt_dao.create(list.get(i), reslist.get(reslist.size()-1).getRes_no());
		}
		
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
