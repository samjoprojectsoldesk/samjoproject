package kr.co.samjo.res;

import org.springframework.stereotype.Controller;


@Controller
public class resCont {

	resDAO dao = null;
	
	public resCont() {
		dao = new resDAO();
		System.out.println("-----resCont객체 생성됨");
	}
	
}
