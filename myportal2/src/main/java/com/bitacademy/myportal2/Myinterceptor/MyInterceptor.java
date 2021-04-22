package com.bitacademy.myportal2.Myinterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.myportal2.controller.BoardController;

//spring-servlet.xml에 등록해주어야함.
//인터페이스 구현 방식 인터셉터 
public class MyInterceptor implements HandlerInterceptor {

	private static Logger logger = 
			LoggerFactory.getLogger(MyInterceptor.class);
	
	//prehandle : 컨트롤러 이전에 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("MyInterceptor.preHandle");
		//return이 false면 중단.
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MyInterceptor.postHandle");
	}

	//aftercompletion : 뷰렌더링까지 완료된 상태에서 호출된다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("MyInterceptor.afterCompletion");

	}

}
