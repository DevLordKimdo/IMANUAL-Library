package com.i.manual.fileio.basic;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class FileIOBasicController {
	
    private final FileIOBasicService fileIOBasicService;
    public FileIOBasicController(FileIOBasicService fileIOBasicService) {this.fileIOBasicService = fileIOBasicService;}
	
	@GetMapping("/FileIO/Basic/Form")
	public String Form() {

		return "fileio/basic/Form";
	}

    @GetMapping("/FileIO/Basic/SampleDownload")
    public void SampleDownload(HttpServletResponse response)  {
        // 다운로드 파일 경로 지정
        final String SampleFile = "C:/download/Sample.png";
    	
        try {
        	fileIOBasicService.SampleDownload(response, SampleFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
	@PostMapping("/FileIO/Basic/SingleUpload")
	public String SingleUpload(@RequestParam("SingleUpload") MultipartFile file) {
		
        // 파일 저장 경로 지정
		String Directory = "C:/upload/";
		
        try {
        	fileIOBasicService.SingleUpload(file, Directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/FileIO/Basic/Form";
	}
	
	@PostMapping("/FileIO/Basic/MultiUpload")
	public String MultiUpload(@RequestParam("MultiUpload") List<MultipartFile> files) {
		
		// 파일 저장 경로 지정
		String Directory = "C:/upload/";

        try {
        	fileIOBasicService.MultiUpload(files, Directory);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return "redirect:/FileIO/Basic/Form";
	}
	
	@PostMapping("/FileIO/Basic/DeleteTarget")
	public String DeleteTarget(HttpServletRequest request) {
		
		// 삭제 폴더 경로
		String Directory = "C:/upload";
        
		// 삭제 대상 파일 이름
		String DeleteTarget = request.getParameter("DeleteTarget"); // 삭제할 파일 이름
		
		fileIOBasicService.DeleteTarget(Directory, DeleteTarget);
		
        return "redirect:/FileIO/Basic/Form";
	}
	
	@GetMapping("/FileIO/Basic/DeleteAll")
	public String DeleteAll() {
		
        // 삭제 폴더 경로
        String Directory = "C:/upload/";
		
        try {
        	fileIOBasicService.DeleteAll(Directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/FileIO/Basic/Form";
	}
	
}
