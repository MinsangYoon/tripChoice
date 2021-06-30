package kr.co.tripChoice.trip_reser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class Trip_reserDAO {
	@Autowired 
	private DBOpen dbopen;
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuilder sql=null;
	ArrayList<Trip_reserDTO> list=null;
	
	public Trip_reserDAO() {//기본생성자함수
		System.out.println("---Trip_reserDAO()객체 생성됨");
	}//end

	
	
	//비즈니스로직 구현
	public int create(Trip_reserDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO trip_reser(trip_code,tu_id,tr_adult,tr_kid,tr_baby,tr_price,tr_resdate,tr_departure,tr_arrival) ");
			sql.append(" VALUES( ?,?,?,?,?,?,now(),?,? ) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTrip_code());
			pstmt.setString(2, dto.getTu_id());
			pstmt.setInt(3, dto.getTr_adult());
			pstmt.setInt(4, dto.getTr_kid());
			pstmt.setInt(5, dto.getTr_baby());
			pstmt.setInt(6, dto.getTr_price());
			pstmt.setString(7, dto.getTr_departure());
			pstmt.setString(8, dto.getTr_arrival());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("상품예약실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//create() end
	
	
	
}//class end
