package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;

public class UsernameCheckServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 编码处理，防止中文乱码
		EncodeUtil.encode(req);

		// 设置响应的内容类型及编码
		resp.setContentType("text/html;charset=utf-8");

		// 从请求中获取用户名
		String name = req.getParameter("name");

		// 调用DAO层的方法检查用户名是否已存在
		int count = EASYBUY_USERDao.selectByName(name);

		// 获取响应的输出流
		PrintWriter out = resp.getWriter();

		// 根据检查结果返回相应的提示信息
		if (count > 0) {
			// 用户名已存在，返回false
			out.print("false");
		} else {
			// 用户名可用，返回true
			out.print("true");
		}

		// 关闭输出流
		out.close();
	}
}
