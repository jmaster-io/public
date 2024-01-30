package com.trungtamjava.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/login-member") // ?errCode=100
public class ClientLoginController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errCode");

		if (code != null && code.equals("100")) {
			req.setAttribute("msg", "Tai khoan hoac mat khau sai");
		}
		if (code != null && code.equals("400")) {
			req.setAttribute("msg", "Tai khoan đã đăng nhập nhiều lần. Bạn có thể vào database, reset giá trị login counter về 0");
		}
		RequestDispatcher dispathcer = req.getRequestDispatcher("/views/client/login.jsp");
		dispathcer.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form gui len
		String username = req.getParameter("username");
		String pass = req.getParameter("password");

		UserDao userDao = new UserDaoImpl();
		User user = userDao.getByUsername(username);

		if (user != null && user.getPassword().equals(pass)) {
			System.out.println("Log in success");

			if (user.getLoginCounter() < 10) {
				// tao session
				HttpSession session = req.getSession();
				// luu doi tuong vao session
				session.setAttribute("loginUser", user);

				// chuyen huong : server tra ve cho client mot trang web(duong dan) khac
				// req.getContextPath(): ten root path(ten project)
				resp.sendRedirect(req.getContextPath() + "/client/product/search"); // respond : server tra ve
			} else {
				System.out.println("Da dang nhap cho khac roi");
				resp.sendRedirect(req.getContextPath() + "/login-member?errCode=400");// not active
			}

		} else {
			System.out.println("Fail");
			resp.sendRedirect(req.getContextPath() + "/login-member?errCode=100");
		}
	}
}
