package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

public class DoProductClassAddServlet extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// ��������б��봦��
		EncodeUtil.encode(req);

		// ��ȡ��������� ID
		int fid = Integer.parseInt(req.getParameter("parentId"));

		// �����������Ϊ UTF-8
		req.setCharacterEncoding("utf-8");

		// ��ȡ��������
		String name = req.getParameter("className");

		// ���ݸ������� ID �ж������һ�����໹������Ӽ�����
		if (fid == 0) {
			// ����һ���������
			EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, name, 0);

			// ���� DAO ��ķ�������һ�������¼
			EASYBUY_PRODUCT_CATEGORYDao.insertOnFather(pc);
		} else {
			// �����Ӽ��������
			EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, name, fid);

			// ���� DAO ��ķ��������Ӽ������¼
			EASYBUY_PRODUCT_CATEGORYDao.insert(pc);
		}

		// �ض�����Ʒ����ҳ��
		resp.sendRedirect("productClass");
	}
}
