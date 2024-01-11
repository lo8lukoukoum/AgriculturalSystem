package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCTDao;

/**
 * Servlet implementation class ProductDelServlet
 * 商品删除 Servlet
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
	 * 处理商品删除请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数中的商品id
		String id = request.getParameter("id");

		// 调用商品数据库操作类的删除方法，返回删除结果
		int count = EASYBUY_PRODUCTDao.del(Integer.parseInt(id));

		// 如果删除成功，将请求转发到商品查询页面，实现删除后的页面刷新
		if (count > 0) {
			request.getRequestDispatcher("productSelect").forward(request, response);
		}
	}
}
