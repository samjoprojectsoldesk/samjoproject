package kr.co.samjo.product.packagetour;

import org.springframework.stereotype.Controller;

@Controller
public class packagetourCont {
	packagetourDAO dao = null;
	
	public packagetourCont() {
		dao = new packagetourDAO();
		System.out.println("-----packagetourCont객체 생성됨");
	}
	
}
