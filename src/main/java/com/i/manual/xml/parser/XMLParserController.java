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
	
	@GetMapping("/XML/Parser/Form")
	public String Form() {

		return "xml/parser/Form";
	}
	
	@PostMapping("/XML/Parser/Upload")
	public String Upload(@RequestParam("Upload") MultipartFile file) {
		
		xmlParserService.Upload(file);
		
		return "redirect:/XML/Parser/Form";
	}

}
