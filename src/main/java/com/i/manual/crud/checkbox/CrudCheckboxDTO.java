package com.i.manual.crud.checkbox;

import java.util.List;

import com.i.manual.crud.basic.CrudBasicDTO;

public class CrudCheckboxDTO extends CrudBasicDTO{
	
	private List<String> idxList;

	public List<String> getIdxList() {
		return idxList;
	}
	public void setIdxList(List<String> idxList) {
		this.idxList = idxList;
	}

}
