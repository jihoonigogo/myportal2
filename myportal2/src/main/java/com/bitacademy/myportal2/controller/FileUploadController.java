package com.bitacademy.myportal2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.myportal2.service.FileUploadService;



@RequestMapping("/fileupload")
@Controller
public class FileUploadController {
	
	
	private static Logger logger =LoggerFactory.getLogger(FileUploadController.class);

	
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping({"","/","form"})
	public String form() {
		return "fileupload/form";
	}

		
		
		@RequestMapping(value="/upload" , method=RequestMethod.POST)
		public String upload(@RequestParam MultipartFile uploadfile,Model model) {
			//파일 업로드 기능 수행 
			//업로드된 이미지 url 생성
			//결과페이지로 포워드
			
			String saveFilename =fileUploadService.store(uploadfile);
			logger.debug("저장된 파일명 " + saveFilename);
			String urlImage = "upload-images/" +saveFilename;
			model.addAttribute("urlImage",urlImage);
			
			return "fileupload/result";
		}
}
