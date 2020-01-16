package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

import com.woniuxy.entitys.Category;
import com.woniuxy.entitys.Goods;
import com.woniuxy.entitys.OutStock;
import com.woniuxy.entitys.PageBean;
import com.woniuxy.tools.ConnectionManager;

public class CategoryDao {
	public List<Category> getAll() throws SQLException {
		List<Category> list=new ArrayList<Category>();
		Connection conn=null;		
		try {
			conn=ConnectionManager.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from category");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int cid=rs.getInt("cid");
				int cnid=rs.getInt("cnid");
				String cname=rs.getString("cname");
				String cstatus=rs.getString("cstatus");
				Category ca=new Category(cid, cnid, cname, cstatus);
				list.add(ca);
			}
			return list;
		} 
		finally{			
			ConnectionManager.closeConnection(conn);			
		}		
	}
	public void Categoryadd(Category ca) throws SQLException{
		Connection conn=null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into category(cnid,cname,cstatus)value(?,?,'未确认')");
		ps.setInt(1, ca.getCnid());
		ps.setString(2, ca.getCname());
		ps.executeUpdate();
		}
		finally{
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	public void deleteCategory(int cId) throws SQLException {
		Connection conn=null;
		conn=ConnectionManager.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from category where cid = ?");
			ps.setInt(1, cId);
			
			ps.executeUpdate();
			
		} finally{
			ConnectionManager.closeConnection(conn);
		}
		
	}
	//修改
	public Category updateById(int cid) throws SQLException{
		Connection conn=null;
		Category ca=null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from category where cid=?");
		ps.setInt(1, cid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			int cId=rs.getInt("cid");
			int cnid=rs.getInt("cnid");
			String cname=rs.getString("cname");
			String cstatus=rs.getString("cstatus");
			ca=new Category(cId, cnid, cname, cstatus);
		}
		return ca;			
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	public void updateCategory(Category ca) throws SQLException{
		Connection conn=null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("update category set cnid=?,cname=? where cid=?");
		ps.setInt(1, ca.getCnid());
		ps.setString(2, ca.getCname());		
		ps.setInt(3, ca.getCid());
		ps.executeUpdate();
		}
		finally{
			ConnectionManager.closeConnection(conn);
		}
	}
	//查询
	public List<Category> getAllCategory(String cnid, String cname) throws SQLException {
		List<Category> list = new ArrayList<Category>();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql = "select cid,cnid,cname,cstatus from category where 1=1";
					
			if (cnid != null && !cnid.equals("")) {
				sql = sql + " and cnid like ?";
			}
			if (cname != null && !cname.equals("")) {
				sql = sql + " and cname like ?";
			}
			if (cnid == null || cname == null) {
				cnid = "";
				cname = "";
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			int count = 0;
			if (cnid != null && !cnid.equals("")) {
				count++;
				ps.setString(count, "%" + cnid + "%");
			}
			if (cname != null && !cname.equals("")) {
				count++;
				ps.setString(count, "%" + cname + "%");
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int cid=rs.getInt("cid");			
				int cnId=rs.getInt("cnid");
				String cName=rs.getString("cname");
				String cstatus=rs.getString("cstatus");
				Category ca=new Category(cid, cnId, cName, cstatus);
				list.add(ca);
				System.out.println("dao方法");
			}
			return list;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	//确认
	public void confirmCategory(int cid) throws SQLException{
		Connection conn=null;
		try{
		conn=ConnectionManager.getConnection();
		PreparedStatement ps=conn.prepareStatement("update category set cstatus='已确认' where cid=?");
		ps.setInt(1, cid);
		ps.executeUpdate();
		}
		finally{
			ConnectionManager.closeConnection(conn);
		}
	}
	//分页查询
	public List<Category> getAllCategory(String cnid, String cname,PageBean<Category> pb) throws SQLException {
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql = "select cid,cnid,cname,cstatus from category where 1=1";
					
			if (cnid != null && !cnid.equals("")) {
				sql = sql + " and cnid like ?";
			}
			if (cname != null && !cname.equals("")) {
				sql = sql + " and cname like ?";
			}
			if (cnid == null || cname == null) {
				cnid = "";
				cname = "";
			}
			sql=sql+" limit ?,?";
			List<Category> list = new ArrayList<Category>();
			PreparedStatement ps = conn.prepareStatement(sql);
			int count = 0;
			if (cnid != null && !cnid.equals("")) {
				count++;
				ps.setString(count, "%" + cnid + "%");
			}
			if (cname != null && !cname.equals("")) {
				count++;
				ps.setString(count, "%" + cname + "%");
			}
			ps.setInt(count + 1, (pb.getCurrentPage() - 1) * pb.getPageSize());
			ps.setInt(count + 2, pb.getPageSize());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int cid=rs.getInt("cid");			
				int cnId=rs.getInt("cnid");
				String cName=rs.getString("cname");
				String cstatus=rs.getString("cstatus");
				Category ca=new Category(cid, cnId, cName, cstatus);
				list.add(ca);
			}
			return list;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	public int getTotalCount(String cnid, String cname) throws SQLException {
	
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql = "select count(cid) as tc from category where 1=1";
					
			if (cnid != null && !cnid.equals("")) {
				sql = sql + " and cnid like ?";
			}
			if (cname != null && !cname.equals("")) {
				sql = sql + " and cname like ?";
			}
			if (cnid == null || cname == null) {
				cnid = "";
				cname = "";
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			int count = 0;
			if (cnid != null && !cnid.equals("")) {
				count++;
				ps.setString(count, "%" + cnid + "%");
			}
			if (cname != null && !cname.equals("")) {
				count++;
				ps.setString(count, "%" + cname + "%");
			}
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("tc");
			}
			return 0;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
}
