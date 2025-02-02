package com.i.manual.pagination.basic;

import com.i.manual.crud.basic.CrudBasicDTO;

public class PaginationBasicDTO extends CrudBasicDTO{
	
	private int postsPerPage;
	private int pageStart;
	
	public int getPostsPerPage() {
		return postsPerPage;
	}
	public void setPostsPerPage(int postsPerPage) {
		this.postsPerPage = postsPerPage;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	
}
