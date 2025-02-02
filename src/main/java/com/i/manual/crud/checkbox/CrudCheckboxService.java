package com.i.manual.crud.checkbox;

import java.util.*;

import org.springframework.stereotype.Service;

import com.i.manual.crud.basic.CrudBasicDTO;

@Service
public class CrudCheckboxService {
	
    private final CrudCheckboxRepository crudCheckboxRepository;
    public CrudCheckboxService(CrudCheckboxRepository crudCheckboxRepository) {this.crudCheckboxRepository = crudCheckboxRepository;}
    
	public List<CrudBasicDTO> list(){
		return crudCheckboxRepository.list();
	}
	
	public void checkCopy(List<String> checkIdx) {
		for(String idx : checkIdx) {
			CrudBasicDTO crudBasicDTO = crudCheckboxRepository.read(idx);
			crudCheckboxRepository.create(crudBasicDTO);
		}
	}
	
	public void checkUpdate(List<String> checkIdx) {
		CrudCheckboxDTO crudCheckboxDTO = new CrudCheckboxDTO();
		crudCheckboxDTO.setTitle("수정");
		crudCheckboxDTO.setName("수정");
		crudCheckboxDTO.setContent("수정");
		crudCheckboxDTO.setIdxList(checkIdx);
		crudCheckboxRepository.updateMulti(crudCheckboxDTO);
	}
	
	public void checkUpdateHit(List<String> checkIdx) {
		crudCheckboxRepository.updateHitMulti(checkIdx);
	}
	
	public void checkDelete(List<String> checkIdx) {
		crudCheckboxRepository.deleteMulti(checkIdx);
	}
}
