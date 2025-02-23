package com.i.manual.cookie.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CookieBasicController {
	
    private final CookieBasicService cookieBasicService;
    public CookieBasicController(CookieBasicService cookieBasicService) {this.cookieBasicService = cookieBasicService;}
	
	@GetMapping("/cookie/basic/index")
	public String index() {

		return "cookie/basic/index";
	}
	
	@GetMapping("/cookie/basic/request-backend")
	public String requestBackend(HttpServletRequest request, HttpServletResponse response) {
		
		cookieBasicService.requestBackend(request, response);
		
		return "redirect:/cookie/basic/index";
	}
	
	@GetMapping("/cookie/basic/check-cookie")
	public String checkCookie(HttpServletRequest request) {
		
		cookieBasicService.checkCookie(request);
				
		return "redirect:/cookie/basic/index";
	}

}
