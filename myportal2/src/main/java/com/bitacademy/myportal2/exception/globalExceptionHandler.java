package com.bitacademy.myportal2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

// 어드바이징 컨트롤러  : 전역에서 발생하는 예외 감지 및 처리
@ControllerAdvice
public class globalExceptionHandler {
	
	
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // cotrollerexception 발생시 500번 에러 전송
		@ExceptionHandler(ControllerException.class)
		public ModelAndView handleControllerException(ControllerException e) {
			// 예외처리시 중요한 것 !
			//1. 로깅 
			System.err.println("------------------");
			System.err.println("ControllAdvice에 의한 Error Handling");
			e.printStackTrace(); // 예외에 대한 세부 정보 로깅 
			
			// 2. 시스템 오류 관련 안내 화면 전송 
			ModelAndView mav = new ModelAndView();
			mav.addObject("name(에러의 이름", e.getClass().getSimpleName());
			mav.addObject("message", e.getMessage());
			mav.setViewName("error/exception");

			
			return mav;
		}
		
		
		//MemberDaoException 예외 처리 핸들러
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(MemberDaoException.class)
		public ModelAndView handleMemberDaoException(MemberDaoException e) {
			
			System.err.println("MemberDaoException : " + e.getMessage());
			e.printStackTrace();
			
			System.err.println("MembereVo :" + e.getMemberVo());
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("name",e.getClass().getSimpleName());
			mav.addObject("message",e.getMessage());
			mav.setViewName("error/exception");
			return mav;
		}
}
