package com.trungtamjava.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.UserDaoImpl;
import com.trungtamjava.model.User;
import com.trungtamjava.validator.UserValidator;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired // tu dong gan BEAN tuong ung vao - DI
//	@Qualifier("test1") // IoC
	UserDao userDao; // = new UserDaoImpl()

	@Autowired
	UserValidator userValidator;

	@GetMapping("/search")
	public String search(HttpServletRequest req, @RequestParam(value = "name", required = false) String name)
			throws SQLException {

		if (name == null)
			name = "";/// neu nguoi dung ko truyen len name

//		UserDao userDao = new UserDaoImpl();
		List<User> users = userDao.search(name);/// MODEL

		req.setAttribute("uList", users);

		return "searchUser";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		userDao.delete(id);

		return "redirect:/admin/user/search";
	}

	@GetMapping("/edit")
	public String edit(HttpServletRequest req, @RequestParam("id") int id) {
//		UserDao userDao = new UserDaoImpl();
		User user = userDao.get((id));

		req.setAttribute("user", user);

		return "editUser";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute User user, BindingResult bindingResult) throws SQLException {
		/// nho goi ham validate o day
		userValidator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			return "editUser";
		}

//		UserDao userDao = new UserDaoImpl();
		userDao.update(user);

		return "redirect:/admin/user/search";
	}
}
