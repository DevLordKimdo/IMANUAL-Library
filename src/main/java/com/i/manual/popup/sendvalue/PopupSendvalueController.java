package com.i.manual.popup.sendvalue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopupSendvalueController {
	
	@GetMapping("/Popup/Sendvalue/Index")
	public String Index() {

		return "popup/sendvalue/Index";
	}
	
	@GetMapping("/Popup/Sendvalue/Form")
	public String Popup() {

		return "popup/sendvalue/Form";
	}

}
