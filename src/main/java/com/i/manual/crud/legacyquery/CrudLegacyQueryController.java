package com.i.manual.crud.legacyquery;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.i.manual.crud.basic.CrudBasicDTO;

@Controller
public class CrudLegacyQueryController {
	
    private final CrudLegacyQueryService crudLegacyQuerytService;
    public CrudLegacyQueryController(CrudLegacyQueryService crudLegacyQuerytService) {this.crudLegacyQuerytService = crudLegacyQuerytService;}
		
	@GetMapping("/Crud/LegacyQuery/List")
	public String List(Model model) {
		
        List<CrudBasicDTO> List = crudLegacyQuerytService.list();        
        model.addAttribute("List", List);
		
		return "crud/legacyquery/List";
	}
	
	@GetMapping("/Crud/LegacyQuery/Create")
	public String Create() {
		
		return "crud/legacyquery/Create";
	}
	
	@PostMapping("/Crud/LegacyQuery/Create")
	public String Create(CrudBasicDTO crudBasicDTO) {
		
		crudLegacyQuerytService.create(crudBasicDTO);
		
		return "redirect:/Crud/LegacyQuery/List";
	}
	
	@GetMapping("/Crud/LegacyQuery/Read/{idx}")
	public String Read(@PathVariable("idx") String idx, Model model) {
		
		crudLegacyQuerytService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudLegacyQuerytService.read(idx);
		model.addAttribute("Read", crudBasicDTO);
		
		return "crud/legacyquery/Read";
	}
	
	@PostMapping("/Crud/LegacyQuery/Update/{idx}")
	public String Update(@PathVariable("idx") String idx, CrudBasicDTO crudBasicDTO) {
						
		crudBasicDTO.setIdx(idx);
		crudLegacyQuerytService.update(crudBasicDTO);
		
		return "redirect:/Crud/LegacyQuery/Read/" + idx;
	}
	
	@GetMapping("/Crud/LegacyQuery/Delete/{idx}")
	public String Delete(@PathVariable("idx") String idx) {
		
		crudLegacyQuerytService.delete(idx);
		
		return "redirect:/Crud/LegacyQuery/List";
	}

}
