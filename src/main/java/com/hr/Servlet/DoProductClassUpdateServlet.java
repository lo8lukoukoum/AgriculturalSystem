package com.hr.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

public class DoProductClassUpdateServlet extends HttpServlet {

	// ����ͻ�������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// ��������б��봦��
		EncodeUtil.encode(req);

		// ��ȡ����� ID����������� ID �ͷ�������
		int id = Integer.parseInt(req.getParameter("id"));
		int fid = Integer.parseInt(req.getParameter("parentId"));
		String name = req.getParameter("className");

		// ������Ʒ�������
		EASYBUY_PRODUCT_CATEGORY pc;

		// ���ݸ������� ID �ж��Ǹ���һ�����໹�Ǹ����Ӽ�����
		if (fid == 0) {
			// ����һ���������
			pc = new EASYBUY_PRODUCT_CATEGORY(id, name, id);
		} else {
			// �����Ӽ��������
			pc = new EASYBUY_PRODUCT_CATEGORY(id, name, fid);
		}

		// ���� DAO ��ķ������·����¼
		EASYBUY_PRODUCT_CATEGORYDao.update(pc);

		// �ض�����Ʒ����ҳ��
		resp.sendRedirect("productClass");
	}
}
