package com.bitacademy.myportal2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal2.repository.MemberDao;
import com.bitacademy.myportal2.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean join(MemberVo vo) {
		int insertedCount = memberDao.insert(vo);
		return 1== insertedCount; // 이 의미를 모름
	}

	@Override
	public MemberVo getUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
