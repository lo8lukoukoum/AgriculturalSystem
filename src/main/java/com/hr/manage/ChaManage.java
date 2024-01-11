package com.hr.manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class ChaManage extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 调用 EASYBUY_COMMENTDao 类的 selectAll 方法获取留言列表
		ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selectAll();

		// 将留言列表存储到请求属性中
		req.setAttribute("list", list);

		// 转发请求到 guestbook.jsp 页面
		req.getRequestDispatcher("guestbook.jsp").forward(req, resp);
	}
}
