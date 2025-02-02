package com.i.manual.crud.returnidx;

import java.util.List;

import org.springframework.stereotype.Service;

import com.i.manual.crud.basic.CrudBasicDTO;

@Service
public class CrudReturnIdxService {
	
    private final CrudReturnIdxRepository crudReturnIdxRepository;
    public CrudReturnIdxService(CrudReturnIdxRepository crudReturnIdxRepository) {this.crudReturnIdxRepository = crudReturnIdxRepository;}
    
	public List<CrudBasicDTO> list(){
		return crudReturnIdxRepository.list();
	}
	
	public void create(CrudBasicDTO crudBasicDTO) {
		crudReturnIdxRepository.create(crudBasicDTO);
	}
	
	public void updateHit(String idx) {
		crudReturnIdxRepository.updateHit(idx);
	}
	
	public CrudBasicDTO read(String idx){
		return crudReturnIdxRepository.read(idx);
	}

}
