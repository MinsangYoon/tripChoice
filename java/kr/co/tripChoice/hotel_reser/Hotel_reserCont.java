package kr.co.tripChoice.hotel_reser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tripChoice.trip_reser.Trip_reserDAO;
import kr.co.tripChoice.trip_reser.Trip_reserDTO;
import net.utility.Utility;

@Controller
public class Hotel_reserCont {
	@Autowired
	private Hotel_reserDAO dao;
	
	
	public Hotel_reserCont() {//기본생성자함수
		System.out.println("----Hotel_reserCont() 객체 생성됨");
	}//end
	
	
	@RequestMapping("hotel_reser/hotel_reser_insert.do")
	public String hotel_reser_insert(Hotel_reserDTO dto, Model model) {
		int cnt = dao.create(dto);
		
		model.addAttribute("root",Utility.getRoot());
		
		if(cnt==1) {
		
		return "hotel_reser/msg";
		}else {
			return "";
		}
	}//end
	
	
	
	

}//class end
