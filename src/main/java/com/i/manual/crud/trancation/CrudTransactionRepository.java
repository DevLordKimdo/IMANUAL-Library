package com.i.manual.crud.trancation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.i.manual.crud.basic.CrudBasicDTO;

@Repository
public class CrudTransactionRepository {
	
    private final SqlSessionTemplate sql;
    public CrudTransactionRepository(SqlSessionTemplate sql) {this.sql = sql;}
    
    public List<CrudBasicDTO> list() {
    	return sql.selectList("CrudBasic.list");
    }
    
    public void create(CrudBasicDTO crudBasicDTO) {
    	sql.insert("CrudBasic.create", crudBasicDTO);
    }

}
