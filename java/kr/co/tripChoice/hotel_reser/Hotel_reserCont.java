package kr.co.tripChoice.hotel_reser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;

@Controller
public class Hotel_reserCont {
	@Autowired
	private Hotel_reserDAO dao;
	
	public Hotel_reserCont() {//기본생성자함수
		System.out.println("----Hotel_reserCont() 객체 생성됨");
	}//end
	
	
	
	

}//class end
