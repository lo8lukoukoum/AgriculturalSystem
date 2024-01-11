package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

public class ToProductClassUpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// �������������ȡ��Ʒ�����ID
		int id = Integer.parseInt(req.getParameter("id"));

		// ����ID����ָ���Ĳ�Ʒ��������
		EASYBUY_PRODUCT_CATEGORY epc = EASYBUY_PRODUCT_CATEGORYDao.selectById(id);

		// ����Ʒ������������Ϊ���������
		req.setAttribute("epc", epc);

		// �������в�Ʒ���࣬���ṩ�޸�ѡ��
		ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = EASYBUY_PRODUCT_CATEGORYDao.selectAll();
		req.setAttribute("epclist", epclist);

		// ���������Ӧת����"productClass-modify.jsp"ҳ�������Ⱦ
		req.getRequestDispatcher("productClass-modify.jsp").forward(req, resp);
	}
}
