package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.entity.EASYBUY_PRODUCT;

/**
 * Servlet implementation class ProductSelectServlet
 * ��Ʒ��ѯ Servlet
 */
public class ProductSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductSelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * ������Ʒ��ѯ����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cpage = 1; // ��ǰҳ��
		int count = 5; // ÿҳ����
		String cp = request.getParameter("cp");

		// ���ҳ���ϴ�����ҳ��������ǰҳ���ı�
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}

		// �����ҳ��
		int totalPage = EASYBUY_PRODUCTDao.totalPage(count);

		// ��ѯ��ǰҳ����Ʒ�б�
		ArrayList<EASYBUY_PRODUCT> productList = EASYBUY_PRODUCTDao.selectAll(cpage, count);

		// �����������ԣ������ݴ��ݵ�ǰ��ҳ��
		request.setAttribute("productList", productList);
		request.setAttribute("currentPage", cpage);
		request.setAttribute("totalPage", totalPage);

		// ת��������Ʒ��ѯҳ��
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}
}
