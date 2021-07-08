package kr.co.tripChoice.t_hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public int create(T_hotelDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO t_hotel(th_code,th_name,th_room,th_reg,th_content,th_cost1,th_cost2,th_max,th_thumbnail,th_situation) ");
			sql.append(" VALUES( ?,?,?,?,?,?,?,?,?,? ) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTh_code());
			pstmt.setString(2, dto.getTh_name());
			pstmt.setString(3, dto.getTh_room());
			pstmt.setString(4, dto.getTh_reg());
			pstmt.setString(5, dto.getTh_content());
			pstmt.setInt(6, dto.getTh_cost1());
			pstmt.setInt(7, dto.getTh_cost2());
			pstmt.setInt(8, dto.getTh_max());
			pstmt.setString(9, dto.getTh_thumbnail());
			pstmt.setString(10, dto.getTh_situation());
			cnt = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("숙소등록실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//create() end
	
	public ArrayList<T_hotelDTO> list_admin() {
		//DB에서 가져온 데이터(rs)를 한꺼번에 모아서(ArrayList)
		list=null;
		
		try {
			con=dbopen.getConnection(); //DB연결
			sql = new StringBuilder();
			sql.append(" SELECT th_code,th_name,th_room,th_reg,th_content,th_cost1,th_cost2,th_max,th_thumbnail,th_situation ");
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
					dto.setTh_cost1(rs.getInt("th_cost1"));
					dto.setTh_cost2(rs.getInt("th_cost2"));
					dto.setTh_max(rs.getInt("th_max"));
					dto.setTh_thumbnail(rs.getString("th_thumbnail"));
					dto.setTh_situation(rs.getString("th_situation"));
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
			sql.append(" SELECT th_code,th_name,th_room,th_reg,th_content,th_cost1,th_cost2,th_max,th_thumbnail,th_situation ");
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
				dto.setTh_cost1(rs.getInt("th_cost1"));
				dto.setTh_cost2(rs.getInt("th_cost2"));
				dto.setTh_max(rs.getInt("th_max"));
				dto.setTh_thumbnail(rs.getString("th_thumbnail"));
				dto.setTh_situation(rs.getString("th_situation"));
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
			sql.append(" SET th_name=?,th_room=?,th_reg=?,th_content=?,th_cost1=?,th_cost2=?,th_max=?,th_thumbnail=?,th_situation=? ");
			sql.append(" WHERE th_code=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTh_name());
			pstmt.setString(2, dto.getTh_room());
			pstmt.setString(3, dto.getTh_reg());
			pstmt.setString(4, dto.getTh_content());
			pstmt.setInt(5, dto.getTh_cost1());
			pstmt.setInt(6, dto.getTh_cost2());
			pstmt.setInt(7, dto.getTh_max());
			pstmt.setString(8, dto.getTh_thumbnail());
			pstmt.setString(9, dto.getTh_situation());
			pstmt.setString(10, dto.getTh_code());
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
			System.out.println("숙소삭제실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		
		return cnt;
	}//delete() end
	 
	//해당 지역 숙소만 리스트
		public ArrayList<T_hotelDTO> list(String th_reg, int total_people, String thr_in, String thr_out) {
			//DB에서 가져온 데이터(rs)를 한꺼번에 모아서(ArrayList)
			list=null;
			
			try {
				con=dbopen.getConnection(); //DB연결
				sql = new StringBuilder();
				
				SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
				Date day1 = dateFormat.parse(thr_in);
				Date day2 = dateFormat.parse(thr_out);
				//System.out.println(day1);
				//System.out.println(day2);
				
				ArrayList<String> no_th = new ArrayList<String>(); //날짜가 겹쳐서 예약할 수 없는 숙소코드 담는 곳.
				
				sql.append(" SELECT HR.thr_in,HR.thr_out,HR.th_code ");
				sql.append(" FROM hotel_reser HR JOIN t_hotel TH ");
				sql.append(" ON HR.th_code = TH.th_code ");
				sql.append(" WHERE TH.th_reg LIKE ? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+th_reg+"%");
				rs=pstmt.executeQuery();
				if(rs.next()) {
					do {
						Date day3=dateFormat.parse(rs.getString("thr_in"));
						Date day4=dateFormat.parse(rs.getString("thr_out"));
						String th_code = rs.getString("th_code");
						if(day1.after(day4) || day2.before(day3)) { //날짜가 겹치지 않는다면
							//System.out.println("y"+th_code);
							
						}else { //날짜가 겹친다면
							//System.out.println('n'+th_code);
							no_th.add(th_code); //날짜가 겹쳐서 예약할 수 없는 숙소코드를 no_th라는 리스트에 담음.
							
						}//if end
						
					}while(rs.next());
				}//if end
				
				List<String> resultList = new ArrayList<String>();
				for(String a : no_th) { //리스트 no_th에 중복된 숙소코드 없애기 위한 작업
					if(!resultList.contains(a)) {
						resultList.add(a);
					}
				}
				//System.out.println("-----------------");
				//System.out.println(resultList.toString());
				
				
				String x=""; //no_th에 담긴 숙소코드를 각각 꺼내서 저장할 곳
				//System.out.println(resultList.size());
				//System.out.println(resultList.get(0));
				for(int i=0; i<resultList.size(); i++) {
				
					x=x+"'"+resultList.get(i)+"'"+", ";
				}
				if(x.length()==0) { //날짜가 안겹쳐서 제외할 숙소가 없는 경우
					x="'!'"; //빈값으로 두면 sql문 신택스 에러 떠서 숙소코드에 들어가지 않는 아무 문자나 넣음
				}else {
					x=x.substring(0,x.length()-2);
				}	
				//System.out.println(x);
				
				sql.delete(0, sql.length()); //위에서 썼던 sql문 초기화.
				
				sql.append(" SELECT th_code,th_name,th_room,th_reg,th_content,th_cost1,th_cost2,th_max,th_thumbnail,th_situation ");
				sql.append(" FROM t_hotel ");
				sql.append(" WHERE th_reg LIKE ? AND th_max>=? AND th_code NOT IN( ");
				sql.append(x+")");
				sql.append(" ORDER BY th_code DESC ");
				
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+th_reg+"%");
				pstmt.setInt(2, total_people);
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
						dto.setTh_cost1(rs.getInt("th_cost1"));
						dto.setTh_cost2(rs.getInt("th_cost2"));
						dto.setTh_max(rs.getInt("th_max"));
						dto.setTh_thumbnail(rs.getString("th_thumbnail"));
						dto.setTh_situation(rs.getString("th_situation"));
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
	
}//class end
