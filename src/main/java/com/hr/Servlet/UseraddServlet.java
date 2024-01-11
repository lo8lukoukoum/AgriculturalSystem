package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UseraddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ���봦����ֹ��������
		EncodeUtil.encode(req);

		// ������Ӧ���������ͼ�����
		resp.setContentType("text/html;charset=utf-8");

		// �������л�ȡ�û��ύ����Ϣ
		String username = req.getParameter("userName");
		String name = req.getParameter("name");
		String pwd = req.getParameter("passWord");
		String sex = req.getParameter("sex");
		String year = req.getParameter("birthday");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");

		// �����û�����
		EASYBUY_USER u = new EASYBUY_USER(username, name, pwd, sex, year, null, email, mobile, address, 1);

		// ����DAO��ķ��������û���Ϣ
		int count = EASYBUY_USERDao.insert(u);

		// ��ȡ��Ӧ�����
		PrintWriter out = resp.getWriter();

		// ���ݲ�����������Ӧ����
		if (count > 0) {
			// ����ɹ����ض��򵽽��ҳ��
			resp.sendRedirect("manage-result.jsp");
		} else {
			// ����ʧ�ܣ�ͨ���ű�������ʾ�û�������������û�ҳ��
			out.write("<script>");
			out.write("alert('���ʧ��');");
			out.write("location.href='user-add.jsp'");
			out.write("</script>");
			out.close();
		}
	}
}
