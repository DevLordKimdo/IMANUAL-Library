package com.i.manual.crud.checkbox;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.i.manual.crud.basic.CrudBasicDTO;

@Repository
public class CrudCheckboxRepository {
	
    private final SqlSessionTemplate sql;
    public CrudCheckboxRepository(SqlSessionTemplate sql) {this.sql = sql;}
    
    public List<CrudBasicDTO> list() {
    	return sql.selectList("CrudBasic.list");
    }
    
    public CrudBasicDTO read(String idx) {
        return sql.selectOne("CrudBasic.read", idx);
    }
    
    public void create(CrudBasicDTO crudBasicDTO) {
    	sql.insert("CrudBasic.create", crudBasicDTO);
    }
    
    public void updateHitMulti(List<String> checkIdx) {
    	sql.update("CrudCheckbox.updateHitMulti", checkIdx);
    }
    
    public void updateMulti(CrudBasicDTO crudBasicDTO) {
    	sql.update("CrudCheckbox.updateMulti", crudBasicDTO);
    }
    
    public void deleteMulti(List<String> checkIdx) {
    	sql.delete("CrudCheckbox.deleteMulti", checkIdx);
    }

}
