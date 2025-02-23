package com.i.manual.http.changemethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HttpChangeMethodController {
	
    @GetMapping("/http/change-method/index")
	public String index() {
    
    	return "http/changemethod/index";
    }
	
    @GetMapping("/http/change-method/get-to-post")
	public String getToPostRequest() {
    	System.out.println("Request HTTP Get");
    
    	return "http/changemethod/gettopost";
    }
    
    @PostMapping("/http/change-method/get-to-post")
	public String getToPostResponse() {
    	System.out.println("Response HTTP Post");
    
    	return "redirect:/http/change-method/index";
    }
    
    @PostMapping("/http/change-method/post-to-get")
	public String postToGetRequest() {
    	System.out.println("Request HTTP Post");
    
    	return "redirect:/http/change-method/post-to-get";
    }
    
    @GetMapping("/http/change-method/post-to-get")
	public String postToGetResponse() {
    	System.out.println("Response HTTP Get");
    
    	return "redirect:/http/change-method/index";
    }

}
