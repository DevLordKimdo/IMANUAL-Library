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
	
	@GetMapping("/excel/export/index")
	public String index() {
		
		return "excel/export/index";
	}
	
	@GetMapping("/excel/export/down-excel")
	public ResponseEntity<byte[]> downExcel() throws IOException {
	    byte[] excelFile = excelExportService.downExcel();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.setContentDispositionFormData("attachment", "ResultDATA.xlsx");
	    
	    return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
	}
	
	@GetMapping("/excel/export/down-excel-enhance")
	public ResponseEntity<byte[]> downExcelEnhance() throws IOException {
	    byte[] excelFile = excelExportService.downExcelEnhance();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.setContentDispositionFormData("attachment", "ResultDATAEnhance.xlsx");
	    
	    return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
	}
	

}
