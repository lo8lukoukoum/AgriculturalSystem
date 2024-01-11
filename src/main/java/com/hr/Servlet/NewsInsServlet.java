package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.util.EncodeUtil;

public class NewsInsServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EncodeUtil.encode(req);

		// 从请求参数获取新闻标题和内容
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		// 创建新闻对象
		EASYBUY_NEWS news = new EASYBUY_NEWS(0, title, content, null);

		// 调用 DAO 层的插入方法
		int count = EASYBUY_NEWSDao.insert(news);

		if (count > 0) {
			// 插入成功，重定向到管理结果页面
			resp.sendRedirect("manage-result.jsp");
		} else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('添加失败');");
			out.print("location.href='news-add.jsp'");
			out.print("</script>");
			out.close();
		}
	}
}
