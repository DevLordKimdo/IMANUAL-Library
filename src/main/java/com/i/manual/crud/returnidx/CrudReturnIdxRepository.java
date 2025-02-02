package com.i.manual.crud.returnidx;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.i.manual.crud.basic.CrudBasicDTO;

@Repository
public class CrudReturnIdxRepository {
	
    private final SqlSessionTemplate sql;
    public CrudReturnIdxRepository(SqlSessionTemplate sql) {this.sql = sql;}
    
    public List<CrudBasicDTO> list() {
    	return sql.selectList("CrudBasic.list");
    }
    
    public void create(CrudBasicDTO crudBasicDTO) {
    	sql.insert("CrudReturnIdx.create", crudBasicDTO);
    }
    
    public void updateHit(String idx) {
    	sql.update("CrudBasic.updateHit", idx);
    }
    
    public CrudBasicDTO read(String idx) {
        return sql.selectOne("CrudBasic.read", idx);
    }

}
