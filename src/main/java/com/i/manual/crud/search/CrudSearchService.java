package com.i.manual.crud.search;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CrudSearchService {
	
    private final CrudSearchRepository crudSearchRepository;
    public CrudSearchService(CrudSearchRepository crudSearchRepository) {this.crudSearchRepository = crudSearchRepository;}
    
	public List<CrudSearchDTO> list(CrudSearchDTO crudSearchDTO){
		return crudSearchRepository.list(crudSearchDTO);
	}
	
}
