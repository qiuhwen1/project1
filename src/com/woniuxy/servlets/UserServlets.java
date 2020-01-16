package com.woniuxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.woniuxy.daos.UserDao;
import com.woniuxy.entitys.User;

public class UserServlets extends HttpServlet{
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
		if(path.equals("/us.do")){
			req.setCharacterEncoding("utf-8");
			
			UserDao ud=new UserDao();		
			String uName=req.getParameter("uname");
			String uPsw=req.getParameter("upsw");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			
			if(uName.equals(ud.landing(uName).getUname()) && uPsw.equals(ud.landing(uName).getUpsw())){
//				HttpSession session=req.getSession();
//				session.setAttribute("uname", uName);
				
//				ServletContext context=req.getServletContext();
//				int count=0;
//				if(context.getAttribute("online")!=null){
//					count=(Integer)context.getAttribute("online");					
//				}	
//				count++;
//				context.setAttribute("online", count);
				System.out.println("true");
				out.print(true);
				
			}else{
				
				out.print(false);
			}
			out.flush();
			out.close();
		}
		else if(path.equals("/exit.do")){
			HttpSession session=req.getSession();
			session.removeAttribute("uname");
			ServletContext context=req.getServletContext();
			if(context!=null){
				int count=(Integer)context.getAttribute("online");
				count--;
				context.setAttribute("online", count);
			}
			resp.sendRedirect("landing.jsp");
		}
	}
}
