package kr.co.tripChoice.trq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class TrqDAO {

	private DBOpen dbOpen=null;
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuilder sql=null;
	ArrayList<TrqDTO> list=null;
		
	public TrqDAO() {
		dbOpen=new DBOpen();
	}//end
	
	 public int insert(TrqDTO dto) {
	        int cnt=0;
	        try {
	          con=dbOpen.getConnection();
	          sql=new StringBuilder();
	          sql.append(" INSERT INTO trq(trq_sub,trq_con,trq_date) ");
	          sql.append(" VALUES(?,?,now()) ");      
	          
	          pstmt=con.prepareStatement(sql.toString());
	          pstmt.setString(1, dto.getTrq_sub());
	          pstmt.setString(2, dto.getTrq_con());
	                   
	        
	          cnt=pstmt.executeUpdate();
	        }catch (Exception e) {
	          System.out.println("추가실패:"+e);
	        }finally {
	          DBClose.close(con, pstmt);
	        }// end
	        return cnt;
	}//insert () end
	 
	 
	 public int create(TrqDTO dto) {
			int cnt = 0;
			try {
				con = dbOpen.getConnection();
				sql = new StringBuilder();
				sql.append("INSERT INTO trq(  trq_sub,trq_con,trq_cnt,trq_date )");
				sql.append(" VALUES( ?,?,?,? )");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, dto.getTrq_no());
				pstmt.setString(2, dto.getTrq_sub());
				pstmt.setString(3, dto.getTrq_con());
				pstmt.setString(4, dto.getTrq_date());
			
				cnt = pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("문의사항 등록실패 :" +e);
			}finally {
				DBClose.close(con, pstmt);
			}//end
			return cnt;
		}//create() end
	
	
	public ArrayList<TrqDTO> list() {
		try {
			con=dbOpen.getConnection();
			sql=new StringBuilder();
			sql.append(" SELECT trq_no,trq_sub,trq_con,trq_date ");
			sql.append(" FROM trq");
			sql.append(" ORDER BY trq_no ");
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TrqDTO>();
				do {
					TrqDTO dto=new TrqDTO();
					dto.setTrq_no(rs.getInt("trq_no"));
					dto.setTrq_sub(rs.getString("trq_sub"));
					dto.setTrq_con(rs.getString("trq_con"));
					dto.setTrq_date(rs.getString("trq_date"));
					
					list.add(dto);
				}while(rs.next());
			}else {
				list=null;
			}//if end
		}catch(Exception e) {
			System.out.println("문의사항 목록실패 : "+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
	}// list() end
	
	public int delete(int trq_no) {
		int cnt = 0;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" DELETE FROM trq ");
			sql.append(" WHERE trq_no =?  ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, trq_no);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("문의사항 삭제 실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//delete() end
	
	public TrqDTO read(int trq_no){ 
		TrqDTO dto=null;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT trq_sub,trq_con,trq_cnt,trq_date ");
			sql.append(" FROM trq ");
			sql.append(" WHERE trq_no =? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, trq_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto=new TrqDTO();
				dto.setTrq_sub(rs.getString("trq_sub"));
				dto.setTrq_con(rs.getString("trq_con"));
				dto.setTrq_date(rs.getString("trq_date"));
			}//if end
		}catch(Exception e) {
			System.out.println("문의사항 상세보기 실패:"+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;
	}//read() end   
	
	
	public int update(TrqDTO dto) {
		int cnt = 0;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE trq ");
			sql.append(" SET trq_sub=? , trq_con=? ,trq_date=? ");
			sql.append(" WHERE trq_no =? ");
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getTrq_sub());
			pstmt.setString(2, dto.getTrq_con());
			pstmt.setString(3, dto.getTrq_date());
		
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("문의사항 수정 실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//update() end
	  
	 
	 public int updateproc(TrqDTO dto) {
	        int cnt=0;
	        try {
	            con=dbOpen.getConnection();
	            sql=new StringBuilder();
	            sql.append(" UPDATE trq ");
	            sql.append(" SET trq_sub=? ");
	            sql.append(" ,trq_con=? ");
	            sql.append(" WHERE trq_no=?  ");
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setString(1, dto.getTrq_sub());
	            pstmt.setString(2, dto.getTrq_con());
	          
	            cnt=pstmt.executeUpdate();
	        }catch (Exception e) {
	            System.out.println("수정 실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt);
	        }//end    
	        return cnt;
	    }//updateproc() end
	    
}//class end