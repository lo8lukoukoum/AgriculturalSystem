package com.hr.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.dao.EASYBUY_COMMENTDao;

public class DelManage extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求和响应的字符编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 从请求中获取留言的id
		int id = Integer.parseInt(request.getParameter("id"));

		// 调用 EASYBUY_COMMENTDao 类的 del 方法删除留言
		int num = EASYBUY_COMMENTDao.del(id);

		// 根据删除结果进行页面跳转
		if (num > 0) {
			// 删除成功，重定向到 manage-result.jsp 页面
			response.sendRedirect("manage-result.jsp");
		} else {
			// 删除失败，弹出提示框并返回到上一页
			response.getWriter().print("<script>alert('删除失败!');history.back();</script>");
		}
	}
}
