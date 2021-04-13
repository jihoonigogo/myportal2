package com.bitacademy.myportal2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Maincontroller {

	
	

		@RequestMapping("/main")
		public ModelAndView home (@RequestParam String name) {
			ModelAndView mav = new ModelAndView();
			
			mav.addObject("message","반갑습니다......"+ name);
			mav.addObject("spring", name + "....봄이 왔습니다.");
			mav.setViewName("/WEB-INF/views/home.jsp");
			return mav;
		}
	}


