package kr.co.tripChoice.hotel_reser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class Hotel_reserDAO {
	@Autowired 
	private DBOpen dbopen;
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuilder sql=null;
	ArrayList<Hotel_reserDTO> list=null;
	
	public Hotel_reserDAO() {//기본생성자함수
		System.out.println("---Hotel_reserDAO()객체 생성됨");
	}//end
	
	
	//비즈니스로직 구현
	
	
	
	
	

}//class end
