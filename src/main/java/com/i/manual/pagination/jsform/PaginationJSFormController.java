package com.i.manual.pagination.jsform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.i.manual.pagination.basic.PaginationBasicDTO;
import com.i.manual.pagination.basic.PaginationBasicService;
import com.i.manual.util.UtilPagination;

import java.util.*;

@Controller
public class PaginationJSFormController {
	
	private final PaginationBasicService paginationBasicService;
    public PaginationJSFormController(PaginationBasicService paginationBasicService) {this.paginationBasicService = paginationBasicService;}
    
    @GetMapping("/Pagination/JSForm/List/{currentPageIndex}")
	public String ListGet(@PathVariable("currentPageIndex") int currentPageIndex , Model model) {

		int Count = paginationBasicService.count();
		int postsPerPage = 10;
		int pageStartIndex = (currentPageIndex - 1) * postsPerPage;
		UtilPagination utilPagination = new UtilPagination(currentPageIndex, postsPerPage, Count);
		model.addAttribute("page", utilPagination);

		PaginationBasicDTO paginationBasicDTO = new PaginationBasicDTO();
		paginationBasicDTO.setPostsPerPage(postsPerPage);
		paginationBasicDTO.setPageStart(pageStartIndex);
		
		List<PaginationBasicDTO> List = paginationBasicService.list(paginationBasicDTO);
    	model.addAttribute("List", List);
		
		return "pagination/jsform/List";
	}
    
    @PostMapping("/Pagination/JSForm/List/{currentPageIndex}")
	public String ListPost(@PathVariable("currentPageIndex") int currentPageIndex , Model model) {

		int Count = paginationBasicService.count();
		int postsPerPage = 10;
		int pageStartIndex = (currentPageIndex - 1) * postsPerPage;
		UtilPagination utilPagination = new UtilPagination(currentPageIndex, postsPerPage, Count);
		model.addAttribute("page", utilPagination);

		PaginationBasicDTO paginationBasicDTO = new PaginationBasicDTO();
		paginationBasicDTO.setPostsPerPage(postsPerPage);
		paginationBasicDTO.setPageStart(pageStartIndex);
		
		List<PaginationBasicDTO> List = paginationBasicService.list(paginationBasicDTO);
    	model.addAttribute("List", List);
		
		return "pagination/jsform/List";
	}
    
}
