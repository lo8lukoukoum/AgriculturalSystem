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
 * 商品查询 Servlet
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
	 * 处理商品查询请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cpage = 1; // 当前页数
		int count = 5; // 每页行数
		String cp = request.getParameter("cp");

		// 如果页面上传递了页数，将当前页数改变
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}

		// 查出总页数
		int totalPage = EASYBUY_PRODUCTDao.totalPage(count);

		// 查询当前页的商品列表
		ArrayList<EASYBUY_PRODUCT> productList = EASYBUY_PRODUCTDao.selectAll(cpage, count);

		// 设置请求属性，将数据传递到前端页面
		request.setAttribute("productList", productList);
		request.setAttribute("currentPage", cpage);
		request.setAttribute("totalPage", totalPage);

		// 转发请求到商品查询页面
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}
}
