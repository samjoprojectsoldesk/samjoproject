package kr.co.samjo.product.sooksoproduct;

public class SooksoProductDTO {
	
	private String room_cn;
	private String s_cn;
	private int room_num;
	private int room_mp;
	private int room_dp;
	private int room_ep;
	private String room_cont;
	
	public String getRoom_cn() {
		return room_cn;
	}
	public void setRoom_cn(String room_cn) {
		this.room_cn = room_cn;
	}
	public String getS_cn() {
		return s_cn;
	}
	public void setS_cn(String s_cn) {
		this.s_cn = s_cn;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
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
	public String getRoom_cont() {
		return room_cont;
	}
	public void setRoom_cont(String room_cont) {
		this.room_cont = room_cont;
	}
	@Override
	public String toString() {
		return "SooksoProductDTO [room_cn=" + room_cn + ", s_cn=" + s_cn + ", room_num=" + room_num + ", room_mp="
				+ room_mp + ", room_dp=" + room_dp + ", room_ep=" + room_ep + ", room_cont=" + room_cont + "]";
	}
	
	
}
