package com.home.spring.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileManager {
	
	//file을 hdd에서 삭제
	public boolean fileDelete(String path, String fileName) throws Exception{
		File file = new File(path, fileName);
		
		boolean result = file.delete();
		
		return result;
	}
	
	//File을 hdd에 저장
	public String saveFile(MultipartFile multipartFile, String path) throws Exception{
		//어디에 저장할것인가 /resources/upload/bankBook/..
		//저장 관리는 운영체제가 담당
		
		File file = new File(path);
		
		//존재하지않으면 폴더를 생성
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//파일을 저장하기
		//파일명??
		//Calendar ca = Calendar.getInstance();
		//ca.getTimeMilies();
		String name = UUID.randomUUID().toString();
		
		//확장자 추가
		name = name + "_" + multipartFile.getOriginalFilename();
		
		
		//파일 저장
		//어느 경로에 어느 이름으로 저장할건지 파일 객체를 통해서 만들어야함
		file = new File(file, name);
		//1) MultipartFile 객체의 tranferTo 메서드 사용
		multipartFile.transferTo(file); 
		//2) Spring API
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return name;
	}
	
}
