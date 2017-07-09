package com.cd.ncdh.javaweb;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo extends HttpServlet {
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();
		String sName = config.getServletName();
		System.out.println(sName);
		
		String value = config.getInitParameter("para1");
		System.out.println(value);
		
		
		Enumeration ems = config.getInitParameterNames();
		while(ems.hasMoreElements())
		{
			String paraName = (String) ems.nextElement();
			String paraValue = config.getInitParameter(paraName);
			
			System.out.println(paraName + "---->" + paraValue);
		}
		
		ServletContext ctx = this.getServletContext();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
