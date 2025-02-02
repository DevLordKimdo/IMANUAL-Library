package com.i.manual.fetch.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FetchCalculatorController {
	
	@GetMapping("/Fetch/Calculator/Form")
	public String Form() {
		
		return "fetch/calculator/Form";
	}
	
	@PostMapping("/Fetch/Calculator/Result")
	@ResponseBody
	public int Result(@RequestParam("numA") int numA,
			          @RequestParam("numB") int numB, HttpServletRequest request) {
		
		// @RequestParam("") 로 인자값을 받을 수 있고
		// HttpServletRequest 로 인자값을 받을 수 있다는 것을 보여주기 위함으로 두개를 동시에 사용함
		// 성능향상을 위해 스위치 문을 사용
		
		int result = 0;
		
		switch (request.getParameter("type")) {
			case "+" : result = numA + numB;
			break;
			case "-" : result = numA - numB;
			break;
			case "*" : result = numA * numB;
			break;
			case "/" : result = numA / numB;
			break;
		}
		
        return result;
	}

}
