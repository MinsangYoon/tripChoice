package kr.co.tripChoice.airp_reser;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tripChoice.t_airp.T_airpDTO;
import net.utility.Utility;

@Controller
public class Airp_reserCont {
	@Autowired
	private Airp_reserDAO dao;

	public Airp_reserCont() {
		System.out.println("---------Airp_reserCont() 객체 생성");
	}
	
	 //http://localhost:9090/tripChoice/airp_reser/reser.do
	 @RequestMapping(value="airp_reser/reser.do", method=RequestMethod.GET)
	 public ModelAndView reserForm(String ta_code) {
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("airp_reser/reserForm");
		 mav.addObject("root", Utility.getRoot());// 
		 mav.addObject("ta_code", ta_code);//부모글 번호
		 return mav;
	 }//create end
	 
	 @RequestMapping(value="airp_reser/reser.do",method=RequestMethod.POST)
	 public ModelAndView reserProc(@ModelAttribute Airp_reserDTO dto, HttpServletRequest req) {
		 
		 int cnt=0;
		 String[] ta_code_list=req.getParameterValues("ta_code");
		 String[] tu_id_list=req.getParameterValues("tu_id");
		 String[] tar_seat_list=req.getParameterValues("tar_seat");
		 String[] tar_name_list=req.getParameterValues("tar_name");
		 String[] tar_passcode_list=req.getParameterValues("tar_passcode");
		 
		 for(int i=0; i<tar_name_list.length;i++) {
			 cnt=dao.reser(ta_code_list[i],tu_id_list[i],tar_seat_list[i],tar_name_list[i],tar_passcode_list[i]);
			
		 }
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("airp_reser/msgView");
		mav.addObject("root", Utility.getRoot());
		
		if (cnt == 0) {
			String msg = "<p>항공권 예약 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='홈으로' onclick='location.href=\"../index.do\"'>";
			mav.addObject("msg1", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>항공권 예약이 완료되었습니다.</p>";
			String img = "<img src='../images/sound.png'>";
			String link1 = "<input type='button' value='홈으로' onclick='location.href=\"../index.do\"'>";
			mav.addObject("msg1", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);

		} // if end

		 
		 return mav;
		
	 }//reserProc() end
	 
	 
}