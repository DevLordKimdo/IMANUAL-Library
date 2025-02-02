package com.i.manual.excel.export;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExcelExportController {
	
	private final ExcelExportService excelExportService;
	public ExcelExportController(ExcelExportService excelExportService) {this.excelExportService = excelExportService;}
	
	@GetMapping("/Excel/Export/Index")
	public String Index() {
		
		return "excel/export/Index";
	}
	
	@GetMapping("/Excel/Export/DownExcel")
	public ResponseEntity<byte[]> DownExcel() throws IOException {
	    byte[] excelFile = excelExportService.DownExcel();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.setContentDispositionFormData("attachment", "ResultDATA.xlsx");
	    
	    return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
	}
	
	@GetMapping("/Excel/Export/DownExcelEnhance")
	public ResponseEntity<byte[]> DownExcelEnhance() throws IOException {
	    byte[] excelFile = excelExportService.DownExcelEnhance();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.setContentDispositionFormData("attachment", "ResultDATAEnhance.xlsx");
	    
	    return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
	}
	

}
