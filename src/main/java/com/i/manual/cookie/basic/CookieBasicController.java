package com.i.manual.cookie.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CookieBasicController {
	
    private final CookieBasicService cookieBasicService;
    public CookieBasicController(CookieBasicService cookieBasicService) {this.cookieBasicService = cookieBasicService;}
	
	@GetMapping("/Cookie/Basic/Index")
	public String Index() {

		return "cookie/basic/Index";
	}
	
	@GetMapping("/Cookie/Basic/RequestBackend")
	public String RequestBackend(HttpServletRequest request, HttpServletResponse response) {
		
		cookieBasicService.RequestBackend(request, response);
		
		return "redirect:/Cookie/Basic/Index";
	}
	
	@GetMapping("/Cookie/Basic/CheckCookie")
	public String CheckCookie(HttpServletRequest request) {
		
		cookieBasicService.CheckCookie(request);
				
		return "redirect:/Cookie/Basic/Index";
	}

}
