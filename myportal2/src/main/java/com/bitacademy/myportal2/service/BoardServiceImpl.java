package com.bitacademy.myportal2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal2.repository.BoardDao;
import com.bitacademy.myportal2.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	//	Repository 연결
	@Autowired
	BoardDao boardDaoImpl;
	
	@Override
	public List<BoardVo> getList() {
		List<BoardVo> list = boardDaoImpl.selectAll();
		return list;
	}

	@Override
	public boolean write(BoardVo vo) {
		int insertedCount = boardDaoImpl.insert(vo);
		
		return  1==insertedCount;
	}

	@Override
	public BoardVo getContent(Long no) {
		BoardVo vo = boardDaoImpl.getContent(no);
		return vo;
	}

	@Override
	public boolean update(BoardVo vo) {
		int updatedCount =boardDaoImpl.update(vo);
		
		return 1 == updatedCount;
	}

}
