package kr.co.samjo.product.rental;

public class rentalDTO {

	private String u_code;	//VARCHAR2(10)	NOT NULL	업체코드
	private String u_name;	//VARCHAR2(20)	NOT NULL	업체명
	private String u_phone;	//VARCHAR2(20) 	NOT NULL	연락처
	private String u_office;//VARCHAR2(200)	NOT NULL	사무실
	
	public rentalDTO() {}
	
	public String getU_code() {
		return u_code;
	}
	public void setU_code(String u_code) {
		this.u_code = u_code;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_office() {
		return u_office;
	}
	public void setU_office(String u_office) {
		this.u_office = u_office;
	}
	
	@Override
	public String toString() {
		return "rentalDTO [u_code=" + u_code + ", u_name=" + u_name + ", u_phone=" + u_phone + ", u_office=" + u_office
				+ "]";
	}	
	
	
	
	
	
}
