package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

public class NewsSelectServlet2 extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id"); // 从请求参数中获取新闻ID
		EASYBUY_NEWS n = null;
		if (id != null) {
			// 根据新闻ID查询对应的新闻详情
			n = EASYBUY_NEWSDao.selectById(Integer.parseInt(id));
		}

		// 将查询到的新闻详情存放到请求属性中
		req.setAttribute("n", n);

		// 查询所有新闻列表
		ArrayList<EASYBUY_NEWS> nlist = EASYBUY_NEWSDao.selectAll();

		// 将新闻列表存放到请求属性中
		req.setAttribute("nlist", nlist);

		// 转发请求到 news-view.jsp 页面进行显示
		req.getRequestDispatcher("news-view.jsp").forward(req, resp);
	}
}
