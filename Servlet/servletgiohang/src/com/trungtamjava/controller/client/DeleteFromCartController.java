package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.BillProduct;

@WebServlet(urlPatterns = "/delete-from-cart") // ?key=1
public class DeleteFromCartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");

		// gio hang co nhieu mat hang
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");// luu tam vao session

		if (obj != null) {
			Map<String, BillProduct> map = (Map<String, BillProduct>) obj;
			map.remove(key);
			// update lai vao session
			session.setAttribute("cart", map);
		}
		// chuyen ve trang gio hang
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
