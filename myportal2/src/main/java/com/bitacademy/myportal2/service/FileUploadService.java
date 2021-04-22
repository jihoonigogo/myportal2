package com.bitacademy.myportal2.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	private static String SAVE_PATH = "d:/upload";
	private static Logger logger =LoggerFactory.getLogger(FileUploadService.class);
	
	
	public String store(MultipartFile multipartFile) {
		String saveFilename ="";
		try {
		
		String originalFileName = multipartFile.getOriginalFilename();
		Long size =multipartFile.getSize();
		
		logger.debug("multipart-원본파일명:" +originalFileName);
		logger.debug("multipart-파일사이즈:"+ size);
		//확장자 분리
		String extName = originalFileName
				.substring(originalFileName.lastIndexOf("."));
		logger.debug("파일확장자" + extName);
		//저장된 실제 파일명 얻어오기 
		saveFilename=getSaveFilename(extName);
		logger.debug("실제저장될 파일명 :" + saveFilename);
		// 멀티파트파일을 save path
		writeFile(multipartFile,saveFilename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveFilename;
	}
	private String getSaveFilename(String ext) { // 확장자를 인자값으로?
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis()/1000) + ext.toLowerCase();
	}
	
	private void writeFile(MultipartFile mFile,String saveFilename) 
	throws IOException {
		//mfile을 savefilename으로 저장
		
		byte[] fileData =mFile.getBytes(); // 실제 2진 파일 정보배열
		FileOutputStream fos = 
				new FileOutputStream(SAVE_PATH+"/"+saveFilename);
		fos.write(fileData);
		fos.flush();
		fos.close();
	}
}
