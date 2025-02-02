package com.i.manual.crud.trancation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.i.manual.crud.basic.CrudBasicDTO;

@Service
public class CrudTransactionService {
	
	private final CrudTransactionRepository crudTransactionRepository;
    public CrudTransactionService(CrudTransactionRepository crudTransactionRepository) { this.crudTransactionRepository = crudTransactionRepository; }
        
	public List<CrudBasicDTO> list(){
		return crudTransactionRepository.list();
	}
	
	public void createNoneTransaction(CrudBasicDTO crudBasicDTO) {
		CrudBasicDTO crudBasicDTOErr = new CrudBasicDTO();
		crudBasicDTOErr.setTitle(crudBasicDTO.getTitle()+crudBasicDTO.getTitle()); // 에러 쿼리를 보내기 위해 제목 길이를 두배
		crudBasicDTOErr.setName(crudBasicDTO.getName());
		crudBasicDTOErr.setContent(crudBasicDTO.getContent());
		
		crudTransactionRepository.create(crudBasicDTO);
		crudTransactionRepository.create(crudBasicDTOErr);
		
	}
	
	@Transactional
	public void createWithTransaction(CrudBasicDTO crudBasicDTO) {
		CrudBasicDTO crudBasicDTOErr = new CrudBasicDTO();
		crudBasicDTOErr.setTitle(crudBasicDTO.getTitle()+crudBasicDTO.getTitle()); // 에러 쿼리를 보내기 위해 제목 길이를 두배
		crudBasicDTOErr.setName(crudBasicDTO.getName());
		crudBasicDTOErr.setContent(crudBasicDTO.getContent());
		
		crudTransactionRepository.create(crudBasicDTO);
		crudTransactionRepository.create(crudBasicDTOErr);
	}
}
