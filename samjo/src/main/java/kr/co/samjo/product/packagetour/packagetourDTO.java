package kr.co.samjo.product.packagetour;

public class packagetourDTO {

	private String pack_no;		//VARCHAR2(10)	 NULL		패키지코드
	private String pack_name;	//VARCHAR2(50)	 NOT NULL	패키지이름
	private String pack_cose;	//VARCHAR2(4000) NOT NULL	여행코스
	private String pack_plan;	//VARCHAR2(1000) NOT NULL	모집일정
	private int pack_price;		//NUMBER 		 NOT NULL 	비용
	private int pack_people;	//NUMBER 		 NOT NULL 	모집인원
	private String pack_cont; 	//VARCHAR2(4000) NOT NULL	내용
	private String pack_img;	//
	
	public packagetourDTO() {}

	public String getPack_no() {
		return pack_no;
	}

	public void setPack_no(String pack_no) {
		this.pack_no = pack_no;
	}

	public String getPack_name() {
		return pack_name;
	}

	public void setPack_name(String pack_name) {
		this.pack_name = pack_name;
	}

	public String getPack_cose() {
		return pack_cose;
	}

	public void setPack_cose(String pack_cose) {
		this.pack_cose = pack_cose;
	}

	public String getPack_plan() {
		return pack_plan;
	}

	public void setPack_plan(String pack_plan) {
		this.pack_plan = pack_plan;
	}

	public int getPack_price() {
		return pack_price;
	}

	public void setPack_price(int pack_price) {
		this.pack_price = pack_price;
	}

	public int getPack_people() {
		return pack_people;
	}

	public void setPack_people(int pack_people) {
		this.pack_people = pack_people;
	}

	public String getPack_cont() {
		return pack_cont;
	}

	public void setPack_cont(String pack_cont) {
		this.pack_cont = pack_cont;
	}

	public String getPack_img() {
		return pack_img;
	}

	public void setPack_img(String pack_img) {
		this.pack_img = pack_img;
	}

	@Override
	public String toString() {
		return "packagetourDTO [pack_no=" + pack_no + ", pack_name=" + pack_name + ", pack_cose=" + pack_cose
				+ ", pack_plan=" + pack_plan + ", pack_price=" + pack_price + ", pack_people=" + pack_people
				+ ", pack_cont=" + pack_cont + ", pack_img=" + pack_img + "]";
	}

}
