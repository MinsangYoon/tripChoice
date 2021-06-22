package kr.co.tripChoice.tuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TuserCont {
	
	@Autowired
	private TuserDAO dao;
	
	public TuserCont() {
		System.out.println("---TuserCont()객체 생성됨");
	}
	
	//페이지 호출
	@RequestMapping(value="tuser/loginForm.do", method =RequestMethod.GET)
	public String loginForm() {
		return "tuser/loginForm";
	}
	//public String 
	@RequestMapping(value="tuser/loginProc.do", method =RequestMethod.POST)
    public ModelAndView loginProc(TuserDTO dto) {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "tuser/loginProc");
        return mav;
	}
	@RequestMapping(value="tuser/logout.do", method =RequestMethod.GET)
	public String logout() {
		return "tuser/logout";
	}
	@RequestMapping(value="tuser/agreement.do", method =RequestMethod.GET)
	public String agreement() {
		return "tuser/agreement";
	}
	@RequestMapping(value = "tuser/emailCheckForm.do", method = RequestMethod.GET)
	public String emailCheckForm() {
		return "tuser/emailCheckForm";
	}
	@RequestMapping(value = "tuser/emailCheckProc.do", method = RequestMethod.GET)
	public String emailCheckProc() {
		return "tuser/emailCheckProc";
	}
	@RequestMapping(value="tuser/findID.do", method =RequestMethod.GET)
	public String findID() {
		return "tuser/findID";
	}
	@RequestMapping(value="tuser/findIDProc.do", method =RequestMethod.GET)
	public String findIDProc() {
		return "tuser/findIDProc";
	}
	@RequestMapping(value = "tuser/idCheckForm.do", method = RequestMethod.GET)
	public String idCheckForm() {
		return "tuser/idCheckForm";
	}
	@RequestMapping(value = "tuser/idCheckProc.do", method = RequestMethod.GET)
	public String idCheckProc() {
		return "tuser/idCheckProc";
	}
	@RequestMapping(value="tuser/memberForm.do", method =RequestMethod.GET)
	public String memberForm() {
		return "tuser/memberForm";
	}
	@RequestMapping(value="tuser/memberModify.do", method =RequestMethod.GET)
	public String memberModify() {
		return "tuser/memberModify";
	}
	@RequestMapping(value="tuser/memberModifyProc.do", method =RequestMethod.POST)
    public ModelAndView memberModifyProc(TuserDTO dto) {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "tuser/memberModifyProc");
        return mav;
	}
	@RequestMapping(value="tuser/memberProc.do", method =RequestMethod.POST)
    public ModelAndView memberProc(TuserDTO dto) {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "tuser/memberProc");
        return mav;
	}
	@RequestMapping(value="tuser/memberWithdraw.do", method =RequestMethod.GET)
	public String memberWithdraw() {
		return "tuser/memberWithdraw";
	}
	@RequestMapping(value="tuser/memberWithdrawProc.do", method =RequestMethod.POST)
    public ModelAndView memberWithdrawProc(TuserDTO dto) {
        ModelAndView mav = new ModelAndView ();
        mav.setViewName ( "tuser/memberWithdrawProc");
        return mav;
	}

}//class end
