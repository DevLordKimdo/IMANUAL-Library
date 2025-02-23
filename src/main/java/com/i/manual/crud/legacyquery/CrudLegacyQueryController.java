package com.i.manual.crud.legacyquery;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.i.manual.crud.basic.CrudBasicDTO;

@Controller
public class CrudLegacyQueryController {
	
    private final CrudLegacyQueryService crudLegacyQuerytService;
    public CrudLegacyQueryController(CrudLegacyQueryService crudLegacyQuerytService) {this.crudLegacyQuerytService = crudLegacyQuerytService;}
		
	@GetMapping("/crud/legacy-query/list")
	public String list(Model model) {
		
        List<CrudBasicDTO> list = crudLegacyQuerytService.list();        
        model.addAttribute("list", list);
		
		return "crud/legacyquery/list";
	}
	
	@GetMapping("/crud/legacy-query/create")
	public String create() {
		
		return "crud/legacyquery/create";
	}
	
	@PostMapping("/crud/legacy-query/create")
	public String create(CrudBasicDTO crudBasicDTO) {
		
		crudLegacyQuerytService.create(crudBasicDTO);
		
		return "redirect:/crud/legacy-query/list";
	}
	
	@GetMapping("/crud/legacy-query/read/{idx}")
	public String read(@PathVariable("idx") String idx, Model model) {
		
		crudLegacyQuerytService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudLegacyQuerytService.read(idx);
		model.addAttribute("read", crudBasicDTO);
		
		return "crud/legacyquery/read";
	}
	
	@PostMapping("/crud/legacy-query/update/{idx}")
	public String update(@PathVariable("idx") String idx, CrudBasicDTO crudBasicDTO) {
						
		crudBasicDTO.setIdx(idx);
		crudLegacyQuerytService.update(crudBasicDTO);
		
		return "redirect:/crud/legacy-query/read/" + idx;
	}
	
	@GetMapping("/crud/legacy-query/delete/{idx}")
	public String delete(@PathVariable("idx") String idx) {
		
		crudLegacyQuerytService.delete(idx);
		
		return "redirect:/crud/legacy-query/list";
	}

}

// mybatis 기능을 쓰지 않고 기존의 JDBC 드라이버를 직접 호출해서 사용하는 방법