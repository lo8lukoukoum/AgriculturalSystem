package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.util.EncodeUtil;

public class NewsInsServlet extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EncodeUtil.encode(req);

		// �����������ȡ���ű��������
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		// �������Ŷ���
		EASYBUY_NEWS news = new EASYBUY_NEWS(0, title, content, null);

		// ���� DAO ��Ĳ��뷽��
		int count = EASYBUY_NEWSDao.insert(news);

		if (count > 0) {
			// ����ɹ����ض��򵽹�����ҳ��
			resp.sendRedirect("manage-result.jsp");
		} else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('���ʧ��');");
			out.print("location.href='news-add.jsp'");
			out.print("</script>");
			out.close();
		}
	}
}
