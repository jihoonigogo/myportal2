package com.bitacademy.myportal2.repository;

import java.util.List;

import com.bitacademy.myportal2.vo.BoardVo;

public interface BoardDao {

	public List<BoardVo> selectAll(); // 게시물 목록 조회용
	public int insert(BoardVo vo);        // 게시물 추가
	public BoardVo getContent(Long no); // 게시물 조회
	public int update(BoardVo vo);      //게시물 수정
}
