package com.i.manual.submit.inputcheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubmitInputCheckController {
	
	@GetMapping("/submit/input-check/form")
	public String list() {
						
		return "submit/inputcheck/form";
	}

}
