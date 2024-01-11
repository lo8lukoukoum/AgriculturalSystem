package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 默认当前页为第一页，每页显示15条记录
		int cpage = 1;
		int count = 15;

		// 获取页面传递的当前页参数
		String cp = req.getParameter("cp");
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}

		// 计算总页数
		int totalPage = EASYBUY_USERDao.totalPage(count);

		// 查询当前页的用户数据
		ArrayList<EASYBUY_USER> userList = EASYBUY_USERDao.selectAll(cpage, count);

		// 将查询结果存入request域中，供前端页面使用
		req.setAttribute("userlist", userList);
		req.setAttribute("cpage", cpage);
		req.setAttribute("tpage", totalPage);

		// 转发到用户管理页面
		req.getRequestDispatcher("user.jsp").forward(req, resp);
	}
}
