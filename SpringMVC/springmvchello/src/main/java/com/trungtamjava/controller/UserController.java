package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping({ "/hello", "/hi" })
	// @RequestMapping(value = "/hello", method = RequestMethod.GET)
	// @RequestMapping(value = "/hello")
	public String hello(HttpServletRequest request) {
		request.setAttribute("msg", "Hello Spring MVC");

		userService.info();

		return "hello";
	}

	@RequestMapping(value = "/2", method = RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("msg", "Hello Spring MVC");
		return "hello";
	}

	@GetMapping(value = "/user/add")
	public String addUser() {
		return "add-user";
	}

	@PostMapping(value = "/user/add")
	public void addUser(HttpServletRequest request,
			HttpServletResponse resp,
			@RequestParam(value="age") int age,
			@RequestParam(value = "name") String name) {
		//String name = request.getParameter("name");
		//String age = request.getParameter("age");
		//save to database
		try {
			resp.sendRedirect("/spring-hello/user/add");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
