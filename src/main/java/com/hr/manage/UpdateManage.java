package com.hr.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class UpdateManage extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求和响应的字符编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 从请求中获取留言的id
		int id = Integer.parseInt(request.getParameter("id"));

		// 调用 EASYBUY_COMMENTDao 类的 selOne 方法查询指定id的留言信息
		EASYBUY_COMMENT comment = EASYBUY_COMMENTDao.selOne(id);

		if (comment != null) {
			// 将查询结果传递给 guestbook-modify.jsp 页面进行显示
			request.setAttribute("list", comment);
			request.getRequestDispatcher("guestbook-modify.jsp").forward(request, response);
		} else {
			response.getWriter().print("<script>alert('查询失败！');history.back();</script>");
		}
	}
}
