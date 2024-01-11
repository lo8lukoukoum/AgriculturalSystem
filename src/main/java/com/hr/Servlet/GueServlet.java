package com.hr.Servlet;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class GueServlet extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// ȡֵ
		String guestName = request.getParameter("guestName");
		String guestContent = request.getParameter("guestContent");

		// ��ȡ��ǰ����
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date).toString();

		// �������Զ���
		EASYBUY_COMMENT comment = new EASYBUY_COMMENT(0, guestContent, time, "", null, guestName);

		// ���� DAO ��ķ����������Լ�¼
		int num = EASYBUY_COMMENTDao.insert(comment);

		if (num > 0) {
			// ����ɹ����ض������Բ�ѯҳ��
			response.sendRedirect("SelallServlet");
		} else {
			// ����ʧ�ܣ�������ʾ�򣬲�������һҳ
			response.getWriter().print("<script>alert('���ʧ�ܣ�');history.back();</script>");
		}
	}
}
