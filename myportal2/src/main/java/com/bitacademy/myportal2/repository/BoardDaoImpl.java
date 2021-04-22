package com.bitacademy.myportal2.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.myportal2.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardVo> selectAll() {
		//	TODO: 예외처리
		List<BoardVo> list = sqlSession.selectList("board.selectAll");
		return list;
	}

	@Override
	public int insert(BoardVo vo) {
		int insertedCount = sqlSession.insert("board.insert",vo);
		return insertedCount;
	}
	
	@Transactional
	@Override
	public BoardVo getContent(Long no) {
		BoardVo vo = sqlSession.selectOne("board.getContent", no);
		sqlSession.update("board.increaseHitCount",no);
		return vo;
	}

	@Override
	public int update(BoardVo vo) {
		int updatedCount = sqlSession.update("board.update",vo);
		return updatedCount;
	}

}