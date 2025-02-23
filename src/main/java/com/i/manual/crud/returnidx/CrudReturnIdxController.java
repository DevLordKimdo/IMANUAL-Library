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
    
	@GetMapping("/crud/return-idx/list")
	public String list(Model model) {
		
		List<CrudBasicDTO> list = crudReturnIdxService.list();
    	model.addAttribute("list", list);
		
		return "crud/returnidx/list";
	}
	
	@GetMapping("/crud/return-idx/create")
	public String create() {
		
		return "crud/returnidx/create";
	}
	
	@PostMapping("/crud/return-idx/create")
	public String create(CrudBasicDTO crudBasicDTO) {
		
		crudReturnIdxService.create(crudBasicDTO);
		
		return "redirect:/crud/return-idx/read/" + crudBasicDTO.getIdx();
	}
	
	@GetMapping("/crud/return-idx/read/{idx}")
	public String read(@PathVariable("idx") String idx, Model model) {
		
		crudReturnIdxService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudReturnIdxService.read(idx);
		model.addAttribute("read", crudBasicDTO);
		
		return "crud/returnidx/read";
	}

}

// 글 작성 후 작성 한 idx(인덱스) 번호값을 바로 가져오는 기능을 사용해보기.
// CrudReturnIdx-mapper.xml 에서 useGeneratedKeys="true" keyProperty="idx" 를 사용함.