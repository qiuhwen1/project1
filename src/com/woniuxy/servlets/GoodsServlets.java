package com.woniuxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.woniuxy.daos.GoodsDao;
import com.woniuxy.entitys.Goods;

public class GoodsServlets extends HttpServlet{
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
		
		if(path.equals("/gds.do")){

			GoodsDao gd=new GoodsDao();
			List<Goods> list = gd.getAll();
			
			JSONArray js=new JSONArray(list);
			out.print(js);
			out.flush();
			out.close();
			
//			try {
//				List<Goods> list = gd.getAllGoods(gnid, gname);
//				Map<String,Object> map=new HashMap<String,Object>();
//				map.put("gnid", gnid);
//				map.put("gname", gname);
//				req.setAttribute("map", map);
//				req.setAttribute("goods", list);
//				RequestDispatcher re= req.getRequestDispatcher("goods.jsp");
//				re.forward(req, resp);
//				System.out.println("servlet·½·¨");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}
		else if(path.equals("/gdsAdd.do")){
			req.setCharacterEncoding("UTF-8");
			String gnid=req.getParameter("gnid");
			String gname=req.getParameter("gname");
			
			String price=req.getParameter("price");		
			String info=req.getParameter("info");
			Goods g=new Goods(Integer.parseInt(gnid), gname, Double.parseDouble(price), info);
			GoodsDao gd=new GoodsDao();
			try {
				gd.addGoods(g);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("goods/goods.html");
		}
		else if(path.equals("/gdsDel.do")){
			String gid=req.getParameter("gid");
			GoodsDao gd=new GoodsDao();
			try {
				gd.deleteGoodsById(Integer.parseInt(gid));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("goods/goods.html");
		}
		else if(path.equals("/gdsconfirm.do")){
			String gid=req.getParameter("gid");
			GoodsDao gd=new GoodsDao();
			try {
				gd.confirmGoods(Integer.parseInt(gid));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("gds.do");
		}
		else if(path.equals("/gdsUpById.do")){
			String gid=req.getParameter("gid");			
			GoodsDao gd=new GoodsDao();
			try {
				Goods g=gd.updateGoodsbyId(Integer.parseInt(gid));
				JSONObject js=new JSONObject(g);
				out.print(js);
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
		else if(path.equals("/gdsUpSave.do")){
			req.setCharacterEncoding("UTF-8");
			String gid=req.getParameter("gid");
			String gnid=req.getParameter("gnid");
			String gname=req.getParameter("gname");
		
			String price=req.getParameter("price");						
			String info=req.getParameter("info");
			GoodsDao gd=new GoodsDao();
			Goods g=new Goods(Integer.parseInt(gid),Integer.parseInt(gnid), gname, Double.parseDouble(price), info);
			try {
				gd.updateGoods(g);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("goods/goods.html");
		}
		
	}
}
