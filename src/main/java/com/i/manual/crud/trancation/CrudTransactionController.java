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
    
	@GetMapping("/crud/transaction/list")
	public String list(Model model) {
		
		List<CrudBasicDTO> list = crudTransactionService.list();
    	model.addAttribute("list", list);
		
		return "crud/transaction/list";
	}
	
	@GetMapping("/crud/transaction/create")
	public String create() {
		
		return "crud/transaction/create";
	}
	
	@PostMapping("/crud/transaction/create")
	public String create(CrudBasicDTO crudBasicDTO, HttpServletRequest request) {
		if(request.getParameter("transaction") == null) {
			crudTransactionService.createNoneTransaction(crudBasicDTO);
		} else {
			crudTransactionService.createWithTransaction(crudBasicDTO);
		}
		
		return "redirect:/crud/transaction/list";
	}
}

// 트랜젝션 기능을 이용해보는 코드.
// 글 작성 시 2개의 글이 들어가는데 한쪽은 글 제목이 2배로 펌핑해서 들어가게 됨.
// 이때 SQL Error이 발생되는데 트렌젝션 옵션 유무에 따라
// 제대로 작성한 SQL insert 문과 Error 를 유발하는 SQL insert 문이 어떻게 되는지를 실험.
// 실험을 하려면 글작성 시 제목에 한글 40자를 타이핑후 실험 (제목이 40자인 글과 제목이 80자인 글이 insert 하게 됨.)