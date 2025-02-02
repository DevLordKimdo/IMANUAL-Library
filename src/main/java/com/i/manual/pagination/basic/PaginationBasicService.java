package com.i.manual.pagination.basic;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PaginationBasicService {
	
    private final PaginationBasicRepository paginationBasicRepository;
    public PaginationBasicService(PaginationBasicRepository paginationBasicRepository) {this.paginationBasicRepository = paginationBasicRepository;}
    
	public List<PaginationBasicDTO> list(PaginationBasicDTO paginationBasicDTO){
		return paginationBasicRepository.list(paginationBasicDTO);
	}
	
	public int count() {
		return paginationBasicRepository.count();
	}
	
}
