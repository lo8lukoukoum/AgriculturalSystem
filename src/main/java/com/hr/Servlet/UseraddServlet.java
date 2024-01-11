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
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UseraddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 编码处理，防止中文乱码
		EncodeUtil.encode(req);

		// 设置响应的内容类型及编码
		resp.setContentType("text/html;charset=utf-8");

		// 从请求中获取用户提交的信息
		String username = req.getParameter("userName");
		String name = req.getParameter("name");
		String pwd = req.getParameter("passWord");
		String sex = req.getParameter("sex");
		String year = req.getParameter("birthday");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");

		// 创建用户对象
		EASYBUY_USER u = new EASYBUY_USER(username, name, pwd, sex, year, null, email, mobile, address, 1);

		// 调用DAO层的方法插入用户信息
		int count = EASYBUY_USERDao.insert(u);

		// 获取响应输出流
		PrintWriter out = resp.getWriter();

		// 根据插入结果进行响应处理
		if (count > 0) {
			// 插入成功，重定向到结果页面
			resp.sendRedirect("manage-result.jsp");
		} else {
			// 插入失败，通过脚本弹窗提示用户，并返回添加用户页面
			out.write("<script>");
			out.write("alert('添加失败');");
			out.write("location.href='user-add.jsp'");
			out.write("</script>");
			out.close();
		}
	}
}
