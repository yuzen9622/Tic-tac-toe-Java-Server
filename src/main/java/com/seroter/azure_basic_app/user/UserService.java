package com.seroter.azure_basic_app.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			return userOptional;
		} else {
			throw new IllegalStateException("no user");
		}
	}

	public Optional<User> loginAndRegister(User user) {
		Optional<User> userOptional = userRepository.login(user.getEmail(), user.getName());

		if (userOptional.isPresent()) {
			return userOptional;
		} else {
			Optional<User> userEmail = userRepository.findUserByEmail(user.getEmail());
			Optional<User> userName = userRepository.findUserByName(user.getName());

			if (!userEmail.isPresent() && userName.isPresent())
				throw new IllegalStateException("email error");
			if (!userName.isPresent() && userEmail.isPresent())
				throw new IllegalStateException("name error");

			if (!userName.isPresent() && !userEmail.isPresent()) {
				addNewUser(user);
				userOptional = userRepository.login(user.getEmail(), user.getName());
				return userOptional;
			} else {
				throw new IllegalStateException("server error");
			}

		}
	}

	public void addNewUser(User user) {

		userRepository.save(user);

	}
}
