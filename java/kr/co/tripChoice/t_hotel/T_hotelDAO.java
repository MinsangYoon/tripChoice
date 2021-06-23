package kr.co.tripChoice.t_hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class T_hotelDAO {
	@Autowired 
	private DBOpen dbopen;
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuilder sql=null;
	ArrayList<T_hotelDTO> list=null;
	
	public T_hotelDAO() {//기본생성자 함수
		System.out.println("---T_hotelDAO()객체 생성됨");
	}//end
	
	
	//비즈니스로직 구현
	public void create(T_hotelDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO t_hotel(th_code,th_name,th_room,th_reg,th_content,th_max) ");
			sql.append(" VALUES( ?,?,?,?,?,? ) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTh_code());
			pstmt.setString(2, dto.getTh_name());
			pstmt.setString(3, dto.getTh_room());
			pstmt.setString(4, dto.getTh_reg());
			pstmt.setString(5, dto.getTh_content());
			pstmt.setInt(6, dto.getTh_max());
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("숙소등록실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
	}//create() end
	
	public ArrayList<T_hotelDTO> list_admin() {
		//DB에서 가져온 데이터(rs)를 한꺼번에 모아서(ArrayList)
		list=null;
		
		try {
			con=dbopen.getConnection(); //DB연결
			sql = new StringBuilder();
			sql.append(" SELECT th_code,th_name,th_room,th_reg,th_content,th_max ");
			sql.append(" FROM t_hotel ");
			sql.append(" ORDER BY th_code DESC ");
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<T_hotelDTO>();//전체 행을 저장
				do {
					//커서가 가리키는 한 줄 저장
					T_hotelDTO dto=new T_hotelDTO();
					dto.setTh_code(rs.getString("th_code"));
					dto.setTh_name(rs.getString("th_name"));
					dto.setTh_room(rs.getString("th_room"));
					dto.setTh_reg(rs.getString("th_reg"));
					dto.setTh_content(rs.getString("th_content"));
					dto.setTh_max(rs.getInt("th_max"));
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
	
	public T_hotelDTO read(String th_code) {
		T_hotelDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT th_code,th_name,th_room,th_reg,th_content,th_max ");
			sql.append(" FROM t_hotel ");
			sql.append(" WHERE th_code=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, th_code);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new T_hotelDTO();
				dto.setTh_code(rs.getString("th_code"));
				dto.setTh_name(rs.getString("th_name"));
				dto.setTh_room(rs.getString("th_room"));
				dto.setTh_reg(rs.getString("th_reg"));
				dto.setTh_content(rs.getString("th_content"));
				dto.setTh_max(rs.getInt("th_max"));
			}//if end
		}catch(Exception e){
			System.out.println("숙소상세보기실패:"+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;
	}//read() end
	
	
	public int update(T_hotelDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE t_hotel ");
			sql.append(" SET th_code=?,th_name=?,th_room=?,th_reg=?,th_content=?,th_max=? ");
			sql.append(" WHERE th_code=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTh_code());
			pstmt.setString(2, dto.getTh_name());
			pstmt.setString(3, dto.getTh_room());
			pstmt.setString(4, dto.getTh_reg());
			pstmt.setString(5, dto.getTh_content());
			pstmt.setInt(6, dto.getTh_max());
			pstmt.setString(7, dto.getTh_code());
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("숙소수정실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		
		return cnt;
	}//update() end
	
	public int delete(String th_code, String tu_id, String tu_pw) {
		int cnt=0;
		int x=0;
		try {
			//관리자 id와 비번이 맞다면 삭제진행
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT count(*) ");
			sql.append(" FROM tuser ");
			sql.append(" WHERE tu_id=? AND tu_pw=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, tu_id);
			pstmt.setString(2, tu_pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				x=rs.getInt(1);
			}//if end
			
			if(x==1) { //x가 1이라는 건 관리자 id와 비번이 맞다는 뜻
				sql.delete(0, sql.length());
				sql.append(" DELETE FROM t_hotel ");
				sql.append(" WHERE th_code=? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, th_code);
				cnt=pstmt.executeUpdate();
			}//if end
			
		}catch(Exception e){
			System.out.println("숙소수정실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		
		return cnt;
	}//delete() end
	
}//class end
