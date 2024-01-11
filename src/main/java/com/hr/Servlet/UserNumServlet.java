package com.hr.Servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserNumServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 定义验证码图片的宽度和高度
		int width = 120;
		int height = 60;

		// 创建BufferedImage对象，表示验证码图片
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = img.createGraphics();

		// 设置背景色为浅灰色
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, width, height);

		// 画干扰线，颜色为黄色
		g.setColor(Color.YELLOW);
		Random rand = new Random();
		for (int i = 0; i < 15; i++) {
			int x1 = rand.nextInt(width);
			int y1 = rand.nextInt(height);
			int x2 = rand.nextInt(width);
			int y2 = rand.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}

		// 设置字体，颜色为随机生成的RGB颜色
		Font f = new Font("Times New Roman", Font.BOLD, 50);
		g.setFont(f);
		int red = 0, green = 0, blue = 0;
		String code = "";

		// 随机生成4个数字，拼接成验证码
		for (int i = 0; i < 4; i++) {
			red = rand.nextInt(255);
			green = rand.nextInt(255);
			blue = rand.nextInt(255);

			Color c = new Color(red, green, blue);
			g.setColor(c);

			int num = rand.nextInt(10);
			code += num;
			g.drawString(num + "", i * 20 + 20, 49);
		}

		// 将生成的验证码存入Session
		HttpSession session = req.getSession();
		session.setAttribute("syscode", code);

		// 获取输出流，将验证码图片输出到客户端
		ServletOutputStream out = resp.getOutputStream();
		ImageIO.write(img, "jpg", out);
	}
}
