package com.i.manual.pagination.basic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PaginationBasicRepository {
	
    private final SqlSessionTemplate sql;
    public PaginationBasicRepository(SqlSessionTemplate sql) {this.sql = sql;}
    
    public List<PaginationBasicDTO> list(PaginationBasicDTO paginationBasicDTO) {
    	return sql.selectList("PaginationBasic.list", paginationBasicDTO);
    }
    
    public int count() {
    	return sql.selectOne("PaginationBasic.count");
    }
    
}
