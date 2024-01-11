package com.hr.manage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class UpManage extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求和响应的字符编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 从请求中获取更新留言所需的信息
		int id = Integer.parseInt(request.getParameter("orderId"));
		String name = request.getParameter("name");
		String replyContent = request.getParameter("replyContent");
		String content = request.getParameter("Content");

		// 获取当前时间并格式化
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String replyTime = sdf.format(date);

		// 创建 EASYBUY_COMMENT 对象并设置属性
		EASYBUY_COMMENT comment = new EASYBUY_COMMENT(id, content, replyTime, replyContent, replyTime, name);
		comment.setEC_ID(id);

		// 调用 EASYBUY_COMMENTDao 类的 update 方法更新留言信息
		int num = EASYBUY_COMMENTDao.update(comment);

		if (num > 0) {
			// 更新成功，重定向到 manage-result.jsp 页面
			response.sendRedirect("manage-result.jsp");
		} else {
			// 更新失败，弹出提示框并返回上一页
			response.getWriter().print("<script>alert('更新失败！');history.back();</script>");
		}
	}
}
