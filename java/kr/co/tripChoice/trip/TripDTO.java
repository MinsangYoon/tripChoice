package kr.co.tripChoice.trip;

import org.springframework.web.multipart.MultipartFile;

public class TripDTO {
	private String trip_code;   
	private String trip_area;  
	private String trip_name;
	private String trip_content;
	private int trip_cost1;
	private int trip_cost2;
	private int trip_cost3;
	private int trip_possible;
	private int trip_airpcost;
	private int trip_bedcost;
	private String trip_situation;
	private String trip_thumbnail;
	
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
		
		public TripDTO() {}//기본생성자함수

		//getter,setter
		public String getTrip_code() {
			return trip_code;
		}

		public void setTrip_code(String trip_code) {
			this.trip_code = trip_code;
		}

		public String getTrip_area() {
			return trip_area;
		}

		public void setTrip_area(String trip_area) {
			this.trip_area = trip_area;
		}

		public String getTrip_name() {
			return trip_name;
		}

		public void setTrip_name(String trip_name) {
			this.trip_name = trip_name;
		}

		public String getTrip_content() {
			return trip_content;
		}

		public void setTrip_content(String trip_content) {
			this.trip_content = trip_content;
		}

		public int getTrip_cost1() {
			return trip_cost1;
		}

		public void setTrip_cost1(int trip_cost1) {
			this.trip_cost1 = trip_cost1;
		}

		public int getTrip_cost2() {
			return trip_cost2;
		}

		public void setTrip_cost2(int trip_cost2) {
			this.trip_cost2 = trip_cost2;
		}

		public int getTrip_cost3() {
			return trip_cost3;
		}

		public void setTrip_cost3(int trip_cost3) {
			this.trip_cost3 = trip_cost3;
		}

		public int getTrip_possible() {
			return trip_possible;
		}

		public void setTrip_possible(int trip_possible) {
			this.trip_possible = trip_possible;
		}

		public int getTrip_airpcost() {
			return trip_airpcost;
		}

		public void setTrip_airpcost(int trip_airpcost) {
			this.trip_airpcost = trip_airpcost;
		}

		public int getTrip_bedcost() {
			return trip_bedcost;
		}

		public void setTrip_bedcost(int trip_bedcost) {
			this.trip_bedcost = trip_bedcost;
		}

		public String getTrip_situation() {
			return trip_situation;
		}

		public void setTrip_situation(String trip_situation) {
			this.trip_situation = trip_situation;
		}

		public String getTrip_thumbnail() {
			return trip_thumbnail;
		}

		public void setTrip_thumbnail(String trip_thumbnail) {
			this.trip_thumbnail = trip_thumbnail;
		}
		
		
	
}//class end
