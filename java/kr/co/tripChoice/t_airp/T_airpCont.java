package kr.co.tripChoice.t_airp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tripChoice.t_airp.T_airpDTO;
import net.utility.Utility;

@Controller
public class T_airpCont {

	@Autowired
	private T_airpDAO dao;

	public T_airpCont() {
		System.out.println("---------T_airpCont() 객체 생성");
	}// Trip_reserCont() end

	// 항공권티켓등록폼 호출
	// http://localhost:9090/tripChoice/t_airp/ticket.do
	@RequestMapping(value = "t_airp/ticket.do", method = RequestMethod.GET)
	public String ticketForm() {
		return "t_airp/ticket";
	}// ticketForm() end

	@RequestMapping(value = "t_airp/ticket.do", method = RequestMethod.POST)
	public ModelAndView ticketProc(@ModelAttribute T_airpDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/t_airp/msgView");
		int cnt = dao.ticket(dto);
		if (cnt == 0) {
			String msg = "<p>항공권 등록 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='홈으로' onclick='location.href=\"../index.do\"'>";
			mav.addObject("msg1", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>항공권 등록이 완료되었습니다.</p>";
			String img = "<img src='../images/sound.png'>";
			String link1 = "<input type='button' value='홈으로' onclick='location.href=\"../index.do\"'>";
			mav.addObject("msg1", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);

		} // if end

		return mav;

	}// ticketProc() end
	
	// 항공권리스트 호출
	// http://localhost:9090/tripChoice/t_airp/list.do
	 @RequestMapping("t_airp/list.do")
	 public ModelAndView list() {
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("t_airp/list");
		 //request 공간에 자료 올리기
		 mav.addObject("root", Utility.getRoot());// /tripChoice
		 mav.addObject("list", dao.list());
		 return mav;
	 }//list end
	 
	
	
	
}// class end
