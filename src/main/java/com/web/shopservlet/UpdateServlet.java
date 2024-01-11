package com.web.shopservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.ESDao;
import com.hr.entity.eb_shop;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// ��ȡ�������
		String str1 = request.getParameter("pid");
		String str2 = request.getParameter("action");
		String str3 = request.getParameter("getvalue");

		// ���ݶ�������ִ����Ӧ�Ĳ���
		if (str2.equals("jia")) {
			// ���ﳵ������1
			int count = ESDao.updateJia(Integer.parseInt(str1));
		}
		if (str2.equals("jian")) {
			// ���ﳵ������1
			int count = ESDao.updateJian(Integer.parseInt(str1));
		}
		if (str2.equals("closeText")) {
			// �޸Ĺ��ﳵ��Ʒ״̬Ϊ�ر�
			eb_shop es = new eb_shop(Integer.parseInt(str1), "1", "1", 1, Integer.parseInt(str3), 1, 1, "1", 1);
			int count = ESDao.updateClose(es);
		}
		if (str2.equals("delText")) {
			// ɾ�����ﳵ��Ʒ
			int count = ESDao.getDeleteDD(Integer.parseInt(str1));
		}

		// �ض��򵽹��ﳵҳ��
		response.sendRedirect("ShopSelect");
	}
}
