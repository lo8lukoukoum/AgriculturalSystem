package com.hr.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.dao.EASYBUY_COMMENTDao;

public class DelManage extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����������Ӧ���ַ�����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// �������л�ȡ���Ե�id
		int id = Integer.parseInt(request.getParameter("id"));

		// ���� EASYBUY_COMMENTDao ��� del ����ɾ������
		int num = EASYBUY_COMMENTDao.del(id);

		// ����ɾ���������ҳ����ת
		if (num > 0) {
			// ɾ���ɹ����ض��� manage-result.jsp ҳ��
			response.sendRedirect("manage-result.jsp");
		} else {
			// ɾ��ʧ�ܣ�������ʾ�򲢷��ص���һҳ
			response.getWriter().print("<script>alert('ɾ��ʧ��!');history.back();</script>");
		}
	}
}
