package com.i.manual.crud.checkbox;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.i.manual.crud.basic.CrudBasicDTO;

import java.util.*;

@Controller
public class CrudCheckboxController {
	
    private final CrudCheckboxService crudCheckboxService;
    public CrudCheckboxController(CrudCheckboxService crudCheckboxService) {this.crudCheckboxService = crudCheckboxService;}
    
	@GetMapping("/crud/checkbox/list")
	public String list(Model model) {
		
		List<CrudBasicDTO> list = crudCheckboxService.list();
    	model.addAttribute("list", list);
				
		return "crud/checkbox/list";
	}
	
	@PostMapping("/crud/checkbox/check-copy")
	public String checkCopy(@RequestParam("checkIdx") List<String> checkIdx) {
		
		crudCheckboxService.checkCopy(checkIdx);

		return "redirect:/crud/checkbox/list";
	}
	
	@PostMapping("/crud/checkbox/check-update")
	public String checkUpdate(@RequestParam("checkIdx") List<String> checkIdx) {
		
		crudCheckboxService.checkUpdate(checkIdx);

		return "redirect:/crud/checkbox/list";
	}
	
	@PostMapping("/crud/checkbox/check-update-hit")
	public String checkUpdateHit(@RequestParam("checkIdx") List<String> checkIdx) {
		
		crudCheckboxService.checkUpdateHit(checkIdx);

		return "redirect:/crud/checkbox/list";
	}
	
	@PostMapping("/crud/checkbox/check-delete")
	public String checkDelete(@RequestParam("checkIdx") List<String> checkIdx) {
		
		crudCheckboxService.checkDelete(checkIdx);

		return "redirect:/crud/checkbox/list";
	}

}
