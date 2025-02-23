package com.i.manual.http.unfilter;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HttpUnfilterController {
	
    @GetMapping("/http/unfilter/index")
	public String index() {
    
    	return "http/unfilter/index";
    }
    
    // 특정 메서드를 지정해서 받고 싶으면 
    // 뒤에 method = RequestMethod.GET(GET방식으로 받기) 추가 혹은
    // @RequestMapping 대신 @GetMapping 이나 @PostMapping 를 넣어줘야 함.
    @RequestMapping(value = "/http/unfilter/request")
	public ResponseEntity<String> request(HttpServletRequest request) {
    	
    	if(request.getMethod().equals("GET")) { System.out.println("GET로 받았습니다."); }
    	else if(request.getMethod().equals("POST")) { System.out.println("POST로 받았습니다."); }
    	else if(request.getMethod().equals("PUT"))  { System.out.println("PUT로 받았습니다."); }
    	else { System.out.println("등록되지 않은 메서드로 받았습니다. 메서드 이름 : " + request.getMethod() ); }
    	
    	return ResponseEntity.ok("success");
    }

}
