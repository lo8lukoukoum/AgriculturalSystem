package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;

/**
 * Servlet implementation class RegisterInServlet
 * 用户注册 Servlet
 */
public class RegisterInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 处理用户注册请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String rePassWord = request.getParameter("rePassWord");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String veryCode = request.getParameter("veryCode");

		HttpSession session = request.getSession();
		// 获得系统生成的验证码
		String sysCode = (String) session.getAttribute("syscode");

		// 创建用户对象
		EASYBUY_USER user = new EASYBUY_USER(username, name, rePassWord, sex, year, null, email, mobile, address, 1);

		// 插入用户数据
		int count = EASYBUY_USERDao.insert(user);
		PrintWriter out = response.getWriter();

		// 验证码正确，注册成功
		if (sysCode.equals(veryCode)) {
			if (count > 0) {
				response.sendRedirect("reg-result.jsp");
			} else {
				out.write("<script>");
				out.write("alert('register error');");
				out.write("location.href='register.jsp'");
				out.write("</script>");
				out.close();
			}
		}
	}
}
