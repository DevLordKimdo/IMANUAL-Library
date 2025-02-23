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
    
	@GetMapping("/crud/js-form/list")
	public String list(Model model) {
		
		List<CrudBasicDTO> list = crudBasicService.list();
    	model.addAttribute("list", list);
		
		return "crud/jsform/list";
	}
	
	@GetMapping("/crud/js-form/create")
	public String create() {
		
		return "crud/jsform/create";
	}
	
	@PostMapping("/crud/js-form/create")
	public String create(CrudBasicDTO crudBasicDTO) {
		
		crudBasicService.create(crudBasicDTO);
		
		return "redirect:/crud/js-form/list";
	}
	
	@GetMapping("/crud/js-form/read/{idx}")
	public String readGet(@PathVariable("idx") String idx, Model model) {
		
		crudBasicService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudBasicService.read(idx);
		model.addAttribute("read", crudBasicDTO);
		
		return "crud/jsform/read";
	}
	
	@PostMapping("/crud/js-form/read/{idx}")
	public String readPost(@PathVariable("idx") String idx, Model model) {
		
		crudBasicService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudBasicService.read(idx);
		model.addAttribute("read", crudBasicDTO);
		
		return "crud/jsform/read";
	}
	
	@PostMapping("/crud/js-form/update/{idx}")
	public String update(@PathVariable("idx") String idx, CrudBasicDTO crudBasicDTO) {
						
		crudBasicDTO.setIdx(idx);
		crudBasicService.update(crudBasicDTO);
		
		return "redirect:/crud/js-form/read/" + idx;
	}
	
	@GetMapping("/crud/js-form/delete/{idx}")
	public String delete(@PathVariable("idx") String idx) {
		
		crudBasicService.delete(idx);
		
		return "redirect:/crud/js-form/list";
	}

}
