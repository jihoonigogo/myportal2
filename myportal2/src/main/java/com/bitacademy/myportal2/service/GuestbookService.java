package com.bitacademy.myportal2.service;

import java.util.List;

import com.bitacademy.myportal2.vo.GuestbookVo;

public interface GuestbookService {
	public List<GuestbookVo> getList ();
	public boolean writeMessage(GuestbookVo vo); // 게심ㄹ ㅈㄱ송
	public boolean deleteMessage(GuestbookVo vo);
}
