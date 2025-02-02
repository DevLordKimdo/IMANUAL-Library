package com.i.manual.crud.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.i.manual.crud.basic.CrudBasicDTO;

import java.util.*;

@Controller
public class CrudAutoWiredController {
	
	@Autowired
    CrudAutoWiredService crudAutoWiredService;
    
	@GetMapping("/Crud/AutoWired/List")
	public String List(Model model) {
		
		List<CrudBasicDTO> List = crudAutoWiredService.list();
    	model.addAttribute("List", List);
		
		return "crud/AutoWired/List";
	}
	
	@GetMapping("/Crud/AutoWired/Create")
	public String Create() {
		
		return "crud/AutoWired/Create";
	}
	
	@PostMapping("/Crud/AutoWired/Create")
	public String Create(CrudBasicDTO crudBasicDTO) {
		
		crudAutoWiredService.create(crudBasicDTO);
		
		return "redirect:/Crud/AutoWired/List";
	}
	
	@GetMapping("/Crud/AutoWired/Read/{idx}")
	public String Read(@PathVariable("idx") String idx, Model model) {
		
		crudAutoWiredService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudAutoWiredService.read(idx);
		model.addAttribute("Read", crudBasicDTO);
		
		return "crud/AutoWired/Read";
	}
	
	@PostMapping("/Crud/AutoWired/Update/{idx}")
	public String Update(@PathVariable("idx") String idx, CrudBasicDTO crudBasicDTO) {
						
		crudBasicDTO.setIdx(idx);
		crudAutoWiredService.update(crudBasicDTO);
		
		return "redirect:/Crud/AutoWired/Read/" + idx;
	}
	
	@GetMapping("/Crud/AutoWired/Delete/{idx}")
	public String Delete(@PathVariable("idx") String idx) {
		
		crudAutoWiredService.delete(idx);
		
		return "redirect:/Crud/AutoWired/List";
	}

}
