package com.bitacademy.myportal2.service;

import com.bitacademy.myportal2.vo.MemberVo;

public interface MemberService {

	public boolean join(MemberVo vo); // 가입 
	public MemberVo getUser(String email,String password) ;// 로그인
	public MemberVo getUser(String email);// 이메일 중복체크
}
