package com.hr.manage;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class SelManage extends HttpServlet {

	// 处理客户端请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 设置请求和响应的字符编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		int page = 1; // 当前页数
		int pagesize = 6; // 每页行数

		// 从请求中获取页面上传递的页数
		String spage = req.getParameter("page");

		if (spage != null) { // 如果页面上传递了页数，将当前页数改变
			page = Integer.parseInt(spage);
		}

		// 调用 EASYBUY_COMMENTDao 类的 selPage 方法查询指定页数的留言列表
		ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selPage(page, pagesize);

		// 查询总页数
		int max_page = EASYBUY_COMMENTDao.getMax(pagesize);

		if (list.size() > 0 && max_page > 0) {
			// 将查询结果和相关信息传递给 guestbook.jsp 页面使用
			req.setAttribute("list", list);
			req.setAttribute("max_page", max_page);
			req.setAttribute("page", page);
			// 转发到 guestbook.jsp 页面
			req.getRequestDispatcher("guestbook.jsp").forward(req, resp);
		} else {
			resp.getWriter().print("还没有留言信息哦！");
		}
	}
}
