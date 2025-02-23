package com.i.manual.fileio.deduplicate;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileIODeduplicateController {
	
    private final FileIODeduplicateService fileIODeduplicateService;
    public FileIODeduplicateController(FileIODeduplicateService fileIODeduplicateService) {this.fileIODeduplicateService = fileIODeduplicateService;}
	
	@GetMapping("/file-io/deduplicate/form")
	public String form() {
		
		return "fileio/deduplicate/form";
	}
	
	@PostMapping("/file-io/deduplicate/upload-no-option")
	public String uploadNoOption(@RequestParam("multiUpload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String directory = "C:/upload/";
		
        try {
        	fileIODeduplicateService.uploadNoOption(files, directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/file-io/deduplicate/form";
	}
	
	@PostMapping("/file-io/deduplicate/upload-add-number")
	public String uploadAddNumber(@RequestParam("multiUpload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String directory = "C:/upload/";
		
        try {
        	fileIODeduplicateService.uploadAddNumber(files, directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/file-io/deduplicate/form";
	}
	
	@PostMapping("/file-io/deduplicate/upload-add-sys-time")
	public String uploadAddSysTime(@RequestParam("multiUpload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String directory = "C:/upload/";
		
        try {
        	fileIODeduplicateService.uploadAddSysTime(files, directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/file-io/deduplicate/form";
	}
	
	@PostMapping("/file-io/deduplicate/upload-crypto")
	public String uploadCrypto(@RequestParam("multiUpload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String directory = "C:/upload/";
		
        try {
        	fileIODeduplicateService.uploadCrypto(files, directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/file-io/deduplicate/form";
	}

}
