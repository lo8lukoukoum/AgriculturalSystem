package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

public class NewsSelectServlet2 extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id"); // ����������л�ȡ����ID
		EASYBUY_NEWS n = null;
		if (id != null) {
			// ��������ID��ѯ��Ӧ����������
			n = EASYBUY_NEWSDao.selectById(Integer.parseInt(id));
		}

		// ����ѯ�������������ŵ�����������
		req.setAttribute("n", n);

		// ��ѯ���������б�
		ArrayList<EASYBUY_NEWS> nlist = EASYBUY_NEWSDao.selectAll();

		// �������б��ŵ�����������
		req.setAttribute("nlist", nlist);

		// ת������ news-view.jsp ҳ�������ʾ
		req.getRequestDispatcher("news-view.jsp").forward(req, resp);
	}
}
