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
 * 订单信息更新 Servlet
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
	 * 处理订单信息更新请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 编码处理
		EncodeUtil.encode(request);

		// 获取更新订单信息的参数
		String orderId = request.getParameter("orderId");
		String name = request.getParameter("name");
		String address = request.getParameter("addres"); // 此处可能是一个拼写错误，应为 "address"
		String cost = request.getParameter("cost");
		String status = request.getParameter("tatus"); // 此处可能是一个拼写错误，应为 "status"

		// 创建订单对象
		EASYBUY_ORDER order = new EASYBUY_ORDER(
				Integer.parseInt(orderId), "", name, address, "",
				Integer.parseInt(cost), Integer.parseInt(status), 1);

		// 调用 DAO 层进行订单信息更新
		int count = EASYBUY_ORDERDao.update(order);

		if (count > 0) {
			// 更新成功，重定向到 manage-result.jsp 页面
			response.sendRedirect("manage-result.jsp");
		} else {
			// 更新失败，返回错误提示并跳转回订单选择页面
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('修改失败');");
			out.print("location.href='ordersel'");
			out.print("</script>");
			out.close();
		}
	}
}
