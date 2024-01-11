package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Ĭ�ϵ�ǰҳΪ��һҳ��ÿҳ��ʾ15����¼
		int cpage = 1;
		int count = 15;

		// ��ȡҳ�洫�ݵĵ�ǰҳ����
		String cp = req.getParameter("cp");
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}

		// ������ҳ��
		int totalPage = EASYBUY_USERDao.totalPage(count);

		// ��ѯ��ǰҳ���û�����
		ArrayList<EASYBUY_USER> userList = EASYBUY_USERDao.selectAll(cpage, count);

		// ����ѯ�������request���У���ǰ��ҳ��ʹ��
		req.setAttribute("userlist", userList);
		req.setAttribute("cpage", cpage);
		req.setAttribute("tpage", totalPage);

		// ת�����û�����ҳ��
		req.getRequestDispatcher("user.jsp").forward(req, resp);
	}
}
