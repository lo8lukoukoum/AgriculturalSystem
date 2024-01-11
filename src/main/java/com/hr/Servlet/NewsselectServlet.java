package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

public class NewsselectServlet extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int cpage = 1; // ��ǰҳ����Ĭ��Ϊ��һҳ
		int count = 10; // ÿҳ��ʾ����������
		String cp = req.getParameter("cp"); // ��ȡ��������еĵ�ǰҳ��
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}

		// ������ҳ��
		int tpage = EASYBUY_NEWSDao.totalPage(count);

		// ��ѯ��ǰҳ�������б�
		ArrayList<EASYBUY_NEWS> newslist = EASYBUY_NEWSDao.selectAll(cpage, count);

		// �������б�ͷ�ҳ��Ϣ��ŵ�����������
		req.setAttribute("newslist", newslist);
		req.setAttribute("cpage", cpage);
		req.setAttribute("tpage", tpage);

		// ת������ news.jsp ҳ�������ʾ
		req.getRequestDispatcher("news.jsp").forward(req, resp);
	}
}
