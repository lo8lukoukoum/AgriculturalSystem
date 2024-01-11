package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

public class NewsselectServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int cpage = 1; // 当前页数，默认为第一页
		int count = 10; // 每页显示的新闻条数
		String cp = req.getParameter("cp"); // 获取请求参数中的当前页数
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}

		// 计算总页数
		int tpage = EASYBUY_NEWSDao.totalPage(count);

		// 查询当前页的新闻列表
		ArrayList<EASYBUY_NEWS> newslist = EASYBUY_NEWSDao.selectAll(cpage, count);

		// 将新闻列表和分页信息存放到请求属性中
		req.setAttribute("newslist", newslist);
		req.setAttribute("cpage", cpage);
		req.setAttribute("tpage", tpage);

		// 转发请求到 news.jsp 页面进行显示
		req.getRequestDispatcher("news.jsp").forward(req, resp);
	}
}
