package com.bitacademy.myportal2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal2.service.GuestbookService;
import com.bitacademy.myportal2.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	// controller에 service 연결
	@Autowired
	GuestbookService guestbookServiceImpl;
	
	
//	@ResponseBody
	@RequestMapping({"","/","/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookServiceImpl.getList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@RequestMapping(value ="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("VO:" +vo);
		boolean success = guestbookServiceImpl.writeMessage(vo);
		System.out.println("Write Result :" + success);
		
		//리스트 페이지로 재전송 
		return "redirect:/guestbook";
	}
	
	//게시물 삭제 폼 
	
	@RequestMapping(value="/delete/{no}", // path variable
		 method = RequestMethod.GET)
	public String deleteForm(@PathVariable Long no,Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookServiceImpl.deleteMessage(vo);
		System.out.println("delete result :" + success);
		return "redirect:/guestbook";
	}
}
