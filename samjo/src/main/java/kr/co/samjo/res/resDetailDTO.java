package kr.co.samjo.res;

public class resDetailDTO {

    private String res_no; // timestamp not null,
    private String s_code; // varchar2(10) not null,
    private int p_cnt;
    private String sdate; // VARCHAR2(30) not null,
    private String fdate; // VARCHAR2(30)
    
	public String getRes_no() {
		return res_no;
	}
	public void setRes_no(String res_no) {
		this.res_no = res_no;
	}
	public String getS_code() {
		return s_code;
	}
	public void setS_code(String s_code) {
		this.s_code = s_code;
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
		return "resDetailDTO [res_no=" + res_no + ", s_code=" + s_code + ", p_cnt=" + p_cnt + ", sdate=" + sdate
				+ ", fdate=" + fdate + "]";
	}    
}
