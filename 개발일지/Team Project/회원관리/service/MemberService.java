package mc.sn.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mc.sn.team.dao.MemberDAO;
import mc.sn.team.vo.MemberVO;

@Service("memberService")
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public boolean addMember(MemberVO member) {
		boolean flag = false;
		flag = memberDAO.insertMember(member);
		return flag;
	}
	public boolean findMemberId(String id) {
		boolean flag = false;
		flag = memberDAO.selectMemberId(id);
		return flag;
	}
	public boolean findMemberEmail(String email) {
		boolean flag = false;
		flag = memberDAO.selectMemberEmail(email);
		return flag;
	}
	public boolean findMemberSubName(String sub_name) {
		boolean flag = false;
		flag = memberDAO.selectMemberSubName(sub_name);
		return flag;
	}
}
