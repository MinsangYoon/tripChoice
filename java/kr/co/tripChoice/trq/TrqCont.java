package kr.co.tripChoice.trq;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TrqCont {

	@Autowired
	private TrqDAO dao;
	
	public TrqCont() {
		System.out.println("--------TrqCont() 객체가 생성 되었습니다.");
	}//TripCont() end
			
	
	
			@RequestMapping(value="trq/trqDel.do", method =RequestMethod.GET)
			public String trqDel() {
				return "trq/trqDel";
			}
			@RequestMapping(value="trq/trqDelproc.do", method =RequestMethod.POST)
		    public ModelAndView trqDelproc(TrqDTO dto) {
		        ModelAndView mav = new ModelAndView ();
		        mav.setViewName ( "trq/trqDelproc");
		        return mav;
			}
			//문의사항 폼 호출
			// http://localhost:9090/tripChoice/trqForm.do
			 @RequestMapping("trq/trqForm.do")
			 public ModelAndView Form() {
				 ModelAndView Form = new ModelAndView();
				 Form.setViewName("trq/trqForm");
				 return Form;
			 }//Form end
			 
			 @RequestMapping(value="trq/trqIns.do", method =RequestMethod.GET)
				public String trqIns() {
					return "trq/trqIns";
				}
			 
			 @RequestMapping(value="trq/trqIns.do", method =RequestMethod.POST)
			    public ModelAndView trqIns(TrqDTO dto) {
			        ModelAndView mav = new ModelAndView ();
			        mav.setViewName ( "trq/trqIns");
			        return mav;
				}
			
			//문의사항 리스트 호출
			// http://localhost:9090/tripChoice/trqList.do
			 @RequestMapping("trq/trqList.do")
			 public ModelAndView list() {
				 ArrayList<TrqDTO> list = dao.list();
				 ModelAndView mav = new ModelAndView();
				 mav.setViewName("trq/trqList");
				 mav.addObject("list",list);
				 return mav;
			 }//list end
			
			@RequestMapping(value="trq/trqRead.do", method =RequestMethod.GET)
			public String trqRead() {
				return "trq/trqRead";
			}
			
	
			@RequestMapping(value="trq/trqUpdate.do", method =RequestMethod.GET)
			public String trqUpdate() {
				return "trq/trqUpdate";
			}
			@RequestMapping(value="trq/trqUpdateproc.do", method =RequestMethod.POST)
		    public ModelAndView trqUpdateproc(TrqDTO dto) {
		        ModelAndView mav = new ModelAndView ();
		        mav.setViewName ( "trq/trqUpdateproc");
		        return mav;
			}
			
		

	
}//class end
