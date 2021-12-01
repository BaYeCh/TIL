package mc.sn.team.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mc.sn.team.service.MemberService;
import mc.sn.team.vo.MemberVO;

@Controller("memberController")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping(value = "/view_member.do", method = RequestMethod.GET)
	public String member(HttpServletRequest request, HttpServletResponse reponse) {
		
		return "/member/join";
	}
	
	@ResponseBody
	@RequestMapping(value = "/addMember.do", method = RequestMethod.POST)
	public void addMember(@ModelAttribute("member") MemberVO member,
									HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println(member);
		boolean flag =  memberService.addMember(member);
		response.getWriter().print(flag);
		
	}
	@ResponseBody
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	public void checkMember(@RequestParam("id") String id,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean flag = memberService.findMemberId(id);
		response.getWriter().print(flag);
		//System.out.println(flag);
	}
	@ResponseBody
	@RequestMapping(value = "/emailCheck.do", method = RequestMethod.POST)
	public void checkMemberEmail(@RequestParam("email") String email,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean flag = memberService.findMemberEmail(email);
		response.getWriter().print(flag);
		//System.out.println(flag);
	}
	@ResponseBody
	@RequestMapping(value = "/subNameCheck.do", method = RequestMethod.POST)
	public void checkMemberNickname(@RequestParam("sub_name") String sub_name,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean flag = memberService.findMemberSubName(sub_name);
		response.getWriter().print(flag);
		//System.out.println(flag);
	}

}
