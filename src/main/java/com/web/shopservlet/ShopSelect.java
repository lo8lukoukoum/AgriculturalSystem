package com.web.shopservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.entity.eb_shop;
import com.hr.util.EncodeUtil;

public class ShopSelect extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EncodeUtil.encode(request);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		EASYBUY_USER user = (EASYBUY_USER) session.getAttribute("name");

		if (user != null) {
			// 用户已登录
			EASYBUY_USER eu = (EASYBUY_USER) session.getAttribute("name");
			String userId = eu.getEU_USER_ID();
			ArrayList<eb_shop> list = ESDao.getShop(userId);
			request.setAttribute("shoplist", list);
			request.getRequestDispatcher("shopping.jsp").forward(request, response);
		} else {
			// 用户未登录，弹窗提示并跳转到登录页面
			out.print("<script>");
			out.print("alert('请先登录');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
			out.close();
		}
	}
}
