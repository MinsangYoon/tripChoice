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
	public int create(Hotel_reserDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO hotel_reser(th_code,tu_id,thr_member,trip_code) ");
			sql.append(" VALUES( ?,?,?,'test01' ) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTh_code());
			pstmt.setString(2, dto.getTu_id());
			pstmt.setInt(3, dto.getThr_member());
			//pstmt.setString(4, dto.getTrip_code());
			cnt = pstmt.executeUpdate();
			
			//예약가능여부 'N'으로 변경하기
			sql.delete(0, sql.length());
			sql.append(" UPDATE t_hotel ");
			sql.append(" SET th_situation='N' ");
			sql.append(" WHERE th_code=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTh_code());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("숙소예약실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		
		return cnt;
	}//create() end
	
	
	
	

}//class end
