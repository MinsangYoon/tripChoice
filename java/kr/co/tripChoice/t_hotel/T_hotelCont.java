package kr.co.tripChoice.t_hotel;

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

import kr.co.tripChoice.trip.TripDTO;
import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class T_hotelCont {
	@Autowired
	private T_hotelDAO dao;
	
	public T_hotelCont() {//기본생성자함수
		System.out.println("----T_hotelCont()객체 생성됨");
	}//end
	
	
	
	//http://localhost:9090/tripChoice/t_hotel/t_hotelForm.do
	//숙소등록 페이지 호출
	@RequestMapping("t_hotel/t_hotelForm.do") 
	public String t_hotelForm() {
		
		return "t_hotel/t_hotelForm";
	}//t_hotelForm() end
	
	//숙소등록 proc
	@RequestMapping("t_hotel/t_hotel_create.do")
	public String t_hotelCreate(T_hotelDTO dto,HttpServletRequest req, Model model) {
		model.addAttribute("root", Utility.getRoot());
		//---------------------------------------------------------
			// 전송받은 썸네일 파일 처리
			// ->실제 파일은 /trip/thumbnail폴더에 저장
			// ->저장된 파일에 관련된 정보는 trip테이블에 저장

			// 파일 저장 폴더의 실제 물리적인 경로 가져오기
			String basePath = req.getRealPath("/t_hotel/thumbnail");

			// 1)<input type='file' name='thumbnailMF' size='50'>
			// 파일 가져오기
			MultipartFile thumbnailMF = dto.getThumbnailMF(); // req에서 꺼내오면 다 null 나옴.
			// 파일을 저장하고 리네임된 파일명 반환. savaFileSpring30() -> storage에 이미 중복된 이름이 있으면 rename시켜서
			// 반환. 중복된거 없으면 그대로 반환.
			String thumbnail = UploadSaveManager.saveFileSpring30(thumbnailMF, basePath);
			// 파일명 dto객체에 담기
			dto.setTh_thumbnail(thumbnail);
		//---------------------------------------------------------	
		
		int cnt = dao.create(dto);
		if(cnt==0) {
			String msg="숙소 등록을 실패하였습니다. 다시 시도해 주세요";
			model.addAttribute("msg",msg);
			return "t_hotel/msg";
		}else {
			return "redirect:/t_hotel/t_hotel_list_admin.do"; //숙소등록 완료되면 자동으로 리스트 페이지 출력
		}//if end
	}//t_hotelCreate() end
	
	//숙소목록 전체보기(관리자 전용)
	@RequestMapping("t_hotel/t_hotel_list_admin.do")
	public String t_hotelList(Model model) {
		List<T_hotelDTO> list= dao.list_admin();
		model.addAttribute("list",list);
		model.addAttribute("root",Utility.getRoot());
		return "t_hotel/t_hotelList";
	}//t_hotelList() end
	
	//숙소상세보기
	@RequestMapping("t_hotel/t_hotel_read.do")
	public String t_hotelRead(Model model, String th_code, HttpServletRequest req) {
		String thr_adult=req.getParameter("thr_adult");
		String thr_kid=req.getParameter("thr_kid");
		String thr_in=req.getParameter("thr_in");
		String thr_out=req.getParameter("thr_out");
		
		T_hotelDTO dto = dao.read(th_code);
		model.addAttribute("dto",dto);
		model.addAttribute("root",Utility.getRoot());
		model.addAttribute("thr_adult",thr_adult);
		model.addAttribute("thr_kid",thr_kid);
		model.addAttribute("thr_in",thr_in);
		model.addAttribute("thr_out",thr_out);
		
		return "t_hotel/t_hotelRead";
	}//t_hotelRead() end
	
	//숙소 수정 페이지 호출
	@RequestMapping(value = "t_hotel/t_hotel_update.do", method = RequestMethod.GET)
	public String t_hotelUpdateForm(Model model, String th_code) {
		T_hotelDTO dto = dao.read(th_code);
		model.addAttribute("dto",dto);
		return "t_hotel/t_hotelUpdateForm";
	}//t_hotelUpdateForm() end
	
	//숙소 수정 proc
	@RequestMapping(value = "t_hotel/t_hotel_update.do", method = RequestMethod.POST)
	public String t_hotelUpdateProc(Model model, T_hotelDTO dto, HttpServletRequest req) {
		
		String basepath = req.getRealPath("/t_hotel/thumbnail");
		T_hotelDTO oldDTO = dao.read(dto.getTh_code()); //기존에 저장된 정보 가져오기
		//--------------------------------------------------------------------
		MultipartFile thumbnailMF = dto.getThumbnailMF();
		if (thumbnailMF.getSize() > 0) { // 새로운 thumbnail파일이 전송되었는지
			// 기존 파일 삭제
			UploadSaveManager.deleteFile(basepath, oldDTO.getTh_thumbnail());
			// 신규 파일 저장
			String thumbnail = UploadSaveManager.saveFileSpring30(thumbnailMF, basepath);
			dto.setTh_thumbnail(thumbnail);
		} else {
			// thumbnail파일을 수정하지 않은 경우
			dto.setTh_thumbnail(oldDTO.getTh_thumbnail());
		} // if end
		
		int cnt = dao.update(dto);
		if (cnt==1) {
			return "redirect:/t_hotel/t_hotel_list_admin.do"; //숙소수정 완료되면 자동으로 리스트 페이지 출력
		}else {
			String msg="숙소 수정을 실패하였습니다. 다시 시도해 주세요";
			model.addAttribute("msg",msg);
			model.addAttribute("root",Utility.getRoot());
			return "t_hotel/msg";
		}//if end
	}//t_hotelUpdateProc() end
	
	//숙소 삭제 페이지 호출
	@RequestMapping(value = "t_hotel/t_hotel_delete.do", method = RequestMethod.GET)
	public String t_hotelDeleteForm(Model model, String th_code) {
		model.addAttribute("th_code",th_code);
		return "t_hotel/t_hotelDeleteForm";
	}//t_hotelDeleteForm() end
	
	//숙소 삭제 proc
	@RequestMapping(value = "t_hotel/t_hotel_delete.do", method = RequestMethod.POST)
	public String t_hotelDeleteproc(Model model, String th_code, String tu_id, String tu_pw, HttpServletRequest req) {
		// tumbnail 폴더에 있는 정보도 삭제하기 위해 삭제하고자하는 상품정보 가져오기
		T_hotelDTO oldDTO = dao.read(th_code);
		
		int cnt = dao.delete(th_code, tu_id, tu_pw);
		if (cnt==1) {//삭제 되었다면
			return "redirect:/t_hotel/t_hotel_list_admin.do"; //숙소삭제 완료되면 자동으로 리스트 페이지 출력 
		}else {//삭제 실패했다면
			String msg="숙소 삭제를 실패하였습니다. 비밀번호를 확인해주세요.";
			model.addAttribute("msg",msg);
			model.addAttribute("root",Utility.getRoot());
			// storge폴더에 있는 파일 삭제
			String basepath = req.getRealPath("/t_hotel/thumbnail");
			UploadSaveManager.deleteFile(basepath, oldDTO.getTh_thumbnail());
			return "t_hotel/msg";
		}//if end
	}//t_hotelDeleteproc() end
	
	
	//숙소리스트 출력(해당 지역만)
	@RequestMapping("t_hotel/t_hotel_list.do")
	public String t_hotelList2(Model model, HttpServletRequest req) {
		String th_reg=req.getParameter("th_reg");
		String thr_adult=req.getParameter("thr_adult");
		String thr_kid=req.getParameter("thr_kid");
		int total_people = Integer.parseInt(thr_adult)+Integer.parseInt(thr_kid); //총 인원 수
		String thr_in = req.getParameter("thr_in");
		String thr_out = req.getParameter("thr_out");
		
		
		List<T_hotelDTO> list =dao.list(th_reg,total_people, thr_in, thr_out);
		
		model.addAttribute("root",Utility.getRoot());
		model.addAttribute("list",list);
		model.addAttribute("thr_adult",thr_adult);
		model.addAttribute("thr_kid",thr_kid);
		model.addAttribute("thr_in",thr_in);
		model.addAttribute("thr_out",thr_out);
		
		
		return "t_hotel/t_hotelList";
	}//t_hotelList2() end

}//class end
