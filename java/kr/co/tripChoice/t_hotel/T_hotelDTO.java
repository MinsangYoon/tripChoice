package kr.co.tripChoice.t_hotel;

import org.springframework.web.multipart.MultipartFile;

public class T_hotelDTO {
	//필드
	private String th_code;
	private String th_name;
	private String th_room;
	private String th_reg;
	private String th_content;
	private int th_cost1;
	private int th_cost2;
	private int th_cost3;
	private int th_max;
	private String th_situation;
	private String th_thumbnail;
	
	//---------------------------------------
			//createForm에서 넘어온 파일을 담기 위해 변수 생성 
			//createForm.jsp 참조
			//1)스프링 파일객체 멤버변수 선언
			//<input type='file' name='thumbnailMF' size='50'>
			private MultipartFile thumbnailMF;
			//2)getter와 setter함수 작성
			public MultipartFile getThumbnailMF() {
				return thumbnailMF;
			}

			public void setThumbnailMF(MultipartFile thumbnailMF) {
				this.thumbnailMF = thumbnailMF;
			}
			
			//3)servlet-context.xml에 스프링빈 등록
		//---------------------------------------	
	
	public T_hotelDTO() {} //기본생성자함수

	//getter.setter
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

	public int getTh_cost1() {
		return th_cost1;
	}

	public void setTh_cost1(int th_cost1) {
		this.th_cost1 = th_cost1;
	}

	public int getTh_cost2() {
		return th_cost2;
	}

	public void setTh_cost2(int th_cost2) {
		this.th_cost2 = th_cost2;
	}

	public int getTh_cost3() {
		return th_cost3;
	}

	public void setTh_cost3(int th_cost3) {
		this.th_cost3 = th_cost3;
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

	public String getTh_thumbnail() {
		return th_thumbnail;
	}

	public void setTh_thumbnail(String th_thumbnail) {
		this.th_thumbnail = th_thumbnail;
	}
	
	
	
	

}//class end
