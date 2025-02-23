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
    
	@GetMapping("/file-io/file-board/list")
	public String list(Model model) {
		List<FileIOFileBoardDTO> list = fileIOFileBoardService.list();
		
    	model.addAttribute("list", list);
		
		return "fileio/fileboard/list";
	}
	
	@GetMapping("/file-io/file-board/upload")
	public String upload() {
		
		return "fileio/fileboard/upload";
	}
	
	@PostMapping("/file-io/file-board/upload")
	public String upload(@RequestParam("upload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String directory = "C:/upload/";
		
		try {
			fileIOFileBoardService.upload(files, directory);
        } catch (Exception e) {
            e.printStackTrace();
        }

		return "redirect:/file-io/file-board/list";
	}

}
