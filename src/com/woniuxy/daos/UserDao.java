package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.User;
import com.woniuxy.tools.ConnectionManager;

public class UserDao {
	
	public 	User landing(String uname) {
		User u=new User();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user where uname = ? ");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int uid = rs.getInt("uid");
				String uName = rs.getString("uname");				
				String upsw = rs.getString("upsw");			
				 u = new User(uid, uName, upsw);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
}
	


