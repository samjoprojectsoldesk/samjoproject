package kr.co.samjo.product.sookso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.samjo.cart.cartDAO;

@Controller
public class SooksoCont {
	SooksoDAO dao = null;
	public SooksoCont() {
		dao = new SooksoDAO();
		System.out.println("-----SooksoCont() 객체 생성됨");
	}//end
	
	//결과확인 http://localhost:9095/product.do
	
		//요청명령어 등록하고, 실행의 주체는 메소드(함수)
		@RequestMapping("/product.do")
		public ModelAndView index() {
			ModelAndView mav=new ModelAndView();
			// applicaion.properties환경설정 파일 참조
			// /WEB-INF/views/index.jsp
			mav.setViewName("product/sooksoProduct");
			return mav;
		}//hello() end
}
