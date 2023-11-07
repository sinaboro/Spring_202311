package com.ezen.mybatis.prj;

public interface mapperInterface {
	
	public MemberVO selectOne(int id);
	public int insertMember(MemberVO mVo);
	public int deleteMember(int id);
}
