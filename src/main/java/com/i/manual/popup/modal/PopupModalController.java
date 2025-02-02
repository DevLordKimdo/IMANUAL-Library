package com.i.manual.popup.modal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopupModalController {
	
	@GetMapping("/Popup/Modal/Index")
	public String Index() {

		return "popup/modal/Index";
	}

}
