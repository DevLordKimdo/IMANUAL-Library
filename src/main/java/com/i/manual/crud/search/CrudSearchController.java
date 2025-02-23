package com.i.manual.crud.search;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CrudSearchController {
	
    private final CrudSearchService crudSearchService;
    public CrudSearchController(CrudSearchService crudSearchService) {this.crudSearchService = crudSearchService;}
        
	@GetMapping("/crud/search/list")
	public String list(Model model, CrudSearchDTO crudSearchDTO) {
		
		List<CrudSearchDTO> list = crudSearchService.list(crudSearchDTO);
		model.addAttribute("search", crudSearchDTO);
    	model.addAttribute("list", list);
								
		return "crud/search/list";
	}
	
	@PostMapping("/crud/search/list")
	public String result(Model model, CrudSearchDTO crudSearchDTO) {
		
		List<CrudSearchDTO> list = crudSearchService.list(crudSearchDTO);
		model.addAttribute("search", crudSearchDTO);
    	model.addAttribute("list", list);

		return "crud/search/list";
	}


}
