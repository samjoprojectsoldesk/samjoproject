package kr.co.samjo.bbs.board;

public class boardDTO {//전송객체
    //멤버변수 field
    private int bbs_idx;
    private String bbs_group;
    private String bbs_id;
    private String bbs_title;
    private String bbs_content;
    private int bbs_count;
    private String bbs_date;
    private String bbs_userip;
    
	public int getBbs_idx() {
		return bbs_idx;
	}
	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}
	public String getBbs_group() {
		return bbs_group;
	}
	public void setBbs_group(String bbs_group) {
		this.bbs_group = bbs_group;
	}
	public String getBbs_id() {
		return bbs_id;
	}
	public void setBbs_id(String bbs_id) {
		this.bbs_id = bbs_id;
	}
	public String getBbs_title() {
		return bbs_title;
	}
	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
	public String getBbs_content() {
		return bbs_content;
	}
	public void setBbs_content(String bbs_content) {
		this.bbs_content = bbs_content;
	}
	public int getBbs_count() {
		return bbs_count;
	}
	public void setBbs_count(int bbs_count) {
		this.bbs_count = bbs_count;
	}
	public String getBbs_date() {
		return bbs_date;
	}
	public void setBbs_date(String bbs_date) {
		this.bbs_date = bbs_date;
	}
	public String getBbs_userip() {
		return bbs_userip;
	}
	public void setBbs_userip(String bbs_userip) {
		this.bbs_userip = bbs_userip;
	}
	
	@Override
	public String toString() {
		return "BbsDTO [bbs_idx=" + bbs_idx + ", bbs_group=" + bbs_group + ", bbs_id=" + bbs_id + ", bbs_title="
				+ bbs_title + ", bbs_content=" + bbs_content + ", bbs_count=" + bbs_count + ", bbs_date=" + bbs_date
				+ ", bbs_userip=" + bbs_userip + "]";
	}
    
}//class end
