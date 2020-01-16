package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.Area;
import com.woniuxy.tools.ConnectionManager;

public class AreaDaos {
	public List<Area> getAllArea(int cid) throws SQLException{
		List<Area> list=new ArrayList<Area>();
		Connection conn= null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from area where cid=?");
		ps.setInt(1, cid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int aid=rs.getInt("aid");
			int anum=rs.getInt("anum");
			String aname=rs.getString("aname");
			int Cid=rs.getInt("cid");
			Area ar=new Area(aid, anum, aname, Cid);
			list.add(ar);
		}
		
		}finally{
			ConnectionManager.closeConnection(conn);
		}
		return list;
	}

}
