package com.i.manual.fetch.search;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.i.manual.crud.search.CrudSearchDTO;
import com.i.manual.crud.search.CrudSearchService;

@Controller
public class FetchSearchController {
	
    private final CrudSearchService crudSearchService;
    public FetchSearchController(CrudSearchService crudSearchService) {this.crudSearchService = crudSearchService;}
        
	@GetMapping("/Fetch/Search/List")
	public String List(Model model, CrudSearchDTO crudSearchDTO) {
		
		List<CrudSearchDTO> list = crudSearchService.list(crudSearchDTO);
		model.addAttribute("search", crudSearchDTO);
    	model.addAttribute("list", list);
								
		return "fetch/search/List";
	}
	
	@PostMapping("/Fetch/Search/submitJson")
	@ResponseBody
	public List<CrudSearchDTO> getJson(@RequestBody CrudSearchDTO crudSearchDTO) {
				
		List<CrudSearchDTO> list = crudSearchService.list(crudSearchDTO);
		
		return list;
	}
	
	@PostMapping("/Fetch/Search/submitForm")
	@ResponseBody
	public List<CrudSearchDTO> getForm(CrudSearchDTO crudSearchDTO) {
						
		List<CrudSearchDTO> list = crudSearchService.list(crudSearchDTO);
		
		return list;
	}


}
