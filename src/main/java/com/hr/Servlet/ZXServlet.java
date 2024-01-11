package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ZXServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取当前会话
		HttpSession session = req.getSession();

		// 移除名为"name"的会话属性，即清除用户登录信息
		session.removeAttribute("name");

		// 重定向到首页
		resp.sendRedirect("indexSelect");
	}
}
