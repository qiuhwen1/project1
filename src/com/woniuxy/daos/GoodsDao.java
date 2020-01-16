package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.woniuxy.entitys.Goods;
import com.woniuxy.entitys.OutStock;
import com.woniuxy.tools.ConnectionManager;

public class GoodsDao {
	public List<Goods> getAll() {
		List<Goods> list=new ArrayList<Goods>();
		Connection conn=null;		
		try {
			conn=ConnectionManager.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from goods");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int gId=rs.getInt("gid");
				int gnid=rs.getInt("gnid");
				String gname=rs.getString("gname");
				int cnid=rs.getInt("cnid");
				int pnid=rs.getInt("pnid");
				Date days=rs.getDate("days");
				double price=rs.getDouble("price");
				int quality=rs.getInt("quality");
				int model=rs.getInt("model");
				String info=rs.getString("info");
				int inventory=rs.getInt("inventory");
				String status=rs.getString("status");
				Goods g=new Goods(gId, gnid, gname, cnid, pnid, days, price, quality, model, info, inventory, status);
				list.add(g);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{			
			ConnectionManager.closeConnection(conn);			
		}
		
	}
	//增加
	public void addGoods(Goods g) throws SQLException{
		Connection conn=null;
		try {
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into goods(gid,gnid,gname,cnid,pnid,days,price,quality,model,info,inventory,status)"
				+ "value(?,?,?,?,?,now(),?,?,?,?,?,'未确认')");
		ps.setInt(1, g.getGid());
		ps.setInt(2, g.getGnid());
		ps.setString(3, g.getGname());
		ps.setInt(4, g.getCnid());
		ps.setInt(5, g.getPnid());
		
		ps.setDouble(6, g.getPrice());
		ps.setInt(7, g.getQuality());
		ps.setInt(8, g.getModel());
		ps.setString(9, g.getInfo());
		ps.setInt(10, g.getInventory());
		ps.executeUpdate();
		} 
		finally{			
			ConnectionManager.closeConnection(conn);			
		}
	}
	//删除
	public void deleteGoodsById(int gid) throws SQLException{
		Connection conn=null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("delete from goods where gid=?");
		ps.setInt(1, gid);
		ps.executeUpdate();
		}
		finally{			
			ConnectionManager.closeConnection(conn);			
		}
	}
	//确认按钮
		public void confirmGoods(int gid) throws SQLException {
			// TODO Auto-generated method stub
			
			Connection conn=null;
			try {
				conn=ConnectionManager.getConnection();
				//对状态进行修改
				PreparedStatement ps=conn.prepareStatement("update goods set status='已确认' where gid=?");
				ps.setInt(1, gid);
				ps.executeUpdate();
							
			} 
			finally{			
				ConnectionManager.closeConnection(conn);			
			}
		}
	//修改
	public Goods updateGoodsbyId(int gid) throws SQLException{
		Connection conn=null;
		Goods g=null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from goods where gid=?");
		ps.setInt(1, gid);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			int gId=rs.getInt("gid");
			int gnid=rs.getInt("gnid");
			String gname=rs.getString("gname");
			int cnid=rs.getInt("cnid");
			int pnid=rs.getInt("pnid");
			Date days=rs.getDate("days");
			double price=rs.getDouble("price");
			int quality=rs.getInt("quality");
			int model=rs.getInt("model");
			String info=rs.getString("info");
			int inventory=rs.getInt("inventory");
			String status=rs.getString("status");
			g=new Goods(gId, gnid, gname, cnid, pnid, days, price, quality, model, info, inventory, status);
			
		}						
		return g;
	}
	finally{
		ConnectionManager.closeConnection(conn);
	}
	
	}
	public void updateGoods(Goods g) throws SQLException{
		Connection conn=null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("update goods set gname=?,pnid=?,price=?,info=?,gnid=? where gid=?");
		ps.setString(1, g.getGname());
		ps.setInt(2, g.getPnid());
		ps.setDouble(3, g.getPrice());
		ps.setString(4, g.getInfo());
		ps.setInt(5, g.getGnid());
		ps.setInt(6, g.getGid());
		ps.executeUpdate();
		}
		finally{
			ConnectionManager.closeConnection(conn);
		}
	}
	// 查询
		public List<Goods> getAllGoods(String gnid, String gname) throws SQLException {
			List<Goods> list = new ArrayList<Goods>();
			Connection conn = null;
			try {
				conn = ConnectionManager.getConnection();
				String sql = "select gid,gnid,gname,cnid,pnid,days,price,quality,model,info,inventory,status from goods where 1=1";
						
				if (gnid != null && !gnid.equals("")) {
					sql = sql + " and gnid like ?";
				}
				if (gname != null && !gname.equals("")) {
					sql = sql + " and gname like ?";
				}
				if (gnid == null || gname == null) {
					gnid = "";
					gname = "";
				}
				PreparedStatement ps = conn.prepareStatement(sql);
				int count = 0;
				if (gnid != null && !gnid.equals("")) {
					count++;
					ps.setString(count, "%" + gnid + "%");
				}
				if (gname != null && !gname.equals("")) {
					count++;
					ps.setString(count, "%" + gname + "%");
				}
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int gid=rs.getInt("gid");
					int gNid=rs.getInt("gnid");
					String gName=rs.getString("gname");
					int cnid=rs.getInt("cnid");
					int pnid=rs.getInt("pnid");
					Date days=rs.getDate("days");
					double price=rs.getDouble("price");
					int quality=rs.getInt("quality");
					int model=rs.getInt("model");
					String info=rs.getString("info");
					int inventory=rs.getInt("inventory");
					String status=rs.getString("status");
					Goods g=new Goods(gid, gNid, gName, cnid, pnid, days, price, quality, model, info, inventory, status);
					list.add(g);
					System.out.println("dao方法");
				}
				return list;
			} finally {
				ConnectionManager.closeConnection(conn);
			}
		}
}
