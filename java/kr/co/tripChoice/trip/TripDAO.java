package kr.co.tripChoice.trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class TripDAO {
	@Autowired 
	private DBOpen dbopen;
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuilder sql=null;
	ArrayList<TripDTO> list=null;
	
	public TripDAO() {//기본생성자 함수
		System.out.println("---TripDAO()객체 생성됨");
	}//end
	
	
	//비즈니스로직 구현
	public int create(TripDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO trip(trip_code,trip_name,trip_area,trip_content,trip_cost1,trip_cost2,trip_cost3,trip_possible,trip_airpcost,trip_bedcost,trip_thumbnail) ");
			sql.append(" VALUES( ?,?,?,?,?,?,?,?,?,?,? ) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTrip_code());
			pstmt.setString(2, dto.getTrip_name());
			pstmt.setString(3, dto.getTrip_area());
			pstmt.setString(4, dto.getTrip_content());
			pstmt.setInt(5, dto.getTrip_cost1());
			pstmt.setInt(6, dto.getTrip_cost2());
			pstmt.setInt(7, dto.getTrip_cost3());
			pstmt.setInt(8, dto.getTrip_possible());
			pstmt.setInt(9, dto.getTrip_airpcost());
			pstmt.setInt(10, dto.getTrip_bedcost());
			pstmt.setString(11, dto.getTrip_thumbnail());
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("상품등록실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//create() end
	
	
	public ArrayList<TripDTO> list_admin() {
		list=null;
		try {
			con=dbopen.getConnection(); //DB연결
			sql = new StringBuilder();
			sql.append(" SELECT trip_code,trip_name,trip_area,trip_cost1,trip_possible,trip_thumbnail ");
			sql.append(" FROM trip ");
			sql.append(" ORDER BY trip_code DESC ");
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TripDTO>();//전체 행을 저장
				do {
					//커서가 가리키는 한 줄 저장
					TripDTO dto=new TripDTO();
					dto.setTrip_code(rs.getString("trip_code"));
					dto.setTrip_name(rs.getString("trip_name"));
					dto.setTrip_area(rs.getString("trip_area"));
					dto.setTrip_cost1(rs.getInt("trip_cost1"));
					dto.setTrip_possible(rs.getInt("trip_possible"));
					dto.setTrip_thumbnail(rs.getString("trip_thumbnail"));
					list.add(dto);//반복할 동안 list에 한 줄씩 추가. 
				}while(rs.next());//다음 줄 있을 때까지 반복.
			}//if end
			
		}catch (Exception e) {
			System.out.println("숙소 리스트 실패:"+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		
		return list;
	}//list_admin() end
	
	public TripDTO read(String trip_code) {
		TripDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT trip_code,trip_name,trip_area,trip_content,trip_cost1,trip_cost2,trip_cost3,trip_possible,trip_airpcost,trip_bedcost,trip_thumbnail ");
			sql.append(" FROM trip ");
			sql.append(" WHERE trip_code=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, trip_code);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new TripDTO();
				dto.setTrip_code(rs.getString("trip_code"));
				dto.setTrip_name(rs.getString("trip_name"));
				dto.setTrip_area(rs.getString("trip_area"));
				dto.setTrip_content(rs.getString("trip_content"));
				dto.setTrip_cost1(rs.getInt("trip_cost1"));
				dto.setTrip_cost2(rs.getInt("trip_cost2"));
				dto.setTrip_cost3(rs.getInt("trip_cost3"));
				dto.setTrip_possible(rs.getInt("trip_possible"));
				dto.setTrip_airpcost(rs.getInt("trip_airpcost"));
				dto.setTrip_bedcost(rs.getInt("trip_bedcost"));
				dto.setTrip_thumbnail(rs.getString("trip_thumbnail"));
			}//if end
		}catch(Exception e){
			System.out.println("상품상세보기실패:"+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;
	}//read() end

}//class end
