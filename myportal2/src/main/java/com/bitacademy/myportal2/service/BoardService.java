package com.bitacademy.myportal2.service;

import java.util.List;

import com.bitacademy.myportal2.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getList(); // 게시물 목록 조회
	public boolean write(BoardVo vo); // 게시물 추가
	public BoardVo getContent(Long no); //게시물 조회
	public boolean update(BoardVo vo); //게시물 업데이트
}
