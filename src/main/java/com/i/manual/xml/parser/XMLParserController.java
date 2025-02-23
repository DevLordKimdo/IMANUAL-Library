package com.i.manual.xml.parser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class XMLParserController {
	
    private final XMLParserService xmlParserService;
    public XMLParserController(XMLParserService xmlParserService) {this.xmlParserService = xmlParserService;}
	
	@GetMapping("/xml/parser/form")
	public String form() {

		return "xml/parser/form";
	}
	
	@PostMapping("/xml/parser/upload")
	public String upload(@RequestParam("upload") MultipartFile file) {
		
		xmlParserService.upload(file);
		
		return "redirect:/xml/parser/form";
	}

}
