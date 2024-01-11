package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_USER;
import com.hr.entity.eb_shop;

/**
 * Servlet implementation class ShopAddServlet
 * 添加商品到购物车的 Servlet
 */
public class ShopAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 处理添加商品到购物车的请求
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取商品ID和购买数量
		String pid = req.getParameter("id");
		String count = req.getParameter("count");
		if (pid != null) {
			EASYBUY_PRODUCT p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(pid));

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			HttpSession session = req.getSession();
			EASYBUY_USER user = (EASYBUY_USER) session.getAttribute("name");

			// 判断用户是否登录
			if (user != null) {
				// 获取用户ID
				String uid = user.getEU_USER_ID();
				int valid = 1;

				// 构建购物车对象
				eb_shop sp = new eb_shop(0, p.getEP_FILE_NAME(), p.getEP_NAME(), p.getEP_PRICE(),
						Integer.parseInt(count), p.getEP_STOCK(), p.getEP_ID(), uid, valid);

				// 插入购物车记录
				ESDao.insert(sp);

				// 重定向到购物车页面
				resp.sendRedirect("ShopSelect");
			} else {
				// 用户未登录，提示登录
				out.print("<script>");
				out.print("alert('请先登录');");
				out.print("location.href='login.jsp';");
				out.print("</script>");
				out.close();
				return;
			}
		}
	}
}
