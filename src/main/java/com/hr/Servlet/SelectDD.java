package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_DdanDao;
import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_Ddan;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

/**
 * Servlet implementation class SelectDD
 * 查询订单 Servlet
 */
public class SelectDD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 处理查询订单请求
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 查询分类数据
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		request.setAttribute("flist", flist);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		request.setAttribute("clist", clist);

		ArrayList<EASYBUY_PRODUCT> tlist = EASYBUY_PRODUCTDao.selectAllByT();
		request.setAttribute("tlist", tlist);
		ArrayList<EASYBUY_PRODUCT> hlist = EASYBUY_PRODUCTDao.selectAllByHot();
		request.setAttribute("hlist", hlist);
		ArrayList<EASYBUY_NEWS> nlist = EASYBUY_NEWSDao.selectAll();
		request.setAttribute("nlist", nlist);

		HttpSession session = request.getSession();

		// 查询最近浏览的商品
		ArrayList<Integer> ids = (ArrayList<Integer>) session.getAttribute("ids");
		if (ids != null) {
			ArrayList<EASYBUY_PRODUCT> lastlylist = EASYBUY_PRODUCTDao.selectById(ids);
			request.setAttribute("lastlylist", lastlylist);
		}

		EncodeUtil.encode(request);
		String dd = request.getParameter("dd");
		ArrayList<EASYBUY_Ddan> dan = EASYBUY_DdanDao.selectById(dd);
		request.setAttribute("dan", dan);
		// 跳转到Dan.jsp页面
		request.getRequestDispatcher("Dan.jsp").forward(request, response);
	}
}
