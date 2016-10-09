package cn.mldn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.mldn.util.dbc.DatabaseConnection;

public class AbstractDAO {
	protected Connection conn ;
	protected PreparedStatement pstmt ;
	public AbstractDAO() {
		this.conn = DatabaseConnection.get() ;
	}
	public Integer getCurrentValueHandle(String id,String tableName) throws SQLException{
		String sql = "SELECT max("+id+") FROM " + tableName ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		try
		{
			
			ResultSet rs = this.pstmt.executeQuery() ;
			if(rs.next()){
				return rs.getInt(1) ;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return  0 ;
	}
	
}
