package com.i.manual.crud.autowired;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.i.manual.crud.basic.CrudBasicDTO;

@Repository
public class CrudAutoWiredRepository {
	
	@Autowired
	SqlSessionTemplate sql;
    
    public List<CrudBasicDTO> list() {
    	return sql.selectList("CrudBasic.list");
    }
    
    public void create(CrudBasicDTO crudBasicDTO) {
    	sql.insert("CrudBasic.create", crudBasicDTO);
    }
    
    public void updateHit(String idx) {
    	sql.update("CrudBasic.updateHit", idx);
    }
    
    public CrudBasicDTO read(String idx) {
        return sql.selectOne("CrudBasic.read", idx);
    }
    
    public void update(CrudBasicDTO crudBasicDTO) {
    	sql.update("CrudBasic.update", crudBasicDTO);
    }
    
    public void delete(String idx) {
    	sql.delete("CrudBasic.delete", idx);
    }

}
