package kr.co.samjo.product.maszip;

import org.springframework.stereotype.Controller;

@Controller
public class MaszipCont {
	MaszipDAO dao = null;
	
	public MaszipCont() {
		dao = new MaszipDAO();
		System.out.println("-----MaszipCont객체 생성됨");
	}
}
