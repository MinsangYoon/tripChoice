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
	
	//국내상품목록 출력
	@RequestMapping("trip/trip_list_korea.do")
	public String list_korea(Model model) {
		List<TripDTO> list = dao.list_korea();
		model.addAttribute("list",list);
		model.addAttribute("root",Utility.getRoot());
		return "trip/list";
	}//list_korea() end
	
	//제주상품목록 출력
		@RequestMapping("trip/trip_list_jeju.do")
		public String list_jeju(Model model) {
			List<TripDTO> list = dao.list_jeju();
			model.addAttribute("list",list);
			model.addAttribute("root",Utility.getRoot());
			return "trip/list";
		}//list_jeju() end
		
	//해외상품목록 출력
	@RequestMapping("trip/trip_list_abroad.do")
	public String list_abroad(Model model) {
		List<TripDTO> list = dao.list_abroad();
		model.addAttribute("list",list);
		model.addAttribute("root",Utility.getRoot());
		return "trip/list";
	}//list_abroad() end
	
	
	//상품상세보기페이지
	@RequestMapping("trip/trip_read.do")
	public String read(Model model, String trip_code) {
		TripDTO dto = dao.read(trip_code);
		model.addAttribute("root",Utility.getRoot());
		model.addAttribute("dto",dto);
		return "trip/read";
	}//read() end
	
	
	//상품수정 페이지 불러오기
	@RequestMapping(value = "trip/trip_update.do", method = RequestMethod.GET)
	public String update(Model model, String trip_code) {
		TripDTO dto = dao.read(trip_code);
		model.addAttribute("root",Utility.getRoot());
		model.addAttribute("dto",dto);
		return "trip/updateForm";
	}//update() end
	
	//상품수정 proc
	@RequestMapping(value = "trip/trip_update.do", method = RequestMethod.POST)
	public String updateProc(TripDTO dto, HttpServletRequest req, Model model) {
		model.addAttribute("root",Utility.getRoot());
		
		String basepath = req.getRealPath("/trip/thumbnail");
		TripDTO oldDTO = dao.read(dto.getTrip_code()); //기존에 저장된 정보 가져오기
		//--------------------------------------------------------------------
		MultipartFile thumbnailMF = dto.getThumbnailMF();
		if (thumbnailMF.getSize() > 0) { // 새로운 thumbnail파일이 전송되었는지
			// 기존 파일 삭제
			UploadSaveManager.deleteFile(basepath, oldDTO.getTrip_thumbnail());
			// 신규 파일 저장
			String thumbnail = UploadSaveManager.saveFileSpring30(thumbnailMF, basepath);
			dto.setTrip_thumbnail(thumbnail);
		} else {
			// thumbnail파일을 수정하지 않은 경우
			dto.setTrip_thumbnail(oldDTO.getTrip_thumbnail());
		} // if end
		
		int cnt=dao.update(dto);
		if (cnt == 0) {
			model.addAttribute("msg1", "<p>상품 수정 실패!!</p>");
			model.addAttribute("img", "<p><img src='../images/fail.png'></p>");
			model.addAttribute("link1", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
			model.addAttribute("link2", "<input type='button' value='상품목록' onclick='location.href=\"trip_list_admin.do\"'>");
		} else {
			model.addAttribute("msg1", "<p>상품파일이 수정 되었습니다.</p>");
			model.addAttribute("img", "<p><img src='../images/sound.png'></p>");
			model.addAttribute("link1", "<input type='button' value='상품목록' onclick='location.href=\"trip_list_admin.do\"'>");
		}//if end	
		
		return "trip/msg";
	}//updateProc() end
	
	//상품삭제 페이지 호출
	@RequestMapping(value = "trip/trip_delete.do", method = RequestMethod.GET)
	public String deleteForm(String trip_code, Model model) {
		model.addAttribute("trip_code",trip_code);
		model.addAttribute("root",Utility.getRoot());
		return "trip/deleteForm";
	}//deleteForm() end
	
	//상품삭제 proc
	@RequestMapping(value = "trip/trip_delete.do", method = RequestMethod.POST)
	public String deleteProc(Model model, String trip_code, String tu_id, String tu_pw, HttpServletRequest req) {
		model.addAttribute("root",Utility.getRoot());
		
		// tumbnail 폴더에 있는 정보도 삭제하기 위해 삭제하고자하는 상품정보 가져오기
		TripDTO oldDTO = dao.read(trip_code);
		
		int cnt = dao.delete(trip_code, tu_id, tu_pw);
		if (cnt == 0) {
			model.addAttribute("msg1", "<p>비밀번호를 다시 확인해 주세요!!</p>");
			model.addAttribute("img", "<p><img src='../images/fail.png'></p>");
			model.addAttribute("link1", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
			model.addAttribute("link2", "<input type='button' value='상품목록' onclick='location.href=\"trip_list_admin.do\"'>");
		} else {
			model.addAttribute("msg1", "<p>상품이 삭제 되었습니다.</p>");
			model.addAttribute("img", "<p><img src='../images/sound.png'></p>");
			model.addAttribute("link1", "<input type='button' value='상품목록' onclick='location.href=\"trip_list_admin.do\"'>");
			// storge폴더에 있는 파일 삭제
			String basepath = req.getRealPath("/trip/thumbnail");
			UploadSaveManager.deleteFile(basepath, oldDTO.getTrip_thumbnail());
		} // if end
		
		return "trip/msg";
	}//deleteProc() end
	

}//class end
