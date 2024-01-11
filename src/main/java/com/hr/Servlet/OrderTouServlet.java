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
 * 订单详情 Servlet
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
	 * 处理订单详情请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取订单ID参数
		String orderId = request.getParameter("id");

		// 调用 DAO 层获取订单和订单详情信息
		EASYBUY_ORDER order = EASYBUY_ORDERDao.selectById(Integer.parseInt(orderId));
		ArrayList<EASYBUY_DD> ddList = EASYBUY_DDDao.selectById(Integer.parseInt(orderId));

		// 将订单详情信息设置到请求属性中
		request.setAttribute("dlist", ddList);
		request.setAttribute("order", order);

		// 转发请求到 order-modify.jsp 页面
		request.getRequestDispatcher("order-modify.jsp").forward(request, response);
	}
}
