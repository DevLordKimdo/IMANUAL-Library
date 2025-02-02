package com.i.manual.fileio.fileboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileIOFileBoardRepository {
	
    private final SqlSessionTemplate sql;
    public FileIOFileBoardRepository(SqlSessionTemplate sql) {this.sql = sql;}
    
    public List<FileIOFileBoardDTO> list() {
    	return sql.selectList("FileIOFileBoard.list");
    }
    
    public String newPostIdx() {
    	return sql.selectOne("FileIOFileBoard.newPostIdx");
    }
    
    public void upload(FileIOFileBoardDTO fileIOFileBoardDTO) {
    	sql.insert("FileIOFileBoard.upload", fileIOFileBoardDTO);
    }
    
}
