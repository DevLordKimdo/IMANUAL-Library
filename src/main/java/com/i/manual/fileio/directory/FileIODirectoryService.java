package com.i.manual.fileio.directory;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class FileIODirectoryService {
	
	public List<String> list(String directoryPath) throws IOException {
		
		Path path = Paths.get(directoryPath);
		List<String> fileList = new ArrayList<>();
		
		if (!Files.exists(path) || !Files.isDirectory(path)) {
			
        	System.out.println("유효하지 않은 디렉토리 입니다.");
        	
        	return null;
        	
        } else {
        	
    		try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
    			Iterator<Path> iterator = directoryStream.iterator();
    			
    			while(iterator.hasNext()) {
    				Path filePath = iterator.next();
    				
    	            // 일반 파일만 필터링
    	            if (Files.isRegularFile(filePath)) {
    	                // 파일 이름만 추출하여 문자열로 변환 후 결과 목록에 추가
    	                String fileName = filePath.getFileName().toString();
    	                fileList.add(fileName);
    	            }
    			}
    		}
    		
        }
		
		return fileList;
	}

}
