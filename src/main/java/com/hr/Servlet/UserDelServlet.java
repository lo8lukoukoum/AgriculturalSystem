package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;

public class UserDelServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 编码处理，防止中文乱码
		EncodeUtil.encode(req);

		// 设置响应的内容类型及编码
		resp.setContentType("text/html;charset=utf-8");

		// 从请求中获取要删除的用户id
		String id = req.getParameter("id");

		// 获取响应输出流
		PrintWriter out = resp.getWriter();

		// 调用DAO层的方法删除用户信息
		int count = EASYBUY_USERDao.del(id);

		// 根据删除结果进行响应处理
		if (count > 0) {
			// 删除成功，重定向到结果页面
			resp.sendRedirect("manage-result.jsp");
		} else {
			// 删除失败，通过脚本弹窗提示用户，并返回用户列表页面
			out.write("<script>");
			out.write("alert('删除失败');");
			out.write("location.href='user.jsp'");
			out.write("</script>");
			out.close();
		}
	}
}
