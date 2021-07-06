package kr.co.tripChoice.trip_reser;

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
public class Trip_reserCont {
	@Autowired
	private Trip_reserDAO dao;
	
	public Trip_reserCont() {//기본생성자함수
		System.out.println("----Trip_reserCont()객체 생성됨");
	}//end
	
	
	
	@RequestMapping(value = "trip_reser/trip_reser_insert.do")
	public String trip_reser_insert(Model model, HttpServletRequest req, Trip_reserDTO dto) {
		String trip_code = req.getParameter("trip_code");
		int tr_adult = Integer.parseInt(req.getParameter("tr_adult"));
		int tr_kid = Integer.parseInt(req.getParameter("tr_kid"));
		int tr_baby = Integer.parseInt(req.getParameter("tr_baby"));
		int tr_price = Integer.parseInt(req.getParameter("tr_price"));
		String tr_departure = req.getParameter("tr_departure");
		String tr_arrival = req.getParameter("tr_arrival");
		String tu_id = req.getParameter("tu_id");
		
		model.addAttribute("root",Utility.getRoot());
		
		int cnt= dao.create2(trip_code, tu_id, tr_adult, tr_kid, tr_baby, tr_price, tr_departure, tr_arrival);
		
		if(cnt==1) {
		return "trip_reser/msg";
		}
		return "";
	}//trip_reser_insert() end
	
	
	
	
}//class end
