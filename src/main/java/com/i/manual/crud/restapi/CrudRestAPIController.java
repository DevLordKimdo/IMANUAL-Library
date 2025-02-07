package com.i.manual.crud.restapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i.manual.crud.basic.CrudBasicDTO;
import com.i.manual.crud.basic.CrudBasicService;

import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class CrudRestAPIController {
	
    private final CrudBasicService crudBasicService;
    public CrudRestAPIController(CrudBasicService crudBasicService) {this.crudBasicService = crudBasicService;}
    
	@GetMapping("/Crud/RestAPI/List")
	public List<CrudBasicDTO> List() {
		
        List<CrudBasicDTO> list = crudBasicService.list();
        
        return list;
    }

}
