package com.woniuxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.woniuxy.entitys.Category;
import com.woniuxy.entitys.OutStock;
import com.woniuxy.entitys.PageBean;
import com.woniuxy.daos.CategoryDao;

public class CategoryServlets extends HttpServlet{
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
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		if(path.equals("/ca.do")){
			
			CategoryDao cd=new CategoryDao();
			try {
				List<Category> list=cd.getAll();
				JSONArray l=new JSONArray(list);
				out.print(l);
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
//			req.setCharacterEncoding("UTF-8");
//			String cnid=req.getParameter("cnid");
//			String cname=req.getParameter("cname");
//			CategoryDao cd=new CategoryDao();			
//			try {
//				
//				Map<String,Object> map=new HashMap<String,Object>();
//				map.put("cnid", cnid);
//				map.put("cname", cname);
//				/**
//				 * 分页处理
//				 */
//				//设置总行数
//				PageBean<Category> pb=new PageBean<Category>();
//				int totalCount=cd.getTotalCount(cnid, cname);
//				pb.setTotalCount(totalCount);
//				//设置每页显示的行数
//				String tempPageSize=req.getParameter("pageSize");
//				int pageSize=5;
//				if(tempPageSize!=null){
//					pageSize=Integer.parseInt(tempPageSize);
//				}
//				pb.setPageSize(pageSize);
//				//设置当前页数
//				int currentPage=1;
//				String temeCurrenPage=req.getParameter("currentPage");
//				if(temeCurrenPage!=null){
//					currentPage=Integer.parseInt(tempPageSize);
//				}
//				if(currentPage<1){
//					currentPage=1;
//				}
//				if(currentPage>pb.getPages()){
//					currentPage=pb.getPages();
//					if(pb.getPages()==0){
//						currentPage=1;
//					}
//				}
//				pb.setCurrentPage(currentPage);
//				//设置每页显示的数据
//				List<Category> list=cd.getAllCategory(cnid, cname, pb);		
//				pb.setData(list);
//												
//				req.setAttribute("map", map);
//				req.setAttribute("pb", pb);
//				req.getRequestDispatcher("/category/category.jsp").forward(req, resp);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		else if(path.equals("/caAdd.do")){
			
			String cnid=req.getParameter("cnid");
			String cname=req.getParameter("cname");
			Category ca=new Category( Integer.parseInt(cnid), cname);
			CategoryDao cad=new CategoryDao();
			try {
				cad.Categoryadd(ca);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("category/category.html");
		}
		
		
		else if(path.equals("/caDel.do")){
			req.setCharacterEncoding("UTF-8");
			CategoryDao cad=new CategoryDao();
			
			String cId = req.getParameter("cid");
			try {
				cad.deleteCategory(Integer.parseInt(cId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("category/category.html");
		}
		else if(path.equals("/caUpbyId.do")){
			
			String cid=req.getParameter("cid");
			CategoryDao cad=new CategoryDao();
			try {
				Category ca=cad.updateById(Integer.parseInt(cid));
				JSONObject jo=new JSONObject(ca);
				out.print(jo);
				out.flush();
				out.close();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		else if(path.equals("/caUpSave.do")){
			String cid=req.getParameter("cid");
			String cnid=req.getParameter("cnid");
			String cname=req.getParameter("cname");
			Category ca=new Category(Integer.parseInt(cid), Integer.parseInt(cnid), cname);
			CategoryDao cad=new CategoryDao();
			try {
				cad.updateCategory(ca);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("category/category.html");
		}
		else if(path.equals("/caconfirm.do")){
			String cid=req.getParameter("cid");
			CategoryDao cad=new CategoryDao();
			try {
				cad.confirmCategory(Integer.parseInt(cid));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("ca.do");
		}
		
	}	
}
