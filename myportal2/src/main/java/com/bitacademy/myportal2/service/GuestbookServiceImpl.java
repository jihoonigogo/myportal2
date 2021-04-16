package com.bitacademy.myportal2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal2.repository.GuestbookDao;
import com.bitacademy.myportal2.vo.GuestbookVo;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	
	
	//DAO연결
	//autowired : bean이름으로 객체를 검색해서 주입(di)
	@Autowired
	GuestbookDao guestbookDaoImpl;
	
	@Override
	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = guestbookDaoImpl.selectAll();
		return list;
	}

	@Override
	public boolean writeMessage(GuestbookVo vo) {
		int insertedCount = guestbookDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public boolean deleteMessage(GuestbookVo vo) {
		int deletedCount = guestbookDaoImpl.delete(vo);
		return 1 == deletedCount;
	}

}
