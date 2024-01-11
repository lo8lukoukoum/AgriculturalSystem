package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class DoProductAddServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 创建 SmartUpload 对象
		SmartUpload su = new SmartUpload();

		// 初始化 SmartUpload 对象
		su.initialize(this.getServletConfig(), req, resp);

		try {
			// 上传文件
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		// 获取上传的文件
		Files fs = su.getFiles();
		File f = fs.getFile(0);
		String fname = f.getFileName();

		try {
			// 保存文件到指定位置
			su.save("images/product");
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		// 获取请求参数
		Request req1 = su.getRequest();
		String pname = req1.getParameter("productName");
		String id = req1.getParameter("parentId");
		String price = req1.getParameter("productPrice");
		String desc = req1.getParameter("productDesc");
		String stock = req1.getParameter("productStock");

		EASYBUY_PRODUCT p = null;
		if (price != null && stock != null && id != null) {
			// 创建商品对象
			p = new EASYBUY_PRODUCT(0, pname, desc,
					Integer.parseInt(price),
					Integer.parseInt(stock),
					Integer.parseInt(id.split("-")[0]),
					Integer.parseInt(id.split("-")[1]),
					fname);
		}

		int count = 0;
		if (p != null) {
			// 插入商品记录
			count = EASYBUY_PRODUCTDao.insert(p);
		}

		// 重定向到商品查询页面
		req.getRequestDispatcher("productSelect").forward(req, resp);
	}
}
