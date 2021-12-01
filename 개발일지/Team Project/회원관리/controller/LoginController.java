package mc.sn.team.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mc.sn.team.service.LoginService;

@Controller("loginController")
public class LoginController {

	@Autowired 
	private LoginService loginService;
	
	
	public LoginController() {
		// TODO Auto-generated constructor stub
		System.out.println("controller");
	}
	@ResponseBody
	@RequestMapping(value = "/login_check", method = RequestMethod.POST)
	public void check(@RequestParam("user_id") String id,
								@RequestParam("user_pwd") String pwd,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean flag = loginService.checkLogin(id, pwd);
		response.getWriter().print(flag);
		
	}
	

}
