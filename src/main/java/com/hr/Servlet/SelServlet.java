package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_COMMENT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

/**
 * Servlet implementation class SelServlet
 * 查询评论和商品分类的 Servlet
 */
public class SelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 处理查询评论和商品分类的请求
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//前台查询所有评论
		ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selectAll();

		//查询商品分类
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		req.setAttribute("flist", flist);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		req.setAttribute("clist", clist);

		//将查询结果存入 request，并转发到 guestbook.jsp 页面进行显示
		req.setAttribute("list", list);
		req.getRequestDispatcher("guestbook.jsp").forward(req, resp);
	}
}
