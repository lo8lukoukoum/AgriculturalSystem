package com.hr.Servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_ORDERDao;
import com.hr.entity.EASYBUY_ORDER;
import com.hr.util.EncodeUtil;

/**
 * Servlet implementation class OrderSelServlet
 * ������ѯ Servlet
 */
public class OrderSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderSelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * ��������ѯ����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ʼ��Ĭ�Ϸ�ҳ��ÿҳ��ʾ����
		int cpage = 1;
		int count = 10;

		// ���봦��
		EncodeUtil.encode(request);

		// ��ȡ��ѯ����
		String cp = request.getParameter("cp");
		String orderId = request.getParameter("orderId");
		String userName = request.getParameter("userName");

		// ���������Ϊ�գ����ַ���תΪ��Ӧ������
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}

		// ���� DAO ���ȡ��ҳ���Ͷ����б�
		int totalPage = EASYBUY_ORDERDao.totalPage(count, orderId, userName);
		ArrayList<EASYBUY_ORDER> orderList = EASYBUY_ORDERDao.selectAll(cpage, count, orderId, userName);

		// ����ѯ������õ�����������
		request.setAttribute("order", orderList);
		request.setAttribute("cpage", cpage);
		request.setAttribute("tpage", totalPage);
		request.setAttribute("orderId", orderId);

		// ���û������� URL ���룬��ֹ��������
		request.setAttribute("userName", URLEncoder.encode(userName, "utf-8"));

		// ת������ order.jsp ҳ��
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}
}
