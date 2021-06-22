package kr.co.tripChoice.tuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.MyAuthenticator;
import net.utility.Utility;

@Component
public class TuserDAO {
	
	
	private DBOpen dbopen=null;
	
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public TuserDAO() {//기본생성자함수
		dbopen=new DBOpen();
	}//end
	
	public String loginProc(TuserDTO dto) {
        String tu_rank=null;
        try {
          con=dbopen.getConnection();
          sql=new StringBuilder();
          sql.append(" SELECT tu_rank ");
          sql.append(" FROM tuser ");
          sql.append(" WHERE tu_ID=? AND tu_pw=? ");
          sql.append(" AND tu_rank IN ('admin', 'vip', 'nomal') ");
          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, dto.getTu_id());
          pstmt.setString(2, dto.getTu_pw());
          rs= pstmt.executeQuery();
          if(rs.next()){
              tu_rank=rs.getString("tu_rank");
          }else{
              tu_rank=null;
          }//if end
          
        }catch(Exception e){
            System.out.println("로그인실패:" + e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return tu_rank;
    }//loginProc() end
	
	public int duplecateID(String tu_id) {
        int cnt=0;
        try {
          con=dbopen.getConnection();          
          sql=new StringBuilder();
          sql.append(" SELECT COUNT(tu_id) as cnt");
          sql.append(" FROM tuser");
          sql.append(" WHERE tu_id=?");
          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, tu_id);
          rs=pstmt.executeQuery();
          if(rs.next()) {
              cnt=rs.getInt("cnt");
          }//if end
        }catch (Exception e) {
            System.out.println("아이디 중복 확인 실패 : " + e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return cnt;
    }//duplecateID() end
    

    public int duplecateEmail(String tu_email) {
        int cnt=0;
        try {
          con=dbopen.getConnection();          
          sql=new StringBuilder();
          sql.append(" SELECT COUNT(tu_email) as cnt");
          sql.append(" FROM tuser");
          sql.append(" WHERE tu_email=?");
          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, tu_email);
          rs=pstmt.executeQuery();
          if(rs.next()) {
              cnt=rs.getInt("cnt");
          }//if end
        }catch (Exception e) {
            System.out.println("Email 중복 확인 실패 : " + e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return cnt;
    }//duplecateEmail() end
    
    
    public int insert(TuserDTO dto) {
        int cnt=0;
        try {
          con=dbopen.getConnection();
          
          sql=new StringBuilder();
          sql.append(" INSERT INTO tuser (tu_id, tu_pw, tu_name, tu_email, tu_phone, tu_zipcode, tu_address, tu_address2, tu_rank, tu_joindate) ");
          sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'nomal', default) ");

          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, dto.getTu_id());
          pstmt.setString(2, dto.getTu_pw());
          pstmt.setString(3, dto.getTu_name());
          pstmt.setString(4, dto.getTu_email());
          pstmt.setString(5, dto.getTu_phone());
          pstmt.setString(6, dto.getTu_zipcode());
          pstmt.setString(7, dto.getTu_address());
          pstmt.setString(8, dto.getTu_address2());
          
          cnt=pstmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("회원가입 실패 : " + e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//insert() end
    
    
    public TuserDTO read(String tu_id) {
        TuserDTO dto=null;
        try {
          con=dbopen.getConnection();
          sql=new StringBuilder();
          sql.append(" SELECT tu_pw, tu_name, tu_email, tu_phone, tu_zipcode, tu_address, tu_address2 ");
          sql.append(" FROM tuser ");
          sql.append(" WHERE tu_ID=?");
          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, tu_id);

          rs= pstmt.executeQuery();
          if(rs.next()){
              dto=new TuserDTO();
              dto.setTu_pw(rs.getString("tu_pw"));
              dto.setTu_name(rs.getString("tu_name"));
              dto.setTu_email(rs.getString("tu_email"));
              dto.setTu_phone(Utility.checkNull(rs.getString("tu_phone")));
              dto.setTu_zipcode(Utility.checkNull(rs.getString("tu_zipcode")));
              dto.setTu_address(Utility.checkNull(rs.getString("tu_address")));
              dto.setTu_address2(Utility.checkNull(rs.getString("tu_address2")));
          }//if end
          
        }catch(Exception e){
            System.out.println("회원상세보기실패:" + e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return dto;
    }//read() end
    
    
    public int modify(TuserDTO dto) {
        int cnt=0;
        try {
          con=dbopen.getConnection();
          
          sql=new StringBuilder();
          sql.append(" UPDATE tuser SET ");
          sql.append("  tu_pw=? ");
          sql.append(" ,tu_name=? ");
          sql.append(" ,tu_email=? ");
          sql.append(" ,tu_phone=? ");
          sql.append(" ,tu_zipcode=? ");
          sql.append(" ,tu_address=? ");
          sql.append(" ,tu_address2=? ");
          sql.append(" WHERE tu_ID=? ");

          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, dto.getTu_pw());
          pstmt.setString(2, dto.getTu_name());
          pstmt.setString(3, dto.getTu_email());
          pstmt.setString(4, dto.getTu_phone());
          pstmt.setString(5, dto.getTu_zipcode());
          pstmt.setString(6, dto.getTu_address());
          pstmt.setString(7, dto.getTu_address2());
          pstmt.setString(8, dto.getTu_id());
          
          cnt=pstmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("회원정보 수정 실패 : " + e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//modify() end

    
    public int withdraw(TuserDTO dto) {
        int cnt=0;
        try {
          con=dbopen.getConnection();
          
          sql=new StringBuilder();
          sql.append(" DELETE FROM tuser ");
          sql.append(" WHERE tu_ID=? AND tu_pw=? ");

          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, dto.getTu_id());
          pstmt.setString(2, dto.getTu_pw());
          
          cnt=pstmt.executeUpdate();
                    
        }catch (Exception e) {
            System.out.println("회원탈퇴 실패 : " + e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//withdraw() end

    
    
    public boolean findID(TuserDTO dto) {
        boolean flag=false;
        try {
          con=dbopen.getConnection();          
          sql=new StringBuilder();
          sql.append(" SELECT tu_id, tu_pw ");
          sql.append(" FROM tuser");
          sql.append(" WHERE tu_name=? AND tu_email=? ");
          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, dto.getTu_name());
          pstmt.setString(2, dto.getTu_email());
          rs=pstmt.executeQuery();      
          if(rs.next()) { //이름과 이메일이 일치되면
            //임시 비밀번호 발급
            String[] ch= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
                         ,"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"
                         ,"0","1","2","3","4","5","6","7","8","9"};

            //임시 비밀번호 랜덤하게 10글자 발생
            StringBuffer imsiPW=new StringBuffer();
            for(int i=0; i<10; i++) {
              int num=(int)(Math.random()*ch.length);
              imsiPW.append(ch[num]);
            }//for end
            //System.out.println(imsiPW.toString());
            
            
            //임시비밀번호로 업데이트 하기
            sql=new StringBuilder();
            sql.append(" UPDATE tuser ");
            sql.append(" SET tu_pw=? ");
            sql.append(" WHERE tu_name=? AND tu_email=? ");
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, imsiPW.toString());
            pstmt.setString(2, dto.getTu_name());
            pstmt.setString(3, dto.getTu_email());
            
            int cnt=pstmt.executeUpdate();
            if(cnt==1) {
              String content="";
              content += "<hr>";
              content += "<table border='1'>";
              content += "<tr>";
              content += "  <td>아이디</td>";
              content += "  <td>" + rs.getString("tu_id") + "</td>";
              content += "</tr>";
              content += "<tr>";
              content += "  <td>비밀번호</td>";
              content += "  <td>" + imsiPW + "</td>";
              content += "</tr>";
              content += "</table>";
              
              //임시비밀번호를 이메일 전송하기
              String mailServer="mw-002.cafe24.com";//카페24 메일서버
              Properties props=new Properties();
              props.put("mail.smtp.host", mailServer);
              props.put("mail.smtp.auth", "true");        
              Authenticator myAuth=new MyAuthenticator();
              Session sess=Session.getInstance(props, myAuth);
              
              InternetAddress[] address={ new InternetAddress(dto.getTu_email()) };
              Message msg=new MimeMessage(sess);
              msg.setRecipients(Message.RecipientType.TO, address);
              msg.setFrom(new InternetAddress("prettyimo@daum.net"));
              msg.setSubject("MyWeb 아이디/비번 입니다");
              msg.setContent(content,"text/html; charset=UTF-8");        
              msg.setSentDate(new Date());
              Transport.send(msg);
              
              flag=true; //최종적으로 성공
              
            }else{
              
              flag=false;
              
            }//if end
            
          }else {
            flag=false;
          }//if end
          
        }catch (Exception e) {
          System.out.println("아이디/비번찾기 실패 : " + e);
        }finally {
          DBClose.close(con, pstmt, rs);
        }//end
        return flag;
      }//findID() end
    

}
