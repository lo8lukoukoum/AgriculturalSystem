package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserNumServlet extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// �������л�ȡ�û��������֤��
		String num = req.getParameter("num");

		// �� HttpSession �л�ȡϵͳ���ɵ���֤��
		HttpSession session = req.getSession();
		String sysCode = (String) session.getAttribute("syscode");

		// ��ȡ��Ӧ�����
		PrintWriter out = resp.getWriter();

		// ����û��������֤���Ƿ���ϵͳ���ɵ���֤��һ��
		if (sysCode.equals(num)) {
			// ��֤����ȷ����� "true"
			out.print("true");
		} else {
			// ��֤�벻��ȷ����� "false"
			out.print("false");
		}

		// �ر������
		out.close();
	}
}
