package kr.co.tripChoice.hotel_reser;

public class Hotel_reserDTO {
	//필드
	private int thr_num;
	private String th_code;
	private String tu_id;
	private int thr_member;
	private String thr_in;
	private String thr_out;
	private String trip_code;
	
	public Hotel_reserDTO() {}//기본생성자함수
	
	
	//getter,setter
	public int getThr_num() {
		return thr_num;
	}

	public void setThr_num(int thr_num) {
		this.thr_num = thr_num;
	}

	public String getTh_code() {
		return th_code;
	}

	public void setTh_code(String th_code) {
		this.th_code = th_code;
	}

	public String getTu_id() {
		return tu_id;
	}

	public void setTu_id(String tu_id) {
		this.tu_id = tu_id;
	}

	public int getThr_member() {
		return thr_member;
	}

	public void setThr_member(int thr_member) {
		this.thr_member = thr_member;
	}

	public String getThr_in() {
		return thr_in;
	}

	public void setThr_in(String thr_in) {
		this.thr_in = thr_in;
	}

	public String getThr_out() {
		return thr_out;
	}

	public void setThr_out(String thr_out) {
		this.thr_out = thr_out;
	}

	public String getTrip_code() {
		return trip_code;
	}

	public void setTrip_code(String trip_code) {
		this.trip_code = trip_code;
	}
	
	
	
}//class end
