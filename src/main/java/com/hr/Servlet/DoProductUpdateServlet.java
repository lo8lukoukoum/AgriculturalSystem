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

public class DoProductUpdateServlet extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 创建 SmartUpload 对象并进行初始化
		SmartUpload su = new SmartUpload();
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
		// 获取文件名
		String fname = f.getFileName();

		try {
			// 保存上传的图片到指定位置
			su.save("images/product");
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		// 获取请求参数
		Request req1 = su.getRequest();
		String id = req1.getParameter("id");
		String pname = req1.getParameter("productName");
		String pid = req1.getParameter("parentId");
		String price = req1.getParameter("productPrice");
		String desc = req1.getParameter("productDesc");
		String stock = req1.getParameter("productStock");

		// 创建商品对象
		EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(Integer.parseInt(id),
				pname,
				desc,
				Integer.parseInt(price),
				Integer.parseInt(stock),
				Integer.parseInt(pid.split("-")[0]),
				Integer.parseInt(pid.split("-")[1]),
				fname);

		int count = 0;
		if (p != null) {
			// 调用 DAO 层的方法更新商品记录
			count = EASYBUY_PRODUCTDao.update(p);
		}

		// 转发到商品查询页面
		req.getRequestDispatcher("productSelect").forward(req, resp);
	}
}
