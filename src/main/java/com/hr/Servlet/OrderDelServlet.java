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
 * 订单删除 Servlet
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
     * 处理订单删除请求
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取订单ID
        String id = request.getParameter("id");

        // 删除订单
        int count = EASYBUY_ORDERDao.del(Integer.parseInt(id));

        if (count > 0) {
            // 删除成功，重定向到 manage-result.jsp 页面
            response.sendRedirect("manage-result.jsp");
        } else {
            // 删除失败，返回错误提示并跳转回订单选择页面
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>");
            out.print("alert('删除失败');");
            out.print("location.href='ordersel'");
            out.print("</script>");
        }
    }
}
