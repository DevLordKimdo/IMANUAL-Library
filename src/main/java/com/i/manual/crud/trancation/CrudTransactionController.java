package com.i.manual.crud.trancation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.i.manual.crud.basic.CrudBasicDTO;

import jakarta.servlet.http.HttpServletRequest;

import java.util.*;

@Controller
public class CrudTransactionController {
	
    private final CrudTransactionService crudTransactionService;
    public CrudTransactionController(CrudTransactionService crudTransactionService) {this.crudTransactionService = crudTransactionService;}
    
	@GetMapping("/Crud/Transaction/List")
	public String List(Model model) {
		
		List<CrudBasicDTO> List = crudTransactionService.list();
    	model.addAttribute("List", List);
		
		return "crud/transaction/List";
	}
	
	@GetMapping("/Crud/Transaction/Create")
	public String Create() {
		
		return "crud/transaction/Create";
	}
	
	@PostMapping("/Crud/Transaction/Create")
	public String Create(CrudBasicDTO crudBasicDTO, HttpServletRequest request) {
		if(request.getParameter("transaction") == null) {
			crudTransactionService.createNoneTransaction(crudBasicDTO);
		} else {
			crudTransactionService.createWithTransaction(crudBasicDTO);
		}
		
		return "redirect:/Crud/Transaction/List";
	}
}
