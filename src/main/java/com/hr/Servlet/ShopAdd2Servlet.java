package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_USER;
import com.hr.entity.eb_shop;

/**
 * Servlet implementation class ShopAdd2Servlet
 * �����Ʒ�����ﳵ�� Servlet
 */
public class ShopAdd2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * ���������Ʒ�����ﳵ������
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// ��ȡ��ƷID�͹�������
		String pid = req.getParameter("id");
		String count = req.getParameter("count");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		// ��ȡ��ǰ�û���Ϣ
		HttpSession session = req.getSession();
		EASYBUY_USER user = (EASYBUY_USER) session.getAttribute("name");

		// �ж��û��Ƿ��¼
		if (user != null) {
			String uid = user.getEU_USER_ID();

			// ��ѯ���ﳵ���Ƿ��Ѵ�����ͬ��Ʒ
			ArrayList<eb_shop> list = ESDao.getShop(uid);
			req.setAttribute("shoplist", list);
		} else {
			// �û�δ��¼����ʾ��¼
			out.print("<script>");
			out.print("alert('���ȵ�¼');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
			out.close();
			return;
		}

		// ��ȡ��Ʒ��Ϣ
		EASYBUY_PRODUCT p = null;
		if (pid != null) {
			p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(pid));
		}

		// ��ȡ�û�ID�ͽ���״̬
		String uid = user.getEU_USER_ID();
		int valid = 1;

		// �������ﳵ����
		eb_shop sp = new eb_shop(0, p.getEP_FILE_NAME(), p.getEP_NAME(), p.getEP_PRICE(), Integer.parseInt(count),
				p.getEP_STOCK(), p.getEP_ID(), uid, valid);

		// ���빺�ﳵ��¼
		int epid = p.getEP_ID();
		ESDao.insert(sp);
		resp.sendRedirect("selectProductView?id=" + epid);
	}
}
