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
	public String hotel_reser_insert(HttpServletRequest req, Model model) {
		String trip_code = req.getParameter("trip_code");
		int tr_adult = Integer.parseInt(req.getParameter("tr_adult"));
		int tr_kid = Integer.parseInt(req.getParameter("tr_kid"));
		int tr_baby = Integer.parseInt(req.getParameter("tr_baby"));
		int tr_price = Integer.parseInt(req.getParameter("tr_price"));
		String tr_departure = req.getParameter("tr_departure");
		String tr_arrival = req.getParameter("tr_arrival");
		String th_code = req.getParameter("th_code");
		String tu_id = req.getParameter("tu_id");
		int thr_member = Integer.parseInt(req.getParameter("thr_member"));
		
		dao.create2(th_code,tu_id,thr_member,trip_code);
		
		model.addAttribute("tr_adult",tr_adult);
		model.addAttribute("tr_kid",tr_kid);
		model.addAttribute("tr_baby",tr_baby);
		model.addAttribute("tr_price",tr_price);
		model.addAttribute("tr_departure",tr_departure);
		model.addAttribute("tr_arrival",tr_arrival);
		model.addAttribute("trip_code",trip_code);
		model.addAttribute("tu_id",tu_id);
		
		return "redirect:/trip_reser/trip_reser_insert.do";
		
	}//end
	

}//class end
