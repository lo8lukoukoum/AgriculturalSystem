package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

/**
 * �������Ÿ��µ�Servlet
 */
public class NewsUpdServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ��ȡ�����е�����ID
		String id = req.getParameter("id");

		// ͨ������ID�����ݿ��л�ȡ��Ӧ��������Ϣ
		EASYBUY_NEWS news = EASYBUY_NEWSDao.selectById(Integer.parseInt(id));

		// ����ȡ��������Ϣ���õ����������У��Ա���JSPҳ����ʹ��
		req.setAttribute("news", news);

		// ת������news-modify.jspҳ����������޸�
		req.getRequestDispatcher("news-modify.jsp").forward(req, resp);
	}
}
