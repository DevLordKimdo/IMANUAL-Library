package com.i.manual.excel.inport;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ExcelInportController {
	
	private final ExcelInportService excelInportService;
	public ExcelInportController(ExcelInportService excelInportService) {this.excelInportService = excelInportService;}
	
	@GetMapping("/excel/inport/form")
	public String form() {
		
		return "excel/inport/form";
	}
	
	@PostMapping("/excel/inport/upload")
	public String upload(@RequestParam("excelUpload") MultipartFile file) throws IOException {
		
		excelInportService.upload(file);
		
		return "redirect:/excel/inport/form";
	}

}
