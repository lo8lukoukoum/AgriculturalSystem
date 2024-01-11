package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

public class DoProductClassAddServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 对请求进行编码处理
		EncodeUtil.encode(req);

		// 获取父级分类的 ID
		int fid = Integer.parseInt(req.getParameter("parentId"));

		// 设置请求编码为 UTF-8
		req.setCharacterEncoding("utf-8");

		// 获取分类名称
		String name = req.getParameter("className");

		// 根据父级分类 ID 判断是添加一级分类还是添加子级分类
		if (fid == 0) {
			// 创建一级分类对象
			EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, name, 0);

			// 调用 DAO 层的方法插入一级分类记录
			EASYBUY_PRODUCT_CATEGORYDao.insertOnFather(pc);
		} else {
			// 创建子级分类对象
			EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, name, fid);

			// 调用 DAO 层的方法插入子级分类记录
			EASYBUY_PRODUCT_CATEGORYDao.insert(pc);
		}

		// 重定向到商品分类页面
		resp.sendRedirect("productClass");
	}
}
