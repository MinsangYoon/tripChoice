package kr.co.tripChoice.t_hotel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.utility.UploadSaveManager;

@Controller
public class T_hotel_ImageUpload {
	// 컨트롤러클래스의 로그를 출력
    private static final Logger logger = LoggerFactory.getLogger(T_hotel_ImageUpload.class); //현재 클래스 이름으로 수정하세요.
 
    // 이미지 업로드
    // product_edit페이지에서 맵핑되는 메소드
    @RequestMapping("/t_hotel/imageUpload.do")
 
    // 이미지를 저장하고, 불러오고, 업로드하기위해 매개변수를 선언
    public void t_hotel_imageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload)
    //MultipartFile 타입은 ckedit에서 upload란 이름으로 저장하게 된다
            throws Exception {
 
        // 한글깨짐을 방지하기위해 문자셋 설정
        response.setCharacterEncoding("utf-8");
 
        // 마찬가지로 파라미터로 전달되는 response 객체의 한글 설정
        response.setContentType("text/html; charset=utf-8");
 
        // 업로드한 파일 이름
        //String fileName = upload.getOriginalFilename();
 
        // 파일을 바이트 배열로 변환
        byte[] bytes = upload.getBytes();
 
        // 이미지를 업로드할 디렉토리(배포 디렉토리로 설정) 실제로 이미지가 저장되는 장소.
        String uploadPath = "C:\\java202102\\workspace_spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\tripChoice\\t_hotel\\storage\\";
        
        //파일명이 중복되면 자동으로 rename 시켜줌.
        String fileName2 = UploadSaveManager.saveFileSpring30(upload, uploadPath);
        
        OutputStream out = new FileOutputStream(new File(uploadPath + fileName2));
 
        // 서버로 업로드
        // write메소드의 매개값으로 파일의 총 바이트를 매개값으로 준다.
        // 지정된 바이트를 출력 스트립에 쓴다 (출력하기 위해서)
        out.write(bytes);
 
        // 클라이언트에 결과 표시
        String callback = request.getParameter("CKEditorFuncNum");
 
        // 서버=>클라이언트로 텍스트 전송(자바스크립트 실행)
        PrintWriter printWriter = response.getWriter();
        String fileUrl = "./storage/" + fileName2; //db에 <img src="./storage/파일명"> 으로 저장됨.
        printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl
                + "','이미지가 업로드되었습니다.')" + "</script>");
        printWriter.flush();
    }

}//class end
