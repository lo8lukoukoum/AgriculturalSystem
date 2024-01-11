package com.hr.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class UpdateManage extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����������Ӧ���ַ�����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// �������л�ȡ���Ե�id
		int id = Integer.parseInt(request.getParameter("id"));

		// ���� EASYBUY_COMMENTDao ��� selOne ������ѯָ��id��������Ϣ
		EASYBUY_COMMENT comment = EASYBUY_COMMENTDao.selOne(id);

		if (comment != null) {
			// ����ѯ������ݸ� guestbook-modify.jsp ҳ�������ʾ
			request.setAttribute("list", comment);
			request.getRequestDispatcher("guestbook-modify.jsp").forward(request, response);
		} else {
			response.getWriter().print("<script>alert('��ѯʧ�ܣ�');history.back();</script>");
		}
	}
}
