package com.hr.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

public class ToProductUpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ����������л�ȡҪ���µĲ�Ʒ��ID
		String id = req.getParameter("id");

		// ���ݲ�ƷID�����ò�Ʒ����ϸ��Ϣ
		EASYBUY_PRODUCT p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(id));

		// ����Ʒ��������Ϊ���������
		req.setAttribute("p", p);

		// �������и�����Ʒ���࣬���ṩ�޸�ѡ��
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		req.setAttribute("flist", flist);

		// ���������Ӽ���Ʒ���࣬���ṩ�޸�ѡ��
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		req.setAttribute("clist", clist);

		// ���������Ӧת����"product-modify.jsp"ҳ�������Ⱦ
		req.getRequestDispatcher("product-modify.jsp").forward(req, resp);
	}
}
