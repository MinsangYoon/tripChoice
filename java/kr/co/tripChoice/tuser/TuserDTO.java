package kr.co.tripChoice.tuser;

public class TuserDTO {
	//멤버변수 field
	private String tu_id; 
	private String tu_pw; 
	private String tu_name; 
	private String tu_email; 
	private String tu_phone;
	private String tu_zipcode; 
	private String tu_address;
	private String tu_address2;
	private String tu_joindate; 
	private String tu_rank;
	
	//생성자함수 default constructor
	public TuserDTO() {}

	//getter setter 함수
	public String getTu_id() {
		return tu_id;
	}
	public void setTu_id(String tu_id) {
		this.tu_id = tu_id;
	}
	public String getTu_pw() {
		return tu_pw;
	}
	public void setTu_pw(String tu_pw) {
		this.tu_pw = tu_pw;
	}
	public String getTu_name() {
		return tu_name;
	}
	public void setTu_name(String tu_name) {
		this.tu_name = tu_name;
	}
	public String getTu_email() {
		return tu_email;
	}
	public void setTu_email(String tu_email) {
		this.tu_email = tu_email;
	}
	public String getTu_phone() {
		return tu_phone;
	}
	public void setTu_phone(String tu_phone) {
		this.tu_phone = tu_phone;
	}
	public String getTu_zipcode() {
		return tu_zipcode;
	}
	public void setTu_zipcode(String tu_zipcode) {
		this.tu_zipcode = tu_zipcode;
	}
	public String getTu_address() {
		return tu_address;
	}
	public void setTu_address(String tu_address) {
		this.tu_address = tu_address;
	}
	public String getTu_address2() {
		return tu_address2;
	}
	public void setTu_address2(String tu_address2) {
		this.tu_address2 = tu_address2;
	}
	public String getTu_joindate() {
		return tu_joindate;
	}
	public void setTu_joindate(String tu_joindate) {
		this.tu_joindate = tu_joindate;
	}
	public String getTu_rank() {
		return tu_rank;
	}
	public void setTu_rank(String tu_rank) {
		this.tu_rank = tu_rank;
	}
	@Override
	public String toString() {
		return "TuserDTO [tu_id=" + tu_id + ", tu_pw=" + tu_pw + ", tu_name=" + tu_name + ", tu_email=" + tu_email
				+ ", tu_phone=" + tu_phone + ", tu_zipcode=" + tu_zipcode + ", tu_address=" + tu_address
				+ ", tu_address2=" + tu_address2 + ", tu_joindate=" + tu_joindate + ", tu_rank=" + tu_rank + "]";
	}
	


}
