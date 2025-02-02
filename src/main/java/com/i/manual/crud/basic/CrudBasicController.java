package com.i.manual.crud.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class CrudBasicController {
	
    private final CrudBasicService crudBasicService;
    public CrudBasicController(CrudBasicService crudBasicService) {this.crudBasicService = crudBasicService;}
    
	@GetMapping("/Crud/Basic/List")
	public String List(Model model) {
						
		List<CrudBasicDTO> List = crudBasicService.list();
    	model.addAttribute("List", List);
		
		return "crud/basic/List";
	}
	
	@GetMapping("/Crud/Basic/Create")
	public String Create() {
		
		return "crud/basic/Create";
	}
	
	@PostMapping("/Crud/Basic/Create")
	public String Create(CrudBasicDTO crudBasicDTO) {
		
		crudBasicService.create(crudBasicDTO);
		
		return "redirect:/Crud/Basic/List";
	}
	
	@GetMapping("/Crud/Basic/Read/{idx}")
	public String Read(@PathVariable("idx") String idx, Model model) {
		
		crudBasicService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudBasicService.read(idx);
		model.addAttribute("Read", crudBasicDTO);
		
		return "crud/basic/Read";
	}
	
	@PostMapping("/Crud/Basic/Update/{idx}")
	public String Update(@PathVariable("idx") String idx, CrudBasicDTO crudBasicDTO) {
						
		crudBasicDTO.setIdx(idx);
		crudBasicService.update(crudBasicDTO);
		
		return "redirect:/Crud/Basic/Read/" + idx;
	}
	
	@GetMapping("/Crud/Basic/Delete/{idx}")
	public String Delete(@PathVariable("idx") String idx) {
		
		crudBasicService.delete(idx);
		
		return "redirect:/Crud/Basic/List";
	}
	
}
