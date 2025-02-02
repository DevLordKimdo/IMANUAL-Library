package com.i.manual.crud.autowired;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i.manual.crud.basic.CrudBasicDTO;

@Service
public class CrudAutoWiredService {
	
	@Autowired
    CrudAutoWiredRepository crudAutoWiredRepository;
    
	public List<CrudBasicDTO> list(){
		return crudAutoWiredRepository.list();
	}
	
	public void create(CrudBasicDTO crudBasicDTO) {
		crudAutoWiredRepository.create(crudBasicDTO);
	}
	
	public void updateHit(String idx) {
		crudAutoWiredRepository.updateHit(idx);
	}
	
	public CrudBasicDTO read(String idx){
		return crudAutoWiredRepository.read(idx);
	}
	
	public void update(CrudBasicDTO crudBasicDTO) {
		crudAutoWiredRepository.update(crudBasicDTO);
	}
	
	public void delete(String idx) {
		crudAutoWiredRepository.delete(idx);
	}

}
