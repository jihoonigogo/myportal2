package com.bitacademy.myportal2.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal2.vo.GuestbookVo;

@Repository
//@Repository("guestbookDao")
public class GuestbookDaoImpl implements GuestbookDao {

	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public List<GuestbookVo> selectAll() {
		
		
//
//			List<GuestbookVo> list = new ArrayList<>();
//			list.add(new GuestbookVo(1L,"헝길덩","1234","왓다가요",new Date()));
//			list.add(new GuestbookVo(2L,"L길덩","PASS","왓다가요2",new Date()));
//
//			list.add(new GuestbookVo(3L,"헝길L","test","왓다가요3",new Date()));
		
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
		System.out.println("방명록:" +list);
		
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = sqlSession.insert("guestbook.insert",vo);
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = sqlSession.delete("guestbook.delete", vo);
		return deletedCount;
	}

}
