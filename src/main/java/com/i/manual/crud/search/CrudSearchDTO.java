package com.i.manual.crud.search;

import com.i.manual.crud.basic.CrudBasicDTO;

public class CrudSearchDTO extends CrudBasicDTO {
	
	private String SearchOption;
	private String SearchKeyword;
	private String SearchDateStart;
	private String SearchDateEnded;
	
	public String getSearchOption() {
		return SearchOption;
	}
	public void setSearchOption(String searchOption) {
		SearchOption = searchOption;
	}
	public String getSearchKeyword() {
		return SearchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		SearchKeyword = searchKeyword;
	}
	public String getSearchDateStart() {
		return SearchDateStart;
	}
	public void setSearchDateStart(String searchDateStart) {
		SearchDateStart = searchDateStart;
	}
	public String getSearchDateEnded() {
		return SearchDateEnded;
	}
	public void setSearchDateEnded(String searchDateEnded) {
		SearchDateEnded = searchDateEnded;
	}


}
