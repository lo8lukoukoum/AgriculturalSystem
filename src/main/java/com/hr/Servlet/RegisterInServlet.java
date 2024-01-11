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
 * �û�ע�� Servlet
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
	 * �����û�ע������
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
		// ���ϵͳ���ɵ���֤��
		String sysCode = (String) session.getAttribute("syscode");

		// �����û�����
		EASYBUY_USER user = new EASYBUY_USER(username, name, rePassWord, sex, year, null, email, mobile, address, 1);

		// �����û�����
		int count = EASYBUY_USERDao.insert(user);
		PrintWriter out = response.getWriter();

		// ��֤����ȷ��ע��ɹ�
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
