package kr.co.tripChoice.t_hotel;

public class T_hotelDTO {
	//필드
	private String th_code;
	private String th_name;
	private String th_room;
	private String th_reg;
	private String th_content;
	private int th_max;
	private String th_situation;
	
	public T_hotelDTO() {} //기본생성자함수
	
	
	//getter,setter
	public String getTh_code() {
		return th_code;
	}

	public void setTh_code(String th_code) {
		this.th_code = th_code;
	}

	public String getTh_name() {
		return th_name;
	}

	public void setTh_name(String th_name) {
		this.th_name = th_name;
	}

	public String getTh_room() {
		return th_room;
	}

	public void setTh_room(String th_room) {
		this.th_room = th_room;
	}

	public String getTh_reg() {
		return th_reg;
	}

	public void setTh_reg(String th_reg) {
		this.th_reg = th_reg;
	}

	public String getTh_content() {
		return th_content;
	}

	public void setTh_content(String th_content) {
		this.th_content = th_content;
	}

	public int getTh_max() {
		return th_max;
	}

	public void setTh_max(int th_max) {
		this.th_max = th_max;
	}


	public String getTh_situation() {
		return th_situation;
	}


	public void setTh_situation(String th_situation) {
		this.th_situation = th_situation;
	}
	

}//class end
