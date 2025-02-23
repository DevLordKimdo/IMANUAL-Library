package com.i.manual.addrow.submit;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.i.manual.crud.basic.CrudBasicDTO;

@Controller
public class AddRowSubmitController {
	
    private final AddRowSubmitService addRowSubmitService;
    public AddRowSubmitController(AddRowSubmitService addRowSubmitService) {this.addRowSubmitService = addRowSubmitService;}
	
	@GetMapping("/add-row/submit/form")
	public String form() {
		
		return "addrow/submit/form";
	}

	@PostMapping("/add-row/submit/create")
	public String create(@RequestParam("title")   List<String> title,
			             @RequestParam("name")    List<String> name,
			             @RequestParam("content") List<String> content) {
		
		List<CrudBasicDTO> crudBasicDTOList = new ArrayList<>();
		
		for (int i = 0; i < title.size(); i++) {
			CrudBasicDTO tempDTO = new CrudBasicDTO();
			tempDTO.setTitle(title.get(i));
			tempDTO.setName(name.get(i));
			tempDTO.setContent(content.get(i));
			crudBasicDTOList.add(tempDTO);
		}
		
		addRowSubmitService.create(crudBasicDTOList);
		
		return "redirect:/add-row/submit/form";
	}

}
