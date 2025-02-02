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
	
	@GetMapping("/FileIO/Deduplicate/Form")
	public String Form() {
		
		return "fileio/Deduplicate/Form";
	}
	
	@PostMapping("/FileIO/Deduplicate/UploadNoOption")
	public String UploadNoOption(@RequestParam("MultiUpload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String Directory = "C:/upload/";
		
        try {
        	fileIODeduplicateService.UploadNoOption(files, Directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/FileIO/Deduplicate/Form";
	}
	
	@PostMapping("/FileIO/Deduplicate/UploadAddNumber")
	public String UploadAddNumber(@RequestParam("MultiUpload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String Directory = "C:/upload/";
		
        try {
        	fileIODeduplicateService.UploadAddNumber(files, Directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/FileIO/Deduplicate/Form";
	}
	
	@PostMapping("/FileIO/Deduplicate/UploadAddSysTime")
	public String UploadAddSysTime(@RequestParam("MultiUpload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String Directory = "C:/upload/";
		
        try {
        	fileIODeduplicateService.UploadAddSysTime(files, Directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/FileIO/Deduplicate/Form";
	}
	
	@PostMapping("/FileIO/Deduplicate/UploadCrypto")
	public String UploadCrypto(@RequestParam("MultiUpload") List<MultipartFile> files) {
		
        // 파일 저장 경로 지정
		String Directory = "C:/upload/";
		
        try {
        	fileIODeduplicateService.UploadCrypto(files, Directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/FileIO/Deduplicate/Form";
	}

}
