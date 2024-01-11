package com.hr.manage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class UpManage extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����������Ӧ���ַ�����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// �������л�ȡ���������������Ϣ
		int id = Integer.parseInt(request.getParameter("orderId"));
		String name = request.getParameter("name");
		String replyContent = request.getParameter("replyContent");
		String content = request.getParameter("Content");

		// ��ȡ��ǰʱ�䲢��ʽ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String replyTime = sdf.format(date);

		// ���� EASYBUY_COMMENT ������������
		EASYBUY_COMMENT comment = new EASYBUY_COMMENT(id, content, replyTime, replyContent, replyTime, name);
		comment.setEC_ID(id);

		// ���� EASYBUY_COMMENTDao ��� update ��������������Ϣ
		int num = EASYBUY_COMMENTDao.update(comment);

		if (num > 0) {
			// ���³ɹ����ض��� manage-result.jsp ҳ��
			response.sendRedirect("manage-result.jsp");
		} else {
			// ����ʧ�ܣ�������ʾ�򲢷�����һҳ
			response.getWriter().print("<script>alert('����ʧ�ܣ�');history.back();</script>");
		}
	}
}
