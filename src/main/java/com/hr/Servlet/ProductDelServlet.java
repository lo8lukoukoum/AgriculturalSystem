package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCTDao;

/**
 * Servlet implementation class ProductDelServlet
 * ��Ʒɾ�� Servlet
 */
public class ProductDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * ������Ʒɾ������
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��������е���Ʒid
		String id = request.getParameter("id");

		// ������Ʒ���ݿ�������ɾ������������ɾ�����
		int count = EASYBUY_PRODUCTDao.del(Integer.parseInt(id));

		// ���ɾ���ɹ���������ת������Ʒ��ѯҳ�棬ʵ��ɾ�����ҳ��ˢ��
		if (count > 0) {
			request.getRequestDispatcher("productSelect").forward(request, response);
		}
	}
}
