package com.i.manual.crud.flutter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i.manual.crud.basic.CrudBasicDTO;
import com.i.manual.crud.basic.CrudBasicService;

import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class CrudFlutterController {
	
    private final CrudBasicService crudBasicService;
    public CrudFlutterController(CrudBasicService crudBasicService) {this.crudBasicService = crudBasicService;}
    
	@GetMapping("/Crud/Flutter/List")
	public List<CrudBasicDTO> List() {
		
        List<CrudBasicDTO> list = crudBasicService.list();
        
        return list;
    }
	
	/*
	@GetMapping("/Crud/Flutter/List")
	public ResponseEntity<List<CrudBasicDTO>> List() {
		
        List<CrudBasicDTO> list = crudBasicService.list();
        
        return ResponseEntity.ok(list);
    }
    */
}
