package com.i.manual.pagination.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import com.i.manual.util.UtilPagination;

@Controller
public class PaginationBasicController {
	
    private final PaginationBasicService paginationBasicService;
    public PaginationBasicController(PaginationBasicService paginationBasicService) {this.paginationBasicService = paginationBasicService;}
        
	@GetMapping("/pagination/basic/list/{currentPageIndex}")
	public String list(@PathVariable("currentPageIndex") int currentPageIndex , Model model) {

		int count = paginationBasicService.count();
		int postsPerPage = 10;
		int pageStartIndex = (currentPageIndex - 1) * postsPerPage;
		UtilPagination utilPagination = new UtilPagination(currentPageIndex, postsPerPage, count);
		model.addAttribute("page", utilPagination);
		
		PaginationBasicDTO paginationBasicDTO = new PaginationBasicDTO();
		paginationBasicDTO.setPostsPerPage(postsPerPage);
		paginationBasicDTO.setPageStart(pageStartIndex);
		
		List<PaginationBasicDTO> list = paginationBasicService.list(paginationBasicDTO);
    	model.addAttribute("list", list);
		
		return "pagination/basic/list";
	}

}
