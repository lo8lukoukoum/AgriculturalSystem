package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;

public class CheckNameServlet extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// ��������б���
		EncodeUtil.encode(req);
		resp.setContentType("text/html;charset=utf-8");

		// �������л�ȡ�û���
		String name = req.getParameter("name");

		// ���� EASYBUY_USERDao ��� selectByName ������ѯ�û����Ƿ����
		int count = EASYBUY_USERDao.selectByName(name);

		// ��ȡ��Ӧ�����
		PrintWriter out = resp.getWriter();

		// ���ݲ�ѯ�����ͻ��������Ӧ����Ϣ
		if (count > 0) {
			// �û����Ѵ��ڣ���� "false"
			out.print("false");
		} else {
			// �û��������ڣ���� "true"
			out.print("true");
		}

		// �ر������
		out.close();
	}
}
