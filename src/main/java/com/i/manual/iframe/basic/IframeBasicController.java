package com.i.manual.iframe.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IframeBasicController {
	
	@GetMapping("/iframe/basic/index")
	public String index() {
		
		return "iframe/basic/index";
	}
	
	@GetMapping("/iframe/basic/content")
	public String content() {
		
		return "iframe/basic/content";
	}

}
