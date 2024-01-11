package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;

public class UserDelServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ���봦����ֹ��������
		EncodeUtil.encode(req);

		// ������Ӧ���������ͼ�����
		resp.setContentType("text/html;charset=utf-8");

		// �������л�ȡҪɾ�����û�id
		String id = req.getParameter("id");

		// ��ȡ��Ӧ�����
		PrintWriter out = resp.getWriter();

		// ����DAO��ķ���ɾ���û���Ϣ
		int count = EASYBUY_USERDao.del(id);

		// ����ɾ�����������Ӧ����
		if (count > 0) {
			// ɾ���ɹ����ض��򵽽��ҳ��
			resp.sendRedirect("manage-result.jsp");
		} else {
			// ɾ��ʧ�ܣ�ͨ���ű�������ʾ�û����������û��б�ҳ��
			out.write("<script>");
			out.write("alert('ɾ��ʧ��');");
			out.write("location.href='user.jsp'");
			out.write("</script>");
			out.close();
		}
	}
}
