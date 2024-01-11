package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

public class ToProductUpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 从请求参数中获取要更新的产品的ID
		String id = req.getParameter("id");

		// 根据产品ID检索该产品的详细信息
		EASYBUY_PRODUCT p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(id));

		// 将产品详情设置为请求的属性
		req.setAttribute("p", p);

		// 检索所有父级产品分类，以提供修改选项
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		req.setAttribute("flist", flist);

		// 检索所有子级产品分类，以提供修改选项
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		req.setAttribute("clist", clist);

		// 将请求和响应转发到"product-modify.jsp"页面进行渲染
		req.getRequestDispatcher("product-modify.jsp").forward(req, resp);
	}
}
