package com.cd.ncdh.web;

import java.io.*;
import javax.servlet.*;


public class FirstServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException
    //Called by the servlet container to allow the servlet to respond to a request. 
	{
		res.getWriter().write("hello servlet");
    }		  
}