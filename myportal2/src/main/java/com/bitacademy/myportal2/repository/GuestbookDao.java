package com.bitacademy.myportal2.repository;

import java.util.List;

import com.bitacademy.myportal2.vo.GuestbookVo;

public interface GuestbookDao {
	public List<GuestbookVo> selectAll();
	public int insert(GuestbookVo vo);
	public int delete(GuestbookVo vo);
	
}
