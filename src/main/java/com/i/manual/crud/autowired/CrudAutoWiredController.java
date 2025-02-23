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
    
	@GetMapping("/crud/auto-wired/list")
	public String list(Model model) {
		
		List<CrudBasicDTO> list = crudAutoWiredService.list();
    	model.addAttribute("list", list);
		
		return "crud/autowired/list";
	}
	
	@GetMapping("/crud/auto-wired/create")
	public String create() {
		
		return "crud/autowired/create";
	}
	
	@PostMapping("/crud/auto-wired/create")
	public String create(CrudBasicDTO crudBasicDTO) {
		
		crudAutoWiredService.create(crudBasicDTO);
		
		return "redirect:/crud/auto-wired/list";
	}
	
	@GetMapping("/crud/auto-wired/read/{idx}")
	public String read(@PathVariable("idx") String idx, Model model) {
		
		crudAutoWiredService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudAutoWiredService.read(idx);
		model.addAttribute("read", crudBasicDTO);
		
		return "crud/autowired/read";
	}
	
	@PostMapping("/crud/auto-wired/update/{idx}")
	public String update(@PathVariable("idx") String idx, CrudBasicDTO crudBasicDTO) {
						
		crudBasicDTO.setIdx(idx);
		crudAutoWiredService.update(crudBasicDTO);
		
		return "redirect:/crud/auto-wired/read/" + idx;
	}
	
	@GetMapping("/crud/auto-wired/delete/{idx}")
	public String delete(@PathVariable("idx") String idx) {
		
		crudAutoWiredService.delete(idx);
		
		return "redirect:/crud/auto-wired/list";
	}

}
