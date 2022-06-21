package kr.co.samjo.product.sooksoproduct;

import org.springframework.stereotype.Controller;

	
@Controller
public class SooksoProductCont {
	SooksoProductDAO dao = null;
	public SooksoProductCont() {
		dao = new SooksoProductDAO();
		System.out.println("-----SooksoProductCont() 객체 생성됨");
	}//end
}

