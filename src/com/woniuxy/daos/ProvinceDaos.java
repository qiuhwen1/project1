package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.Province;
import com.woniuxy.tools.ConnectionManager;

public class ProvinceDaos {
	
	public List<Province> getAllpro() throws SQLException{
		List<Province> list=new ArrayList<Province>();
		Connection conn= null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from province");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int pid=rs.getInt("pid");
			int pnum=rs.getInt("pnum");
			String pname=rs.getString("pname");
			Province pv=new Province(pid, pnum, pname);
			list.add(pv);
		}
		return list;
		}finally{
			ConnectionManager.closeConnection(conn);
		}
	}
	
}
