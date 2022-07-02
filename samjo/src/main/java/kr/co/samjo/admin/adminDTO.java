package kr.co.samjo.admin;

import org.springframework.web.multipart.MultipartFile;

public class adminDTO {

	/* 여행지 시작 */
	private String t_cn;
	private String t_name;
	private String t_addr;
	private int t_dividecn;
	private String t_tel;
	private String t_link;
	private String t_sche;
	private String t_car;
	private String t_img;
	private String t_cont;
	private String t_rdate;

	public adminDTO() {
	}

	private MultipartFile posterMF;

	public MultipartFile getPosterMF() {
		return posterMF;
	}

	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}

	public String getT_cn() {
		return t_cn;
	}

	public void setT_cn(String t_cn) {
		this.t_cn = t_cn;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_addr() {
		return t_addr;
	}

	public void setT_addr(String t_addr) {
		this.t_addr = t_addr;
	}

	public int getT_dividecn() {
		return t_dividecn;
	}

	public void setT_dividecn(int t_dividecn) {
		this.t_dividecn = t_dividecn;
	}

	public String getT_tel() {
		return t_tel;
	}

	public void setT_tel(String t_tel) {
		this.t_tel = t_tel;
	}

	public String getT_link() {
		return t_link;
	}

	public void setT_link(String t_link) {
		this.t_link = t_link;
	}

	public String getT_sche() {
		return t_sche;
	}

	public void setT_sche(String t_sche) {
		this.t_sche = t_sche;
	}

	public String getT_car() {
		return t_car;
	}

	public void setT_car(String t_car) {
		this.t_car = t_car;
	}

	public String getT_img() {
		return t_img;
	}

	public void setT_img(String t_img) {
		this.t_img = t_img;
	}

	public String getT_cont() {
		return t_cont;
	}

	public void setT_cont(String t_cont) {
		this.t_cont = t_cont;
	}

	public String getT_rdate() {
		return t_rdate;
	}

	public void setT_rdate(String t_rdate) {
		this.t_rdate = t_rdate;
	}
	/* 여행지 끝 */

	/* 공지사항 시작 */
	private int board_no; // NUMBER NULL 일련번호
	private String board_title; // VARCHAR2(200) NOT NULL 제목
	private String board_content; // VARCHAR2(4000) NOT NULL 내용
	private String board_date; // date NOT NULL 작성일
	private int board_readcnt;

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public int getBoard_readcnt() {
		return board_readcnt;
	}

	public void setBoard_readcnt(int board_readcnt) {
		this.board_readcnt = board_readcnt;
	}

	/* 공지사항 끝 */

	/* 자유게시판 시작 */

	/* 자유게시판 끝 */

}
