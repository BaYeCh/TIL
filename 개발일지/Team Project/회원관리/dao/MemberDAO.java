package mc.sn.team.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mc.sn.team.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insertMember(MemberVO memberVO) {
		boolean flag = false;
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		if(result==1) {
			flag = true;
		}
		return flag;
	}
	public boolean selectMemberId(String id) {
		boolean flag = false;
		MemberVO memberVO = sqlSession.selectOne("mapper.member.selectById", id);
		//System.out.println(memberVO);
		if(memberVO != null) {
			flag = true;
		}
		return flag;
	}
	public boolean selectMemberEmail(String email) {
		boolean flag = false;
		MemberVO memberVO = sqlSession.selectOne("mapper.member.selectByEmail", email);
		//System.out.println(memberVO);
		if(memberVO != null) {
			flag = true;
		}
		return flag;
	}
	public boolean selectMemberSubName(String sub_name) {
		boolean flag = false;
		MemberVO memberVO = sqlSession.selectOne("mapper.member.selectBySubName", sub_name);
		//System.out.println(memberVO);
		if(memberVO != null) {
			flag = true;
		}
		return flag;
	}
}
