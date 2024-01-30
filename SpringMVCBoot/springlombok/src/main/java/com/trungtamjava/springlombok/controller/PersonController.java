package com.trungtamjava.springlombok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trungtamjava.springlombok.model.Country;
import com.trungtamjava.springlombok.model.Person;

@Controller
public class PersonController {

	
	@GetMapping("/person")
	public String getPerson(Model model) {
		Person p = new Person(1, "Java Master");
		model.addAttribute("p", p);
		
		Person p2 = Person.builder().id(2).name("trung tam java").build();
		
		model.addAttribute("p2", p2);
		
		Person.PersonBuilder pBuilder = p.toBuilder();
		
		Person p3 = pBuilder.name("trung tam java 3").build();
		
		
		model.addAttribute("p3", p3);
		
		Country vn = Person.builderCountry().id(1).name("VN").build();
		
		return "person";
	}
}
