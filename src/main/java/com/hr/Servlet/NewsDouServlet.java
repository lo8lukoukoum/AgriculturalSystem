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

public class NewsDouServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EncodeUtil.encode(req);
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		// 创建新闻对象
		EASYBUY_NEWS news = new EASYBUY_NEWS(Integer.parseInt(id), title, content, null);

		// 调用 DAO 层的更新方法
		int count = EASYBUY_NEWSDao.update(news);

		if (count > 0) {
			// 更新成功，重定向到管理结果页面
			resp.sendRedirect("manage-result.jsp");
		} else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('修改失败');");
			out.print("location.href='newsselect'");
			out.print("</script>");
			out.close();
		}
	}
}
