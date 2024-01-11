package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_ORDERDao;
import com.hr.entity.EASYBUY_ORDER;
import com.hr.util.EncodeUtil;

/**
 * Servlet implementation class OrderDoUServlet
 * ������Ϣ���� Servlet
 */
public class OrderDoUServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDoUServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * ��������Ϣ��������
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���봦��
		EncodeUtil.encode(request);

		// ��ȡ���¶�����Ϣ�Ĳ���
		String orderId = request.getParameter("orderId");
		String name = request.getParameter("name");
		String address = request.getParameter("addres"); // �˴�������һ��ƴд����ӦΪ "address"
		String cost = request.getParameter("cost");
		String status = request.getParameter("tatus"); // �˴�������һ��ƴд����ӦΪ "status"

		// ������������
		EASYBUY_ORDER order = new EASYBUY_ORDER(
				Integer.parseInt(orderId), "", name, address, "",
				Integer.parseInt(cost), Integer.parseInt(status), 1);

		// ���� DAO ����ж�����Ϣ����
		int count = EASYBUY_ORDERDao.update(order);

		if (count > 0) {
			// ���³ɹ����ض��� manage-result.jsp ҳ��
			response.sendRedirect("manage-result.jsp");
		} else {
			// ����ʧ�ܣ����ش�����ʾ����ת�ض���ѡ��ҳ��
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('�޸�ʧ��');");
			out.print("location.href='ordersel'");
			out.print("</script>");
			out.close();
		}
	}
}
