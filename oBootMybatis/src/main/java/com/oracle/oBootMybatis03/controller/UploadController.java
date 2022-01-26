package com.oracle.oBootMybatis03.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	// upLoadForm 시작화면
	@RequestMapping(value = "upLoadFormStart")
	public String upLoadFormStart(Model model) {
		System.out.println("upLoadFormStart Start....");
		return "upLoadFormStart";
	}
	
	
	/*
	 *  uploadForm 업로드 로직 수행하기
	 * */
	@RequestMapping(value = "uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		System.out.println("uploadForm GET Start");
		System.out.println();
	}
	@RequestMapping(value = "uploadForm", method = RequestMethod.POST)
	public String uploadForm ( HttpServletRequest request, MultipartFile file1, Model model)
			throws Exception {
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		
		System.out.println("uploadForm POST Start...");
		logger.info("originalName : " + file1.getOriginalFilename());
		// logger.info("title : " + title);
		logger.info("size : " + file1.getSize());
		logger.info("contentType : " + file1.getContentType());
		logger.info("uploadPath : " + uploadPath);
		String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
		logger.info("savedName : " + savedName);
		model.addAttribute("savedName", savedName);
		return "uploadResult";
	}
	/*
	 * uploadFile
	 * */
	private String uploadFile(String originalName, byte[] fileDate, String uploadPath)
			throws Exception {
		UUID uid = UUID.randomUUID();
		//requestPath = requestPath + "/resources/image";
		System.out.println("uploadPath -> " + uploadPath);
		// Directory 생성
		File fileDirectory = new File(uploadPath);
		if (!fileDirectory.exists()) {		// 파일이 존재안하면 만들어준다(당연히 1번 만 실행되겠지?)
			fileDirectory.mkdirs();
			System.out.println("업로드용 폴더 생성 : " + uploadPath);
		}
		
		String savedName = uid.toString() + "_" + originalName;
		logger.info("savedName : " + savedName);
		File target = new File(uploadPath, savedName);
		// File target = new File(requestPath, savedName);
		FileCopyUtils.copy(fileDate, target); 	// org.springframework.util.FileCopyUtils
		
		// 서버에 올릴때는 db연결하고 context에서 꺼내서 보여주기?
		
		return savedName;
	}
	
	
	/*
	 * 업로드 삭제하기
	 * */
	@RequestMapping(value = "uploadFileDelete", method = RequestMethod.GET)
	public String uploadFileDelete ( HttpServletRequest request, Model model)
	                                // 프로젝트 할때는 파일명 대신 입력
				throws Exception {
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		String deleteFile = uploadPath + "63d8651f-7637-41e5-834a-76eae2e8064d_wallpaperflare.com_wallpaper.jpg";
		logger.info("deleteFile : " + deleteFile);
		System.out.println("uploadFileDelete POST Start...");
		int delResult = upFileDelete(deleteFile);
		logger.info("deleteFile result -> " + delResult);
		model.addAttribute("deleteFile", deleteFile);
		model.addAttribute("delResult", delResult);
		return "uploadResult";
	}
	/*
	 * upFileDelete
	 * */
	private int upFileDelete(String deleteFileName) throws Exception {
		int result = 0;
		logger.info("upFileDelete result -> " + deleteFileName);
		File file = new File(deleteFileName);
		if ( file.exists() ) {
				if(file.delete()) {
					System.out.println("파일 삭제 성공");
					result = 1;
				} else {
					System.out.println("파일 삭제 실패");
					result = 0;
				}
			} 
		else {
			System.out.println("파일이 존재하지 않습니다.");
			result = -1;
		}
		return result;
	}
	
	
	

}
