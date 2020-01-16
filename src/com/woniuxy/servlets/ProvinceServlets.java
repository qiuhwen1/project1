package com.woniuxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.woniuxy.daos.ProvinceDaos;
import com.woniuxy.entitys.Province;

/**
 * Servlet implementation class ProvinceServlets
 */

public class ProvinceServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProvinceDaos pd=new ProvinceDaos();
		try {
			List<Province> list=pd.getAllpro();
			 JSONArray proArray=new JSONArray(list);
			 response.setContentType("text/html;charset=utf-8");
			 PrintWriter out=response.getWriter();
			 out.print(proArray);
			 out.flush();
			 out.close();
			 System.out.println("Ê¡·Ý");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
