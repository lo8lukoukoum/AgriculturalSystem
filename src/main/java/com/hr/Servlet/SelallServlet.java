package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.entity.EASYBUY_USER;
import com.hr.entity.EASYBUY_COMMENT;

/**
 * Servlet implementation class SelallServlet
 * 查询所有评论 Servlet
 */
public class SelallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 处理查询所有评论请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int page = 1; // 当前页数
		int pageSize = 6; // 每页行数
		String spage = request.getParameter("page");

		// 获取一级分类和二级分类列表
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		request.setAttribute("flist", flist);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		request.setAttribute("clist", clist);

		if (spage != null) { // 如果页面上传递了页数,将当前页数改变掉
			page = Integer.parseInt(spage);
		}

		// 查出总页数
		ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selPage(page, pageSize);
		int maxPage = EASYBUY_COMMENTDao.getMax(pageSize);

		// 如果有评论数据并且总页数大于0
		if (list.size() > 0 && maxPage > 0) {
			request.setAttribute("list", list);
			// 把总页数传递给guestbook.jsp 使用
			request.setAttribute("max_page", maxPage);
			// 把当前页数传递给guestbook.jsp使用
			request.setAttribute("page", page);
			// 跳转到guestbook.jsp
			request.getRequestDispatcher("guestbook.jsp").forward(request, response);
		} else {
			request.setAttribute("list", list);
			// 把总页数传递给guestbook.jsp 使用
			request.setAttribute("max_page", maxPage);
			// 把当前页数传递给guestbook.jsp使用
			request.setAttribute("page", page);
			// 跳转到guestbook.jsp
			request.getRequestDispatcher("guestbook.jsp").forward(request, response);
		}
	}
}
