package com.i.manual.fileio.fileboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
public class FileIOFileBoardController {
	
    private final FileIOFileBoardService fileIOFileBoardService;
    public FileIOFileBoardController(FileIOFileBoardService fileIOFileBoardService) {this.fileIOFileBoardService = fileIOFileBoardService;}
    
	@GetMapping("/FileIO/FileBoard/List")
	public String List(Model model) {
		List<FileIOFileBoardDTO> List = fileIOFileBoardService.list();
		
    	model.addAttribute("List", List);
		
		return "fileio/fileboard/List";
	}
	
	@GetMapping("/FileIO/FileBoard/Upload")
	public String Upload() {
		
		return "fileio/fileboard/Upload";
	}
	
	@PostMapping("/FileIO/FileBoard/Upload")
	public String Upload(@RequestParam("Upload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String Directory = "C:/upload/";
		
		try {
			fileIOFileBoardService.upload(files, Directory);
        } catch (Exception e) {
            e.printStackTrace();
        }

		return "redirect:/FileIO/FileBoard/List";
	}

}
