package kr.co.samjo.member;

public class MemberDTO { 
    private String user_id;
    private String user_pw;
    private String mname;
    private String user_phone;
    private String user_email;
    private String zipcode;
    private String user_addr1;
    private String user_addr2;
    private String job;
    private String user_level;
    private String mdate;
    
    public MemberDTO() {}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getUser_addr1() {
		return user_addr1;
	}

	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}

	public String getUser_addr2() {
		return user_addr2;
	}

	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getUser_level() {
		return user_level;
	}

	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [user_id=" + user_id + ", user_pw=" + user_pw + ", mname=" + mname + ", user_phone="
				+ user_phone + ", user_email=" + user_email + ", zipcode=" + zipcode + ", user_addr1=" + user_addr1
				+ ", user_addr2=" + user_addr2 + ", job=" + job + ", user_level=" + user_level + ", mdate=" + mdate
				+ "]";
	}


    
    
    
}//class end
