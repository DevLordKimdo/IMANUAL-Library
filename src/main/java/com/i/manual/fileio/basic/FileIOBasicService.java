package com.i.manual.fileio.basic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class FileIOBasicService {
	
	public void SampleDownload(HttpServletResponse response, String SampleFile) throws IOException {
		
        Path path = Paths.get(SampleFile);
        Resource resource = new FileSystemResource(path.toFile());

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        response.setContentType(contentType);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, headerValue);
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.EXPIRES, "0");

		FileCopyUtils.copy(resource.getInputStream(), response.getOutputStream());
		
	}
	
	public void SingleUpload(MultipartFile file, String Directory) throws IOException {
		
		if (!file.isEmpty()) {

            // 파일 이름 생성
            String fileName = file.getOriginalFilename();
            
            // 파일 저장 경로 생성
            Path uploadPath = Paths.get(Directory);
            
            // 디렉토리가 존재하지 않으면 생성
            if (!Files.exists(uploadPath)) {
            	Files.createDirectories(uploadPath);
            }
            
            // 파일 저장
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	    }
	}
	
	public void MultiUpload(List<MultipartFile> files, String Directory) throws IOException {
		
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
	
	public void DeleteTarget(String Directory, String DeleteTarget) {
		
        Path DirectoryPath = Paths.get(Directory);
        Path filePath = DirectoryPath.resolve(DeleteTarget);
        File file = filePath.toFile();

        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println(DeleteTarget + " 파일이 삭제되었습니다.");
            } else {
                System.out.println(DeleteTarget + " 파일 삭제에 실패했습니다.");
            }
        } else {
            System.out.println(DeleteTarget + " 파일이 존재하지 않습니다.");
        }
	}
	
	public void DeleteAll(String Directory) throws IOException {
		
        Path DirectoryPath = Paths.get(Directory);

        // uploadPath 디렉토리에 있는 모든 파일 삭제
        Files.list(DirectoryPath).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);

	}
}
