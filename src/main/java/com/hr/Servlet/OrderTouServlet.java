package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_DDDao;
import com.hr.dao.EASYBUY_ORDERDao;
import com.hr.entity.EASYBUY_DD;
import com.hr.entity.EASYBUY_ORDER;

/**
 * Servlet implementation class OrderTouServlet
 * �������� Servlet
 */
public class OrderTouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderTouServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * ��������������
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����ID����
		String orderId = request.getParameter("id");

		// ���� DAO ���ȡ�����Ͷ���������Ϣ
		EASYBUY_ORDER order = EASYBUY_ORDERDao.selectById(Integer.parseInt(orderId));
		ArrayList<EASYBUY_DD> ddList = EASYBUY_DDDao.selectById(Integer.parseInt(orderId));

		// ������������Ϣ���õ�����������
		request.setAttribute("dlist", ddList);
		request.setAttribute("order", order);

		// ת������ order-modify.jsp ҳ��
		request.getRequestDispatcher("order-modify.jsp").forward(request, response);
	}
}
