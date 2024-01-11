package com.hr.manage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class ChaManage extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// ���� EASYBUY_COMMENTDao ��� selectAll ������ȡ�����б�
		ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selectAll();

		// �������б�洢������������
		req.setAttribute("list", list);

		// ת������ guestbook.jsp ҳ��
		req.getRequestDispatcher("guestbook.jsp").forward(req, resp);
	}
}
