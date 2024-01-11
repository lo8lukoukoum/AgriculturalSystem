package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;

/**
 * Servlet implementation class ProductClassDelServlet
 * 商品分类删除 Servlet
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
	 * 处理商品分类删除请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从请求中获取要删除的商品分类的id
		int id = Integer.parseInt(request.getParameter("id"));

		// 调用商品分类数据库操作类的删除方法
		EASYBUY_PRODUCT_CATEGORYDao.del(id);

		// 重定向到商品分类列表页面
		response.sendRedirect("productClass");
	}
}
