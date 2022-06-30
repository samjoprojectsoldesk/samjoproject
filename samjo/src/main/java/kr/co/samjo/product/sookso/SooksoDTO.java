package kr.co.samjo.product.sookso;

import org.springframework.web.multipart.MultipartFile;

public class SooksoDTO {

	private String s_cn;
	private String s_name;
	private String s_addr;
	private String s_tel;
	private String s_link;
	private String s_cont;
	private String s_img;
	
	public SooksoDTO() {}
	
	private MultipartFile posterMF;
	
	public MultipartFile getPosterMF() {
        return posterMF;
    }

    public void setPosterMF(MultipartFile posterMF) {
        this.posterMF = posterMF;
    }
	
	
	public String getS_cn() {
		return s_cn;
	}
	public void setS_cn(String s_cn) {
		this.s_cn = s_cn;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_addr() {
		return s_addr;
	}
	public void setS_addr(String s_addr) {
		this.s_addr = s_addr;
	}
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	public String getS_link() {
		return s_link;
	}
	public void setS_link(String s_link) {
		this.s_link = s_link;
	}
	public String getS_cont() {
		return s_cont;
	}
	public void setS_cont(String s_cont) {
		this.s_cont = s_cont;
	}
	public String getS_img() {
		return s_img;
	}
	public void setS_img(String s_img) {
		this.s_img = s_img;
	}
	
	private String room_cn;
	private String room_name;
	private int room_mp;
	private int room_dp;
	private int room_ep;
	private String room_img;
	
	private MultipartFile posterMF2;
	
	public MultipartFile getPosterMF2() {
        return posterMF2;
    }

    public void setPosterMF2(MultipartFile posterMF2) {
        this.posterMF2 = posterMF2;
    }
	
	public String getRoom_cn() {
		return room_cn;
	}
	public void setRoom_cn(String room_cn) {
		this.room_cn = room_cn;
	}
	 
	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getRoom_mp() {
		return room_mp;
	}
	public void setRoom_mp(int room_mp) {
		this.room_mp = room_mp;
	}
	public int getRoom_dp() {
		return room_dp;
	}
	public void setRoom_dp(int room_dp) {
		this.room_dp = room_dp;
	}
	public int getRoom_ep() {
		return room_ep;
	}
	public void setRoom_ep(int room_ep) {
		this.room_ep = room_ep;
	}
	public String getRoom_img() {
		return room_img;
	}
	public void setRoom_img(String room_img) {
		this.room_img = room_img;
	}

	public void setRoom_cont(String room_img) {
		this.room_img = room_img;
	}

	@Override
	public String toString() {
		return "SooksoDTO [s_cn=" + s_cn + ", s_name=" + s_name + ", s_addr=" + s_addr + ", s_tel=" + s_tel
				+ ", s_link=" + s_link + ", s_cont=" + s_cont + ", s_img=" + s_img + ", posterMF=" + posterMF
				+ ", room_cn=" + room_cn + ", room_name=" + room_name + ", room_mp=" + room_mp + ", room_dp=" + room_dp
				+ ", room_ep=" + room_ep + ", room_img=" + room_img + "]";
	}

}
