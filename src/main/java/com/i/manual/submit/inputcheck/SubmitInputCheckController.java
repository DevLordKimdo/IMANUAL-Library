package com.i.manual.submit.inputcheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubmitInputCheckController {
	
	@GetMapping("/Submit/InputCheck/Form")
	public String List() {
						
		return "submit/inputcheck/Form";
	}

}
