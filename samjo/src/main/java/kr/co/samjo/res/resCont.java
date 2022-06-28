package kr.co.samjo.res;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class resCont {

	resDAO dao = null;
	resDetailDAO dt_dao = null;
	
	public resCont() {
		dao = new resDAO();
		dt_dao = new resDetailDAO();
		System.out.println("-----resCont객체 생성됨");
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
	
	@RequestMapping("read.do")
	public ModelAndView read(String res_no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/res/read");
		
		return mav;
	}
	
}
