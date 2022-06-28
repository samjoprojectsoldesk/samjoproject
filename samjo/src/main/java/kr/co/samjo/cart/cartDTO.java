package kr.co.samjo.cart;

import kr.co.samjo.product.maszip.MaszipDAO;
import kr.co.samjo.product.maszip.MaszipDTO;
import kr.co.samjo.product.rental.rentalDAO;
import kr.co.samjo.product.rental.rentalDTO;
import kr.co.samjo.product.sookso.SooksoDAO;
import kr.co.samjo.product.sookso.SooksoDTO;
import kr.co.samjo.product.sooksoproduct.SooksoProductDAO;
import kr.co.samjo.product.sooksoproduct.SooksoProductDTO;

public class cartDTO {

	private int c_no;// NUMBER NOT NULL 			일련번호
	private String user_id;//VARCHAR2(15) NOT NULL 	아이디
	private String s_code;// VARCHAR2(10) NOT NULL 	상품코드
	private int cnt;// NUMBER 						수량
	private int p_cnt;// NUMBER NOT NULL 			인원
	private String sdate;// VARCHAR2(30) NOT NULL 	이용시작일
	private String fdate;// VARCHAR2(30)			이용끝일
	private String s_name;// 상품명
	
	
	public cartDTO() {}
	
	public String gets_name() {
		return s_name;
	}
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getS_code() {
		return s_code;
	}
	public void setS_code(String s_code) {
		this.s_code = s_code;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getP_cnt() {
		return p_cnt;
	}
	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	@Override
	public String toString() {
		return "cartDTO [c_no=" + c_no + ", user_id=" + user_id + ", s_code=" + s_code + ", cnt=" + cnt + ", p_cnt="
				+ p_cnt + ", sdate=" + sdate + ", fdate=" + fdate + "]";
	}	
	
	public void setSname() {
		String scode = this.getS_code();
		char S = scode.charAt(0);
		if(S=='S') {
			SooksoDAO dao = new SooksoDAO();
			SooksoDTO dto = new SooksoDTO();
			SooksoProductDAO pdao = new SooksoProductDAO();
			SooksoProductDTO pdto = new SooksoProductDTO();
			
			//pdao 에서 pdto를 가져와서 pdto = pdao.list(scode);
			dto = dao.list(pdto.getS_cn()).get(0); // 숙소 가져오기
			
			s_name = dto.getS_name() + "의 " + pdto.getRoom_num() + "호실";
		}else if(S=='R') {
			MaszipDAO dao = new MaszipDAO();
			MaszipDTO dto = new MaszipDTO();
			
		}else if(S=='C') {
			rentalDAO dao = new rentalDAO();
			rentalDTO dto = new rentalDTO();
			s_name = dto.getU_name();
		}
		
	}
}