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
        
	@GetMapping("/Crud/Search/List")
	public String List(Model model, CrudSearchDTO crudSearchDTO) {
		
		List<CrudSearchDTO> List = crudSearchService.list(crudSearchDTO);
		model.addAttribute("Search", crudSearchDTO);
    	model.addAttribute("List", List);
								
		return "crud/search/List";
	}
	
	@PostMapping("/Crud/Search/List")
	public String Result(Model model, CrudSearchDTO crudSearchDTO) {
		
		List<CrudSearchDTO> List = crudSearchService.list(crudSearchDTO);
		model.addAttribute("Search", crudSearchDTO);
    	model.addAttribute("List", List);

		return "crud/search/List";
	}


}
