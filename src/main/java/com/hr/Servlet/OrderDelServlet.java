package com.hr.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_ORDERDao;

/**
 * Servlet implementation class OrderDelServlet
 * ����ɾ�� Servlet
 */
public class OrderDelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     * ������ɾ������
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ��ȡ����ID
        String id = request.getParameter("id");

        // ɾ������
        int count = EASYBUY_ORDERDao.del(Integer.parseInt(id));

        if (count > 0) {
            // ɾ���ɹ����ض��� manage-result.jsp ҳ��
            response.sendRedirect("manage-result.jsp");
        } else {
            // ɾ��ʧ�ܣ����ش�����ʾ����ת�ض���ѡ��ҳ��
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>");
            out.print("alert('ɾ��ʧ��');");
            out.print("location.href='ordersel'");
            out.print("</script>");
        }
    }
}
