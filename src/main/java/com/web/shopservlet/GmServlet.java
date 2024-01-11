package com.web.shopservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;

public class GmServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		EncodeUtil.encode(request);
		HttpSession session = request.getSession();
		EASYBUY_USER user = (EASYBUY_USER) session.getAttribute("name");

		// �û���Ϣ
		String id = user.getEU_USER_ID();
		String name = user.getEU_USER_NAME();
		String address = user.getEU_ADDRESS();

		// �ܼ�Ǯ
		String price = request.getParameter("jstext");

		// ��Ʒ��Ϣ
		String[] EP_ID = request.getParameterValues("spID");
		String[] quantity = request.getParameterValues("number");
		String[] sPPrice = request.getParameterValues("sPPrice");

		// ������Ʒ��Ŀ��
		for (int i = 0; i < EP_ID.length; i++) {
			int count5 = ESDao.updateStock(Integer.parseInt(quantity[i]), Integer.parseInt(EP_ID[i]));
		}

		// ������Ʒ�����ܼ�
		int[] pprice = new int[EP_ID.length];
		for (int i = 0; i < EP_ID.length; i++) {
			pprice[i] = Integer.parseInt(quantity[i]) * Integer.parseInt(sPPrice[i]);
		}

		// �����������������
		int count = ESDao.insertDD(id, name, address, Integer.parseInt(price));
		int sequenceId = ESDao.getSequenceId();

		// ѭ���������������
		for (int i = 0; i < EP_ID.length; i++) {
			EASYBUY_ORDER_DETAIL eod = new EASYBUY_ORDER_DETAIL(1, sequenceId, Integer.parseInt(EP_ID[i]),
					Integer.parseInt(quantity[i]), pprice[i]);
			int count2 = ESDao.eodInsert(eod);
		}

		// �޸Ĺ��ﳵ
		String[] esID = request.getParameterValues("esID");
		for (int i = 0; i < esID.length; i++) {
			int count3 = ESDao.esdelete(Integer.parseInt(esID[i]));
		}

		if (count > 0) {
			out.print("<script>");
			out.print("alert('����ɹ�');");
			out.print("location.href='shopping-result.jsp';");
			out.print("</script>");
			out.close();
		} else {
			out.print("<script>");
			out.print("alert('����ʧ�ܣ�������ѡ����Ʒ');");
			out.print("location.href='ShopSelect';");
			out.print("</script>");
			out.close();
		}
	}
}
