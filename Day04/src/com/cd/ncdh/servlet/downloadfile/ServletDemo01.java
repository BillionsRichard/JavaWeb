package com.cd.ncdh.servlet.downloadfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo01 extends HttpServlet {

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
		
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("√¿≈Æ.jpg", "utf-8"));
		FileInputStream fis = new FileInputStream(this.getServletContext().getRealPath("1.jpg"));
		OutputStream os = response.getOutputStream();
		
		byte [] bs = new byte[1024];
		int i=0;
		
		while((i=fis.read(bs)) != -1)
		{
			os.write(bs, 0, i);
		}
		
		fis.close();
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(URLEncoder.encode("ƒ„∫√.doc", "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String encodedString = "%E4%BD%A0%E5%A5%BD.doc";
		try {
			System.out.println(URLDecoder.decode(encodedString,"utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
