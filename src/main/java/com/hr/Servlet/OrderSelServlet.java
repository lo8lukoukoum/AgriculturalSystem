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
 * 订单查询 Servlet
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
	 * 处理订单查询请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 初始化默认分页和每页显示条数
		int cpage = 1;
		int count = 10;

		// 编码处理
		EncodeUtil.encode(request);

		// 获取查询参数
		String cp = request.getParameter("cp");
		String orderId = request.getParameter("orderId");
		String userName = request.getParameter("userName");

		// 如果参数不为空，则将字符串转为相应的数字
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}

		// 调用 DAO 层获取总页数和订单列表
		int totalPage = EASYBUY_ORDERDao.totalPage(count, orderId, userName);
		ArrayList<EASYBUY_ORDER> orderList = EASYBUY_ORDERDao.selectAll(cpage, count, orderId, userName);

		// 将查询结果设置到请求属性中
		request.setAttribute("order", orderList);
		request.setAttribute("cpage", cpage);
		request.setAttribute("tpage", totalPage);
		request.setAttribute("orderId", orderId);

		// 对用户名进行 URL 编码，防止中文乱码
		request.setAttribute("userName", URLEncoder.encode(userName, "utf-8"));

		// 转发请求到 order.jsp 页面
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}
}
