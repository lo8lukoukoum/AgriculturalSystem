package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

public class ToProductClassUpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 从请求参数中提取产品分类的ID
		int id = Integer.parseInt(req.getParameter("id"));

		// 根据ID检索指定的产品分类详情
		EASYBUY_PRODUCT_CATEGORY epc = EASYBUY_PRODUCT_CATEGORYDao.selectById(id);

		// 将产品分类详情设置为请求的属性
		req.setAttribute("epc", epc);

		// 检索所有产品分类，以提供修改选项
		ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = EASYBUY_PRODUCT_CATEGORYDao.selectAll();
		req.setAttribute("epclist", epclist);

		// 将请求和响应转发到"productClass-modify.jsp"页面进行渲染
		req.getRequestDispatcher("productClass-modify.jsp").forward(req, resp);
	}
}
