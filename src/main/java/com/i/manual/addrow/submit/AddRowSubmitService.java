package com.i.manual.addrow.submit;

import java.util.List;

import org.springframework.stereotype.Service;

import com.i.manual.crud.basic.CrudBasicDTO;

@Service
public class AddRowSubmitService {
	
    private final AddRowSubmitRepository addRowSubmitRepository;
    public AddRowSubmitService(AddRowSubmitRepository addRowSubmitRepository) {this.addRowSubmitRepository = addRowSubmitRepository;}
    
	public void create(List<CrudBasicDTO> crudBasicDTOList) {
		
		for(CrudBasicDTO crudBasicDTO : crudBasicDTOList) {
			addRowSubmitRepository.create(crudBasicDTO);
		}
		
	}

}
