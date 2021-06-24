package kr.co.tripChoice.t_hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;

@Controller
public class T_hotelCont {
	@Autowired
	private T_hotelDAO dao;
	
	public T_hotelCont() {//기본생성자함수
		System.out.println("----T_hotelCont()객체 생성됨");
	}//end
	
	
	
	// http://localhost:9090/tripChoice/t_hotel/t_hotelForm.do
	//숙소등록 페이지 호출
	@RequestMapping("t_hotel/t_hotelForm.do") 
	public String t_hotelForm() {
		
		return "t_hotel/t_hotelForm";
	}//t_hotelForm() end
	
	//숙소등록 proc
	@RequestMapping("t_hotel/t_hotel_create.do")
	public String t_hotelCreate(T_hotelDTO dto) {
		dao.create(dto);
		return "redirect:/t_hotel/t_hotel_list_admin.do"; //숙소등록 완료되면 자동으로 리스트 페이지 출력
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
	public String t_hotelRead(Model model, String th_code) {
		T_hotelDTO dto = dao.read(th_code);
		model.addAttribute("dto",dto);
		model.addAttribute("root",Utility.getRoot());
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
	public String t_hotelUpdateProc(Model model, T_hotelDTO dto) {
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
	public String t_hotelDeleteproc(Model model, String th_code, String tu_id, String tu_pw) {
		int cnt = dao.delete(th_code, tu_id, tu_pw);
		if (cnt==1) {//삭제 되었다면
			return "redirect:/t_hotel/t_hotel_list_admin.do"; //숙소삭제 완료되면 자동으로 리스트 페이지 출력 
		}else {//삭제 실패했다면
			String msg="숙소 삭제를 실패하였습니다. 비밀번호를 확인해주세요.";
			model.addAttribute("msg",msg);
			model.addAttribute("root",Utility.getRoot());
			return "t_hotel/msg";
		}//if end
	}//t_hotelDeleteproc() end

}//class end
