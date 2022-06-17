package kr.co.samjo.cart;

import org.springframework.stereotype.Controller;

@Controller
public class cartCont {
	cartDAO dao = null;
	
	public cartCont() {
		dao = new cartDAO();
		System.out.println("-----cartCont객체 생성됨");
	}
	
}
