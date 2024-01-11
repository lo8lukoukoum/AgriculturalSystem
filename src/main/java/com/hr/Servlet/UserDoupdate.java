package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;

public class UserDoupdate extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 编码处理，防止中文乱码
		EncodeUtil.encode(req);

		// 设置响应的内容类型及编码
		resp.setContentType("text/html;charset=utf-8");

		// 从请求中获取用户信息
		String username = req.getParameter("userName");
		String name = req.getParameter("name");
		String pwd = req.getParameter("passWord");
		String sex = req.getParameter("sex");
		String birthday = req.getParameter("birthday");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		String userStatus = req.getParameter("userStatus");

		// 默认用户状态为1
		int status = 1;

		// 如果用户状态不为空，则解析用户状态
		if (userStatus != null && !"".equals(userStatus)) {
			status = Integer.parseInt(userStatus);
		}

		// 创建用户对象
		EASYBUY_USER user = new EASYBUY_USER(username, name, pwd, sex, birthday, null, email, mobile, address, status);

		// 调用DAO层的方法更新用户信息
		int count = EASYBUY_USERDao.update(user);

		// 根据更新结果进行响应处理
		if (count > 0) {
			// 更新成功，重定向到结果页面
			resp.sendRedirect("manage-result.jsp");
		} else {
			// 更新失败，通过脚本弹窗提示用户，并返回用户列表页面
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('修改失败');");
			out.print("location.href='user'");
			out.print("</script>");
			out.close();
		}
	}
}
