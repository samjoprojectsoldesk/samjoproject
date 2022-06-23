package kr.co.samjo.product.rentalcar;

import org.springframework.stereotype.Controller;

@Controller
public class rentalcarCont {
	rentalcarDAO dao = null;
	
	public rentalcarCont() {
		dao = new rentalcarDAO();
		System.out.println("-----rentalcarCont객체 생성됨");
	}
	
}
