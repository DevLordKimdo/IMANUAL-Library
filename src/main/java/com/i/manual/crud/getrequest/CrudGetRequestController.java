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
    
	@GetMapping("/Crud/GetRequest/List")
	public String List(Model model) {
		
		List<CrudBasicDTO> List = crudCoreService.list();
    	model.addAttribute("List", List);
    	
		return "crud/getrequest/List";
	}
	
	@GetMapping("/Crud/GetRequest/Create")
	public String Create() {
		
		return "crud/getrequest/Create";
	}
	
	@PostMapping("/Crud/GetRequest/Create")
	public String Create(HttpServletRequest request) {
		
		CrudBasicDTO crudBasicDTO = new CrudBasicDTO();
		crudBasicDTO.setName(request.getParameter("name"));
		crudBasicDTO.setTitle(request.getParameter("title"));
		crudBasicDTO.setContent(request.getParameter("content"));
		crudCoreService.create(crudBasicDTO);
		
		return "redirect:/Crud/GetRequest/List";
	}
	
	@GetMapping("/Crud/GetRequest/Read/{idx}")
	public String Read(@PathVariable("idx") String idx, Model model) {
		
		crudCoreService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudCoreService.read(idx);
		model.addAttribute("Read", crudBasicDTO);
		
		return "crud/getrequest/Read";
	}
	
	@PostMapping("/Crud/GetRequest/Update/{idx}")
	public String Update(HttpServletRequest request) {
						
		CrudBasicDTO crudBasicDTO = new CrudBasicDTO();
		crudBasicDTO.setIdx(request.getParameter("idx"));
		crudBasicDTO.setName(request.getParameter("name"));
		crudBasicDTO.setTitle(request.getParameter("title"));
		crudBasicDTO.setContent(request.getParameter("content"));
		crudCoreService.update(crudBasicDTO);
		
		return "redirect:/Crud/GetRequest/Read/" + request.getParameter("idx");
	}
	
	@GetMapping("/Crud/GetRequest/Delete/{idx}")
	public String Delete(@PathVariable("idx") String idx) {
		
		crudCoreService.delete(idx);
		
		return "redirect:/Crud/GetRequest/List";
	}
}
