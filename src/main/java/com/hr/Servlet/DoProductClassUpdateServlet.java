package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

public class DoProductClassUpdateServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 对请求进行编码处理
		EncodeUtil.encode(req);

		// 获取分类的 ID、父级分类的 ID 和分类名称
		int id = Integer.parseInt(req.getParameter("id"));
		int fid = Integer.parseInt(req.getParameter("parentId"));
		String name = req.getParameter("className");

		// 创建商品分类对象
		EASYBUY_PRODUCT_CATEGORY pc;

		// 根据父级分类 ID 判断是更新一级分类还是更新子级分类
		if (fid == 0) {
			// 创建一级分类对象
			pc = new EASYBUY_PRODUCT_CATEGORY(id, name, id);
		} else {
			// 创建子级分类对象
			pc = new EASYBUY_PRODUCT_CATEGORY(id, name, fid);
		}

		// 调用 DAO 层的方法更新分类记录
		EASYBUY_PRODUCT_CATEGORYDao.update(pc);

		// 重定向到商品分类页面
		resp.sendRedirect("productClass");
	}
}
