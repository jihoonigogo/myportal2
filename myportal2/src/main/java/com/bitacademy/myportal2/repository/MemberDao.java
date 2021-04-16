package com.bitacademy.myportal2.repository;

import com.bitacademy.myportal2.vo.MemberVo;

public interface MemberDao {
	
	public int insert(MemberVo vo); // 테이블 레코드 삽입
	public MemberVo selectUser(String email,String password);
	public MemberVo selectUser(String email);

}
