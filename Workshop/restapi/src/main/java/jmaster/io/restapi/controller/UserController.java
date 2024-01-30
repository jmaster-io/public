package jmaster.io.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jmaster.io.restapi.model.User;

@RestController
public class UserController {
	private List<User> users = new ArrayList<User>();

	@PostMapping("/user")
	public User create(@RequestBody User user) {
		users.add(user);

		return user;
	}

	@GetMapping("/users")
	public List<User> getAll() {
		return users;
	}
	
	@DeleteMapping("/user") 
	public void delete(@RequestParam(name="id") int id) {
		for (int i = 0; i < users.size() ; i++) {
			if (users.get(i).getId() == id) {
				users.remove(i);
				break;
			}
		}
	}
	
	@PutMapping("/user")
	public void update(@RequestBody User user) {
		for (int i = 0; i < users.size() ; i++) {
			if (users.get(i).getId() == user.getId()) {
				users.set(i, user);
				break;
			}
		}
	}
	
}
