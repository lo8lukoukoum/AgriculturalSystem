package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

/**
 * Servlet implementation class SelectProductViewServlet
 * 查询商品详情的 Servlet
 */
public class SelectProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 处理查询商品详情请求
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//查询商品分类
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		req.setAttribute("flist", flist);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		req.setAttribute("clist", clist);

		String id = req.getParameter("id");
		HttpSession session = req.getSession();

		//查询最近浏览的商品
		ArrayList<Integer> ids = (ArrayList<Integer>) session.getAttribute("ids");
		if (ids == null) {
			ids = new ArrayList<Integer>();
		}

		if (ids.size() >= 5) {
			ids.remove(0);
		}

		if (id != null && (!ids.contains(Integer.parseInt(id)))) {
			ids.add(Integer.parseInt(id));
		}

		session.setAttribute("ids", ids);
		ids = (ArrayList<Integer>) session.getAttribute("ids");

		if (ids != null) {
			ArrayList<EASYBUY_PRODUCT> lastlylist = EASYBUY_PRODUCTDao.selectById(ids);
			req.setAttribute("lastlylist", lastlylist);
		}

		//查询商品详情
		EASYBUY_PRODUCT p = null;
		if (id != null) {
			p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(id));
		}

		req.setAttribute("p", p);
		req.getRequestDispatcher("product-view.jsp").forward(req, resp);
	}
}
