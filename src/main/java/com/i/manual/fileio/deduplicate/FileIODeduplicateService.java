package com.i.manual.fileio.deduplicate;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.i.manual.util.UtilMakeCrypto;
import com.i.manual.util.UtilMakeDateTime;

@Service
public class FileIODeduplicateService {
		
	public void UploadNoOption(List<MultipartFile> files, String Directory) throws IOException {
		
		if (!files.isEmpty()) {
	            
            // 파일 저장 경로 생성
            Path uploadPath = Paths.get(Directory);
            
            // 디렉토리가 존재하지 않으면 생성
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            
            // 각 파일을 저장
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
	    }
	}
	
	public void UploadAddNumber(List<MultipartFile> files, String Directory) throws IOException {
		
		if (!files.isEmpty()) {
            
            // 파일 저장 경로 생성
            Path uploadPath = Paths.get(Directory);
            
            // 디렉토리가 존재하지 않으면 생성
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            
            // 각 파일을 저장
            for (MultipartFile file : files) {
                String originalFilename = file.getOriginalFilename();
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
                String fileNameWithoutExtension = originalFilename.substring(0, originalFilename.lastIndexOf("."));

                Path filePath = uploadPath.resolve(originalFilename);
                int duplicateCount = 1;

                // 동일한 파일명이 있는지 확인하고, 있다면 파일명에 (숫자) 추가
                while (Files.exists(filePath)) {
                    String duplicateFileName = fileNameWithoutExtension + "(" + duplicateCount + ")" + fileExtension;
                    filePath = uploadPath.resolve(duplicateFileName);
                    duplicateCount++;
                }

                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
	    }
	}
	
	public void UploadAddSysTime(List<MultipartFile> files, String Directory) throws IOException {
		
		if (!files.isEmpty()) {
            
            // 파일 저장 경로 생성
            Path uploadPath = Paths.get(Directory);
            
            // 디렉토리가 존재하지 않으면 생성
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            
            UtilMakeDateTime utilMakeDateTime = new UtilMakeDateTime();
            
            // 각 파일을 저장
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                String nanoTime = utilMakeDateTime.Nano();
                Path filePath = uploadPath.resolve(nanoTime+fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
	    }
	}
	
	public void UploadCrypto(List<MultipartFile> files, String Directory) throws IOException {
		
		if (!files.isEmpty()) {
            
            // 파일 저장 경로 생성
            Path uploadPath = Paths.get(Directory);
            
            // 디렉토리가 존재하지 않으면 생성
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            
            UtilMakeCrypto utilMakeCrypto = new UtilMakeCrypto();
            
            // 각 파일을 저장
            for (MultipartFile file : files) {
            	String fileName = file.getOriginalFilename();
            	String extension = fileName.substring(fileName.lastIndexOf("."));
            	String toCrypto = utilMakeCrypto.StringNum(10) + extension;
                Path filePath = uploadPath.resolve(toCrypto);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
	    }
	}
}
