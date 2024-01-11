package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;

/**
 * Servlet implementation class ProductClassDelServlet
 * ��Ʒ����ɾ�� Servlet
 */
public class ProductClassDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductClassDelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * ������Ʒ����ɾ������
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������л�ȡҪɾ������Ʒ�����id
		int id = Integer.parseInt(request.getParameter("id"));

		// ������Ʒ�������ݿ�������ɾ������
		EASYBUY_PRODUCT_CATEGORYDao.del(id);

		// �ض�����Ʒ�����б�ҳ��
		response.sendRedirect("productClass");
	}
}
