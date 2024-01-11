package com.web.shopservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.ESDao;
import com.hr.entity.eb_shop;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 获取请求参数
		String str1 = request.getParameter("pid");
		String str2 = request.getParameter("action");
		String str3 = request.getParameter("getvalue");

		// 根据动作类型执行相应的操作
		if (str2.equals("jia")) {
			// 购物车数量加1
			int count = ESDao.updateJia(Integer.parseInt(str1));
		}
		if (str2.equals("jian")) {
			// 购物车数量减1
			int count = ESDao.updateJian(Integer.parseInt(str1));
		}
		if (str2.equals("closeText")) {
			// 修改购物车商品状态为关闭
			eb_shop es = new eb_shop(Integer.parseInt(str1), "1", "1", 1, Integer.parseInt(str3), 1, 1, "1", 1);
			int count = ESDao.updateClose(es);
		}
		if (str2.equals("delText")) {
			// 删除购物车商品
			int count = ESDao.getDeleteDD(Integer.parseInt(str1));
		}

		// 重定向到购物车页面
		response.sendRedirect("ShopSelect");
	}
}
