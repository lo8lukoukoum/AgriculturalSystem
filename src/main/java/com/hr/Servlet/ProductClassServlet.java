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
 * Servlet implementation class ProductClassServlet
 * 商品分类列表 Servlet
 */
public class ProductClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductClassServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 处理商品分类列表请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用商品分类数据库操作类的查询所有分类方法
		ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = EASYBUY_PRODUCT_CATEGORYDao.selectAll();

		// 将查询结果存储到 request 中
		request.setAttribute("epclist", epclist);

		// 转发请求到商品分类列表页面
		request.getRequestDispatcher("productClass.jsp").forward(request, response);
	}
}
