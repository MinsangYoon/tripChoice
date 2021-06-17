package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

//스프링컨테이너(웹서버)가 자동으로 객체 생성함(servlet-context.xml에서 환경설정해야함)
@Component
public class DBOpen {
	
	public DBOpen() {
		System.out.println("-----DBOpen()객체 생성됨");
	}
	
	//데이터베이스 연결 메소드
	public Connection getConnection() {
		
		Connection con=null;
	
		try{
			String url     ="jdbc:mariadb://127.0.0.1:3306/tripChoice";
            String user    ="root";
            String password="1234";
            String driver  ="org.mariadb.jdbc.Driver";
			
			Class.forName(driver);
			con= DriverManager.getConnection(url, user, password);
			
		}catch (Exception e) {
			System.out.println("DB연결실패:"+e);
		}//end	
		
		return con;
		
	}//getConnection() end
	
}//class end
