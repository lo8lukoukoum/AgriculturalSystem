package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

/**
 * 处理新闻更新的Servlet
 */
public class NewsUpdServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取请求中的新闻ID
		String id = req.getParameter("id");

		// 通过新闻ID从数据库中获取对应的新闻信息
		EASYBUY_NEWS news = EASYBUY_NEWSDao.selectById(Integer.parseInt(id));

		// 将获取的新闻信息设置到请求属性中，以便在JSP页面中使用
		req.setAttribute("news", news);

		// 转发请求到news-modify.jsp页面进行新闻修改
		req.getRequestDispatcher("news-modify.jsp").forward(req, resp);
	}
}
