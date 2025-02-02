package com.i.manual.crud.jsform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.i.manual.crud.basic.CrudBasicDTO;
import com.i.manual.crud.basic.CrudBasicService;

import java.util.*;

@Controller
public class CrudJSFromController {
	
    private final CrudBasicService crudBasicService;
    public CrudJSFromController(CrudBasicService crudBasicService) {this.crudBasicService = crudBasicService;}
    
	@GetMapping("/Crud/JSForm/List")
	public String List(Model model) {
		
		List<CrudBasicDTO> List = crudBasicService.list();
    	model.addAttribute("List", List);
		
		return "crud/JSForm/List";
	}
	
	@GetMapping("/Crud/JSForm/Create")
	public String Create() {
		
		return "crud/JSForm/Create";
	}
	
	@PostMapping("/Crud/JSForm/Create")
	public String Create(CrudBasicDTO crudBasicDTO) {
		
		crudBasicService.create(crudBasicDTO);
		
		return "redirect:/Crud/JSForm/List";
	}
	
	@GetMapping("/Crud/JSForm/Read/{idx}")
	public String ReadGet(@PathVariable("idx") String idx, Model model) {
		
		crudBasicService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudBasicService.read(idx);
		model.addAttribute("Read", crudBasicDTO);
		
		return "crud/JSForm/Read";
	}
	
	@PostMapping("/Crud/JSForm/Read/{idx}")
	public String ReadPost(@PathVariable("idx") String idx, Model model) {
		
		crudBasicService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudBasicService.read(idx);
		model.addAttribute("Read", crudBasicDTO);
		
		return "crud/JSForm/Read";
	}
	
	@PostMapping("/Crud/JSForm/Update/{idx}")
	public String Update(@PathVariable("idx") String idx, CrudBasicDTO crudBasicDTO) {
						
		crudBasicDTO.setIdx(idx);
		crudBasicService.update(crudBasicDTO);
		
		return "redirect:/Crud/JSForm/Read/" + idx;
	}
	
	@GetMapping("/Crud/JSForm/Delete/{idx}")
	public String Delete(@PathVariable("idx") String idx) {
		
		crudBasicService.delete(idx);
		
		return "redirect:/Crud/JSForm/List";
	}

}
