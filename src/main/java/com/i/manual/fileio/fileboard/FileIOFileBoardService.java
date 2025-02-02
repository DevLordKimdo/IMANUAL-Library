package com.i.manual.fileio.fileboard;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileIOFileBoardService {
	
    private final FileIOFileBoardRepository fileIOFileBoardRepository;
    public FileIOFileBoardService(FileIOFileBoardRepository fileIOFileBoardRepository) {this.fileIOFileBoardRepository = fileIOFileBoardRepository;}

	public List<FileIOFileBoardDTO> list(){
		
		List<FileIOFileBoardDTO> List = fileIOFileBoardRepository.list();

		if (!List.isEmpty()) {
		    String prevPostidx = List.get(0).getPostidx();

		    for (int i = 1; i < List.size(); i++) {
		    	FileIOFileBoardDTO currentDTO = List.get(i);
		        String currentPostidx = currentDTO.getPostidx();

		        if (currentPostidx != null && currentPostidx.equals(prevPostidx)) {
		            currentDTO.setPostidx(null);
		        } else {
		            prevPostidx = currentPostidx;
		        }
		    }
		}
		
		return List;
	}
	
	public void upload(List<MultipartFile> files, String Directory) throws IOException {
		
		// 첨부파일 리스트 정보 DB에 INSERT
		// 새로운 PostIdx 값 생성
		String newPostIdx = fileIOFileBoardRepository.newPostIdx();
		
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
	    	FileIOFileBoardDTO boardFileRoomDTO = new FileIOFileBoardDTO();
	    	boardFileRoomDTO.setPostidx(newPostIdx);
	    	boardFileRoomDTO.setName(file.getOriginalFilename());
	    	boardFileRoomDTO.setSeq(Integer.toString(i+1));
	    	boardFileRoomDTO.setSize(Long.toString(file.getSize()));
	    	
	    	fileIOFileBoardRepository.upload(boardFileRoomDTO);
	    }
	    
		// 첨부파일 물리 드라이브에 업로드
        Path uploadPath = Paths.get(Directory);
        
        if (!Files.exists(uploadPath)) {
        	Files.createDirectories(uploadPath);
        }
        
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        }
	}
	
}
