package com.i.manual.addrow.submit;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.i.manual.crud.basic.CrudBasicDTO;

@Repository
public class AddRowSubmitRepository {
	
    private final SqlSessionTemplate sql;
    public AddRowSubmitRepository(SqlSessionTemplate sql) {this.sql = sql;}
	
    public void create(CrudBasicDTO crudBasicDTO) {
    	sql.insert("CrudBasic.create", crudBasicDTO);
    }

}
