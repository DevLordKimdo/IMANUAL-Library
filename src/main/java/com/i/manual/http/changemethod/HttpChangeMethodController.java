package com.i.manual.http.changemethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HttpChangeMethodController {
	
    @GetMapping("/Http/ChangeMethod/Index")
	public String Index() {
    
    	return "http/changemethod/Index";
    }
	
    @GetMapping("/Http/ChangeMethod/GetToPost")
	public String GetToPostRequest() {
    	System.out.println("Request HTTP Get");
    
    	return "http/changemethod/GetToPost";
    }
    
    @PostMapping("/Http/ChangeMethod/GetToPost")
	public String GetToPostResponse() {
    	System.out.println("Response HTTP Post");
    
    	return "redirect:/Http/ChangeMethod/Index";
    }
    
    @PostMapping("/Http/ChangeMethod/PostToGet")
	public String PostToGetRequest() {
    	System.out.println("Request HTTP Post");
    
    	return "redirect:/Basic/Http/ChangeMethod/PostToGet";
    }
    
    @GetMapping("/Basic/Http/ChangeMethod/PostToGet")
	public String PostToGetResponse() {
    	System.out.println("Response HTTP Get");
    
    	return "redirect:/Http/ChangeMethod/Index";
    }

}
