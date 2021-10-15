package model.member;

import java.util.List;

public interface MemberService {
	public MemberVO login(MemberVO vo);
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public void deleteMember(MemberVO vo);
	public void updateMember(MemberVO vo);
}
