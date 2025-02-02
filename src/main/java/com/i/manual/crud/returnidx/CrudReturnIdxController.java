package com.i.manual.crud.returnidx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.i.manual.crud.basic.CrudBasicDTO;

import java.util.*;

@Controller
public class CrudReturnIdxController {
	
    private final CrudReturnIdxService crudReturnIdxService;
    public CrudReturnIdxController(CrudReturnIdxService crudReturnIdxService) {this.crudReturnIdxService = crudReturnIdxService;}
    
	@GetMapping("/Crud/ReturnIdx/List")
	public String List(Model model) {
		
		List<CrudBasicDTO> List = crudReturnIdxService.list();
    	model.addAttribute("List", List);
		
		return "crud/ReturnIdx/List";
	}
	
	@GetMapping("/Crud/ReturnIdx/Create")
	public String Create() {
		
		return "crud/ReturnIdx/Create";
	}
	
	@PostMapping("/Crud/ReturnIdx/Create")
	public String Create(CrudBasicDTO crudBasicDTO) {
		
		crudReturnIdxService.create(crudBasicDTO);
		
		return "redirect:/Crud/ReturnIdx/Read/" + crudBasicDTO.getIdx();
	}
	
	@GetMapping("/Crud/ReturnIdx/Read/{idx}")
	public String Read(@PathVariable("idx") String idx, Model model) {
		
		crudReturnIdxService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudReturnIdxService.read(idx);
		model.addAttribute("Read", crudBasicDTO);
		
		return "crud/returnidx/Read";
	}

}
