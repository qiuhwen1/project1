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
import com.woniuxy.entitys.PageBean;
import com.woniuxy.tools.ConnectionManager;

public class OutStockServletsDao {
	// 所有信息
	public List<OutStock> getAll() throws SQLException {
		List<OutStock> list = new ArrayList<OutStock>();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from outstock");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int osid = rs.getInt("osid");
				int osnum = rs.getInt("osnum");
				int oscount = rs.getInt("oscount");
				int gid = rs.getInt("gid");
				Date osdays = rs.getDate("osdays");
				String osstatus = rs.getString("osstatus");
				int uid = rs.getInt("uid");
				String osinfo = rs.getString("osinfo");
				OutStock ost = new OutStock(osid, osnum, oscount, gid, osdays, osstatus, uid, osinfo);
				list.add(ost);
			}
			return list;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	// 添加
	public void addOutStock(OutStock os) throws SQLException {

		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"insert into outstock(osnum,oscount,gid,osdays,osstatus,uid,osinfo)values(?,?,?,now(),'未确认',?,?)");
			ps.setInt(1, os.getOsnum());
			ps.setInt(2, os.getOscount());
			ps.setInt(3, os.getGid());
			ps.setInt(4, os.getUid());
			ps.setString(5, os.getOsinfo());
			ps.executeUpdate();

		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	// 删除
	public void deleteOutStockById(int osid) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			// ？占位符(预编译的statement接口)
			PreparedStatement ps = conn.prepareStatement("delete from outstock where osid=?");
			ps.setInt(1, osid);
			ps.executeUpdate();

		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	// 确认按钮
	public void confirmOutStock(OutStock os) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			// 对状态进行修改
			PreparedStatement ps = conn.prepareStatement("update outstock set osstatus='已确认' where osid=?");
			ps.setInt(1, os.getOsid());
			ps.executeUpdate();

			// 完成库存量的更改
			ps = conn.prepareStatement("update goods set inventory=inventory-? where gid=?");
			ps.setInt(1, os.getOscount());
			ps.setInt(2, os.getGid());
			ps.executeUpdate();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	// 修改
	public OutStock updateOutStockById(int osid) throws SQLException {
		// TODO Auto-generated method stub
		OutStock os = null;
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			// ？占位符(预编译的statement接口)
			PreparedStatement ps = conn.prepareStatement("select * from outstock where osid=?");
			ps.setInt(1, osid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int osId = rs.getInt("osid");
				int osnum = rs.getInt("osnum");
				int oscount = rs.getInt("oscount");
				int gid = rs.getInt("gid");
				Date osdays = rs.getDate("osdays");
				String osstatus = rs.getString("osstatus");
				int uid = rs.getInt("uid");
				String osinfo = rs.getString("osinfo");
				os = new OutStock(osId, osnum, oscount, gid, osdays, osstatus, uid, osinfo);
			}
			return os;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	public void upDateOutStock(OutStock os) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update outstock set osnum=?,oscount=?,gid=?,osinfo=? where osid=?");
			ps.setInt(1, os.getOsnum());
			ps.setInt(2, os.getOscount());
			ps.setInt(3, os.getGid());
			ps.setString(4, os.getOsinfo());
			ps.setInt(5, os.getOsid());
			ps.executeUpdate();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	// 查询
//	public List<OutStock> getAllOutStock(String osnum, String gname) throws SQLException {
//		List<OutStock> list = new ArrayList<OutStock>();
//		Connection conn = null;
//		try {
//			conn = ConnectionManager.getConnection();
//			String sql = "select osid,osnum,oscount,outstock.gid,osdays,osstatus,uid,osinfo,gname from outstock "
//					+ "left join goods on outstock.gid=goods.gid where 1=1";
//			if (osnum != null && !osnum.equals("")) {
//				sql = sql + " and osnum like ?";
//			}
//			if (gname != null && !gname.equals("")) {
//				sql = sql + " and gname like ?";
//			}
//			if (osnum == null || gname == null) {
//				osnum = "";
//				gname = "";
//			}
//			PreparedStatement ps = conn.prepareStatement(sql);
//			int count = 0;
//			if (osnum != null && !osnum.equals("")) {
//				count++;
//				ps.setString(count, "%" + osnum + "%");
//			}
//			if (gname != null && !gname.equals("")) {
//				count++;
//				ps.setString(count, "%" + gname + "%");
//			}
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				int osid = rs.getInt("osid");
//				int osNum = rs.getInt("osnum");
//				int oscount = rs.getInt("oscount");
//				int gid = rs.getInt("gid");
//				Date osdays = rs.getDate("osdays");
//				String osstatus = rs.getString("osstatus");
//				int uid = rs.getInt("uid");
//				String osinfo = rs.getString("osinfo");
//				String gName = rs.getString("gname");
//				Goods g = new Goods();
//				g.setGname(gName);
//				OutStock ost = new OutStock(osid, osNum, oscount, gid, osdays, osstatus, uid, osinfo);
//				list.add(ost);
//			}
//			return list;
//		} finally {
//			ConnectionManager.closeConnection(conn);
//		}
//	}

	// 分页
	public List<OutStock> getAllOutStock(String osnum, String gname, PageBean<OutStock> pb) throws SQLException {
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql = "select osid,osnum,oscount,outstock.gid,osdays,osstatus,uid,osinfo,gname from outstock "
					+ "left join goods on outstock.gid=goods.gid where 1=1";
			if (osnum != null && !osnum.equals("")) {
				sql = sql + " and osnum like ?";
			}
			if (gname != null && !gname.equals("")) {
				sql = sql + " and gname like ?";
			}
			if (osnum == null || gname == null) {
				osnum = "";
				gname = "";
			}
			sql=sql+" limit ?,?";
			List<OutStock> list = new ArrayList<OutStock>();
			PreparedStatement ps = conn.prepareStatement(sql);
			int count = 0;
			if (osnum != null && !osnum.equals("")) {
				count++;
				ps.setString(count, "%" + osnum + "%");
			}
			if (gname != null && !gname.equals("")) {
				count++;
				ps.setString(count, "%" + gname + "%");
			}
			ps.setInt(count + 1, (pb.getCurrentPage() - 1) * pb.getPageSize());
			ps.setInt(count + 2, pb.getPageSize());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int osid = rs.getInt("osid");
				int osNum = rs.getInt("osnum");
				int oscount = rs.getInt("oscount");
				int gid = rs.getInt("gid");
				Date osdays = rs.getDate("osdays");
				String osstatus = rs.getString("osstatus");
				int uid = rs.getInt("uid");
				String osinfo = rs.getString("osinfo");
				String gName = rs.getString("gname");
				Goods g = new Goods();
				g.setGname(gName);
				OutStock ost = new OutStock(osid, osNum, oscount, gid, osdays, osstatus, uid, osinfo);
				list.add(ost);
			}
			return list;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	public int getTotalCount(String osnum, String gname) throws SQLException {
		List<OutStock> list = new ArrayList<OutStock>();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql = "select count(osid) as 'tc' from outstock "
					+ "left join goods on outstock.gid=goods.gid where 1=1";
			if (osnum != null && !osnum.equals("")) {
				sql = sql + " and osnum like ?";
			}
			if (gname != null && !gname.equals("")) {
				sql = sql + " and gname like ?";
			}
			if (osnum == null || gname == null) {
				osnum = "";
				gname = "";
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			int count = 0;
			if (osnum != null && !osnum.equals("")) {
				count++;
				ps.setString(count, "%" + osnum + "%");
			}
			if (gname != null && !gname.equals("")) {
				count++;
				ps.setString(count, "%" + gname + "%");
			}
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("tc");
			}
			return 0;
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
}
