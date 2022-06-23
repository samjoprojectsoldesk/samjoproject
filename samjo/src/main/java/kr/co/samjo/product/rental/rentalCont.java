package kr.co.samjo.product.rental;

import org.springframework.stereotype.Controller;

@Controller
public class rentalCont {
	rentalDAO dao = null;
	
	public rentalCont() {
		dao = new rentalDAO();
		System.out.println("-----rentalCont객체 생성됨");
	}
	
}
