package com.i.manual.crud.legacyquery;

import java.util.List;

import org.springframework.stereotype.Service;

import com.i.manual.crud.basic.CrudBasicDTO;

@Service
public class CrudLegacyQueryService {
	
    private final CrudLegacyQueryRepository crudLegacyQueryRepository;
    public CrudLegacyQueryService(CrudLegacyQueryRepository crudLegacyQueryRepository) {this.crudLegacyQueryRepository = crudLegacyQueryRepository;}

    public List<CrudBasicDTO> list() {
        return crudLegacyQueryRepository.list();
    }
    
	public void create(CrudBasicDTO crudBasicDTO) {
		crudLegacyQueryRepository.create(crudBasicDTO);
	}
	
	public void updateHit(String idx) {
		crudLegacyQueryRepository.updateHit(idx);
	}
	
	public CrudBasicDTO read(String idx){
		return crudLegacyQueryRepository.read(idx);
	}
	
	public void update(CrudBasicDTO crudBasicDTO) {
		crudLegacyQueryRepository.update(crudBasicDTO);
	}
	
	public void delete(String idx) {
		crudLegacyQueryRepository.delete(idx);
	}

}
