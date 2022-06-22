package kr.co.samjo.cart;

public class cartDTO {

	private int c_no;// NUMBER NOT NULL 			일련번호
	private String user_id;//VARCHAR2(15) NOT NULL 	아이디
	private String s_code;// VARCHAR2(10) NOT NULL 	상품코드
	private int cnt;// NUMBER 						수량
	private int p_cnt;// NUMBER NOT NULL 			인원
	private String sdate;// VARCHAR2(30) NOT NULL 	이용시작일
	private String fdate;// VARCHAR2(30)			이용끝일
	
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
}
