package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

/**
 * Servlet implementation class ProductClassAddServlet
 * ��Ʒ�������ҳ���ʼ�� Servlet
 */
public class ProductClassAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductClassAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * ������Ʒ�������ҳ���ʼ������
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����ݿ��ѯ������Ʒ��������
		ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = EASYBUY_PRODUCT_CATEGORYDao.selectAll();
		request.setAttribute("epclist", epclist);

		// ת������ productClass-add.jsp ҳ��
		request.getRequestDispatcher("productClass-add.jsp").forward(request, response);
	}
}
