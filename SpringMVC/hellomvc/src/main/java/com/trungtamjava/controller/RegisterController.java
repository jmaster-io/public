package com.trungtamjava.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.UserDaoImpl;
import com.trungtamjava.model.User;

@Controller
public class RegisterController {

	@GetMapping("/register")
	public String register() {
		return "register-user";
	}

	@PostMapping("/register")
	public String register(
			@RequestParam("username") String uname,
			@RequestParam(value="password", required=false) String pass,//null
			@RequestParam("name") String name,
			@RequestParam("role") String role) {

		/// save to database
		UserDao userDao = new UserDaoImpl();

		User user = new User();
		user.setUsername(uname);
		user.setPassword(pass);
		user.setName(name);
		user.setRole(role);

		try {
			userDao.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:/login";
	}
	
	//cach 2
	@PostMapping("/register-model")
	public String registerModel(@ModelAttribute User user) {
		/// save to database
		UserDao userDao = new UserDaoImpl();

		try {
			userDao.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:/login";
	}
	// getmap -> tra ve form
	// postmap -> doc form
}
