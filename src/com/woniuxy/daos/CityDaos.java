package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.City;
import com.woniuxy.tools.ConnectionManager;

public class CityDaos {
	
	public List<City> getAllCity(int pid) throws SQLException{
		Connection conn=null;
		List<City> list=new ArrayList<City>();
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from city where pid=?");
		ps.setInt(1, pid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int cid=rs.getInt("cid");
			int cnum=rs.getInt("cnum");
			String cname=rs.getString("cname");
			int Pid=rs.getInt("pid");
			City ct=new City(cid, cnum, cname, Pid);
			list.add(ct);
		}
		
		}finally{
			ConnectionManager.closeConnection(conn);
		}
		return list;
	}

}
