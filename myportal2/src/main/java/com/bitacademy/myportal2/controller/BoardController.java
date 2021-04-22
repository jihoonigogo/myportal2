package com.bitacademy.myportal2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal2.service.BoardService;
import com.bitacademy.myportal2.vo.BoardVo;
import com.bitacademy.myportal2.vo.MemberVo;


@Controller
@RequestMapping("/board")
public class BoardController {
	//	로거 연결
	private static Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	//	서비스 연결
	@Autowired
	BoardService boardServiceImpl;
	
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		//	게시물 목록 받아오기
		List<BoardVo> list = boardServiceImpl.getList();
		//	모델에 실어서 View로 전달
		model.addAttribute("list", list);
		logger.debug("게시물 목록:", list);
		
		return "board/list";
	}

	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		//시용자를 체크해서 로그인 안한 사람은 쓰기 기능x
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if(authUser == null) {
			//로그인 하지 않은 사용자 
			return "redirect:/";
		}   
			return "board/write";
	}
	
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String writeAction(@ModelAttribute BoardVo vo,
			HttpSession session) {
		MemberVo authUser =(MemberVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/board/write";
		}
		
		//전달받은 boardvo객체에 현재 로그인한 사용자의 pk 삽입
		vo.setMemberNo(authUser.getNo());
		boolean success = boardServiceImpl.write(vo);
		logger.debug("게시물 등록 결과",success);
		
		if(success) {
			return "redirect:/board";
			
		}else {
			return "redirect:/board/write";
		}
	}
	
	@RequestMapping("/{no}")
	public String view(@PathVariable Long no,Model model) {
		BoardVo vo = boardServiceImpl.getContent(no);
		model.addAttribute("vo", vo); // "이름",전달할 내용
		return "board/view";
		
	}
	
	@RequestMapping("/{no}/modify")
	public String modifyForm(@PathVariable Long no,Model model,HttpSession session) {
		//기존 게시물 받아오기
		BoardVo vo = boardServiceImpl.getContent(no); // 게시물 받아오기
		MemberVo authUser = (MemberVo)session.getAttribute("authUser"); //세션받아오기
		if(authUser == null) {
			return "redirect:/board";
		}else if (authUser.getNo() != vo.getMemberNo()) { //게시물 작성자가 아니라면 
			return "redirect:/board";
		}
			model.addAttribute("vo",vo);
			return "/board/modify";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String modifyAction(@ModelAttribute BoardVo updatedVo) {
		//기ㅗㄴ 게시물 불러오기 
		BoardVo vo = boardServiceImpl.getContent(updatedVo.getNo());
		//변경된 내용을 교체한다.
		vo.setTitle(updatedVo.getTitle());
		vo.setContent(updatedVo.getContent());
		
		boolean success = boardServiceImpl.update(vo);
		logger.debug("게시물 업데이트 :",success);
		return "redirect:/board";
		
	}
}
