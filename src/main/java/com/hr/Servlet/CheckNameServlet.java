package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;

public class CheckNameServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 对请求进行编码
		EncodeUtil.encode(req);
		resp.setContentType("text/html;charset=utf-8");

		// 从请求中获取用户名
		String name = req.getParameter("name");

		// 调用 EASYBUY_USERDao 类的 selectByName 方法查询用户名是否存在
		int count = EASYBUY_USERDao.selectByName(name);

		// 获取响应输出流
		PrintWriter out = resp.getWriter();

		// 根据查询结果向客户端输出相应的信息
		if (count > 0) {
			// 用户名已存在，输出 "false"
			out.print("false");
		} else {
			// 用户名不存在，输出 "true"
			out.print("true");
		}

		// 关闭输出流
		out.close();
	}
}
