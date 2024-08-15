package com.trungtamjava.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(value = "/admin")
public class LoginController {

	@GetMapping("/login") /// url
	public String loginPage() {

		return "login";// ten trang view login.jsp, ko gach cheo o dau
	}

	// @PostMapping("/login") ///url
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(
			HttpServletRequest request, 
			@RequestParam("username") String uname,
			@RequestParam("password") String password
			) {

		// String uname = request.getParameter("username");
		//String password = request.getParameter("password");

		HttpSession session = request.getSession();

		session.setAttribute("name", uname);

		return "redirect:/welcome";// ten trang view login.jsp
	}

	// ta ca doget,post,... deu goi vao
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// HttpSession session = req.getSession();// chua co tao moi, co roi lay ra

		session.invalidate();

		// resp.sendRedirect("/servetv2/login");
		return "redirect:/login";
	}

	@GetMapping("/welcome") /// url
	public String welcomePage(HttpSession session) {
		String name = (String) session.getAttribute("name");

		System.out.println(name);

		return "welcome";// ten trang view login.jsp, ko gach cheo o dau
	}
}
