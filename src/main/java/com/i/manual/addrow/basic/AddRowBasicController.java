package com.i.manual.addrow.basic;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.i.manual.crud.basic.CrudBasicDTO;

@Controller
public class AddRowBasicController {
	
	@GetMapping("/AddRow/Basic/Form")
	public String Form() {
		
		return "addrow/basic/Form";
	}
	
	@PostMapping("/AddRow/Basic/Submit")
	public String Submit(@RequestParam("title")   List<String> title, 
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
	
		for(CrudBasicDTO list : crudBasicDTOList) {
			System.out.println(list.getTitle() + " " + list.getName() + " " + list.getContent());
		}
		
		return "redirect:/AddRow/Basic/Form";
	}

}
