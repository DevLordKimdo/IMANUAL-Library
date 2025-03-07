package com.i.manual.crud.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.i.manual.crud.basic.CrudBasicDTO;
import com.i.manual.crud.basic.CrudBasicService;

import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class CrudRestAPIController {
	
    private final CrudBasicService crudBasicService;
    public CrudRestAPIController(CrudBasicService crudBasicService) {this.crudBasicService = crudBasicService;}
    
	@GetMapping("/crud/rest-api/list")
	public ResponseEntity<List<CrudBasicDTO>> List() {

        List<CrudBasicDTO> list = crudBasicService.list();
        
        return ResponseEntity.ok(list);
    }
		
	@PostMapping("/crud/rest-api/create")
	public ResponseEntity<String> Create(@RequestBody CrudBasicDTO crudBasicDTO) {
		
		crudBasicService.create(crudBasicDTO);
		
		return ResponseEntity.ok("Success");
	}
	
	@PostMapping("/crud/rest-api/update/{idx}")
	public ResponseEntity<String> Update(@PathVariable("idx") String idx, @RequestBody CrudBasicDTO crudBasicDTO) {

		crudBasicDTO.setIdx(idx);
		crudBasicService.update(crudBasicDTO);
		
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/crud/rest-api/delete/{idx}")
	public ResponseEntity<String> Delete(@PathVariable("idx") String idx) {
		
		crudBasicService.delete(idx);
		
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/crud/rest-api/read/{idx}")
	public ResponseEntity<CrudBasicDTO> Read(@PathVariable("idx") String idx, Model model) {
		
		crudBasicService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudBasicService.read(idx);
		
		return ResponseEntity.ok(crudBasicDTO);
	}

}
