package com.woniuxy.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.interfaces.PBEKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.daos.GoodsDao;
import com.woniuxy.daos.OutStockServletsDao;
import com.woniuxy.entitys.Goods;
import com.woniuxy.entitys.OutStock;
import com.woniuxy.entitys.PageBean;


public class OutStockServlets extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=req.getServletPath();
		System.out.println("path:"+path);
		//展示所有出库信息
		 if(path.equals("/outs.do")){
			req.setCharacterEncoding("UTF-8");
			String osnum=req.getParameter("osnum");
			String gname=req.getParameter("gname");
			System.out.println("osnum:"+osnum);
			 System.out.println("gname:"+gname);
			OutStockServletsDao osd=new OutStockServletsDao();
			try {
				
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("osnum", osnum);
				map.put("gname", gname);
				//分页处理
				PageBean<OutStock> pb=new  PageBean<OutStock>();
				int totalCount=osd.getTotalCount(osnum, gname);
				//设置总行数
				pb.setTotalCount(totalCount);
				//设置每页显示的条目数
				String tempPageSize=req.getParameter("pageSize");
				int pageSize=3;
				if(tempPageSize!=null){			
					pageSize=Integer.parseInt(tempPageSize);
				}
				pb.setPageSize(pageSize);
				//设置当前页数
				int currentPage=1;
				String temeCurrenPage=req.getParameter("currentPage");
				if(temeCurrenPage!=null){
					currentPage=Integer.parseInt(tempPageSize);
				}
				if(currentPage<1){
					currentPage=1;
				}
				if(currentPage>pb.getPages()){
					currentPage=pb.getPages();
					if(pb.getPages()==0){
						currentPage=1;
					}
				}
				pb.setCurrentPage(currentPage);
				//设置总页数
				//设置每页显示的数据
				List<OutStock> list=osd.getAllOutStock(osnum, gname,pb);		
				pb.setData(list);
				
				
				req.setAttribute("map", map);
				req.setAttribute("pb", pb);
				req.getRequestDispatcher("/outStock/outStock.jsp").forward(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//增加出库
		 else if(path.equals("/outsadd.do")){
			req.setCharacterEncoding("UTF-8");
			String osnum=req.getParameter("osnum");
			String oscount=req.getParameter("oscount");
			String gid=req.getParameter("gid");
			String uid=req.getParameter("uid");
			String osinfo=req.getParameter("osinfo");
			OutStock os=new OutStock(Integer.parseInt(osnum), Integer.parseInt(oscount), Integer.parseInt(gid), Integer.parseInt(uid), osinfo);
			OutStockServletsDao osd=new OutStockServletsDao();
			try {
				osd.addOutStock(os);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("outs.do");
		}
		//删除操作
		else if(path.equals("/outsdelete.do")){
			String osid=req.getParameter("osid");
			OutStockServletsDao osd=new OutStockServletsDao();
			try {
				osd.deleteOutStockById(Integer.parseInt(osid));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("outs.do");
		}
		//确认操作
		else if(path.equals("/outsconfirm.do")){
			String osid=req.getParameter("osid");
			String gid=req.getParameter("gid");
			String oscount=req.getParameter("oscount");
			OutStock os=new OutStock(Integer.parseInt(osid), Integer.parseInt(oscount), Integer.parseInt(gid));
			OutStockServletsDao osd=new OutStockServletsDao();
			try {
				osd.confirmOutStock(os);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("outs.do");
		}
		//修改操作
		else if(path.equals("/outsupDatebyId.do")){
			req.setCharacterEncoding("UTF-8");
			String osid=req.getParameter("osId");
			OutStockServletsDao osd=new OutStockServletsDao();
			GoodsDao gd=new GoodsDao();
			try {
				OutStock os=osd.updateOutStockById(Integer.parseInt(osid));
				List<Goods> list=gd.getAll();
				req.setAttribute("outStock", os);
				req.setAttribute("goods", list);
				req.getRequestDispatcher("/outStock/upDate.jsp").forward(req, resp);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else if(path.equals("/outsupDate.do")){
			req.setCharacterEncoding("UTF-8");
			String osid=req.getParameter("osid");
			String osnum=req.getParameter("osnum");
			String oscount=req.getParameter("oscount");
			String gid=req.getParameter("gId");
			String osinfo=req.getParameter("osinfo");
			OutStockServletsDao osd=new OutStockServletsDao();
			OutStock os=new OutStock(Integer.parseInt(osid), Integer.parseInt(osnum), Integer.parseInt(oscount), Integer.parseInt(gid), osinfo);
			try {
				osd.upDateOutStock(os);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("outs.do");
		}
	
	}
}
