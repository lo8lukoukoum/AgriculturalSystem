package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;

public class UsernameCheckServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ���봦����ֹ��������
		EncodeUtil.encode(req);

		// ������Ӧ���������ͼ�����
		resp.setContentType("text/html;charset=utf-8");

		// �������л�ȡ�û���
		String name = req.getParameter("name");

		// ����DAO��ķ�������û����Ƿ��Ѵ���
		int count = EASYBUY_USERDao.selectByName(name);

		// ��ȡ��Ӧ�������
		PrintWriter out = resp.getWriter();

		// ���ݼ����������Ӧ����ʾ��Ϣ
		if (count > 0) {
			// �û����Ѵ��ڣ�����false
			out.print("false");
		} else {
			// �û������ã�����true
			out.print("true");
		}

		// �ر������
		out.close();
	}
}
