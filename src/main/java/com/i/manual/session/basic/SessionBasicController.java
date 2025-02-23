package com.i.manual.session.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SessionBasicController {
	
	@GetMapping("/session/basic/index")
	public String index() {

		return "session/basic/index";
	}
	
	@GetMapping("/session/basic/request-session-a")
	public String requestSessionA(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		session.setAttribute("session-name", "value-a");

		return "redirect:/session/basic/index";
	}
	
	@GetMapping("/session/basic/request-session-b")
	public String requestSessionB(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		session.setAttribute("session-name", "value-b");

		return "redirect:/session/basic/index";
	}
	
	@GetMapping("/session/basic/check-session")
	public String checkSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("session-name"));
		
		if((String)session.getAttribute("session-name") == "value-a") {
			System.out.println("A 세션이 맞습니다.");
		} else if(session.getAttribute("session-name") == null) {
			System.out.println("세션이 없습니다.");
		} else {
			System.out.println("A 세션이 아닙니다.");
		}

		return "redirect:/session/basic/index";
	}
	
	@GetMapping("/session/basic/delete-session")
	public String deleteSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/session/basic/index";
	}
	
}
