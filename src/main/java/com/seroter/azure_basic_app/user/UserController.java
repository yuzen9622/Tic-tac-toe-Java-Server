package com.seroter.azure_basic_app.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {

		this.userService = userService;
	}

	@GetMapping("/all")
	public List<User> getUser() {
		return userService.getUsers();
	}

	@GetMapping("/id")
	public Optional<User> getUserById(@RequestParam Long id) {
		return userService.getUserById(id);
	}

	@PostMapping("/login")
	public Optional<User> login(@RequestBody User user) {

		return userService.loginAndRegister(user);
	}

//	@PostMapping("/add")
//	public void addUser(@RequestBody User user) {
//		userService.addNewUser(user);
//	}
}
