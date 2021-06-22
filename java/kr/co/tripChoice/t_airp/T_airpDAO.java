package kr.co.tripChoice.t_airp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import kr.co.tripChoice.t_airp.T_airpDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class T_airpDAO {
	@Autowired // @componet어노테이션으로 자동 생성된 객체를 사용하려면 객체가 서로 연결이 되어야 한다 이때 쓰는 것
	private DBOpen dbopen;
	@Autowired
	private DBClose dbclose;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuilder sql = null;
	ArrayList<T_airpDTO> list = null;

	 public T_airpDAO() {
		 System.out.println("---------Trip_reserDAO() 객체 생성");
	 }//T_aripDAO() end
	 
		public int ticket(T_airpDTO dto) {
			int cnt = 0;
			try {
				con = dbopen.getConnection();
				sql = new StringBuilder();
				sql.append(" INSERT INTO t_airp(ta_code,ta_dep,ta_arr,ta_pax,ta_flightnum,ta_sdate,ta_fdate) ");
				sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?) ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, dto.getTa_code());
				pstmt.setString(2, dto.getTa_dep());
				pstmt.setString(3, dto.getTa_arr());
				pstmt.setInt(4, dto.getTa_pax());
				pstmt.setString(5, dto.getTa_flightnum());
				pstmt.setString(6, dto.getTa_sdate());
				pstmt.setString(7, dto.getTa_fdate());
				cnt = pstmt.executeUpdate();

			} catch (Exception e) {
				System.out.println("항공권 등록 실패" + e);
			} finally {
				DBClose.close(con, pstmt);
			}
			return cnt;
		}// create() end
		
		public ArrayList<T_airpDTO> list() {
			try {
				con = dbopen.getConnection();
				sql = new StringBuilder();
				sql.append(" SELECT ta_code, ta_dep, ta_arr, ta_pax, ta_sdate, ta_fdate ");
				sql.append(" FROM t_airp ");
				sql.append(" ORDER BY ta_sdate ASC ");
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					list = new ArrayList<T_airpDTO>();
					do {
						T_airpDTO dto = new T_airpDTO();
						dto.setTa_code(rs.getString("ta_code"));
						dto.setTa_dep(rs.getString("ta_dep"));
						dto.setTa_arr(rs.getString("ta_arr"));
						dto.setTa_pax(rs.getInt("ta_pax"));
						dto.setTa_sdate(rs.getString("ta_sdate"));
						dto.setTa_fdate(rs.getString("ta_fdate"));
						list.add(dto);
					} while (rs.next());
				} else {
					list = null;
				} // if end

			} catch (Exception e) {
				System.out.println("티켓 목록 실패" + e);
			} finally {
				DBClose.close(con, pstmt, rs);
			} // end

			return list;
		}//list end
	
}// class end
