package com.i.manual.session.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SessionBasicController {
	
	@GetMapping("/Session/Basic/Index")
	public String Index() {

		return "session/basic/Index";
	}
	
	@GetMapping("/Session/Basic/RequestSessionA")
	public String RequestSessionA(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		session.setAttribute("SessionName", "valueA");

		return "redirect:/Session/Basic/Index";
	}
	
	@GetMapping("/Session/Basic/RequestSessionB")
	public String RequestSessionB(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		session.setAttribute("SessionName", "valueB");

		return "redirect:/Session/Basic/Index";
	}
	
	@GetMapping("/Session/Basic/CheckSession")
	public String CheckSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("SessionName"));
		
		if((String)session.getAttribute("SessionName") == "valueA") {
			System.out.println("A 세션이 맞습니다.");
		} else if(session.getAttribute("SessionName") == null) {
			System.out.println("세션이 없습니다.");
		} else {
			System.out.println("A 세션이 아닙니다.");
		}

		return "redirect:/Session/Basic/Index";
	}
	
	@GetMapping("/Session/Basic/DeleteSession")
	public String DeleteSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/Session/Basic/Index";
	}
	
}
