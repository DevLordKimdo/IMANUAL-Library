package com.i.manual.popup.sendvalue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopupSendvalueController {
	
	@GetMapping("/popup/send-value/index")
	public String index() {

		return "popup/sendvalue/index";
	}
	
	@GetMapping("/popup/send-value/form")
	public String popup() {

		return "popup/sendvalue/form";
	}

}
