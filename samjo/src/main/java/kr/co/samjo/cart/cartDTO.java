package kr.co.samjo.cart;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.co.samjo.product.rentalcar.rentalcarDAO;
import kr.co.samjo.product.rentalcar.rentalcarDTO;

public class cartDTO {

	private int c_no;// NUMBER NOT NULL 			일련번호
	private String user_id;//VARCHAR2(15) NOT NULL 	아이디
	private String s_code;// VARCHAR2(10) NOT NULL 	상품코드
	private int cnt;// NUMBER 						수량
	private int p_cnt;// NUMBER NOT NULL 			인원
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sdate;// VARCHAR2(30) NOT NULL 	이용시작일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fdate;// VARCHAR2(30)			이용끝일
	private String s_name;// 상품명
	public cartDTO() {}
	
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

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getFdate() {
		return fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

	public String getS_name() {
		if(this.s_code.equals("C")){
			rentalcarDAO dao = new rentalcarDAO();
			s_name = dao.read(s_code).getC_name();
		}
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	@Override
	public String toString() {
		return "cartDTO [c_no=" + c_no + ", user_id=" + user_id + ", s_code=" + s_code + ", cnt=" + cnt + ", p_cnt="
				+ p_cnt + ", sdate=" + sdate + ", fdate=" + fdate + ", s_name=" + s_name + "]";
	}
	
	
}