package jmaster.io.jpatutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jmaster.io.jpatutorial.entity.Person;
import jmaster.io.jpatutorial.repostirory.PersonRepository;

@Controller
@RequestMapping("/user")
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	
	/// SEARCH USER
	@GetMapping("/search")
	public String search(Model model) {
		List<Person> users = personRepository.findAll();/// MODEL
		model.addAttribute("uList", users);
		
		return "user/searchUser";
	}
	
	//
	@GetMapping("/create")
	public String create() {
		return "user/createUser";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Person user) {
		personRepository.save(user);
		return "redirect:/user/search";
	}

	//
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		personRepository.deleteById(id);
		return "redirect:/user/search";
	}

	/// edit?id=123
	@GetMapping("/edit")
	public String edit(Model model, @Param("id") int id) {
		Person user = personRepository.getById(id);
		model.addAttribute("user", user);

		return "user/editUser";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute("user") Person user) {
		personRepository.save(user);

		return "redirect:/user/search";
	}
}
