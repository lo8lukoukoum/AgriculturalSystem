package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserNumServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 从请求中获取用户输入的验证码
		String num = req.getParameter("num");

		// 从 HttpSession 中获取系统生成的验证码
		HttpSession session = req.getSession();
		String sysCode = (String) session.getAttribute("syscode");

		// 获取响应输出流
		PrintWriter out = resp.getWriter();

		// 检查用户输入的验证码是否与系统生成的验证码一致
		if (sysCode.equals(num)) {
			// 验证码正确，输出 "true"
			out.print("true");
		} else {
			// 验证码不正确，输出 "false"
			out.print("false");
		}

		// 关闭输出流
		out.close();
	}
}
