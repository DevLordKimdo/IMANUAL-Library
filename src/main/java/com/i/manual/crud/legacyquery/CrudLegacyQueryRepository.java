package com.i.manual.crud.legacyquery;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.i.manual.crud.basic.CrudBasicDTO;

@Repository
public class CrudLegacyQueryRepository {
	
	@Autowired
    private DataSource dataSource;
	
	public List<CrudBasicDTO> list() {
		try {
			Connection conn = DataSourceUtils.getConnection(dataSource);
			
    		String sql = "SELECT";
    		sql += "  idx";
    		sql += " ,title";
    		sql += " ,content";
    		sql += " ,name";
    		sql += " ,FORMATDATETIME(datetime, 'yyyy-MM-dd HH:mm:ss') AS datetime";
    		sql += " ,hit";
    		sql += " FROM CRUD";
    		
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            List<CrudBasicDTO> list = new ArrayList<>();
            while (rs.next()) {
                CrudBasicDTO crudBasicDTO = new CrudBasicDTO();
                crudBasicDTO.setIdx     (rs.getString("idx"));
                crudBasicDTO.setTitle   (rs.getString("title"));
                crudBasicDTO.setContent (rs.getString("content"));
                crudBasicDTO.setName    (rs.getString("name"));
                crudBasicDTO.setDatetime(rs.getString("datetime"));
                crudBasicDTO.setHit     (rs.getString("hit"));
                list.add(crudBasicDTO);
            }
			
            rs.close();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);
            
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public void create(CrudBasicDTO crudBasicDTO) {
    	try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
            
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        
            String sql = "INSERT INTO ";
            sql += "  CRUD (title, content, name, datetime, hit) ";
            sql += "VALUES (    ?,       ?,    ?,        ?,   ?) ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, crudBasicDTO.getTitle());
            ps.setString(2, crudBasicDTO.getContent());
            ps.setString(3, crudBasicDTO.getName());
            ps.setString(4, now.format(formatter));
            ps.setString(5, "0");
            ps.executeUpdate();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void updateHit(String idx) {
    	try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
                        
            String sql = "UPDATE CRUD SET ";
            sql += "hit = hit + 1 ";
            sql += "WHERE idx = ? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idx);
            ps.executeUpdate();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public CrudBasicDTO read(String idx) {
        CrudBasicDTO crudBasicDTO = null;
        try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
            String sql = "SELECT";
            sql += "  idx";
            sql += " ,title";
            sql += " ,content";
            sql += " ,name";
            sql += " ,FORMATDATETIME(datetime, 'yyyy-MM-dd HH:mm:ss') AS datetime";
            sql += " ,hit";
            sql += " FROM CRUD";
            sql += " WHERE idx = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idx);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	crudBasicDTO = new CrudBasicDTO();
            	crudBasicDTO.setIdx(rs.getString("idx"));
            	crudBasicDTO.setTitle(rs.getString("title"));
            	crudBasicDTO.setContent(rs.getString("content"));
            	crudBasicDTO.setName(rs.getString("name"));
            	crudBasicDTO.setDatetime(rs.getString("datetime"));
            	crudBasicDTO.setHit(rs.getString("hit"));
            }

            rs.close();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crudBasicDTO;
    }
    
    public void update(CrudBasicDTO crudBasicDTO) {
    	try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
                                    
            String sql = "UPDATE CRUD SET ";
            sql += " title = ? ";
            sql += ",content = ? ";
            sql += ",name = ? ";
            sql += "WHERE idx = ? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, crudBasicDTO.getTitle());
            ps.setString(2, crudBasicDTO.getContent());
            ps.setString(3, crudBasicDTO.getName());
            ps.setString(4, crudBasicDTO.getIdx());
            ps.executeUpdate();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
    
    public void delete(String idx) {
    	try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
                                    
            String sql = "DELETE FROM CRUD WHERE idx = ? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idx);
            ps.executeUpdate();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}