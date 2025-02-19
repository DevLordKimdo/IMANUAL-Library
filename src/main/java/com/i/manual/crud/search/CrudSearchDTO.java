package com.i.manual.crud.search;

import com.i.manual.crud.basic.CrudBasicDTO;

public class CrudSearchDTO extends CrudBasicDTO {
	
	private String searchOption;
	private String searchKeyword;
	private String searchDateStart;
	private String searchDateEnded;
	
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchDateStart() {
		return searchDateStart;
	}
	public void setSearchDateStart(String searchDateStart) {
		this.searchDateStart = searchDateStart;
	}
	public String getSearchDateEnded() {
		return searchDateEnded;
	}
	public void setSearchDateEnded(String searchDateEnded) {
		this.searchDateEnded = searchDateEnded;
	}
		
}
