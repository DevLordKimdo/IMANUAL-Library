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
	
	@GetMapping("/file-io/basic/form")
	public String form() {

		return "fileio/basic/form";
	}

    @GetMapping("/file-io/basic/sample-download")
    public void sampleDownload(HttpServletResponse response)  {
        // 다운로드 파일 경로 지정
        final String sampleFile = "C:/download/Sample.png";
    	
        try {
        	fileIOBasicService.sampleDownload(response, sampleFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
	@PostMapping("/file-io/basic/single-upload")
	public String SingleUpload(@RequestParam("singleUpload") MultipartFile file) {
		
        // 파일 저장 경로 지정
		String Directory = "C:/upload/";
		
        try {
        	fileIOBasicService.singleUpload(file, Directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/file-io/basic/form";
	}
	
	@PostMapping("/file-io/basic/multi-upload")
	public String multiUpload(@RequestParam("multiUpload") List<MultipartFile> files) {
		
		// 파일 저장 경로 지정
		String directory = "C:/upload/";

        try {
        	fileIOBasicService.multiUpload(files, directory);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return "redirect:/file-io/basic/form";
	}
	
	@PostMapping("/file-io/basic/delete-target")
	public String deleteTarget(HttpServletRequest request) {
		
		// 삭제 폴더 경로
		String directory = "C:/upload";
        
		// 삭제 대상 파일 이름
		String deleteTarget = request.getParameter("deleteTarget"); // 삭제할 파일 이름
		
		fileIOBasicService.deleteTarget(directory, deleteTarget);
		
        return "redirect:/file-io/basic/form";
	}
	
	@GetMapping("/file-io/basic/delete-all")
	public String deleteAll() {
		
        // 삭제 폴더 경로
        String directory = "C:/upload/";
		
        try {
        	fileIOBasicService.deleteAll(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "redirect:/file-io/basic/form";
	}
	
}
