package kr.co.tripChoice.trip;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class TripCont {
	@Autowired
	private TripDAO dao;
	
	public TripCont() {//기본 생성자함수
		System.out.println("----TripCont()객체 생성됨");
	}//end
	
	
	//http://localhost:9090/tripChoice/trip/createForm.do
	//상품등록 페이지 호출
	@RequestMapping(value="trip/createForm.do", method = RequestMethod.GET) 
	public String createForm() {
		return "trip/createForm";
	}//createForm() end
	
	//상품등록 proc
	@RequestMapping(value="trip/createForm.do", method = RequestMethod.POST)
	public String createProc(TripDTO dto, HttpServletRequest req, Model model) {
		model.addAttribute("root", Utility.getRoot());
		
	//---------------------------------------------------------
		// 전송받은 썸네일 파일 처리
		// ->실제 파일은 /trip/thumbnail폴더에 저장
		// ->저장된 파일에 관련된 정보는 trip테이블에 저장

		// 파일 저장 폴더의 실제 물리적인 경로 가져오기
		String basePath = req.getRealPath("/trip/thumbnail");

		// 1)<input type='file' name='thumbnailMF' size='50'>
		// 파일 가져오기
		MultipartFile thumbnailMF = dto.getThumbnailMF(); // req에서 꺼내오면 다 null 나옴.
		// 파일을 저장하고 리네임된 파일명 반환. savaFileSpring30() -> storage에 이미 중복된 이름이 있으면 rename시켜서
		// 반환. 중복된거 없으면 그대로 반환.
		String thumbnail = UploadSaveManager.saveFileSpring30(thumbnailMF, basePath);
		// 파일명 dto객체에 담기
		dto.setTrip_thumbnail(thumbnail);
	//---------------------------------------------------------	
		int cnt = dao.create(dto);
		if(cnt==0) {
			String msg="상품 등록을 실패하였습니다. 다시 시도해 주세요";
			model.addAttribute("msg",msg);
			return "trip/msg";
		}else {
			return "redirect:/trip/trip_list_admin.do"; //상품등록 완료되면 자동으로 리스트 페이지 출력
		}//if end
	}//createProc() end
	
	
	//상품목록 전체출력(관리자용)
	@RequestMapping("trip/trip_list_admin.do")
	public String list_admin(Model model) {
		List<TripDTO> list = dao.list_admin();
		model.addAttribute("list",list);
		model.addAttribute("root",Utility.getRoot());
		return "trip/list";
	}//list_admin() end
	
	@RequestMapping("trip/trip_read.do")
	public String read(Model model, String trip_code) {
		TripDTO dto = dao.read(trip_code);
		model.addAttribute("dto",dto);
		return "trip/read";
	}//read() end
	

}//class end
