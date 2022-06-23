package kr.co.samjo.product.packagetour;

public class packagetourDTO {

	private String package_no;		//VARCHAR2(10)	 NULL		패키지코드
	private String package_name;	//VARCHAR2(50)	 NOT NULL	패키지이름
	private String package_course;	//VARCHAR2(4000) NOT NULL	여행코스
	private String package_schedule;//VARCHAR2(1000) NOT NULL	모집일정
	private int package_price;		//NUMBER 		 NOT NULL 	비용
	private int package_recruitment;//NUMBER 		 NOT NULL 	모집 인원
	private String package_content; //VARCHAR2(4000) NOT NULL	내용
	
	public packagetourDTO() {}

	public String getPackage_no() {
		return package_no;
	}

	public void setPackage_no(String package_no) {
		this.package_no = package_no;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public String getPackage_course() {
		return package_course;
	}

	public void setPackage_course(String package_course) {
		this.package_course = package_course;
	}

	public String getPackage_schedule() {
		return package_schedule;
	}

	public void setPackage_schedule(String package_schedule) {
		this.package_schedule = package_schedule;
	}

	public int getPackage_price() {
		return package_price;
	}

	public void setPackage_price(int package_price) {
		this.package_price = package_price;
	}

	public int getPackage_recruitment() {
		return package_recruitment;
	}

	public void setPackage_recruitment(int package_recruitment) {
		this.package_recruitment = package_recruitment;
	}

	public String getPackage_content() {
		return package_content;
	}

	public void setPackage_content(String package_content) {
		this.package_content = package_content;
	}

	@Override
	public String toString() {
		return "packagetourDTO [package_no=" + package_no + ", package_name=" + package_name + ", package_course="
				+ package_course + ", package_schedule=" + package_schedule + ", package_price=" + package_price
				+ ", package_recruitment=" + package_recruitment + ", package_content=" + package_content + "]";
	}
	
	
	
}
