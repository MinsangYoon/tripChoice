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
	
	
	
	//http://localhost:9090/tripChoice/t_hotel/t_hotelForm.do
	@RequestMapping("t_hotel/t_hotelForm.do") 
	public String t_hotelForm() {
		
		return "t_hotel/t_hotelForm";
	}//end
	
	
	@RequestMapping("t_hotel/create.do")
	public String t_hotelCreate(T_hotelDTO dto) {
		dao.create(dto);
		return "redirect:/t_hotel/list.do";
	}//end
	
	@RequestMapping("t_hotel/list.do")
	public String t_hotelList(Model model) {
		List<T_hotelDTO> list= dao.list();
		model.addAttribute("list",list);
		return "t_hotel/t_hotelList";
	}//end
	
	

}//class end
