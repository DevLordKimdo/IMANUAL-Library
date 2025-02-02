package com.i.manual.crud.search;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CrudSearchRepository {
	
    private final SqlSessionTemplate sql;
    public CrudSearchRepository(SqlSessionTemplate sql) {this.sql = sql;}
    
    public List<CrudSearchDTO> list(CrudSearchDTO crudSearchDTO) {
    	return sql.selectList("CrudSearch.list",crudSearchDTO);
    }

}
