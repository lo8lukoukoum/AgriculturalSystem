package com.hr.Servlet;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class GueServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 取值
		String guestName = request.getParameter("guestName");
		String guestContent = request.getParameter("guestContent");

		// 获取当前日期
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date).toString();

		// 创建留言对象
		EASYBUY_COMMENT comment = new EASYBUY_COMMENT(0, guestContent, time, "", null, guestName);

		// 调用 DAO 层的方法插入留言记录
		int num = EASYBUY_COMMENTDao.insert(comment);

		if (num > 0) {
			// 插入成功，重定向到留言查询页面
			response.sendRedirect("SelallServlet");
		} else {
			// 插入失败，弹出提示框，并返回上一页
			response.getWriter().print("<script>alert('添加失败！');history.back();</script>");
		}
	}
}
