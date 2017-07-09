package com.cd.ncdh.servlet.verifyImg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java_cup.internal.internal_error;

/**
 *  ������֤���Servlet
 *  
 * @author Administrator
 *
 */
public class ValiImage extends HttpServlet {

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
		//1�����ڴ��й���һ��ͼƬ
		int height = 30;
		int width = 120;
		BufferedImage bImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		//2����ȡͼ���ϵĻ���
		Graphics2D graphics = (Graphics2D) bImage.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, width, height);
		
		graphics.setColor(Color.black);
		graphics.drawRect(0, 0, width-1, height-1);
		
		graphics.setColor(Color.DARK_GRAY);
		
		//3�����������5��������.
		for(int i =0; i< 5 ; i++)
		{
			graphics.drawLine(randNum(0, width), randNum(0, height), 
					randNum(0, width), randNum(0, height));
		}
		
		//4��д��
		String zhChar = "������Ը��ū�������ǰ����ǵ�Ѫ��������" +
				"���µĳ����л����嵽����Σ�յ�ʱ����������һ��ð�ŵ��˵��ڻ�ǰ��ǰ��";
		
		graphics.setFont(new Font("΢���ź�",Font.ITALIC, 23));
		for(int i=0; i<4; i++)
		{
//			graphics.setColor(new Color(randNum(0, 255), randNum(0, 255), randNum(0, 255)));
			graphics.setColor(Color.BLUE);
			double degree = randNum(-45, 45) * 1.0 / 180 * Math.PI;
			int xOffset = 5 + i * 30;
			int yOffset = 24;
			graphics.rotate(degree, xOffset, yOffset);
//			graphics.drawString(zhChar.charAt(randNum(0, zhChar.length())) + "", 5 + i * 26, 24);
			graphics.drawString(zhChar.charAt(randNum(0, zhChar.length())) + "", 5 + i * 26, 24);
			graphics.rotate(-degree, xOffset, yOffset);
		}
		
		//3����ͼƬ����������
		ImageIO.write(bImage, "jpg", response.getOutputStream());
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

	private Random random = new Random();
	private int randNum(int begin, int end)
	{
		return random.nextInt(end - begin) + begin;
	}
}
