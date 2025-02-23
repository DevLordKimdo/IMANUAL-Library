package com.i.manual.crud.getrequest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.i.manual.crud.basic.CrudBasicDTO;
import com.i.manual.crud.basic.CrudBasicService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CrudGetRequestController {
	
    private final CrudBasicService crudCoreService;
    public CrudGetRequestController(CrudBasicService crudCoreService) {this.crudCoreService = crudCoreService;}
    
	@GetMapping("/crud/get-request/list")
	public String list(Model model) {
		
		List<CrudBasicDTO> list = crudCoreService.list();
    	model.addAttribute("list", list);
    	
		return "crud/getrequest/list";
	}
	
	@GetMapping("/crud/get-request/create")
	public String create() {
		
		return "crud/getrequest/create";
	}
	
	@PostMapping("/crud/get-request/create")
	public String create(HttpServletRequest request) {
		
		CrudBasicDTO crudBasicDTO = new CrudBasicDTO();
		crudBasicDTO.setName(request.getParameter("name"));
		crudBasicDTO.setTitle(request.getParameter("title"));
		crudBasicDTO.setContent(request.getParameter("content"));
		crudCoreService.create(crudBasicDTO);
		
		return "redirect:/crud/get-request/list";
	}
	
	@GetMapping("/crud/get-request/read/{idx}")
	public String read(@PathVariable("idx") String idx, Model model) {
		
		crudCoreService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudCoreService.read(idx);
		model.addAttribute("read", crudBasicDTO);
		
		return "crud/getrequest/read";
	}
	
	@PostMapping("/crud/get-request/update")
	public String update(HttpServletRequest request) {
		
		// /{idx} 로 URL맵핑을 이용해 idx 값을 받을 수 있었으나
		// 이걸 사용하지 않고 request 안에 들어있는 값을 꺼내서 써보기.
						
		CrudBasicDTO crudBasicDTO = new CrudBasicDTO();
		crudBasicDTO.setIdx(request.getParameter("idx"));
		crudBasicDTO.setName(request.getParameter("name"));
		crudBasicDTO.setTitle(request.getParameter("title"));
		crudBasicDTO.setContent(request.getParameter("content"));
		crudCoreService.update(crudBasicDTO);
		
		return "redirect:/crud/get-request/read/" + request.getParameter("idx");
	}
	
	@GetMapping("/crud/get-request/delete/{idx}")
	public String delete(@PathVariable("idx") String idx) {
		
		crudCoreService.delete(idx);
		
		return "redirect:/crud/get-request/list";
	}
}

// request 에서 getParameter 를 이용해 들어온 값들을 하나하나 꺼내서 사용하기 위한 코드
