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
    
	@GetMapping("/Crud/Checkbox/List")
	public String List(Model model) {
		
		List<CrudBasicDTO> List = crudCheckboxService.list();
    	model.addAttribute("List", List);
				
		return "crud/checkbox/List";
	}
	
	@PostMapping("/Crud/Checkbox/CheckCopy")
	public String CheckCopy(@RequestParam("checkIdx") List<String> checkIdx) {
		
		crudCheckboxService.checkCopy(checkIdx);

		return "redirect:/Crud/Checkbox/List";
	}
	
	@PostMapping("/Crud/Checkbox/CheckUpdate")
	public String CheckUpdate(@RequestParam("checkIdx") List<String> checkIdx) {
		
		crudCheckboxService.checkUpdate(checkIdx);

		return "redirect:/Crud/Checkbox/List";
	}
	
	@PostMapping("/Crud/Checkbox/CheckUpdateHit")
	public String CheckUpdateHit(@RequestParam("checkIdx") List<String> checkIdx) {
		
		crudCheckboxService.checkUpdateHit(checkIdx);

		return "redirect:/Crud/Checkbox/List";
	}
	
	@PostMapping("/Crud/Checkbox/CheckDelete")
	public String CheckDelete(@RequestParam("checkIdx") List<String> checkIdx) {
		
		crudCheckboxService.checkDelete(checkIdx);

		return "redirect:/Crud/Checkbox/List";
	}

}
