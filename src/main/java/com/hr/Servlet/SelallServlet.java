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
 * ��ѯ�������� Servlet
 */
public class SelallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * �����ѯ������������
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int page = 1; // ��ǰҳ��
		int pageSize = 6; // ÿҳ����
		String spage = request.getParameter("page");

		// ��ȡһ������Ͷ��������б�
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		request.setAttribute("flist", flist);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		request.setAttribute("clist", clist);

		if (spage != null) { // ���ҳ���ϴ�����ҳ��,����ǰҳ���ı��
			page = Integer.parseInt(spage);
		}

		// �����ҳ��
		ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selPage(page, pageSize);
		int maxPage = EASYBUY_COMMENTDao.getMax(pageSize);

		// ������������ݲ�����ҳ������0
		if (list.size() > 0 && maxPage > 0) {
			request.setAttribute("list", list);
			// ����ҳ�����ݸ�guestbook.jsp ʹ��
			request.setAttribute("max_page", maxPage);
			// �ѵ�ǰҳ�����ݸ�guestbook.jspʹ��
			request.setAttribute("page", page);
			// ��ת��guestbook.jsp
			request.getRequestDispatcher("guestbook.jsp").forward(request, response);
		} else {
			request.setAttribute("list", list);
			// ����ҳ�����ݸ�guestbook.jsp ʹ��
			request.setAttribute("max_page", maxPage);
			// �ѵ�ǰҳ�����ݸ�guestbook.jspʹ��
			request.setAttribute("page", page);
			// ��ת��guestbook.jsp
			request.getRequestDispatcher("guestbook.jsp").forward(request, response);
		}
	}
}
