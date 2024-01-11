package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;

public class UserUpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置请求编码
		EncodeUtil.encode(req);
		// 设置响应内容类型及编码
		resp.setContentType("text/html;charset=utf-8");

		// 获取要修改用户的ID
		String id = req.getParameter("id");

		// 根据ID查询用户信息
		EASYBUY_USER user = EASYBUY_USERDao.selectById(id);

		// 将查询到的用户信息存入request域中，以便前端页面使用
		req.setAttribute("user", user);

		// 转发到用户信息修改页面
		req.getRequestDispatcher("user-modify.jsp").forward(req, resp);
	}
}
