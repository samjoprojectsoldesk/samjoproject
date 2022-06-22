package kr.co.samjo.product.sookso;

public class SooksoDTO {

	private String s_cn;
	private String s_name;
	private String s_addr;
	private String s_cont;
	
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
	public String getS_cont() {
		return s_cont;
	}
	public void setS_cont(String s_cont) {
		this.s_cont = s_cont;
	}
	
	@Override
	public String toString() {
		return "productDTO [s_cn=" + s_cn + ", s_name=" + s_name + ", s_addr=" + s_addr + ", s_cont=" + s_cont + "]";
	}
	
	
}
