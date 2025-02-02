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
	
	@GetMapping("/Excel/Inport/Form")
	public String Form() {
		
		return "excel/inport/Form";
	}
	
	@PostMapping("/Excel/Inport/Upload")
	public String Upload(@RequestParam("ExcelUpload") MultipartFile file) throws IOException {
		
		excelInportService.Upload(file);
		
		return "redirect:/Excel/Inport/Form";
	}

}
