package com.bitacademy.myportal2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.myportal2.exception.ControllerException;

@Controller
public class MainController {

	
	

		@RequestMapping({"/","/main"})
		public ModelAndView home () {
			ModelAndView mav = new ModelAndView();
			
			//mav.addObject("message","반갑습니다......"+ name); @RequestParam String name
			//mav.addObject("spring", name + "....봄이 왔습니다.");
//			mav.setViewName("/WEB-INF/views/home.jsp");
			mav.setViewName("home");

			return mav;
		}
		
		@ResponseBody
		@RequestMapping("/except")
		public String except(HttpServletRequest req) {
			try { 
				int result =4/0;
			}catch(Exception e) {
				//예외는 완벽복구 어렵기에 외부로 던진다 ?
				//System.out.println("예외:"+e.getMessage());
				
//				throw new RuntimeException("main controller error");
				//일반적인 예외는 구체적인 의미를 가진 예외로 전환해서 
				//처리하는 것을 권장.
				
				throw new ControllerException("Main Controller Error",req);
			}
			return "Exception Test";
		}
	


	// 컨트롤러 내부 예외처리 
//	//exceptionhandler v1
//	//예외를 처리하는 메서드.	
//@ExceptionHandler(RuntimeException.class)
//@ResponseBody
//public String handleControllerExcept(RuntimeException e) {
//	return "main controller exception :" + e.getMessage();
//}
//
//
//	//exceptionhandler v2 
//	//v1보다 구체적인 예외처리 
//@ExceptionHandler(ControllerException.class)
////@ResponseBody
//public String handleControllerExcept(ControllerException e, Model model) {
//	model.addAttribute("name", e.getClass().getSimpleName());
//	model.addAttribute("message", e.getMessage());
//	
//	//예외가 발생하면 가급적 
//	//로그를 기록하고, 개발자나 관ㄹ리자에게 고지 ㄱㄱ
//	System.err.println("발생 예외" + e.getClass().getSimpleName());
//	System.err.println("예외발생시 요청 url:"+e.getReq().getRequestURI()); // => 에러 발생 당시 요청 정보 기록 
//	return "error/exception";
//}
//
//
//
//}
}