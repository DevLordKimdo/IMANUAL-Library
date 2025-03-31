package com.i.manual.fileio.directory;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileIODirectoryController {
	
	private final FileIODirectoryService fileIODirectoryService;
	public FileIODirectoryController(FileIODirectoryService fileIODirectoryService) {
		this.fileIODirectoryService = fileIODirectoryService;
	}
		
	@GetMapping("/file-io/directory/list")
	public String list(Model model) throws IOException {
		
		String directoryPath = "C:/Directory";
				
		List<String> fileList = fileIODirectoryService.list(directoryPath);
	
		model.addAttribute("fileList", fileList);

        return "fileio/directory/list";
	}
	
}